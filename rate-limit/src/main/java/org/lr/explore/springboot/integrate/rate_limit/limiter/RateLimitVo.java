package org.lr.explore.springboot.integrate.rate_limit.limiter;

import lombok.Getter;
import lombok.Setter;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2019-07-25 12:08:13
 */
@Getter
@Setter
public class RateLimitVo {

    private String url;

    private boolean isLimit;

    private Double interval;

    private Integer maxPermits;

    private Integer initialPermits;

}
