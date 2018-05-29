/**
 * 
 */
package com.eshequ.onlinepay.web.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author davidhardson
 *
 */
public class JsApi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5058957717903329265L;
	
	public JsApi() {
		super();
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("appId")
	private String appid;
	
	@JsonProperty("timeStamp")
	private String timestamp;
	
	@JsonProperty("nonceStr")
	private String noncestr;
	
	@JsonProperty("package")
	private String pack;
	
	@JsonProperty("signType")
	private String signType;
	
	@JsonProperty("paySign")
	private String paysign;

	@JsonProperty("out_trade_no")
	private String trade_water_id;
	
	private String token_id;	//威富通用
	
	@JsonProperty("PAYURL")
	private String pay_url;	//建行用
	
	@JsonIgnore
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	@JsonIgnore
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@JsonIgnore
	public String getNoncestr() {
		return noncestr;
	}

	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	@JsonIgnore
	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	@JsonIgnore
	public String getPaysign() {
		return paysign;
	}

	public void setPaysign(String paysign) {
		this.paysign = paysign;
	}

	public String getToken_id() {
		return token_id;
	}

	public void setToken_id(String token_id) {
		this.token_id = token_id;
	}

	@JsonIgnore
	public String getTrade_water_id() {
		return trade_water_id;
	}

	public void setTrade_water_id(String trade_water_id) {
		this.trade_water_id = trade_water_id;
	}

	public String getPay_url() {
		return pay_url;
	}

	public void setPay_url(String pay_url) {
		this.pay_url = pay_url;
	}
	
	
	
}
