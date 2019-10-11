package com.cos.common.config.redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/7/31 15:22
 * @Classname: RedisUtils
 * @To change this template use File | Settings | File Templates.
 */
@Service
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    // 获取缓存数据
    public Object get(String key) {
        return this.get(key, RedisConfig.DB);
    }

    // 删除缓存
    public void delete(String key) {
        this.delete(key, RedisConfig.DB);
    }

    // 缓存添加
    public void set(String key, Object val) {
        this.set(key, val, RedisConfig.DB);
    }

    // 设置时间的-添加缓存
    public void set(String key, Object val, Long times) {
        this.set(key, val, times, RedisConfig.DB);
    }

    // 设置时间的-添加缓存
    public void set(String key, Object val, Long times, int db) {
        JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) redisTemplate.getConnectionFactory();
        jedisConnectionFactory.setDatabase(db);
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        ValueOperations valueOperations = redisTemplate.opsForValue();

        valueOperations.set(key, val, times, TimeUnit.SECONDS);
    }

    // 添加
    public Object get(String key, int db) {
        JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) redisTemplate.getConnectionFactory();
        jedisConnectionFactory.setDatabase(db);
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        ValueOperations valueOperations = redisTemplate.opsForValue();

        return valueOperations.get(key);
    }

    // 删除缓存
    public void delete(String key, int db) {
        JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) redisTemplate.getConnectionFactory();
        jedisConnectionFactory.setDatabase(db);
        redisTemplate.setConnectionFactory(jedisConnectionFactory);

        redisTemplate.delete(key);
    }

    // 缓存添加
    public void set(String key, Object val, int db) {
        JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) redisTemplate.getConnectionFactory();
        jedisConnectionFactory.setDatabase(db);
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, val);
    }
}
