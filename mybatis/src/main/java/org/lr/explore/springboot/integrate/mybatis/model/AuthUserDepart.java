package org.lr.explore.springboot.integrate.mybatis.model;

import lombok.Data;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2019-08-26 23:06:30
 */
@Data
public class AuthUserDepart {
    private Long id;
    private Long userId;
    private Long departmentId;
    private Integer ehrMappingCount;
}
