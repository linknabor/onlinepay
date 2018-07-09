/**
 * 
 */
package com.eshequ.onlinepay.web.vo;

import java.io.Serializable;


/**
 * @author huym
 * 物业订单
 * 此类还可以继承 Order类，WuyeOrder只代表当前系统中的物业费、停车费、租金
 *
 */
public class Order implements Serializable{

	private static final long serialVersionUID = 8125516361675978484L;
	
	private String orderId;		//商户交易ID
	private MchInfo mchInfo;	//商户信息
	private String openId;		//微信用户openid，公众号支付必填，扫码支付选填
	private String totalFee;	//支付总金额
	private String body;		//商品描述
	private String detail;		//商品详细描述
	private String attach;		//附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
	private String authCode;	//条码,扫码支付用,扫码支付必填
	private String platChannel;	//支付渠道
	private String notifyUrl;   //交易结果通知地址
	private String limitPay;    //支付限制-暂时只对微信支付有效,仅支持 no_credit,通联支付
	private String transactionId;	//全局交易ID

	public Order() {
		super();
	}
	
//	public Order(String orderId, MchInfo mchInfo){
//		this();
//		this.orderId = orderId;
//		this.mchInfo = mchInfo;
//		this.platChannel = mchInfo.getPlat_channel();
//	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getPlatChannel() {
		return platChannel;
	}

	public void setPlatChannel(String platChannel) {
		this.platChannel = platChannel;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getLimitPay() {
		return limitPay;
	}

	public void setLimitPay(String limitPay) {
		this.limitPay = limitPay;
	}

	public MchInfo getMchInfo() {
		return mchInfo;
	}

	public void setMchInfo(MchInfo mchInfo) {
		this.mchInfo = mchInfo;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", mchInfo=" + mchInfo + ", openId=" + openId + ", totalFee=" + totalFee
				+ ", body=" + body + ", detail=" + detail + ", attach=" + attach + ", authCode=" + authCode
				+ ", platChannel=" + platChannel + ", notifyUrl=" + notifyUrl + ", limitPay=" + limitPay
				+ ", transactionId=" + transactionId + "]";
	}

	
	
}
