package com.eshequ.onlinepay.service;

import org.springframework.stereotype.Service;

import com.eshequ.onlinepay.service.OnlinepaydService;

/**
 * 抽象渠道。每个渠道继承抽象渠道需要实现各自渠道的支付、查询、退款、撤单动作
 * @author davidhardson
 *
 */
@Service
public abstract class OnlinepayChannel implements OnlinepaydService{
	
	private String name;	//渠道名称
	private String value;	//渠道值

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	
}
