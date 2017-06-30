package com.laojiao.service.impl;

import com.laojiao.dao.ClassInfoMapper;
import com.laojiao.model.ClassInfo;
import com.laojiao.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Super.John on 2017/06/19.
 */
@Service
public class ClassServiceImpl implements ClassService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    ClassInfoMapper classInfoMapper;
    @Override
    public void insertClassInfo(ClassInfo classInfo) {
        classInfoMapper.insert(classInfo);
    }
}
