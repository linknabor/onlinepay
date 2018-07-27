package com.eshequ.onlinepay.service.impl;

import org.springframework.stereotype.Service;

import com.eshequ.onlinepay.service.OnlinepayService;
import com.eshequ.onlinepay.web.vo.Order;
import com.eshequ.onlinepay.web.vo.PayResponse;
import com.eshequ.onlinepay.web.vo.QueryResponse;

@Service
public class SandImpl implements OnlinepayService {

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
	public QueryResponse query(Order order) {
		return null;
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
