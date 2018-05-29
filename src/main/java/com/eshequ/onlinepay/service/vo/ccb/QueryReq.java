package com.eshequ.onlinepay.service.vo.ccb;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QueryReq implements Serializable {
	
//	7 START     起始日期 varChar(8) T 　 
//	8 STARTHOUR 开始小时 varChar(2) T 　 
//	9 STARTMIN  开始分钟 varChar(2) T 　 
//	10 END       截止日期 varChar(8) T 　 
//	11 ENDHOUR   结束小时 varChar(2) T 　 
//	12 ENDMIN    结束分钟 varChar(2) T 　 
//	13 KIND      流水类型 Char(1) F 0:未结流水,1:已结流水 
//	14 ORDER     订单号   varChar(30) F 按订单号查询时，时间段不起作用 
//	15 ACCOUNT   结算账户号 varChar(30) T 暂不用 
//	16 DEXCEL    文件类型 Char(1) F 默认为“1”，1:不压缩,2.压缩成zip文件 
//	17 MONEY     金额     Decimal(16,2) T 不支持以金额查询 
//	18 NORDERBY  排序     Char(1) F 1:交易日期,2:订单号 
//	19 PAGE      当前页次 Int F 　 
//	20 POS_CODE  柜台号   varChar(9) T 　 
//	21 STATUS    流水状态 Char(1) F 0:交易失败,1:交易成功,2:待银行确认(针对未结流水查询);3:全部 

	/**
	 * 
	 */
	private static final long serialVersionUID = 4420759119934660613L;
	
	@JsonProperty("START")
	private String start;
	@JsonProperty("STARTHOUR")
	private String starthour;
	@JsonProperty("STARTMIN")
	private String startmin;
	@JsonProperty("END")
	private String end;
	@JsonProperty("ENDHOUR")
	private String endhour;
	@JsonProperty("ENDMIN")
	private String endmin;
	@JsonProperty("KIND")
	private String kind;
	@JsonProperty("ORDER")
	private String order;
	@JsonProperty("ACCOUNT")
	private String account;
	@JsonProperty("DEXCEL")
	private String dexcel;
	@JsonProperty("MONEY")
	private String money;
	@JsonProperty("NORDERBY")
	private String norderby;
	@JsonProperty("PAGE")
	private String page;
	@JsonProperty("POS_CODE")
	private String pos_code;
	@JsonProperty("STATUS")
	private String status;
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getStarthour() {
		return starthour;
	}
	public void setStarthour(String starthour) {
		this.starthour = starthour;
	}
	public String getStartmin() {
		return startmin;
	}
	public void setStartmin(String startmin) {
		this.startmin = startmin;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getEndhour() {
		return endhour;
	}
	public void setEndhour(String endhour) {
		this.endhour = endhour;
	}
	public String getEndmin() {
		return endmin;
	}
	public void setEndmin(String endmin) {
		this.endmin = endmin;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
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
	public String getDexcel() {
		return dexcel;
	}
	public void setDexcel(String dexcel) {
		this.dexcel = dexcel;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getNorderby() {
		return norderby;
	}
	public void setNorderby(String norderby) {
		this.norderby = norderby;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getPos_code() {
		return pos_code;
	}
	public void setPos_code(String pos_code) {
		this.pos_code = pos_code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "QueryReqBody [start=" + start + ", starthour=" + starthour
				+ ", startmin=" + startmin + ", end=" + end + ", endhour="
				+ endhour + ", endmin=" + endmin + ", kind=" + kind
				+ ", order=" + order + ", account=" + account + ", dexcel="
				+ dexcel + ", money=" + money + ", norderby=" + norderby
				+ ", page=" + page + ", pos_code=" + pos_code + ", status="
				+ status + "]";
	}
	
	
	
	
}
