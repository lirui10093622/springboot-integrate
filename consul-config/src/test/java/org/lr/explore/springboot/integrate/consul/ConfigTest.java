package org.lr.explore.springboot.integrate.consul;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lr.explore.springboot.integrate.consul.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigTest {

    @Autowired
    private Config config;

    @Test
    public void testConfig() {
        System.out.println(config.getUrl());
        System.out.println(config.getUsername());
        System.out.println(config.getPassword());
    }
}
