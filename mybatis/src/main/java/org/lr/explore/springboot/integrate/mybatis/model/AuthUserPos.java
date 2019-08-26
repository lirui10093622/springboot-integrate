package org.lr.explore.springboot.integrate.mybatis.model;

import lombok.Data;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2019-08-26 23:38:29
 */
@Data
public class AuthUserPos {
    private Long id;
    private Long userId;
    private Long posId;
    private Integer ehrMappingCount;
}
