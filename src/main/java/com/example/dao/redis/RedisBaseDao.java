package com.example.dao.redis;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by lopez on 2017/2/28.
 */
@Repository
public class RedisBaseDao {

    @Resource(name="redisTemplate")
    protected ValueOperations<String, String> valueOperations;

    @Resource(name="redisTemplate")
    protected HashOperations<String,String,String> hashOperations;

    void addValue(String key, String value){
        valueOperations.set(key, value);
    }

    String getValue(String key){
        return valueOperations.get(key);
    }

    void hset(String key, String field, String value){
        hashOperations.put(key, field, value);
    }

    String hget(String key, String field){
       return  hashOperations.get(key,field);
    }
}
