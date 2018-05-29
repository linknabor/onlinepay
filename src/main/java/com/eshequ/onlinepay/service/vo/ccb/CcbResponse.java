package com.eshequ.onlinepay.service.vo.ccb;

import java.io.Serializable;

public class CcbResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7853735608047691169L;
	
	public CcbResponse() {
		super();
	}

	private CcbRespBody<T> tx;
	
	public CcbResponse(CcbRespBody<T> tx) {
		super();
		this.tx = tx;
	}

	public CcbRespBody<T> getTx() {
		return tx;
	}

	public void setTx(CcbRespBody<T> tx) {
		this.tx = tx;
	}

	@Override
	public String toString() {
		return "CcbResponse [tx=" + tx + "]";
	}
	
	
	
}
