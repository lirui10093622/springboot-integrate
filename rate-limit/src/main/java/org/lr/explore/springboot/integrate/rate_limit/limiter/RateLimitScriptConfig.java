package org.lr.explore.springboot.integrate.rate_limit.limiter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2019-07-25 12:11:30
 */
@Configuration
public class RateLimitScriptConfig {

    @Bean("rateLimitLua")
    public DefaultRedisScript<Long> getRateLimitScript() {
        DefaultRedisScript<Long> rateLimitLua = new DefaultRedisScript<>();
        rateLimitLua.setLocation(new ClassPathResource("rate_limit.lua"));
        rateLimitLua.setResultType(Long.class);
        return rateLimitLua;
    }
}
