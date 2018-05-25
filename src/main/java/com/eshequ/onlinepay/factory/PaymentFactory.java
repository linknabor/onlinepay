/**
 * 
 */
package com.eshequ.onlinepay.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshequ.onlinepay.constant.Constants;
import com.eshequ.onlinepay.service.OnlinepayChannel;
import com.eshequ.onlinepay.service.impl.AllinpayImpl;
import com.eshequ.onlinepay.service.impl.CcbImpl;
import com.eshequ.onlinepay.service.impl.SandImpl;
import com.eshequ.onlinepay.service.impl.SwiftpassImpl;
import com.eshequ.onlinepay.service.impl.WechatImpl;

/**
 * @author davidhardson
 *
 */
@Service
public class PaymentFactory {
	
	public PaymentFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private WechatImpl wechatImpl;
	@Autowired
	private SwiftpassImpl swiftpassImpl;
	@Autowired
	private SandImpl sandImpl;
	@Autowired
	private AllinpayImpl allinpayImpl;
	@Autowired
	private CcbImpl ccbImpl;
	
	
	public OnlinepayChannel getOnlinepayInstance(String platChannel) {
		
		OnlinepayChannel onlinepayChannel = null;
		
		if (Constants.WECHATPAY_CCB.equals(platChannel)) {
			onlinepayChannel = ccbImpl;
		}else {
			//TODO;
		}
		return onlinepayChannel;
	}
	
	
}
