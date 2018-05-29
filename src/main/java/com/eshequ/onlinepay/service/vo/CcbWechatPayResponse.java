/**
 * 
 */
package com.eshequ.onlinepay.service.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author davidhardson
 *
 */
public class CcbWechatPayResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7249969621003594834L;
	
	@JsonProperty("SUCCESS")
	private String success;
	
	@JsonProperty("PAYURL")
	private String payurl;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getPayurl() {
		return payurl;
	}

	public void setPayurl(String payurl) {
		this.payurl = payurl;
	}
	
	
	

}
