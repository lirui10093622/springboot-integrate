package org.lr.explore.springboot.integrate.rate_limit.limiter;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2019-07-25 12:09:25
 */
public enum RateLimitMethod {

    //initialize rate limiter
    init,

    //modify rate limiter parameter
    modify,

    //delete rate limiter
    delete,

    //acquire permits
    acquire;
}
