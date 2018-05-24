/**
 * 
 */
package com.eshequ.onlinepay.service;

import java.util.Map;

import com.eshequ.onlinepay.web.vo.PaymentOrder;

/**
 * @author davidhardson
 *
 */
public interface OnlinepayService {
	
	Map<String, Object> wechatpay(PaymentOrder paymentOrder);
	
	Map<String, Object> query();

}
