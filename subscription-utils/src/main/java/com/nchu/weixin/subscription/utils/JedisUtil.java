package com.nchu.weixin.subscription.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * java redis 工具类
 * Created by fujianjian on 2016/12/15.
 */
@Component
@Slf4j
public class JedisUtil {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    private static final String CHAR_ENCODING = "UTF-8";

    private static final String GOODS_SERIAL_NO_KEY = "CURRENT_GOODS_SERIAL_NO_VALUE";

    private static final String ORDER_SERIAL_NO_KEY = "CURRENT_ORDERE_SERIAL_NO_VALUE";

    /**
     * 获取redis键值对
     * @param key
     * @return
     * @throws Exception
     */
    public String get(String key) throws Exception {
        RedisConnection connection = redisConnectionFactory.getConnection();
        byte[] keyByte = key.getBytes(CHAR_ENCODING);
        try {
            byte[] bytes = connection.get(keyByte);
            if(bytes == null){
                return null;
            }
            return new String(bytes, CHAR_ENCODING);
        } catch (Exception e) {
            log.warn("redis 获取数据出现情况，现发起一次重复连接", e);
            if (connection != null) {
                connection.close();
            }
            connection = redisConnectionFactory.getConnection();
            byte[] bytes = connection.get(keyByte);
            if(bytes == null){
                return null;
            }
            return new String(bytes, CHAR_ENCODING);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * 设置redis键值对
     * @param key
     * @param value
     * @param cacheSeconds 如果为0，则永久不过期，否则n秒后过期
     * @throws Exception
     */
    public void set(String key, String value, int cacheSeconds) throws Exception {
        RedisConnection connection = redisConnectionFactory.getConnection();
        byte[] keyByte = key.getBytes("UTF-8");
        byte[] valueByte = value.getBytes(CHAR_ENCODING);
        try {
            connection.set(keyByte, valueByte);
            if (cacheSeconds != 0) {
                connection.expire(keyByte, cacheSeconds);
            }
        } catch (Exception e) {
            log.warn("redis 保存数据出现情况，现发起一次重复连接", e);
            if (connection != null) {
                connection.close();
            }
            connection = redisConnectionFactory.getConnection();
            connection.set(keyByte, valueByte);
            if (cacheSeconds != 0) {
                connection.expire(keyByte, cacheSeconds);
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * 删除
     * @param keys
     * @return
     * @throws Exception
     */
    public long del(String ...keys) throws Exception {
        RedisConnection connection = redisConnectionFactory.getConnection();
        byte[][] keyBytes= new byte[keys.length][];
        for(int i=0;i<keys.length;i++){
            keyBytes[i] = keys[i].getBytes(CHAR_ENCODING);
        }
        try {
            return connection.del(keyBytes);
        } catch (Exception e) {
            log.warn("redis 获取数据出现情况，现发起一次重复连接", e);
            if (connection != null) {
                connection.close();
            }
            connection = redisConnectionFactory.getConnection();
            return connection.del(keyBytes);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * 自增长+1
     * @param key
     * @return
     * @throws Exception
     */
    public long incr(String key) throws Exception {
        RedisConnection connection = redisConnectionFactory.getConnection();
        byte[] keyByte = key.getBytes(CHAR_ENCODING);
        try {
            return connection.incr(keyByte);
        } catch (Exception e) {
            log.warn("redis 获取数据出现情况，现发起一次重复连接", e);
            if (connection != null) {
                connection.close();
            }
            connection = redisConnectionFactory.getConnection();
            return connection.incr(keyByte);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * 设置过期时间
     * @param key
     * @return
     * @throws Exception
     */
    public void expire(String key, int cacheSeconds) throws Exception {
        RedisConnection connection = redisConnectionFactory.getConnection();
        byte[] keyByte = key.getBytes(CHAR_ENCODING);
        try {
            if (cacheSeconds != 0) {
                connection.expire(keyByte, cacheSeconds);
            }
        } catch (Exception e) {
            log.warn("redis 获取数据出现情况，现发起一次重复连接", e);
            if (connection != null) {
                connection.close();
            }
            connection = redisConnectionFactory.getConnection();
            if (cacheSeconds != 0) {
                connection.expire(keyByte, cacheSeconds);
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public boolean tryLock(String key) throws Exception{
        long incr = incr(key);
        if(incr == 1){
            expire(key, 10);//10秒后自动释放锁，防止死锁
            return true;
        }else{
            return false;
        }
    }

    public void releaseLock(String key) throws Exception{
        set(key, "0", 0);
    }
}