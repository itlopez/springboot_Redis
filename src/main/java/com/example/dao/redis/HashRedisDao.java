package com.example.dao.redis;

/**
 * Created by lopez on 2017/2/28.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/2/28.
 */
@Repository
public class HashRedisDao {

    @Autowired
    public RedisBaseDao redisBaseDao;

    public void hset(String key, String field, String value){
        this.redisBaseDao.hset(key, field, value);
    }

    public String hget(String key, String field){
       return this.redisBaseDao.hget(key, field);
    }
}
