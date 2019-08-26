package org.lr.explore.springboot.integrate.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lr.explore.springboot.integrate.mybatis.model.EhrDepartmentMapping;
import org.springframework.stereotype.Repository;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2019-08-26 23:08:54
 */
@Repository
public interface EhrDepartmentMappingMapper {

    @Select("select * from ehr_department_mapping ehr_department_id = #{ehrDepartmentId}")
    List<EhrDepartmentMapping> selectByEhrDepartmentId(@Param("ehrDepartmentId") Long ehrDepartmentId);
}
