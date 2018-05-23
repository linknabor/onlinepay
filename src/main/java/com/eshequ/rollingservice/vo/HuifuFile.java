/**
 * 
 */
package com.eshequ.rollingservice.vo;

import java.io.Serializable;

/**
 * @author davidhardson
 *
 */
public class HuifuFile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4040495540397107524L;
	
	private String mchId;		//商户号
	private String mchName;		//商户名称
	private String terminalNo;	//逻辑终端号
	private String voucherNo;	//凭证号
	private String orderNo;		//汇付订单号
	private String outerOrderNo;//外部订单号
	private String tradeType;	//交易类型
	private String payMethod;	//交易方式
	private String tranAmt;		//交易金额
	private String consultAmt;	//商户手续费
	private String acctAmt;		//入账金额
	private String refundAmt;	//退款金额
	private String tranStatus;	//交易状态
	private String tranTime;	//交易时间
	private String tranDate;	//交易日期
	private String cardNum;		//付款银行卡卡号
	private String loanFlag;	//借贷标志
	private String referNo;		//参考号
	private String originOrderNo;	//原汇付交易订单号
	private String originReferNo;	//原交易参考号
	private String originOuterOrderNo;	//原外部交易订单号

	/**
	 * 
	 */
	public HuifuFile() {
		// TODO Auto-generated constructor stub
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getMchName() {
		return mchName;
	}

	public void setMchName(String mchName) {
		this.mchName = mchName;
	}

	public String getTerminalNo() {
		return terminalNo;
	}

	public void setTerminalNo(String terminalNo) {
		this.terminalNo = terminalNo;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOuterOrderNo() {
		return outerOrderNo;
	}

	public void setOuterOrderNo(String outerOrderNo) {
		this.outerOrderNo = outerOrderNo;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(String tranAmt) {
		this.tranAmt = tranAmt;
	}

	public String getConsultAmt() {
		return consultAmt;
	}

	public void setConsultAmt(String consultAmt) {
		this.consultAmt = consultAmt;
	}

	public String getAcctAmt() {
		return acctAmt;
	}

	public void setAcctAmt(String acctAmt) {
		this.acctAmt = acctAmt;
	}

	public String getRefundAmt() {
		return refundAmt;
	}

	public void setRefundAmt(String refundAmt) {
		this.refundAmt = refundAmt;
	}

	public String getTranStatus() {
		return tranStatus;
	}

	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}

	public String getTranTime() {
		return tranTime;
	}

	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}

	public String getTranDate() {
		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getLoanFlag() {
		return loanFlag;
	}

	public void setLoanFlag(String loanFlag) {
		this.loanFlag = loanFlag;
	}

	public String getReferNo() {
		return referNo;
	}

	public void setReferNo(String referNo) {
		this.referNo = referNo;
	}

	public String getOriginOrderNo() {
		return originOrderNo;
	}

	public void setOriginOrderNo(String originOrderNo) {
		this.originOrderNo = originOrderNo;
	}

	public String getOriginReferNo() {
		return originReferNo;
	}

	public void setOriginReferNo(String originReferNo) {
		this.originReferNo = originReferNo;
	}

	public String getOriginOuterOrderNo() {
		return originOuterOrderNo;
	}

	public void setOriginOuterOrderNo(String originOuterOrderNo) {
		this.originOuterOrderNo = originOuterOrderNo;
	}
	
	
	

}
