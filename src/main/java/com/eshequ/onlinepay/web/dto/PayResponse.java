package com.eshequ.onlinepay.web.dto;

import java.io.Serializable;

public class PayResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4654472860874963880L;
	
	private String out_trade_no;	//商户交易号
	private String transaction_id;	//全局交易ID
	private String return_code;	//返回码
	private String return_msg;	//返回信息
	private String result_code;	//业务返回码
	private String err_code;	//错误码
	private String err_code_des;	//错误描述
	private String pay_url;	//移动端支付链接,建行和威富通用
	
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
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
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public String getPay_url() {
		return pay_url;
	}
	public void setPay_url(String pay_url) {
		this.pay_url = pay_url;
	}
	
	

}
