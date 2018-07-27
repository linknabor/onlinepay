package com.eshequ.onlinepay.mapper;

import java.util.List;

import com.eshequ.onlinepay.common.CommonMapper;
import com.eshequ.onlinepay.model.SpServeBillPayTrade;

public interface SpServeBillPayTradeMapper extends CommonMapper<SpServeBillPayTrade> {
 
	List<SpServeBillPayTrade> getBillTradeByCsp(String cspId);
		
	
}