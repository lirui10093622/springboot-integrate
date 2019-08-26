package org.lr.explore.springboot.integrate.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lr.explore.springboot.integrate.mybatis.model.EhrPositionMapping;
import org.springframework.stereotype.Repository;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2019-08-26 23:42:43
 */
@Repository
public interface EhrPositionMappingMapper {
    @Select("select * from ehr_position_mapping ehr_position_id = #{ehrPositionId}")
    List<EhrPositionMapping> selectByEhrPositionId(@Param("ehrPositionId") Long ehrPositionId);
}
