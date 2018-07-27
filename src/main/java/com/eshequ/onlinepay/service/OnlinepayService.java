package com.eshequ.onlinepay.service;

import com.eshequ.onlinepay.web.vo.Order;
import com.eshequ.onlinepay.web.vo.PayResponse;
import com.eshequ.onlinepay.web.vo.QueryResponse;

/**
 * 支付接口
 * @author davidhardson
 *
 */
public interface OnlinepayService {

	PayResponse wechatpay(Order order);
	
	PayResponse micropay(Order order);
	
	QueryResponse query(Order order);
	
	void refund(Order order);

	void refundQuery(Order order);
	
	void reverse(Order order);
	
}
