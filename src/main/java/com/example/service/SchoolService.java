package com.example.service;

import com.example.dto.SchoolDto;
import com.example.entity.School;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by lopez on 2017/2/27.
 */
public interface SchoolService {

    List<School> queryListSchoolByIndex(SchoolDto schoolDto);

    void putSchoolDataToRedis(SchoolDto schoolDto);

    String getSchoolDataFromRedis(String key, String field);

    void updateSchoolBySchoolIdService(SchoolDto schoolDto);

    void updateSchoolBySchoolIdServiceNotRollback(SchoolDto schoolDto);
}
