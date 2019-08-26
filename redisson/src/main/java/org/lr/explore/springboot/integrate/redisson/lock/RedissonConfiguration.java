package org.lr.explore.springboot.integrate.redisson.lock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * redisson 配置类
 * Created on 2018/6/19
 */
@Configuration
public class RedissonConfiguration {

    @Bean
    public RedissonClient getRedissonClient(@Value("${spring.redis.host}") String host,
        @Value("${spring.redis.port}") int port,
        @Value("${spring.redis.password}") String password) {
        Config config = new Config();
        config.useSingleServer().setAddress(host + ":" + port);
        return Redisson.create(config);
    }
}
