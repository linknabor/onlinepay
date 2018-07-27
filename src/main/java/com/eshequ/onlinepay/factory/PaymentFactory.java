/**
 * 
 */
package com.eshequ.onlinepay.factory;

import org.springframework.stereotype.Component;

import com.eshequ.onlinepay.constant.Constants;
import com.eshequ.onlinepay.service.OnlinepayService;
import com.eshequ.onlinepay.util.BeanUtil;

/**
 * @author davidhardson
 *
 */
@Component
public class PaymentFactory {
	
	public PaymentFactory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OnlinepayService getOnlinepayService(String platChannel) {
		
		String beanName = "";
		if (Constants.WECHATPAY_CCB.equals(platChannel)) {
			beanName = "CcbImpl";
		}else if (Constants.WECHATPAY_TENCENT.equals(platChannel)) {
			beanName = "WechatImpl";
		}else if (Constants.WECHATPAY_SWIFTPASS.equals(platChannel)) {
			beanName = "SwiftpassImpl";
		}else if (Constants.WECHATPAY_SAND.equals(platChannel)) {
			beanName = "SandImpl";
		}else if (Constants.WECHATPAY_ALLINPAY.equals(platChannel)) {
			beanName = "AllinpayImpl";
		}
		return BeanUtil.getBean(beanName, null);
		
	}

	
}
