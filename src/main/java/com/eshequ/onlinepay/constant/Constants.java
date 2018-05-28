/**
 * 
 */
package com.eshequ.onlinepay.constant;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * @author davidhardson
 *
 */
@Component
public class Constants {
	
	public static String WECHATPAY_TENCENT;
	public static String WECHATPAY_SWIFTPASS;
	public static String WECHATPAY_ALLINPAY;
	public static String WECHATPAY_CCB;
	public static String WECHATPAY_SAND;
	
	public Constants() {
		
		super();
	}
	
	@PostConstruct
	public void init() {
		
		WECHATPAY_TENCENT = "";
		WECHATPAY_SWIFTPASS = "";
		WECHATPAY_ALLINPAY = "";
		WECHATPAY_CCB = "9";
		WECHATPAY_SAND = "";
		
	}
	
	public static String CCB_WECHAT_SUCCESS = "success";
	
	
	

}
