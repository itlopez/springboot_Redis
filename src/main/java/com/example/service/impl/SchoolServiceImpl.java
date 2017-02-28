package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.constant.SchoolAreaRedisPrefix;
import com.example.dao.SchoolMapper;
import com.example.dao.redis.HashRedisDao;
import com.example.dao.redis.RedisBaseDao;
import com.example.dto.SchoolDto;
import com.example.entity.School;
import com.example.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/2/27.
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Autowired
    private HashRedisDao hashRedisDao;

    @Override
    public List<School> queryListSchoolByIndex(SchoolDto schoolDto) {
        return schoolMapper.queryListSchoolByIndex(schoolDto);
    }

    @Override
    public void putSchoolDataToRedis(SchoolDto schoolDto) {
        List<School> schoolList = schoolMapper.queryListSchoolByIndex(schoolDto);
        School school = schoolList.get(0);
        hashRedisDao.hset(SchoolAreaRedisPrefix.schoolPrefix + school.getOrgNo(), String.valueOf(school.getType()), JSON.toJSONString(school));
    }

    @Override
    public String getSchoolDataFromRedis(String key, String field) {
        return hashRedisDao.hget(key, field);
    }

    @Override
    @Transactional(rollbackFor={IllegalArgumentException.class})
    public void updateSchoolBySchoolIdService(SchoolDto schoolDto) {
        schoolMapper.updateSchoolBySchoolId(schoolDto);
        if (ObjectUtils.isEmpty(schoolDto.getSchoolKey())){
            throw new IllegalArgumentException("参数错误！");
        }
    }

    @Override
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public void updateSchoolBySchoolIdServiceNotRollback(SchoolDto schoolDto) {
        schoolMapper.updateSchoolBySchoolId(schoolDto);
        if (ObjectUtils.isEmpty(schoolDto.getSchoolKey())){
            throw new IllegalArgumentException("参数错误！");
        }
    }

}
