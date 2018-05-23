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
package com.eshequ.rollingservice.response;

/**
 * 返回结果是对象类型时的模板.
 *
 * @param <T> 结果类型.
 * @date: 2018-01-24
 * @version: 1.0
 * @author: scott.che@beyondsoft.com
 */
public class ObjectRestResponse<T> extends BaseResponse {

    T data;

    public ObjectRestResponse<T> data(T data) {
        this.setData(data);
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
