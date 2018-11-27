package com.pay.constant;

/**
 * 银行卡省份编码
 * @ClassName ProvinceEnum
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月8日 下午4:19:47
 *
 */
public enum ProvinceEnum {
	BEIJING("北京市","0011"),
	TIANJIN("天津市","0012"),
	HEIBEI("河北省","0013"),
	SHANXI("山西省","0014"),
	NEIMENGGU("内蒙古自治区","0015"),
	LIAONING("辽宁省","0021"),
	JILIN("吉林省","0022"),
	HUBEI("湖北省","0042"),
	HUNAN("湖南省","0043"),
	GUANGDONG("广东省","0044"),
	GUANGXI("广西壮族自治区","0045"),
	HAINAN("海南省","0046"),
	HEILONGJIANG("黑龙江省","0023"),
	SHANGHAI("上海市","0031"),
	JIANGSU("江苏省","0032"),
	ZHEJIANG("浙江省","0033"),
	ANHUI("安徽省","0034"),
	FUJIAN("福建省","0035"),
	CHONGQING("重庆市","0050"),
	SICHUAN("四川省","0051"),
	GUIZHOU("贵州省","0052"),
	YUNNAN("云南省","0053"),
	XIZANG("西藏自治区","0054"),
	JIANGXI("江西省","0036"),
	SHANDONG("山东省","0037"),
	HENAN("河南省","0041"),
	XS("陕西省","0061"),
	GANSU("甘肃省","0062"),
	QINGHAI("青海省","0063"),
	NIANGXIA("宁夏回族自治区","0064"),
	XINJIANG("新疆维吾尔自治区","0065"),
	XIANGGANG("香港特别行政区","2001"),
	AOMEN("澳门特别行政区","2002"),
	TAIWAN("台湾省","2003");
	
	
	private String name;
	private String code;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private ProvinceEnum(String name,String code){
		this.name = name;
		this.code = code;
	}
	
	/**
	 * 根据名称来找省份代码
	 * @author shrChang.Liu
	 * @param name
	 * @return
	 * @date 2018年10月1日 下午9:29:41
	 * @return String
	 * @description
	 */
	public static String getCodeByName(String name){
		for(ProvinceEnum provinceEnum : ProvinceEnum.values()){
			if(provinceEnum.getName().equals(name)){
				return provinceEnum.getCode();
			}
		}
		return null;
	}
}
