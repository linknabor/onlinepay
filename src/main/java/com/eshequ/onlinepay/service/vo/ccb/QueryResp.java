package com.eshequ.onlinepay.service.vo.ccb;

import java.io.Serializable;

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
	
	private String cur_page;
	private String page_count;
	private String notice;
	
	/*
	 * /QueryRespDetail理论上应该定义成List<QueryRespDetail>，但由于XMLSerializer这个工具类的BUG，在LIST只有一个元素的时候，
	 * 会将LIST转换成其对应的泛型类型，因此这里不再定义成LIST。
	 */
	private QueryRespDetail list;

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

	public QueryRespDetail getList() {
		return list;
	}

	public void setList(QueryRespDetail list) {
		this.list = list;
	}

	
	
}
