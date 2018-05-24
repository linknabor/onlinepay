/**
 * 
 */
package com.eshequ.onlinepay.web.vo;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;


/**
 * @author huym
 *
 */
public class MchInfo implements Serializable{

	private static final long serialVersionUID = -7446460169198633581L;
	
	private String mch_id;	//商户号
	private String secret;	//支付密钥
	private String appid;	//APPID
	
	private String mch_name;	//商户名称
	private String mch_type;	//商户类型
	private String plat_channel;	//平台类型
	private String bank_acct;	//银行账户
	private String acct_name;	//银行账户名称
	private String bank_name;	//开户行名称
	
	public MchInfo() {
		super();
	}
	
	public <T> MchInfo(T t){

		super();
		if (t != null) {
			BeanUtils.copyProperties(t, this);
		}
		
	}

	public MchInfo(String mch_id, String secret, String appid) {
		super();
		this.mch_id = mch_id;
		this.secret = secret;
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_name() {
		return mch_name;
	}

	public void setMch_name(String mch_name) {
		this.mch_name = mch_name;
	}

	public String getMch_type() {
		return mch_type;
	}

	public void setMch_type(String mch_type) {
		this.mch_type = mch_type;
	}

	public String getPlat_channel() {
		return plat_channel;
	}

	public void setPlat_channel(String plat_channel) {
		this.plat_channel = plat_channel;
	}

	public String getBank_acct() {
		return bank_acct;
	}

	public void setBank_acct(String bank_acct) {
		this.bank_acct = bank_acct;
	}

	public String getAcct_name() {
		return acct_name;
	}

	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	@Override
	public String toString() {
		return "MchInfo [mch_id=" + mch_id + ", secret=" + secret + ", appid="
				+ appid + ", mch_name=" + mch_name + ", mch_type=" + mch_type
				+ ", plat_channel=" + plat_channel + ", bank_acct=" + bank_acct
				+ ", acct_name=" + acct_name + ", bank_name=" + bank_name + "]";
	}


}
