/**
 * 
 */
package com.eshequ.onlinepay.web.vo;

/**
 * @author huym
 * 物业订单
 * 此类还可以继承 Order类，WuyeOrder只代表当前系统中的物业费、停车费、租金
 */
public class PaymentOrder extends WuyeOrder{
	
	private static final long serialVersionUID = 7091142086936638491L;

	public PaymentOrder() {
		super();
	}

	@Override
	public String toString() {
		return "PaymentOrder [getOrderId()=" + getOrderId() + ", getOpenId()=" + getOpenId() + ", getTotalFee()="
				+ getTotalFee() + ", getBody()=" + getBody() + ", getDetail()=" + getDetail() + ", getAttach()="
				+ getAttach() + ", getPayScenarios()=" + getPayScenarios() + ", getSectId()=" + getSectId()
				+ ", getCspId()=" + getCspId() + ", getPlatChannel()=" + getPlatChannel() + ", getNotifyUrl()="
				+ getNotifyUrl() + ", getLimitPay()=" + getLimitPay() + ", getPayMethod()=" + getPayMethod()
				+ ", getMchInfo()=" + getMchInfo() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	

}
