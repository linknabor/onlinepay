package com.eshequ.onlinepay.mapper;

import com.eshequ.onlinepay.entity.SpBaseCsp;

public interface SpBaseCspMapper {
    int deleteByPrimaryKey(Long cspId);

    int insert(SpBaseCsp record);

    int insertSelective(SpBaseCsp record);

    SpBaseCsp selectByPrimaryKey(Long cspId);

    int updateByPrimaryKeySelective(SpBaseCsp record);

    int updateByPrimaryKey(SpBaseCsp record);
}