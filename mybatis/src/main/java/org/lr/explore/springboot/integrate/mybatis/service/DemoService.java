package org.lr.explore.springboot.integrate.mybatis.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.lr.explore.springboot.integrate.mybatis.mapper.AuthUserDepartMapper;
import org.lr.explore.springboot.integrate.mybatis.mapper.AuthUserPosMapper;
import org.lr.explore.springboot.integrate.mybatis.mapper.AuthUserRoleMapper;
import org.lr.explore.springboot.integrate.mybatis.mapper.EhrDepartmentMappingMapper;
import org.lr.explore.springboot.integrate.mybatis.mapper.EhrPositionMappingMapper;
import org.lr.explore.springboot.integrate.mybatis.mapper.EhrPositionRoleMapper;
import org.lr.explore.springboot.integrate.mybatis.model.AuthUserDepart;
import org.lr.explore.springboot.integrate.mybatis.model.AuthUserPos;
import org.lr.explore.springboot.integrate.mybatis.model.AuthUserRole;
import org.lr.explore.springboot.integrate.mybatis.model.EhrDepartmentMapping;
import org.lr.explore.springboot.integrate.mybatis.model.EhrPositionMapping;
import org.lr.explore.springboot.integrate.mybatis.model.EhrPositionRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2019-08-26 23:12:56
 */
@Service
public class DemoService {
    @Autowired
    private EhrDepartmentMappingMapper ehrDepartmentMappingMapper;
    @Autowired
    private AuthUserDepartMapper authUserDepartMapper;
    @Autowired
    private EhrPositionMappingMapper ehrPositionMappingMapper;
    @Autowired
    private AuthUserPosMapper authUserPosMapper;
    @Autowired
    private EhrPositionRoleMapper ehrPositionRoleMapper;
    @Autowired
    private AuthUserRoleMapper authUserRoleMapper;

    public void adjust(Long userId, Long departmentId, Long positionId) {

        {
            authUserDepartMapper.deleteMapping(userId);
            List<EhrDepartmentMapping> mappingDepartments = ehrDepartmentMappingMapper.selectByEhrDepartmentId(departmentId);

            Map<Long, Long> departIdEhrMappingCount = mappingDepartments.stream()
                .collect(Collectors.groupingBy(EhrDepartmentMapping::getAuthDepartmentId, Collectors.counting()));

            Set<Long> mappingDepartmentIds = mappingDepartments.stream().map(EhrDepartmentMapping::getAuthDepartmentId).distinct()
                .collect(Collectors.toSet());
            List<Long> authDepartmentIds = authUserDepartMapper.selectByUserId(userId);

            Collection<Long> intersectionDepartmentIds = CollectionUtils.intersection(mappingDepartmentIds, authDepartmentIds);
            if (CollectionUtils.isNotEmpty(intersectionDepartmentIds)) {
                authUserDepartMapper.deleteBatch(userId, intersectionDepartmentIds);
            }

            mappingDepartmentIds.removeAll(intersectionDepartmentIds);
            if (CollectionUtils.isNotEmpty(mappingDepartmentIds)) {
                authUserDepartMapper.insertBatch(mappingDepartmentIds.stream().map(e -> new AuthUserDepart()).collect(Collectors.toList()));
            }
        }

        {
            authUserPosMapper.deleteMapping(userId);
            List<EhrPositionMapping> mappingPositions = ehrPositionMappingMapper.selectByEhrPositionId(positionId);

            Map<Long, Long> posIdEhrMappingCount = mappingPositions.stream()
                .collect(Collectors.groupingBy(EhrPositionMapping::getAuthPositionId, Collectors.counting()));

            Set<Long> mappingPositionIds = mappingPositions.stream().map(EhrPositionMapping::getAuthPositionId).distinct()
                .collect(Collectors.toSet());
            List<Long> authPositionIds = authUserPosMapper.selectByUserId(userId);

            Collection<Long> intersectionPositionIds = CollectionUtils.intersection(mappingPositionIds, authPositionIds);
            if (CollectionUtils.isNotEmpty(intersectionPositionIds)) {
                authUserPosMapper.deleteBatch(userId, intersectionPositionIds);
            }

            mappingPositionIds.removeAll(intersectionPositionIds);
            if (CollectionUtils.isNotEmpty(mappingPositionIds)) {
                authUserPosMapper.insertBatch(mappingPositionIds.stream().map(e -> new AuthUserPos()).collect(Collectors.toList()));
            }
        }

        {
            authUserRoleMapper.deleteMapping(userId);
            List<EhrPositionRole> mappingRoles = ehrPositionRoleMapper.selectByEhrPositionId(positionId);

            Map<Long, Long> roleIdEhrMappingCount = mappingRoles.stream()
                .collect(Collectors.groupingBy(EhrPositionRole::getAuthRoleId, Collectors.counting()));

            Set<Long> mappingRoleIds = mappingRoles.stream().map(EhrPositionRole::getAuthRoleId).distinct()
                .collect(Collectors.toSet());
            List<Long> authRoleIds = authUserRoleMapper.selectByUserId(userId);

            Collection<Long> intersectionRoleIds = CollectionUtils.intersection(mappingRoleIds, authRoleIds);
            if (CollectionUtils.isNotEmpty(intersectionRoleIds)) {
                authUserRoleMapper.deleteBatch(userId, intersectionRoleIds);
            }

            mappingRoleIds.removeAll(intersectionRoleIds);
            if (CollectionUtils.isNotEmpty(mappingRoleIds)) {
                authUserRoleMapper.insertBatch(mappingRoleIds.stream().map(e -> new AuthUserRole()).collect(Collectors.toList()));
            }
        }
    }
}
