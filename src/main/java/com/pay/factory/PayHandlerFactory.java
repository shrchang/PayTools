package com.pay.factory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.pay.annotation.Handler;
import com.pay.enums.PayWay;

/**
 * 支付工厂类 用于根据具体支付类型返回的支付接口实现，我们应当需要支持自定义扫描路径，当前路径必须包含lib同级的所有包中 类似spring asm扫描器</br>
 * 当前包的配置必须支持logsf4j支持
 * @ClassName PayHandlerFactory
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年7月3日 上午9:40:39
 *
 */
public class PayHandlerFactory {
	
	private static Logger logger = LoggerFactory.getLogger(PayHandlerFactory.class);

	private static String PACKAGE_NAME = "com.pay.handler";// 需要扫描的地址
	
	private static String[] PACKAGE_NAMES = new String[]{PACKAGE_NAME};//多个扫描地址

	/**
	 * 根据对应的枚举去获取支付接口实现类
	 * 
	 * @author shrChang.Liu
	 * @param handler 需要的接口实现
	 * @param way 接口实现的枚举
	 * @return
	 * @date 2018年7月3日 上午10:08:21
	 * @return PayHandler
	 * @throws @throws
	 * @description 需要获取所有的handler的实现类，然后从实现类中去比较对应的接口 并返回 因为这个可能会达成jar包
	 *              所以需要考虑扫描jar包的可能性 这样做的原因是为了方便扩展 否则需要定义一个静态管理工具类
	 *              在每实现一个接口后就需要添加一次 现在默认所有的接口实现必须在com.pay.handler这个包名下面
	 *              如果需要添加多个扫描的记录请
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getPayHandler(Class<T> handler, PayWay way) {
		try {
			List<Class<?>> classes = getClasses(PACKAGE_NAMES);
			for (Class<?> c : classes) {
				// 第一步必须是实现了handler的接口
				if (handler.isAssignableFrom(c)) {
					//下面是必须实现handler这个接口才行 其实默认情况下应该可以不这样做的，可以将这个更广泛的使用
					if (c.isAnnotationPresent(Handler.class)) {
						Handler h = c.getAnnotation(Handler.class);
						if (h.value().equals(way)) {
							return (T) c.newInstance();
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error("获取接口【"+handler.getName()+"】的实现类失败：",e);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 扫描指定目录下面的接口实现类，可以多个路径，也可以不传，默认是扫描com.pay.handler包下面的
	 * @author shrChang.Liu
	 * @param handler 接口名字
	 * @param packageNames 需要扫描的包名 com.xx.cc 这样的格式
	 * @return
	 * @date 2018年7月4日 上午9:09:59
	 * @return List<T> 返回实现这个接口的所有的对象
	 * @description
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getImplClass(Class<T> handler,String... packageNames)throws Exception{
		List<T> ret = new ArrayList<T>();
		if(!handler.isInterface()){
			logger.error("传入的对象不是接口，请校验！");
			throw new Exception("传入的对象不是接口！");
		}
		try {
			if(packageNames.length>0){
				List<Class<?>> classes = getClasses(packageNames);
				for (Class<?> c : classes) {
					// 第一步必须是实现了handler的接口
					if (handler.isAssignableFrom(c)) {
						ret.add((T) c.newInstance());
					}
				}
			}else{//扫描默认包下面的
				List<Class<?>> classes = getClasses(PACKAGE_NAMES);
				for (Class<?> c : classes) {
					// 第一步必须是实现了handler的接口
					if (handler.isAssignableFrom(c)) {
						ret.add((T) c.newInstance());
					}
				}
			}
		} catch (Exception e) {
			logger.error("扫描类实例化失败：",e);
			throw new Exception(e.getLocalizedMessage());
		}
		return ret;
	}

	/**
	 * 利用spring asm扫描包的功能去扫描包 缺点就是必须要引入spring的包 已经放弃
	 * 
	 * @author shrChang.Liu
	 * @param packageName
	 *            包名
	 * @return
	 * @date 2018年7月3日 下午3:41:33
	 * @return List<Class<?>>
	 * @description
	 */
	@Deprecated
	public static List<Class<?>> scanPackage(String packageName) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver(classLoader);
			String packageNamePath = packageName.replace('.', '/');
			String packNamePath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + packageNamePath
					+ "/**/*.class";
			Resource[] resources = patternResolver.getResources(packNamePath);
			for (Resource resource : resources) {
				// 接下来这个解析都是有问题的了，需要考虑是不是jar包
				URL url = resource.getURL();
				// 得到协议的名称
				String protocol = url.getProtocol();
				if ("file".equals(protocol)) {
					// 获取包的物理路径
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					// 以文件的方式扫描整个包下的文件 并添加到集合中
					String classFilePath = filePath.replaceAll("\\\\", "/");
					int start = classFilePath.indexOf(packageNamePath);
					int last = classFilePath.lastIndexOf("/");
					String realPackagePath = classFilePath.substring(start, last).replaceAll("/", ".");
					// 需要获取他的路径
					classes.add(classLoader
							.loadClass(realPackagePath + "." + resource.getFilename().replace(".class", "")));
				} else if ("jar".equals(protocol)) {// 判断是jar的时候
					// 定义一个JarFile
					JarFile jar;
					try {
						// 获取jar
						jar = ((JarURLConnection) url.openConnection()).getJarFile();
						// 从此jar包 得到一个枚举类
						Enumeration<JarEntry> entries = jar.entries();
						// 同样的进行循环迭代
						while (entries.hasMoreElements()) {
							// 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
							JarEntry entry = entries.nextElement();
							// 如果发现当前和这个对象是一个文件夹或者后缀不是.class文件就直接跳到下一个循环
							if (entry.isDirectory() || !entry.getName().endsWith(".class")) {
								continue;
							}
							String name = entry.getName();
							// 如果是以/开头的 获取后面的字符串
							if (name.startsWith("/")) {
								name = name.substring(1);
							}
							// 如果前半部分和定义的包名相同
							if (name.startsWith(packageNamePath)) {
								int idx = name.lastIndexOf('/');
								// 如果以"/"结尾 是一个包 获取包名 把"/"替换成"." 转变成包名
								if (idx != -1) {
									packageName = name.substring(0, idx).replace('/', '.');
									// 去掉后面的".class" 获取真正的类名 -6的原因是因为.class是六位
									String className = name.substring(packageName.length() + 1, name.length() - 6);
									// 添加到classes
									try {
										classes.add(classLoader.loadClass(packageName + '.' + className));
									} catch (ClassNotFoundException e) {
										e.printStackTrace();
									}
								}
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classes;
	}
	
	
	/**
	 * 扫描多个包下面的类
	 * @author shrChang.Liu
	 * @param packs
	 * @return
	 * @date 2018年8月1日 上午11:48:11
	 * @return List<Class<?>>
	 * @description
	 */
	private static List<Class<?>> getClasses(String... packs) {
		// 第一个class类的集合
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for(String pack : packs){
			logger.info("扫描包【"+pack+"】下面的类....");
			classes.addAll(getClasses(pack));
		}
		return classes;
	}

	/**
	 * 从包package中获取所有的Class
	 * @param pack 扫描的路径
	 * @return
	 */
	private static List<Class<?>> getClasses(String pack) {
		// 第一个class类的集合
		List<Class<?>> classes = new ArrayList<Class<?>>();
		// 获取包的名字 并进行替换
		String packageName = pack;
		String packageDirName = packageName.replace('.', '/');
		// 定义一个枚举的集合 并进行循环来处理这个目录下的things
		Enumeration<URL> dirs;
		try {
			// 如果构建成jar包 这个扫描会存在致命的错误，所以需要重新修改
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			// 如果是jar包的话 这个路径是不对的，那么他就扫描不了外部的包了，需要拿到外面的路径
			dirs = classLoader.getResources(packageDirName);
			// 循环迭代下去
			while (dirs.hasMoreElements()) {
				// 获取下一个元素
				URL url = dirs.nextElement();
				// 得到协议的名称
				String protocol = url.getProtocol();
				// 如果是以文件的形式保存在服务器上
				if ("file".equals(protocol)) {
					// 获取包的物理路径
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					// 以文件的方式扫描整个包下的文件 并添加到集合中
					findAndAddClassesInPackageByFile(packageName, filePath, classes);
				} else if ("jar".equals(protocol)) {
					// 定义一个JarFile
					JarFile jar;
					try {
						// 获取jar
						jar = ((JarURLConnection) url.openConnection()).getJarFile();
						// 从此jar包 得到一个枚举类
						Enumeration<JarEntry> entries = jar.entries();
						// 同样的进行循环迭代
						while (entries.hasMoreElements()) {
							// 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
							JarEntry entry = entries.nextElement();
							if (entry.isDirectory() || !entry.getName().endsWith(".class")) {
								continue;
							}
							String name = entry.getName();
							// 如果是以/开头的 获取后面的字符串
							if (name.charAt(0) == '/') {
								name = name.substring(1);
							}
							// 如果前半部分和定义的包名相同
							if (name.startsWith(packageDirName)) {
								int idx = name.lastIndexOf('/');
								// 如果以"/"结尾 是一个包 获取包名 把"/"替换成"."
								if (idx != -1) {
									packageName = name.substring(0, idx).replace('/', '.');
									// 去掉后面的".class" 获取真正的类名
									String className = name.substring(packageName.length() + 1, name.length() - 6);
									try {
										// 添加到classes
										classes.add(classLoader.loadClass(packageName + '.' + className));
									} catch (ClassNotFoundException e) {
										e.printStackTrace();
									}
								}
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return classes;
	}

	/**
	 * 以文件的形式来获取包下的所有Class
	 * @param packageName
	 * @param packagePath
	 * @param recursive
	 * @param classes
	 */
	private static void findAndAddClassesInPackageByFile(String packageName, String packagePath,
			List<Class<?>> classes) {
		// 获取此包的目录 建立一个File
		File dir = new File(packagePath);
		// 如果不存在或者 也不是目录就直接返回
		if (!dir.exists() || !dir.isDirectory()) {
			return;
		}
		// 如果存在 就获取包下的所有文件 包括目录
		File[] dirfiles = dir.listFiles(new FileFilter() {
			// 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
			public boolean accept(File file) {
				return (file.isDirectory()) || (file.getName().endsWith(".class"));
			}
		});
		// 循环所有文件
		for (File file : dirfiles) {
			// 如果是目录 则继续扫描
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), classes);
			} else {
				// 如果是java类文件 去掉后面的.class 只留下类名
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {
					// 添加到集合中去
					// 经过回复同学的提醒，这里用forName有一些不好，会触发static方法，没有使用classLoader的load干净
					classes.add(
							Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 注入你需要扫描的包名
	 * @author shrChang.Liu
	 * @param packageName
	 * @date 2018年7月4日 上午9:03:16
	 * @return void
	 * @description
	 */
	public static void setScanPackageName(String... packageNames)throws Exception{
		if(packageNames.length<1){
			throw new Exception("传入的包路径不能为空！");
		}
		String packageRegex = "[a-zA-Z]+[0-9a-zA-Z_]*(\\.[a-zA-Z]+[0-9a-zA-Z_]*)*";
		Pattern pattern = Pattern.compile(packageRegex);
		for(String s : packageNames){
			Matcher matcher = pattern.matcher(s);
			if(!matcher.matches()){
				throw new Exception("包名【"+s+"】输入格式存在问题,请验证");
			}
		}
		//替换掉数组
		PACKAGE_NAMES = new String[packageNames.length];
		PACKAGE_NAMES = Arrays.copyOf(packageNames, packageNames.length);
	}

	public static void main(String[] args)throws Exception {
//		PayHandler handler = getPayHandler(PayHandler.class, PayWay.HFB);
//		System.out.println(handler.getClass().getName());
		// scanPackage(PACKAGE_NAME);
		// String s =
		// "E:\\allcode\\pay-engine\\pay-engine\\target\\classes\\com\\pay\\handler\\payment\\hfb\\HFB_PayHandler$A.class";
		// System.out.println(s.replaceAll("\\\\", "/"));
		
//		setScanPackageName("bb.a11a","com.pay.handler");
//		getClasses(PACKAGE_NAMES);
	}

}
