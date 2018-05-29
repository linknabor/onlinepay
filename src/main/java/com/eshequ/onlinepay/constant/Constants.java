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
	
	/*微信支付标准返回值*/
	public final static String WECHAT_SUCCESS = "SUCCESS";
	public final static String WECHAT_FAIL = "FAIL";
	public final static String WECHAT_PAYING = "USERPAYING";
	public final static String WECHAT_REFUNDING = "REFUND";
	public final static String WECHAT_PROCESSING = "PROCESSING";
	public final static String WECHAT_NOTSURE = "NOTSURE";
	public final static String WECHAT_CHANGE = "CHANGE";
	

}
