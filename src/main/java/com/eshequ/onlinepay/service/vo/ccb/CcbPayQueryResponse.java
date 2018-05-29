package com.eshequ.onlinepay.service.vo.ccb;

import java.io.Serializable;

public class CcbPayQueryResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1707206165205299801L;
	
	private String trade_state;
	private String trade_stat_desc;
	private String total_fee;
	private String other_payId;
	private String transaction_id;
	private String result_code;
	private String return_code;
	private String return_msg;
	
	public CcbPayQueryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTrade_state() {
		return trade_state;
	}

	public void setTrade_state(String trade_state) {
		this.trade_state = trade_state;
	}

	public String getTrade_stat_desc() {
		return trade_stat_desc;
	}

	public void setTrade_stat_desc(String trade_stat_desc) {
		this.trade_stat_desc = trade_stat_desc;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getOther_payId() {
		return other_payId;
	}

	public void setOther_payId(String other_payId) {
		this.other_payId = other_payId;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
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
	
	
	
	
}
