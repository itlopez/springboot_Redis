package com.example;

import com.alibaba.fastjson.JSON;
import com.example.constant.SchoolAreaRedisPrefix;
import com.example.dao.SchoolMapper;
import com.example.dao.redis.ValueRedisDao;
import com.example.dto.SchoolDto;
import com.example.entity.School;
import com.example.service.SchoolService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

	@Autowired
	private ValueRedisDao valueRedisDao;

	@Autowired
	private SchoolService schoolService;

	@Autowired
	private SchoolMapper schoolMapper;


	/**
	 * 使用string模型demo
	 */
	@Test
	public void contextLoads() {
		this.valueRedisDao.save("lopez");
		System.out.println(this.valueRedisDao.getParam());

	}

	/**
	 * 使用hash模型hset demo
	 */
	@Test
	public void putSchoolDataToRedis(){
		SchoolDto schoolDto = new SchoolDto();
		schoolDto.setFromIndex(0);
		schoolDto.setToIndex(10000);
		schoolService.putSchoolDataToRedis(schoolDto);
	}

	/**
	 * 使用hash模型hget demo
	 */
	@Test
	public void getSchoolDataFromRedis(){

		List<School> schoolList = schoolMapper.queryListSchoolByIndex(new SchoolDto());
		School school = schoolList.get(0);
		String schoolStr = schoolService.getSchoolDataFromRedis(SchoolAreaRedisPrefix.schoolPrefix + school.getOrgNo(), String.valueOf(school.getType()));
		System.out.println(schoolStr);
	}
}
