/**
 * 
 */
package com.eshequ.onlinepay.service.vo.ccb;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author huym
 * @param <T>
 *
 */
public class CcbReqBody<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3134288749659611847L;
	
//	REQUEST_SN 请求序列号 varChar(16) F 只可以使用数字 
//	2 CUST_ID 商户号 varChar(21) F 字符型char，网银商户号 
//	3 USER_ID 操作员号 varChar(21) F 20051210后必须使用 
//	4 PASSWORD 密码 varChar(32) F 操作员号交易密码 
//	5 TX_CODE 交易码 varChar(6) F 交易请求码 
//	6 LANGUAGE 语言 varChar(2) F CN 

	@JsonProperty("REQUEST_SN")
	private String request_sn;
	
	@JsonProperty("CUST_ID")
	private String cust_id;
	
	@JsonProperty("USER_ID")
	private String user_id;
	
	@JsonProperty("PASSWORD")
	private String password;

	@JsonProperty("TX_CODE")
	private String tx_code;
	
	@JsonProperty("LANGUAGE")
	private String language;
	
	@JsonProperty("TX_INFO")
	private T tx_info;
	
	public String getRequest_sn() {
		return request_sn;
	}
	public void setRequest_sn(String request_sn) {
		this.request_sn = request_sn;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTx_code() {
		return tx_code;
	}
	public void setTx_code(String tx_code) {
		this.tx_code = tx_code;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public T getTx_info() {
		return tx_info;
	}
	public void setTx_info(T tx_info) {
		this.tx_info = tx_info;
	}

	
	
}
