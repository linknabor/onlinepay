/**
 * 
 */
package com.eshequ.onlinepay.service.vo.ccb;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author davidhardson
 * @param <T>
 *
 */
public class CcbRespBody<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 335452220003470754L;

//	1 REQUEST_SN 请求序列号 varChar(16) F 同请求报文中的序列号 
//	2 CUST_ID 商户号 varChar(21) F 同请求报文中的商户号 
//	3 TX_CODE 交易码 varChar(6) F 同请求报文中的交易码 
//	4 RETURN_CODE 响应码 varChar(12) F 交易响应码 
//	5 RETURN_MSG 响应信息 varChar(99) T 交易响应信息 
//	7 LANGUAGE 语言 varChar(2) F CN，同请求报文 

	@JsonProperty("REQUEST_SN")
	private String request_sn;
	@JsonProperty("CUST_ID")
	private String cust_id;
	@JsonProperty("TX_CODE")
	private String tx_code;
	@JsonProperty("RETURN_CODE")
	private String return_code;
	@JsonProperty("RETURN_MSG")
	private String return_msg;
	@JsonProperty("LANGUAGE")
	private String language;
	
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
	public String getTx_code() {
		return tx_code;
	}
	public void setTx_code(String tx_code) {
		this.tx_code = tx_code;
	}
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
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
	@Override
	public String toString() {
		return "CcbRespBody [request_sn=" + request_sn + ", cust_id=" + cust_id
				+ ", tx_code=" + tx_code + ", return_code=" + return_code
				+ ", return_msg=" + return_msg + ", language=" + language
				+ ", tx_info=" + tx_info + "]";
	}
	
	
	
}
