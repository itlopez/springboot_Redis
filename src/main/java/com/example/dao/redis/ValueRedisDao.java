package com.example.dao.redis;

import com.example.dao.redis.RedisBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/2/28.
 */
@Repository
public class ValueRedisDao {

    @Autowired
    public RedisBaseDao redisBaseDao;

    private String getKey(){
        return "param";
    }

    public void save(String param){
        this.redisBaseDao.addValue(this.getKey(), param);
    }

    public String getParam(){
        return this.redisBaseDao.getValue(this.getKey());
    }

}