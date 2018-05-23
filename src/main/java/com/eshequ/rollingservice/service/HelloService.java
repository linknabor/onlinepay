package com.eshequ.rollingservice.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.rollingservice.mapper.SpServeBillPayTradeMapper;
import com.eshequ.rollingservice.model.SpServeBillPayTrade;
import com.eshequ.rollingservice.util.HttpUtil;

@Service
public class HelloService {

	private Logger logger = LoggerFactory.getLogger(HelloService.class);
	
	@Autowired
    private SpServeBillPayTradeMapper spServeBillPayTradeMapper;

	
	public void testHttp() {
		
		String str = "hello world !";
		String url = "http://127.0.0.1:8082/shanghai/servplat/login.do";
		String resp = HttpUtil.doGet(url);
		logger.info("resp is : " + resp);
	}
	
	@Transactional
	public void testInsert() {
		
		SpServeBillPayTrade trade = new SpServeBillPayTrade();
		trade.setTradeWaterId(912323232323232323l);
		trade.setMergerStatus("02");
		trade.setTranAmt(new BigDecimal("100"));
		trade.setCspId(0l);
		trade.setSectId(0l);
		//baseDao.selectByPrimaryKey(912323232323232323l, SpServeBillPayTrade.class);
//		spServeBillPayTradeMapper.insert(trade);
		
		List<SpServeBillPayTrade> list = spServeBillPayTradeMapper.select(trade);
		for (int i = 0; i < list.size(); i++) {
			SpServeBillPayTrade t = list.get(i);
			System.out.println(t.toString());
		}
		
		
	}
	
	
}
