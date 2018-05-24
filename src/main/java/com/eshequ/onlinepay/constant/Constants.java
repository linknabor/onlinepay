/**
 * 
 */
package com.eshequ.onlinepay.constant;

import javax.annotation.PostConstruct;

/**
 * @author davidhardson
 *
 */
public class Constants {
	
	public static String WECHATPAY_TENCENT;
	public static String WECHATPAY_SWIFTPASS;
	public static String WECHATPAY_ALLINPAY;
	public static String WECHATPAY_CCB;
	
	@PostConstruct
	public void init() {
		
		WECHATPAY_TENCENT = "";
		WECHATPAY_SWIFTPASS = "";
		WECHATPAY_ALLINPAY = "";
		WECHATPAY_CCB = "";
		
	};
	
	
	

}
