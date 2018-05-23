package com.eshequ.rollingservice.service.liquidate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class LiquidateContextFactory {

	private Map<String, LiquidateService> strategyMap = new HashMap<>();

	public Map<String, LiquidateService> getMap() {
		return strategyMap;
	}

	public void setMap(Map<String, LiquidateService> map) {
		this.strategyMap = map;
	}
	
	public void startLiquidate(String liquidateType, String liquidateDate) {
		
		strategyMap.get(liquidateType).startLiquidate(liquidateDate);
	}
	
}
