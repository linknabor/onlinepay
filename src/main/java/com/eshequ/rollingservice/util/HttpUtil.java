package com.eshequ.rollingservice.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import com.eshequ.rollingservice.exception.AppSysException;

public class HttpUtil {

	private static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * http get
	 * 
	 * @param requestUrl
	 * @return
	 */
	public static String doGet(String requestUrl) {

		return doGet(requestUrl, null);

	}

	/**
	 * http get
	 * 
	 * @param requestUrl
	 * @param params
	 * @return
	 */
	public static String doGet(String requestUrl, Map<String, String> params) {

		String responseStr = "";
		try {

			if (params != null) {
				StringBuffer buffer = new StringBuffer();
				Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String, String> entry = it.next();
					String key = entry.getKey();
					String value = entry.getValue();
					buffer.append(key).append("=").append(value).append("&");
				}
				requestUrl += "?" + buffer.toString();
				requestUrl = requestUrl.substring(0, requestUrl.length() - 1);
			}

			URL url = new URL(requestUrl);
			// 得到connection对象。
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// 设置请求方式
			connection.setRequestMethod("GET");
			// 连接
			connection.connect();
			// 得到响应码
			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				// 得到响应流
				InputStream inputStream = connection.getInputStream();
				// 将响应流转换成字符串
				responseStr = inputStream2String(inputStream);// 将流转换为字符串。
			}
		} catch (Throwable e) {

			throw new AppSysException(e);
		}
		return responseStr;

	}

	/**
	 * convert inpustream 2 string
	 * 
	 * @param inputStream
	 * @return
	 */
	private static String inputStream2String(InputStream inputStream) {

		StringBuffer stringBuffer = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, DEFAULT_CHARSET));

			String str = "";
			while ((str = br.readLine()) != null) {
				stringBuffer.append(str);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return stringBuffer.toString();

	}

}
