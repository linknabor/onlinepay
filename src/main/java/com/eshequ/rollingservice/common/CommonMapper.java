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
package com.eshequ.rollingservice.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 共通Mapper.
 *
 * @date: 2018-01-24
 * @version: 1.0
 * @author: scott.che@beyondsoft.com
 */
public interface CommonMapper<T> extends MySqlMapper<T>, Mapper<T> {
	//TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
