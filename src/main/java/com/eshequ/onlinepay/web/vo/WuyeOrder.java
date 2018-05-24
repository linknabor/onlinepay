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
public abstract class WuyeOrder implements Serializable{

	private static final long serialVersionUID = 8125516361675978484L;
	
	private String orderId;		//交易ID
	private String openId;		//微信用户openid，公众号支付必填，扫码支付选填
	private String totalFee;	//支付总金额
	private String body;		//商品描述
	private String detail;		//商品详细描述
	private String attach;		//附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
	private String sectId;		//小区ID
	private String cspId;		//物业ID
	private String payMethod;	//支付方式
	private String payScenarios;//支付场景
	private String platChannel;	//支付渠道
	private String notifyUrl;   //交易结果通知地址
	private String limitPay;    //支付限制-暂时只对微信支付有效,仅支持 no_credit,通联支付
	
	private MchInfo mchInfo;	//商户信息

	public WuyeOrder() {
		super();
	}
	
	public WuyeOrder(String orderId, MchInfo mchInfo){
		this();
		this.orderId = orderId;
		this.mchInfo = mchInfo;
		this.platChannel = mchInfo.getPlat_channel();
	}

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

	public String getPayScenarios() {
		return payScenarios;
	}

	public void setPayScenarios(String payScenarios) {
		this.payScenarios = payScenarios;
	}
	public String getSectId() {
		return sectId;
	}

	public void setSectId(String sectId) {
		this.sectId = sectId;
	}
	
	public String getCspId() {
		return cspId;
	}

	public void setCspId(String cspId) {
		this.cspId = cspId;
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

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public MchInfo getMchInfo() {
		return mchInfo;
	}

	public void setMchInfo(MchInfo mchInfo) {
		this.mchInfo = mchInfo;
	}

	@Override
	public String toString() {
		return "WuyeOrder [orderId=" + orderId + ", openId=" + openId + ", totalFee=" + totalFee + ", body=" + body
				+ ", detail=" + detail + ", attach=" + attach + ", sectId=" + sectId + ", cspId=" + cspId
				+ ", payMethod=" + payMethod + ", payScenarios=" + payScenarios + ", platChannel=" + platChannel
				+ ", notifyUrl=" + notifyUrl + ", limitPay=" + limitPay + ", mchInfo=" + mchInfo + "]";
	}
	
	
	
}
