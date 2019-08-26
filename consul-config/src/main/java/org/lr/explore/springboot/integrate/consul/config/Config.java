package org.lr.explore.springboot.integrate.consul.config;

import java.io.Serializable;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "config")
public class Config implements Serializable {
    private String url;
    private String username;
    private String password;
}
