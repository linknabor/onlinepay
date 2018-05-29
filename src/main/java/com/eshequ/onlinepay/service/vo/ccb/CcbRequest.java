package com.eshequ.onlinepay.service.vo.ccb;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CcbRequest<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7853735608047691169L;

	public CcbRequest(CcbReqBody<T> tx) {
		super();
		this.tx = tx;
	}
	@JsonProperty("TX")
	private CcbReqBody<T> tx;

	public CcbReqBody<T> getTx() {
		return tx;
	}
	public void setTx(CcbReqBody<T> tx) {
		this.tx = tx;
	}

}
