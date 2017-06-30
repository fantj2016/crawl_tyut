package com.laojiao.service.impl;

import com.laojiao.dao.CodeInfoMapper;
import com.laojiao.model.CodeInfo;
import com.laojiao.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Super.John on 2017/06/19.
 */
@Service
public class CodeServiceImpl implements CodeService{
    @Autowired
    CodeInfoMapper codeInfoMapper;
    @Override
    public void insertCodeTable(CodeInfo codeInfo) {
        codeInfoMapper.insert(codeInfo);
    }
}
