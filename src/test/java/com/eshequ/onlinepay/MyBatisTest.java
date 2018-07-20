package com.eshequ.onlinepay;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.eshequ.onlinepay.config.AppConfig;
import com.eshequ.onlinepay.mapper.SpBaseCspMapper;
import com.eshequ.onlinepay.mapper.SpServeBillPayTradeMapper;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
@WebAppConfiguration
public class MyBatisTest {
	
	
	@Autowired
	private SpBaseCspMapper spBaseCspMapper;
	
	@Autowired
	private SpServeBillPayTradeMapper billPayTradeMapper;
	
	@Test
	public void testQuery() {
		
		SpBaseCspMapper csp = spBaseCspMapper.selectByPrimaryKey(1);
		System.out.println(csp.toString());
		
	}
	
}
