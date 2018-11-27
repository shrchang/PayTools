package com.pay.util.text;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.pay.annotation.xml.XmlAlias;
import com.pay.annotation.xml.XmlAttribute;
import com.pay.annotation.xml.XmlField;
import com.pay.annotation.xml.XmlSet;
import com.pay.test.A;

/**
 * XML解析帮助类 采用dom4j
 * 
 * @ClassName XmlUtil
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月22日 下午3:10:07
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class XmlUtil {

	/**
	 * 
	 * 将xml转化为对象，默认对象必须配置根节点的名称，然后默认去查里面的attribute field alias set，默认如果有多个标签的话
	 * 会后面的覆盖前面的 如果发现set标签 必须下面是数组或者集合才可以 
	 * @XmlAlias 支持对象与Map map只支持String,String的map 切记
	 * @author shrChang.Liu
	 * @param xmlStr
	 *            传入的xml片段 这里面必须包含xml的头部
	 * @param t
	 *            需要转化的对象 主要用到以下的注解 对象{@link XmlAlias}单一属性{@link XmlAttribute}
	 *            单一节点{@link XmlField}列表{@link XmlSet}
	 * @param
	 * @date 2018年6月22日 下午3:13:46
	 * @return T
	 * @description
	 */
	public static <T> T convertToBean(String xmlStr, Class<T> z) throws Exception {
		Document document = null;
		try {
			document = DocumentHelper.parseText(xmlStr);
			Element root = document.getRootElement();
			T t = z.newInstance();
			// 必须判断是不是存在这个
			if (!t.getClass().isAnnotationPresent(XmlAlias.class)) {
				throw new Exception("bean找不到对应的xml注解！");
			}
			XmlAlias alias = t.getClass().getAnnotation(XmlAlias.class);
			//可能为空
			if (!root.getName().equals(alias.name())) {
				throw new Exception("bean找不到xml对应的根节点配置！");
			}
			Class c = t.getClass();
			List<Field> fields = getClassAllFileds(c);
			// 循环去注入值
			RoundSetterAllFiledValue(root, t, fields);
			return t;
		} catch (Exception e) {
			throw new Exception("转换失败：" + e.getLocalizedMessage());
		}
	}

	/**
	 * 获取当前类的所有的子属性
	 * @author shrChang.Liu
	 * @param c 类名
	 * @return
	 * @date 2018年6月23日 下午7:39:17
	 * @return List<Field>
	 * @description
	 */
	private static <T> List<Field> getClassAllFileds(Class c) {
		List<Field> fields = new ArrayList<Field>();
		//必须获取父类所有的属性
		while (c.getSuperclass() != null) {
			fields.addAll(Arrays.asList(c.getDeclaredFields()));
			c = c.getSuperclass();
		}
		return fields;
	}

	/**
	 * 依次设置对应的属性值
	 * 
	 * @author shrChang.Liu
	 * @param root
	 *            xml节点内容
	 * @param t
	 *            需要转化的对象
	 * @param fileds
	 *            对象包含的所有字段
	 * @throws Exception
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @date 2018年6月23日 下午3:35:28
	 * @return void
	 * @description
	 */
	private static <T> void RoundSetterAllFiledValue(Element root, T t, List<Field> fileds)
			throws Exception, InstantiationException, IllegalAccessException {
		for (Field f : fileds) {
			String qName;// qName
			// 先找到对应的注解，默认先去找attribute的 然后filed 然后Alias 最后去找到set的
			RoundSetterSingleFiledValue(root, t, f);
			// 判断是不是Alias 需要判断是不是对象或者是Map 如果是对象的话 应该下面会有字段的 没有字段默认就不算是对象
			if (f.isAnnotationPresent(XmlAlias.class)) {
				XmlAlias xmlAlias = f.getAnnotation(XmlAlias.class);
				//不能为空或者空字符串
				qName = StringUtils.isNoneBlank(xmlAlias.name()) ? xmlAlias.name() : f.getName();
				Element e = root.element(qName);
				if (e != null) {
					Class filedClass = f.getType();
					if(Map.class.isAssignableFrom(f.getType())){//判断是不是Map如果是Map的话 直接将这个下面的所有的属性直接放到里面就行了
						HashMap<String, String> map = new HashMap<String, String>();
						List<Attribute> attributes = (List<Attribute>)e.attributes();
						for(Attribute attribute : attributes){
							map.put(attribute.getName(), attribute.getText());
						}
						for(Element element : (List<Element>)e.elements()){
							map.put(element.getName(), element.getText());
						}
						Reflections.invokeSetter(t, f.getName(), map);
					}else{
						List<Field> fList = getClassAllFileds(filedClass);
						// 判断
						if (filedClass.getDeclaredFields().length < 1) {
							throw new Exception("XmlAlias注解必须对应一个对象！");
						}
						// 创建一个这样的对象
						Object o = filedClass.newInstance();
						RoundSetterAllFiledValue(e, o, fList);
						Reflections.invokeSetter(t, f.getName(), o);
					}
				}
			}
			// 下面是判断数组与集合
			RoundSetterArrayOrCollctionFiledValue(root, t, f);
		}
	}

	/**
	 * 设置数组与集合的值 默认如果是List的话 就用arraryList如果是Set的话 就用hashSet
	 * 
	 * @author shrChang.Liu
	 * @param root
	 *            xml节点数据 Element
	 * @param t
	 *            需要转换的对象
	 * @param f
	 *            字段
	 * @throws Exception
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @date 2018年6月23日 下午4:57:59
	 * @return void
	 * @description
	 */
	private static <T> void RoundSetterArrayOrCollctionFiledValue(Element root, T t, Field f)
			throws Exception, InstantiationException, IllegalAccessException {
		String qName;
		if (f.isAnnotationPresent(XmlSet.class)) {
			if (!f.getType().isArray() && !(Collection.class.isAssignableFrom(f.getType()))) {
				throw new Exception("XmlSet注解只能在数组与集合下进行使用");
			}
			XmlSet xmlSet = f.getAnnotation(XmlSet.class);
			qName = StringUtils.isNotBlank(xmlSet.name()) ? xmlSet.name() : f.getName();
			Element element = root.element(qName);
			// 说明存在
			if (element != null) {
				// 判断字段的对象是不是数组或者是集合
				if (f.getType().isArray()) {
					Class c = f.getType().getComponentType();
					if (c.newInstance().getClass().isAnnotationPresent(XmlAlias.class)) {
						XmlAlias xmlAlias = c.newInstance().getClass().getAnnotation(XmlAlias.class);
						qName = xmlAlias.name();
						if (StringUtils.isNotBlank(qName)) {
							List<Element> elements = element.elements(qName);
							Object o = Array.newInstance(c, elements.size());
							int i = 0;
							for (Element el : elements) {
								Object value = c.newInstance();
								List<Field> fList = getClassAllFileds(c);
								RoundSetterAllFiledValue(el, value, fList);
								Array.set(o, i, value);
								i++;
							}
							Reflections.invokeSetter(t, f.getName(), o);
						}
					}
				}
				// 集合的情况，这个比较复杂了 因为集合里面有很多种 包含了List Set
				if (Collection.class.isAssignableFrom(f.getType())) {
					Class[] classes = getParameterizedTypeClass(f);
					if (classes.length > 0) {
						Class c = classes[0];
						if (c.newInstance().getClass().isAnnotationPresent(XmlAlias.class)) {
							XmlAlias xmlAlias = c.newInstance().getClass().getAnnotation(XmlAlias.class);
							qName = xmlAlias.name();
							if (StringUtils.isNotBlank(qName)) {
								List<Element> elements = element.elements(qName);
								Collection collect = null;
								//这里还有问题
								if (List.class.isAssignableFrom(f.getType())) {
									collect = new ArrayList();
								} else if (Set.class.isAssignableFrom(f.getType())) {
									collect = new HashSet();
								}
								if(collect == null){
									throw new Exception("其余的集合暂时没有实现！");
								}
								for (Element el : elements) {
									Object value = c.newInstance();
									List<Field> fList = getClassAllFileds(c);
									RoundSetterAllFiledValue(el, value, fList);
									collect.add(value);
								}
								Reflections.invokeSetter(t, f.getName(), collect);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 设置单个属性的值 不包含对象
	 * 
	 * @author shrChang.Liu
	 * @param root
	 *            Element xml节点信息
	 * @param t
	 *            需要转化的对象
	 * @param f
	 *            Field字段
	 * @throws Exception
	 * @date 2018年6月23日 下午4:58:14
	 * @return void
	 * @description
	 */
	private static <T> void RoundSetterSingleFiledValue(Element root, T t, Field f) throws Exception {
		String qName;
		// 如果有注解 但是没有填写name的话 默认就是当前的字段值
		if (f.isAnnotationPresent(XmlAttribute.class)) {
			XmlAttribute attr = f.getAnnotation(XmlAttribute.class);
			qName = StringUtils.isNotBlank(attr.name()) ? attr.name() : f.getName();
			Attribute attribute = root.attribute(qName);
			if (attribute != null) {
				Object value;
				Converter converter = BeanUtilsBean.getInstance().getConvertUtils().lookup(f.getType());
				if (converter != null) {
					value = converter.convert(f.getType(), attribute.getText());
					Reflections.invokeSetter(t, f.getName(), value);
				} else {
					throw new Exception("导入的数据类型与数据库保存类型冲突！");
				}
			}
		}
		// 判断是不是field这个也只能是基本类型才行
		if (f.isAnnotationPresent(XmlField.class)) {
			XmlField xmlField = f.getAnnotation(XmlField.class);
			qName = StringUtils.isNotBlank(xmlField.name()) ? xmlField.name() : f.getName();
			Element e = root.element(qName);
			if (e != null) {
				Object value;
				Converter converter = BeanUtilsBean.getInstance().getConvertUtils().lookup(f.getType());
				if (converter != null) {
					value = converter.convert(f.getType(), e.getText());
					Reflections.invokeSetter(t, f.getName(), value);
				} else {
					throw new Exception("导入的数据类型与数据库保存类型冲突！");
				}
			}
		}
	}

	/**
	 * 获取字段里面包含泛型的数据对象的class对象数组
	 * 
	 * @author shrChang.Liu
	 * @param f
	 *            字段名
	 * @return
	 * @date 2018年6月23日 下午4:52:36
	 * @return Class
	 * @description
	 */
	private static Class<?>[] getParameterizedTypeClass(Field f) {
		// 获取f字段的通用类型
		Type fc = f.getGenericType();
		// 如果不为空并且是泛型参数的类型
		if (fc != null && fc instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) fc;
			Type[] types = pt.getActualTypeArguments();
			if (types != null && types.length > 0) {
				Class<?>[] classes = new Class<?>[types.length];
				for (int i = 0; i < classes.length; i++) {
					classes[i] = (Class<?>) types[i];
				}
				return classes;
			}
		}
		return null;
	}

	/**
	 * 将java bean解析为xml片段
	 * 
	 * @author shrChang.Liu
	 * @param @param
	 *            t
	 * @param @return
	 * @date 2018年6月22日 下午4:20:56
	 * @return String
	 * @description
	 */
	public static <T> String covertToXML(T t) throws Exception {
		Class c = t.getClass();
		if (!c.isAnnotationPresent(XmlAlias.class)) {
			throw new Exception("对象没有配置xml标签无法转化！");
		}
		XmlAlias alias = t.getClass().getAnnotation(XmlAlias.class);
		Document document = DocumentHelper.createDocument();
		try {
			// 创建根节点元素
			Element root = document.addElement(alias.name());
			// 下面开始设置值
			SetFieldXML(t, c, root);
		} catch (Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
		return document.asXML();
	}

	/**
	 * 这里面是设置document的值
	 * @author shrChang.Liu
	 * @param t
	 * @param c
	 * @param root
	 * @date 2018年6月22日 下午4:54:15
	 * @return void
	 * @description
	 */
	private static <T> void SetFieldXML(T t, Class c, Element root) throws Exception {
		List<Field> fields = getClassAllFileds(c);
		if (fields.size() < 1) {
			throw new Exception("无法找到对象下面的属性值！");
		}
		for (Field f : fields) {
			// 先获取所有的属性值设置进去
			if (f.isAnnotationPresent(XmlAttribute.class)) {
				XmlAttribute attribute = f.getAnnotation(XmlAttribute.class);
				String name = attribute.name();
				Object value = Reflections.invokeGetter(t, f.getName());
				String v = value != null ? String.valueOf(value) : attribute.defaultValue();
				root.addAttribute(name, v);
			}
			// 获取字段节点
			if (f.isAnnotationPresent(XmlField.class)) {
				XmlField xmlField = f.getAnnotation(XmlField.class);
				Object value = Reflections.invokeGetter(t, f.getName());
				String v = value != null ? String.valueOf(value) : xmlField.defaultValue();
				if("".equals(v)){
					//跳出当前循环咯
					continue;
				}
				Element e = root.addElement(xmlField.name());
				e.setText(v);
			}
			// 设置对象
			if (f.isAnnotationPresent(XmlAlias.class)) {
				XmlAlias xmlAlias = f.getAnnotation(XmlAlias.class);
				Element e = root.addElement(xmlAlias.name());
				Object value = Reflections.invokeGetter(t, f.getName());
				SetFieldXML(value, value.getClass(), e);
			}
			if (f.isAnnotationPresent(XmlSet.class)) {
				Object value = Reflections.invokeGetter(t, f.getName());
				// 判断是不是集合或者数组
				if (!value.getClass().isArray() && !(value instanceof Collection)) {
					throw new Exception("XmlSet当前注解必须是数组或者集合！");
				}
				XmlSet set = f.getAnnotation(XmlSet.class);
				Element e = root.addElement(set.name());
				if (value.getClass().isArray()) {
					Object[] objs = (Object[]) value;
					for (Object o : objs) {
						if (!o.getClass().isAnnotationPresent(XmlAlias.class)) {
							throw new Exception("无法确认子节点的节点");
						}
						XmlAlias alias = o.getClass().getAnnotation(XmlAlias.class);
						Element element = e.addElement(alias.name());
						SetFieldXML(o, o.getClass(), element);
					}
				} else if (value instanceof Collection) {
					Collection collection = (Collection) value;
					Iterator iterator = collection.iterator();
					while (iterator.hasNext()) {
						Object o = iterator.next();
						if (!o.getClass().isAnnotationPresent(XmlAlias.class)) {
							throw new Exception("无法确认子节点的节点");
						}
						XmlAlias alias = o.getClass().getAnnotation(XmlAlias.class);
						Element element = e.addElement(alias.name());
						SetFieldXML(o, o.getClass(), element);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		// XmlUtil x = new XmlUtil();
		// B b = x.new B();
		// b.setAge(11);
		// b.setId(1L);
		// A a = x.new A();
		// a.setB(b);
		// a.setId(22L);
		// a.setName("aaaaaaaaa");
		// List<B> s = new ArrayList<B>();
		// B[] bbs = new B[] { b };
		// s.add(b);
		// a.setBb(bbs);
		// a.setRoots(s);
		// System.out.println(covertToXML(a));s
		for (Field f : A.class.getDeclaredFields()) {
			if (Collection.class.isAssignableFrom(f.getType())) {
				System.out.println("name:" + f.getName() + ",type:" + f.getGenericType());
				if (f.getGenericType() instanceof ParameterizedType) {
					ParameterizedType pt = (ParameterizedType) f.getGenericType();
					Type[] types = pt.getActualTypeArguments();
					System.out.println(types[0].getClass());
				}
			}
		}

		 String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
		 + "<root id=\"22\"><name>aaaaaaaaa</name><list><node id=\"1\"><age>11</age></node></list><node id=\"1\">"
		 + "<age>11</age></node><bbs><node id=\"1\"><age>11</age></node></bbs></root>";
		 A a = convertToBean(xmlStr, A.class);
		 System.out.println(JsonUtil.getJsonStrByObj(a));
	}

}
