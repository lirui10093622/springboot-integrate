package org.lr.explore.springboot.integrate.rate_limit;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lr.explore.springboot.integrate.rate_limit.limiter.RateLimitVo;
import org.lr.explore.springboot.integrate.rate_limit.limiter.TokenBucketLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenBucketLimiterTest {

    @Autowired
    private TokenBucketLimiter limiter;

    @Test
    public void testInit() {
        RateLimitVo vo = new RateLimitVo();
        vo.setInitialPermits(10);
        vo.setMaxPermits(10);
        vo.setInterval(2000.0);
        log.info("令牌桶限流初始化结果: {}", limiter.init("test", vo));
    }

    @Test
    public void testAcquire() {
        for (int i = 0; i < 1000; i++) {
            log.info("令牌获取结果: {}", limiter.acquire("test"));
        }
    }
}
