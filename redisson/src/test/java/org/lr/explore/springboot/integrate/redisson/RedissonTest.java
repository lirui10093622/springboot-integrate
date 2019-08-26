package org.lr.explore.springboot.integrate.redisson;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonTest {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void testLockMultiple() {

        Executor executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                RLock lock = redissonClient.getLock("lock:test");
                try {
                    lock.lock();
                    log.info("获取到锁, thread: {}", Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (Exception e) {
                    log.error("发生异常", e);
                } finally {
                    lock.unlock();
                }
            });
        }
    }

    @Test
    public void testLock() {
        RLock lock = redissonClient.getLock("lock:test");
        try {
            lock.lock();
            log.info("获取到锁, thread: {}", Thread.currentThread().getName());
            Thread.sleep(50000);
        } catch (Exception e) {
            log.error("发生异常", e);
        } finally {
            lock.unlock();
        }
    }

    @Test
    public void testLockOther() {
        RLock lock = redissonClient.getLock("lock:test");
        try {
            lock.lock();
            log.info("获取到锁, thread: {}", Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (Exception e) {
            log.error("发生异常", e);
        } finally {
            lock.unlock();
        }
    }

    @Test
    public void testTryLock() {
        RLock lock = redissonClient.getLock("lock:test");
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                log.info("获取到锁, thread: {}", Thread.currentThread().getName());
            } else {
                log.info("等待时间之内没有拿到锁");
            }
        } catch (Exception e) {
            log.error("发生异常", e);
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}
