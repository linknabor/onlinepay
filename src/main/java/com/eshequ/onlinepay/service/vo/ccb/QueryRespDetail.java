/**
 * 
 */
package com.eshequ.onlinepay.service.vo.ccb;

import java.io.Serializable;

/**
 * @author huym
 *
 */
public class QueryRespDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918711131977295629L;

//	11 TRAN_DATE 交易日期 varChar(32) T 　 
//	12 ACC_DATE 记账日期 varChar(32) T 　 
//	13 ORDER 订单号 varChar(30) T 　 
//	14 ACCOUNT 付款方账号 varChar(30) T 　 
//	15 PAYMENT_MONEY 支付金额 Decimal(16,2) T 　 
//	16 REFUND_MONEY 退款金额 Decimal(16,2) T 　 
//	17 POS_ID 柜台号 varChar(9) T 　 
//	18 REM1 备注1 varChar(32) T 　 
//	19 REM2 备注2  varChar(32) T 　 
//	20 ORDER_STATUS 订单状态 Char(1) T 0:失败,1:成功,2:待银行确认,3:已部分退款,4:已全额退款,5:待银行确认 

	private String trade_date;
	private String acct_date;
	private String order;
	private String account;
	private String payment_money;
	private String refund_money;
	private String pos_id;
	private String rem1;
	private String rem2;
	private String order_status;
	
	public String getTrade_date() {
		return trade_date;
	}
	public void setTrade_date(String trade_date) {
		this.trade_date = trade_date;
	}
	public String getAcct_date() {
		return acct_date;
	}
	public void setAcct_date(String acct_date) {
		this.acct_date = acct_date;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPayment_money() {
		return payment_money;
	}
	public void setPayment_money(String payment_money) {
		this.payment_money = payment_money;
	}
	public String getRefund_money() {
		return refund_money;
	}
	public void setRefund_money(String refund_money) {
		this.refund_money = refund_money;
	}
	public String getPos_id() {
		return pos_id;
	}
	public void setPos_id(String pos_id) {
		this.pos_id = pos_id;
	}
	public String getRem1() {
		return rem1;
	}
	public void setRem1(String rem1) {
		this.rem1 = rem1;
	}
	public String getRem2() {
		return rem2;
	}
	public void setRem2(String rem2) {
		this.rem2 = rem2;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	@Override
	public String toString() {
		return "QueryDetail [trade_date=" + trade_date + ", acct_date="
				+ acct_date + ", order=" + order + ", account=" + account
				+ ", payment_money=" + payment_money + ", refund_money="
				+ refund_money + ", pos_id=" + pos_id + ", rem1=" + rem1
				+ ", rem2=" + rem2 + ", order_status=" + order_status + "]";
	}
	
	
	
}
