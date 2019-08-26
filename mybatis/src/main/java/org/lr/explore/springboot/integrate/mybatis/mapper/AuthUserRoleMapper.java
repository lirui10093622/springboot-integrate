package org.lr.explore.springboot.integrate.mybatis.mapper;

import java.util.Collection;
import java.util.List;
import org.lr.explore.springboot.integrate.mybatis.model.AuthUserRole;
import org.springframework.stereotype.Repository;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2019-08-26 23:47:26
 */
@Repository
public interface AuthUserRoleMapper {

    int deleteMapping(Long userId);

    List<Long> selectByUserId(Long userId);

    int deleteBatch(Long userId, Collection<Long> roleIds);

    int insertBatch(List<AuthUserRole> list);
}
