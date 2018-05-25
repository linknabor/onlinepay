/**
 * 
 */
package com.eshequ.onlinepay.service.impl;

import java.util.Map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.onlinepay.service.RecordService;

/**
 * @author davidhardson
 *
 */
@Service
public class RecordServiceImp implements RecordService {

	/* (non-Javadoc)
	 * @see com.eshequ.onlinepay.service.RecordService#recordOrder(java.util.Map)
	 */
	@Async
	@Override
	@Transactional
	public void recordOrder(Map<String, Object> map) {
		// TODO Auto-generated method stub

	}

}
