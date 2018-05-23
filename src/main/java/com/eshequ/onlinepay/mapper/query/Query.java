/*
 * Copyright (c) 2018. Beyondsoft Corporation.
 * All Rights Reserved.
 *
 * BEYONDSOFT CONFIDENTIALITY
 *
 * The information in this file is confidential and privileged from Beyondsoft Corporation,
 * which is intended only for use solely by Beyondsoft Corporation.
 * Disclosure, copying, distribution, or use of the contents of this file by persons other than Beyondsoft Corporation
 * is strictly prohibited and may violate applicable laws.
 */
package com.eshequ.onlinepay.mapper.query;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 分页查询参数
 *
 * @date: 2018-01-24
 * @version: 1.0
 * @author: scott.che@beyondsoft.com
 */
public class Query extends LinkedHashMap<String, Object> {

    private static final String QUERY_PAGE_NUMBER_KEY = "page";

    private static final String QUERY_LIMIT_NUMBER_KEY = "limit";

    private static final long serialVersionUID = 1L;
    /**
     * 当前页码
     */
    private int page = 1;

    /**
     * 每页条数
     */
    private int limit = 10;

    public Query(Map<String, Object> params) {
        this.putAll(params);
        //分页参数
        if (params.get(QUERY_PAGE_NUMBER_KEY) != null) {
            this.page = Integer.parseInt(params.get(QUERY_PAGE_NUMBER_KEY).toString());
        }
        if (params.get(QUERY_LIMIT_NUMBER_KEY) != null) {
            this.limit = Integer.parseInt(params.get(QUERY_LIMIT_NUMBER_KEY).toString());
        }
        this.remove(QUERY_PAGE_NUMBER_KEY);
        this.remove(QUERY_LIMIT_NUMBER_KEY);
    }

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
    
    
    

}
