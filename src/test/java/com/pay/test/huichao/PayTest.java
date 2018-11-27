package com.pay.test.huichao;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;

import com.pay.entity.huichao.pay.HC_GateWayPayRequestParam;
import com.pay.util.common.poco.RSAUtils;
import com.pay.util.sign.huichao.SignUtil;

public class PayTest {

	public String executePostByUsual(String actionURL, Map<String, String> parameters) {
		String response = "";
		try {
			URL url = new URL(actionURL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// 发送post请求需要下面两行
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("Charset", "UTF-8");
			;
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			// 设置请求数据内容
			String requestContent = "";
			Set<String> keys = parameters.keySet();
			for (String key : keys) {
				requestContent = requestContent + key + "=" + parameters.get(key) + "&";
			}
			requestContent = requestContent.substring(0, requestContent.lastIndexOf("&"));
			DataOutputStream ds = new DataOutputStream(connection.getOutputStream());
			// 使用write(requestContent.getBytes())是为了防止中文出现乱码
			ds.write(requestContent.getBytes());
			ds.flush();
			try {
				// 获取URL的响应
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
				String s = "";
				String temp = "";
				while ((temp = reader.readLine()) != null) {
					s += temp;
				}
				response = s;
				System.out.println("结果：" + s);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("No response get!!!");
			}
			ds.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Request failed!");
		}
		return response;
	}

	public static void main(String[] args) throws Exception {
		// PayTest payTest = new PayTest();
		// HC_GateWayPayRequestParam param = new HC_GateWayPayRequestParam();
		// param.getSignInfo();
		// param.validate();
		// Map<String,String> parameters = SignUtil.getHttpPostParamMap(param);
		// payTest.executePostByUsual(param.getUrl(), parameters);
		String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJyCbZ+14jK2NwJ6"
				+ "v1mE4ZR8H+sOyUs33LzNys8mJj8+1zDxTIlv0tr0JnR/m8swKw9Jes7QsQw05edm"
				+ "tndeQ9bLbJeXSzqpuI3Dw35etBRD7Ec93NBtX49ezf51qmqxTRRwYcMUsIhXqliu"
				+ "K/2G1B75EbfgGfprA1MVNQv6YX8bAgMBAAECgYAF0xjPU86KQpvDfNv4MejPRNtP"
				+ "PSqioP6XDDWbBflwax9JFAHcL4wyV9nChik/I5jGpd5rKfsc0C8qMHlj8d8mZV9h"
				+ "gh8YeUFsfH8i02SbnR8l4MvutxnDaq2PDatTPnK6Qd7PPvKqwOnfT3BHhL415yJ0"
				+ "ia8+uzwVONYCYcvvqQJBAMpNEa+dx/d1xY50M9n6ds4uxKEBJN+DoMqtBRUu2tdv"
				+ "qgITgY7es8LW2Kn+5GTCIiSdWbvmL2GSIlwqfMz92a8CQQDGDbEzgECX0kp5J3od"
				+ "gLm5C5nrfmk3HG2+vt0eUUWP+a5iBKqCXXW9lx+8AYs5MKxkvQkA2m13Wxm+r1ND"
				+ "0UhVAkEAo4MVd3e1R/umGVUtD9OUsWQ1w9jz38E5dnfQcuWzNoxnwlPX1Q2GCEa1"
				+ "Svndyt7qz+NqwyfzRg7ivNIOm3XWuwJAHAILsTDN8ap3hbKjflCZ8yVE2xzBXF3U"
				+ "10i+lG8B215/3rSyOEVnRSx9/GRrf+b2OjjRcSFyoZJsjZ7Vs52BEQJBAILJlhPh"
				+ "aSQ2QG+gxkdqUmcTtU28ImI2MGzJmNAkfSzSOoogO5SCw8/6qxRZqyuTxZWUm0dE" 
				+ "s7YEln3LT7PObuM=";
		String s = "aa123";
		System.out.println(RSAUtils.sign(s.getBytes(), privateKey));
	}

}
