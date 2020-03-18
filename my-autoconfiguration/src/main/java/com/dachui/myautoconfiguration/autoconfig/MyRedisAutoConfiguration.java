package com.dachui.myautoconfiguration.autoconfig;

import com.dachui.myautoconfiguration.core.IMyRedis;
import com.dachui.myautoconfiguration.core.MyRedisClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 自定义启动类配置类
 */
@ConditionalOnClass(value = {Jedis.class, JedisPool.class, JedisPoolConfig.class})
@EnableConfigurationProperties(value = MyRedisProperties.class)
@Slf4j
@Configuration
public class MyRedisAutoConfiguration {

    @Autowired
    private MyRedisProperties tulingRedisProperties;


    @Bean
    @ConditionalOnProperty(prefix = "spring.tuling.redis",name = "USEHA",havingValue ="false")
    public JedisPool jedisPool() {
        log.info("自定义启动器加载------------->jedisPool");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(tulingRedisProperties.getMaxTotal());
        jedisPoolConfig.setMaxIdle(tulingRedisProperties.getMaxIdel());
        jedisPoolConfig.setMinIdle(tulingRedisProperties.getMinIdel());
        jedisPoolConfig.setTestOnBorrow(tulingRedisProperties.isTestOnBorrow());
        jedisPoolConfig.setTestOnReturn(tulingRedisProperties.isTestOnRetrun());

        JedisPool  jedisPool = new JedisPool(jedisPoolConfig,tulingRedisProperties.getHost(), tulingRedisProperties.getPort(),tulingRedisProperties.getTimeOut(),tulingRedisProperties.getPassword());
        return jedisPool;
    }

    @Bean
    @ConditionalOnBean(value = JedisPool.class)
    public IMyRedis tulingRedis(JedisPool jedisPool){
        log.info("加载了单机版的操作类------------>TulingRedisClient");
        IMyRedis tulingRedis = new MyRedisClient(jedisPool);
        return tulingRedis;
    }

}
