package com.pay.constant;

/**
 * 银行的编号与名称枚举
 * @ClassName BankEnum
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年10月1日 下午9:16:55
 *
 */
public enum BankEnum {

	XXYH("兴业银行","03090000"),
	HXYH("华夏银行	","03040000"),
	BJYH("北京银行","03130011"),
	ZSYH("招商银行","03080000"),
	GSYH("工商银行","01020000"),
	JSYH("建设银行","01050000"),
	NYYH("农业银行","01030000"),
	ZXYH("中信银行","03020000"),
	GDYH("光大银行","03030000"),
	BJNCSYYH("北京农村商业银行","04020011"),
	ZGYH("中国银行","01040000"),
	ZGYZCXYH("中国邮政储蓄银行","04030000"),
	NJYH("南京银行","03133201"),
	HZYH("杭州银行","03133301"),
	ZHSYH("浙商银行","03160000"),
	SHYH("上海银行","03130031"),
	BHYH("渤海银行","03180000"),
	SHNCSYYH("上海农村商业银行","04020031"),
	GFYH("广发银行","03060000"),
	MSYH("民生银行","03050000"),
	PDFZYH("浦发银行","03100000"),
	PAYH("平安银行","03134402"),
	JTYH("交通银行","03010000");
	
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

	private BankEnum(String name,String code){
		this.name = name;
		this.code = code;
	}
	
	/**
	 * 根据银行来找对应的编号
	 * @author shrChang.Liu
	 * @param name
	 * @return
	 * @date 2018年10月1日 下午9:29:41
	 * @return String
	 * @description
	 */
	public static String getCodeByName(String name){
		for(BankEnum bank : BankEnum.values()){
			if(name.equals(bank.getName())){
				return bank.getCode();
			}
		}
		return null;
	}
}
