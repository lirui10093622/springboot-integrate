package org.lr.explore.springboot.integrate.mybatis.model;

import lombok.Data;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2019-08-26 23:39:02
 */
@Data
public class AuthUserRole {
    private Long id;
    private Long userId;
    private Long roleId;
    private Integer ehrMappingCount;
}
