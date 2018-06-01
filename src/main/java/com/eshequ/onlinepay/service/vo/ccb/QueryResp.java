package com.eshequ.onlinepay.service.vo.ccb;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QueryResp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1340882516186813582L;
	
//	8 CUR_PAGE 当前页次 Int T 　 
//	9 PAGE_COUNT 总页次 Int T 　 
//	10 NOTICE 提示 varChar(200) T 提示信息 
//	List（多条信息） 
//	List End
	
	@JsonProperty("CUR_PAGE")
	private String cur_page;
	@JsonProperty("PAGE_COUNT")
	private String page_count;
	@JsonProperty("NOTICE")
	private String notice;
	
	/*
	 * /QueryRespDetail理论上应该定义成List<QueryRespDetail>，但由于XMLSerializer这个工具类的BUG，在LIST只有一个元素的时候，
	 * 会将LIST转换成其对应的泛型类型，因此这里不再定义成LIST。
	 */
	@JsonProperty("LIST")
	private List<QueryRespDetail> list;

	public String getCur_page() {
		return cur_page;
	}

	public void setCur_page(String cur_page) {
		this.cur_page = cur_page;
	}

	public String getPage_count() {
		return page_count;
	}

	public void setPage_count(String page_count) {
		this.page_count = page_count;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public List<QueryRespDetail> getList() {
		return list;
	}

	public void setList(List<QueryRespDetail> list) {
		this.list = list;
	}

	
	
}
