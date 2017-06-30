package com.laojiao.dao;

import com.laojiao.model.CodeInfo;

public interface CodeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeInfo record);

    int insertSelective(CodeInfo record);

    CodeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeInfo record);

    int updateByPrimaryKey(CodeInfo record);
}