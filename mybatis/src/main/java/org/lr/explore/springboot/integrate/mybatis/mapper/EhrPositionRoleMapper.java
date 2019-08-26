package org.lr.explore.springboot.integrate.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lr.explore.springboot.integrate.mybatis.model.EhrPositionRole;
import org.springframework.stereotype.Repository;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2019-08-26 23:43:03
 */
@Repository
public interface EhrPositionRoleMapper {
    @Select("select * from ehr_position_mapping ehr_position_id = #{ehrPositionId}")
    List<EhrPositionRole> selectByEhrPositionId(@Param("ehrPositionId") Long ehrPositionId);
}
