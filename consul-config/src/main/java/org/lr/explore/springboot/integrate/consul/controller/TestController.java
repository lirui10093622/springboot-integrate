package org.lr.explore.springboot.integrate.consul.controller;

import org.lr.explore.springboot.integrate.consul.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2019-07-27 11:17:11
 */
@RestController
@RequestMapping("api/consul")
public class TestController {

    @Autowired
    private Config config;

    @RequestMapping("/config")
    public String getConfig() {
        return "url: " + config.getUrl() + ", username: " + config.getUsername() + ", password: " + config.getPassword();
    }
}
