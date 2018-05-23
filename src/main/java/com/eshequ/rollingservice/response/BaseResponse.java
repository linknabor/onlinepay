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
 * 针对客户端请求的响应类. 包含响应码和响应信息.
 *
 * @date: 2018-01-24
 * @version: 1.0
 * @author: scott.che@beyondsoft.com
 */
public class BaseResponse {
    private int status = 200;
    private String message = "ok";

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
