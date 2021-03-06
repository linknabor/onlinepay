package com.eshequ.onlinepay.web.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4654472860874963880L;
	
	private String out_trade_no = "";	//商户交易号
	private String trade_water_id = "";	//同上
	private String transaction_id = "";	//全局交易ID
	private String return_code = "";	//返回码
	private String return_msg = "";	//返回信息
	private String result_code = "";	//业务返回码
	private String err_code = "";	//错误码
	private String err_code_des = "";	//错误描述
	@JsonProperty("jsApiMap")
	private JsApi jsApi;	//页面支付用集合
	
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
		this.trade_water_id = out_trade_no;
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
	public JsApi getJsApi() {
		return jsApi;
	}
	public void setJsApi(JsApi jsApi) {
		this.jsApi = jsApi;
	}
	public String getTrade_water_id() {
		return trade_water_id;
	}
	public void setTrade_water_id(String trade_water_id) {
		this.trade_water_id = trade_water_id;
	}
	
	
}
