/**
 * 
 */
package com.eshequ.onlinepay.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.eshequ.onlinepay.exception.AppSysException;


/**
 * @author davidhardson
 *
 */
@Component
public class HttpUtil {
	
	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	@Autowired
	private CloseableHttpClient httpClient;
	
	@Autowired
	private RequestConfig requestConfig;
	
	/**
	 * 
	 */
	public HttpUtil() {
		// TODO Auto-generated constructor stub
	}

	
	public void doPost(String url, String json) {
		
		doPost(url, json, "utf-8");
		
	}
	
	/**
	 * POST with json	目前只支持json，用map的自行转换一下
	 * @param requestUrl
	 * @param json
	 * @param charset
	 * @return
	 */
	public String doPost(String requestUrl, String json, String charset) {
		
        String httpStr = "";
        HttpPost httpPost = new HttpPost(requestUrl);
        httpPost.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        
        StringEntity stringEntity = new StringEntity(json, charset);
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Accept", "application/json");
        try {
	        response = httpClient.execute(httpPost);
	        HttpEntity entity = response.getEntity();
	        logger.info("response statusCode "+response.getStatusLine().getStatusCode());
			httpStr = EntityUtils.toString(entity, charset);
		} catch (Exception e) {
			throw new AppSysException(e);
		}
        return httpStr;
    
	}
		

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
