package com.eshequ.onlinepay.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.eshequ.onlinepay.service.OnlinepayChannel;
import com.eshequ.onlinepay.web.dto.PayResponse;
import com.eshequ.onlinepay.web.vo.Order;

@Service
public class SwiftpassImpl extends OnlinepayChannel{

	@Override
	public PayResponse wechatpay(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PayResponse micropay(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void query(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refund(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refundQuery(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reverse(Order order) {
		// TODO Auto-generated method stub
		
	}


}
