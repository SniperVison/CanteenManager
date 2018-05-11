package com.vison.canteen.biz.config;

import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author huangwenshen 2018/4/9 18:21
 */
@Configuration
public class RedisConfig {

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private int port;

    @Value("${redis.database}")
    private int datebase;

    @Value("${redis.password}")
    private String password;

    @Value("${redis.block-when-exhausted}")
    private boolean blockWhenExhausted;

    @Value("${redis.max-idle}")
    private int maxIdle;

    @Value("${redis.time-between-eviction-runs-millis}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${redis.jmx-enabled}")
    private boolean jmxEnabled;

    @Value("${redis.min-idle}")
    private int minIdle;

    @Value("${redis.max-total}")
    private int maxTotal;

    @Value("${redis.num-tests-per-eviction-run}")
    private int numTestsPerEvictionRun;

    @Value("${redis.max-wait-millis}")
    private long maxWaitMillis;

    @Value("${redis.test-on-return}")
    private boolean testOnReturn;

    @Value("${redis.test-on-borrow}")
    private boolean testOnBorrow;

    @Value("${redis.test-while-idle}")
    private boolean testWhileIdle;

    /**
     * 配置shiro redisManager
     *
     * @return
     */
    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPassword(password);
        redisManager.setDatabase(datebase);
        redisManager.setPort(port);
//        redisManager.setTimeout(timeout);
        redisManager.setExpire(1800);
        redisManager.setJedisPoolConfig(this.jedisPoolConfig());
        return redisManager;
    }

    /**
     * 使用redis实现cacheManager缓存
     *
     * @return
     */
    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(this.redisManager());
        return redisCacheManager;
    }

    /**
     * 配置JedisPoolConfig
     *
     * @return
     */
    @Bean
    @ConfigurationProperties("redis")
    public JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

}
