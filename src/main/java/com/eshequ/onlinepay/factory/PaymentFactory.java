/**
 * 
 */
package com.eshequ.onlinepay.factory;

import org.springframework.beans.factory.annotation.Autowired;

import com.eshequ.onlinepay.constant.Constants;
import com.eshequ.onlinepay.service.OnlinepayService;
import com.eshequ.onlinepay.service.impl.WechatPayServiceImpl;

/**
 * @author davidhardson
 *
 */
public class PaymentFactory {
	
	public PaymentFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	WechatPayServiceImpl wechatPayServiceImpl;
	
	public OnlinepayService getInstance(String platChannel) {

		OnlinepayService onlinepayService = null;
		if (Constants.WECHATPAY_CCB.equals(platChannel)) {
			onlinepayService = wechatPayServiceImpl;
		}else if (Constants.WECHATPAY_TENCENT.equals(platChannel)) {
			onlinepayService = null;	//TODO
		}else if (Constants.WECHATPAY_SWIFTPASS.equals(platChannel)) {
			onlinepayService = null;
		}
		return onlinepayService;
		
		
	} 

}
