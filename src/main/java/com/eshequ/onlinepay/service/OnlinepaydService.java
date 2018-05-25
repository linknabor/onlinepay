package com.eshequ.onlinepay.service;

import java.util.Map;

/**
 * 支付接口
 * @author davidhardson
 *
 */
public interface OnlinepaydService {

	void wechatpay(Map<String, Object> map);
	
	void micropay(Map<String, Object> map);
	
	void query(Map<String, Object> map);
	
	void refund(Map<String, Object> map);

	void refundQuery(Map<String, Object> map);
	
	void reverse(Map<String, Object> map);
	
}
