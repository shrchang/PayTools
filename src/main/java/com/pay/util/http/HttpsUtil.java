/**     
*   Copyright © since 2008. All Rights Reserved 
*   汇元银通（北京）在线支付技术有限公司   www.heepay.com    
*/

package com.pay.util.http;

import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * http连接工具
 * 
 * @ClassName HttpsUtil
 * @author shrChang.Liu
 * @Description TODO
 * @date 2018年6月21日 下午3:07:16
 *
 */
public class HttpsUtil {

	/**
	 * 用于模拟http post请求，将参数编码utf-8，这里返回的可能是json可能是xml
	 * 
	 * @author shrChang.Liu
	 * @param @param
	 *            url
	 * @param @param
	 *            nvPairs
	 * @param @return
	 * @param @throws
	 *            Exception
	 * @date 2018年6月21日下午3:17:32
	 * @return String
	 * @description
	 */
	public static String sendHttpsRequestWithParam(String url, List<NameValuePair> nvPairs) throws Exception {
		return sendHttpRequestWithParam(url, nvPairs, "UTF-8");
	}

	/**
	 * 可以设置编码的请求
	 * 
	 * @author shrChang.Liu
	 * @param @param
	 *            url
	 * @param @param
	 *            nvPairs
	 * @param @param
	 *            charest
	 * @param @return
	 * @param @throws
	 *            Exception
	 * @date 2018年6月22日 下午2:23:46
	 * @return String
	 * @description
	 */
	private static String sendHttpRequestWithParam(String url, List<NameValuePair> nvPairs, String charest)
			throws Exception {
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		httpPost.setEntity(new UrlEncodedFormEntity(nvPairs, charest));
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		String retStr = EntityUtils.toString(httpResponse.getEntity(), charest);
		httpResponse.close();
		httpClient.close();
		return retStr;
	}

	/**
	 * 调用自己封装的json报文格式去完成请求
	 * 
	 * @author shrChang.Liu
	 * @param url
	 * @param json
	 *            直接传递的JSON字符串参数
	 * @param charest
	 * @return
	 * @throws Exception
	 * @date 2018年6月28日 下午3:39:52
	 * @return String
	 * @description
	 */
	private static String sendHttpRequestWithParam(String url, String json, String charest) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(3000).setConnectTimeout(3000)
				.setSocketTimeout(3000).build();
		httpPost.setConfig(requestConfig);
		httpPost.addHeader(new BasicHeader("Content-Type","application/json;charset=UTF-8"));
		StringEntity entity = new StringEntity(json, Charset.forName(charest));
		entity.setContentType("application/json;charset=UTF-8");
		httpPost.setEntity(entity);
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		String retStr = EntityUtils.toString(httpResponse.getEntity(), Charset.forName(charest));
		httpResponse.close();
		httpClient.close();
		return retStr;
	}

	/**
	 * 添加TLS认证的https的请求过程
	 * 
	 * @author shrChang.Liu
	 * @param @param
	 *            url
	 * @param @param
	 *            nvPairs
	 * @param @param
	 *            charest
	 * @param @return
	 * @param @throws
	 *            Exception
	 * @date 2018年6月22日 下午2:48:37
	 * @return String
	 * @description
	 */
	public static String sendHttpsRequestWithParam(String url, List<NameValuePair> nvPairs, String charest)
			throws Exception {
		// 如果只是http的请求的话 就跳到上面去执行
		if (url.startsWith("http://")) {
			return sendHttpRequestWithParam(url, nvPairs, charest);
		}
		SSLContext sslContext = SSLContext.getInstance("TLS");
		// 信托管理
		X509TrustManager tm = new X509TrustManager() {
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}

			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}
		};
		// 初始化
		sslContext.init(null, new TrustManager[] { tm }, new java.security.SecureRandom());
		// 设置验证域名
		HostnameVerifier hv = new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return hostname.equals(session.getPeerHost());
			}
		};
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(hv).setSSLContext(sslContext)
				.build();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(nvPairs, charest));
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		String retStr = EntityUtils.toString(httpResponse.getEntity(), charest);
		httpResponse.close();
		httpClient.close();
		return retStr;
	}

	/**
	 * 直接请求JSON格式的参数 包含HTTP/HTTPS
	 * 
	 * @author shrChang.Liu
	 * @param url
	 * @param json
	 * @param charest
	 * @return
	 * @throws Exception
	 * @date 2018年6月28日 下午3:52:19
	 * @return String
	 * @description
	 */
	public static String sendHttpsRequestWithParam(String url, String json, String charest) throws Exception {
		// 如果只是http的请求的话 就跳到上面去执行
		if (url.startsWith("http://")) {
			return sendHttpRequestWithParam(url, json, charest);
		}
		SSLContext sslContext = SSLContext.getInstance("TLS");
		// 信托管理
		X509TrustManager tm = new X509TrustManager() {
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}

			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}
		};
		// 初始化
		sslContext.init(null, new TrustManager[] { tm }, new java.security.SecureRandom());
		// 设置验证域名
		HostnameVerifier hv = new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return hostname.equals(session.getPeerHost());
			}
		};
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(hv).setSSLContext(sslContext)
				.build();
		HttpPost httpPost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(3000).setConnectTimeout(3000)
				.setSocketTimeout(3000).build();
		httpPost.setConfig(requestConfig);
		httpPost.addHeader(new BasicHeader("Content-Type","application/json;charset=UTF-8"));
		StringEntity entity = new StringEntity(json, Charset.forName(charest));
		entity.setContentType("application/json;charset=UTF-8");
		httpPost.setEntity(entity);
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		String retStr = EntityUtils.toString(httpResponse.getEntity(), Charset.forName(charest));
		httpResponse.close();
		httpClient.close();
		return retStr;
	}

	/**
	 * http请求
	 * 
	 * @author shrChang.Liu
	 * @param url
	 * @param map
	 * @param charset
	 * @return
	 * @date 2018年6月30日 下午1:47:48
	 * @return String
	 * @description
	 */
	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public static String sendHttpsRequestWithParam(String url, Map<String, String> map, String charset) {
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			// ���ò���
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String> elem = (Entry<String, String>) iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
			}
			if (list.size() > 0) {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
				httpPost.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, charset);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (httpPost != null) {
				httpPost.releaseConnection();
			}
			if (httpClient != null) {
				httpClient.getConnectionManager().shutdown();
			}
		}
		return result;
	}

	/**
	 * 通过xml格式传递post请求
	 * 
	 * @author shrChang.Liu
	 * @param url
	 * @param xmlBody
	 * @param charset
	 * @return
	 * @date 2018年9月4日 上午9:32:27
	 * @return String
	 * @description
	 */
	public static String sendHttpsRequestWithXmlParam(String url, String xmlBody, String charset) throws Exception {
		SSLContext sslContext = SSLContext.getInstance("TLS");
		// 信托管理
		X509TrustManager tm = new X509TrustManager() {
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}

			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			}
		};
		// 初始化
		sslContext.init(null, new TrustManager[] { tm }, new java.security.SecureRandom());
		// 设置验证域名
		HostnameVerifier hv = new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return hostname.equals(session.getPeerHost());
			}
		};
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(hv).setSSLContext(sslContext)
				.build();
		HttpPost httpPost = new HttpPost(url);
		StringEntity entity = new StringEntity(xmlBody, charset);
		entity.setContentType("text/xml");
		httpPost.setEntity(entity);
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		String retStr = EntityUtils.toString(httpResponse.getEntity(), charset);
		httpResponse.close();
		httpClient.close();
		return retStr;
	}

	public static void main(String[] args) throws Exception {
		try {
			List<NameValuePair> nvPairs = new ArrayList<NameValuePair>();

			/*
			 * nvPairs.add(new BasicNameValuePair("out_trade_no",
			 * "1516185831821")); nvPairs.add(new BasicNameValuePair("partner",
			 * "130")); nvPairs.add(new BasicNameValuePair("sign",
			 * "mFkRj879FG4BPA/Itpa7XvmhE3i+PG/6bFVjeFR093wWQ6bwmHqs59zZ4hrLrQbVC8QiCzLrpSXtmcAFlULepWrBlRHRbAZid5tfqllf13ZrYe4fL93/0dS6g+2Y8nTBJVbqX8fqaQxHiUEeHyxzN6pjVBzzdna2URN5Edz14Riq6dMS8qOm5DsmtC/RqtyMowmFmBmoMIadJeUNnAkuCY/COfWkFJL712i4zblydxefE2vSyJd7CdHpup9FhznEfp1fBe4kblYahQUG0GQ/XB/2+QQNbzNppemZ8BRTcSmsFf1mOgjjwg+wZNZ2Hq1zMZ28VeD7ExqgGb8k22YnEA=="
			 * )); nvPairs.add(new BasicNameValuePair("trans_type", "query"));
			 * nvPairs.add(new BasicNameValuePair("certId",
			 * "335902764374016746163578510918738695929360058949"));
			 * nvPairs.add(new BasicNameValuePair("sign_type",
			 * "SHA256withRSA")); nvPairs.add(new BasicNameValuePair("version",
			 * "4.0")); String xmlStr = sendHttpsRequestWithParam(
			 * "http://wx.globalcash.cn/paycenter/gateways.do", nvPairs, "GBK");
			 * System.out.println(xmlStr); YPL_OrderResponseEntity entity =
			 * XmlUtil.convertToBean(xmlStr,YPL_OrderResponseEntity.class);
			 * System.out.println(JsonUtil.getJsonStrByObj(entity));
			 */
			nvPairs.add(new BasicNameValuePair("base64_memo", "SXBob25lWA=="));
			nvPairs.add(new BasicNameValuePair("certId", "335902764374016746163578510918738695929360058949"));
			nvPairs.add(new BasicNameValuePair("currency_type", "RMB"));
			nvPairs.add(new BasicNameValuePair("is_raw", "1"));
			nvPairs.add(new BasicNameValuePair("notify_url", "http://www.baidu.com"));
			nvPairs.add(new BasicNameValuePair("out_trade_no", "20180627172745970"));
			nvPairs.add(new BasicNameValuePair("partner", "130"));
			nvPairs.add(new BasicNameValuePair("pay_id", "wxpay"));
			nvPairs.add(new BasicNameValuePair("sign_type", "SHA256withRSA"));
			nvPairs.add(new BasicNameValuePair("store_oi_type", "0"));
			nvPairs.add(new BasicNameValuePair("sub_appid", "wxdac3dd7ffa21c579"));
			nvPairs.add(new BasicNameValuePair("sub_openid", "ojKWzt_zSJDSxTmIlNlYEO0wYUCQ"));
			nvPairs.add(new BasicNameValuePair("time_out", "20180627175745"));
			nvPairs.add(new BasicNameValuePair("total_fee", "0.01"));
			nvPairs.add(new BasicNameValuePair("version", "4.0"));
			nvPairs.add(new BasicNameValuePair("sign",
					"laLAuob2330kns6LGpIMIRlXWj9V4oRbu74SXnQ/BpbsAuqLNaNWWa+9VvIl9uCWV5VbSLUbki9au0yk4kPuq8yMRHcSL2SLcOHNL7IiPUs93aFFpbMmOV+A5LENxMzBCzGaiPkUDYySe0+bEKYoXS8Z5AoCa+r7GJ3jkad+DrmsDnwW9TYtPz4/QuTXoo7lHNe6HCkT/89tH+clC7Zxl9EoxTd///0dw0pr+8Dh01aY+UkRweao2nxL/07amit4YDeooiHSlsW6+o4iNAZduBymrpt/kE+iIjcRhgXv3d/TcJtLjlmS+UHkIXidWWDI2nt0i3O5dOdDf/ZvlhWQoQ=="));
			String xmlStr = sendHttpsRequestWithParam("http://wx.globalcash.cn/paycenter/v2.0/getoi.do", nvPairs,
					"GBK");
			System.out.println(xmlStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
