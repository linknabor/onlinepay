package com.eshequ.onlinepay.service;

import com.eshequ.onlinepay.web.dto.PayResponse;
import com.eshequ.onlinepay.web.vo.Order;

/**
 * 支付接口
 * @author davidhardson
 *
 */
public interface OnlinepaydService {

	PayResponse wechatpay(Order order);
	
	PayResponse micropay(Order order);
	
	void query(Order order);
	
	void refund(Order order);

	void refundQuery(Order order);
	
	void reverse(Order order);
	
}
