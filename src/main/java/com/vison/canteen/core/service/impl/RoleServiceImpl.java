package com.vison.canteen.core.service.impl;

import com.vison.canteen.biz.common.BaseServiceImpl;
import com.vison.canteen.biz.util.BeanUtil;
import com.vison.canteen.biz.util.LongUtils;
import com.vison.canteen.biz.util.StringUtils;
import com.vison.canteen.core.bean.DTO.RoleDTO;
import com.vison.canteen.core.bean.PO.PermissionPO;
import com.vison.canteen.core.bean.PO.RolePO;
import com.vison.canteen.core.bean.VO.RoleVO;
import com.vison.canteen.core.exception.CanteenException;
import com.vison.canteen.core.mapper.RoleMapper;
import com.vison.canteen.core.service.PermissionService;
import com.vison.canteen.core.service.RolePermissionService;
import com.vison.canteen.core.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangwenshen 2018/3/31 16:59
 */
@Slf4j
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, RolePO> implements RoleService {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 通过角色id集合查询角色列表
     *
     * @param roleIds
     * @return
     */
    @Override
    public List<RolePO> selectRoleListByIds(List<Long> roleIds) {
        return baseMapper.selectRoleListByIds(roleIds);
    }

    @Override
    public List<PermissionPO> getPermissionListById(Long roleId) {
        List<Long> permissionIds = rolePermissionService.getPermissionIdsByRoleId(roleId);
        List<PermissionPO> permissionPOList = permissionService.selectBatchIds(permissionIds);
        return permissionPOList;
    }

    /**
     * 新增角色
     *
     * @param roleDTO
     * @return
     * @throws CanteenException
     */
    @Override
    public Boolean addRole(RoleDTO roleDTO) throws CanteenException {
        if (roleDTO == null) {
            log.error("roleDTO不能为null");
            throw CanteenException.ROLE_NULL_EXCEPTION;
        }
        if (roleDTO.getAble() != null) {
            log.error("新增角色时,默认可用,不能设置可用性");
            throw CanteenException.ROLE_CANT_SET_ABLE_EXCEPTION;
        }
        RolePO rolePO = new RolePO();
        BeanUtil.copyProperties(roleDTO, rolePO);
        rolePO.setId(null);
        return super.insert(rolePO);

    }

    /**
     * 更新角色
     *
     * @param roleDTO
     * @return
     */
    @Override
    public Boolean updateRole(RoleDTO roleDTO) throws CanteenException {
        if (roleDTO == null) {
            log.error("roleDTO不能为null");
            throw CanteenException.ROLE_NULL_EXCEPTION;
        }
        if (StringUtils.isEmpty(roleDTO.getId())) {
            log.error("id不能为null");
            throw CanteenException.ROLE_NULL_ID_EXCEPTION;
        }
        RolePO rolePO = super.selectById(roleDTO.getId());
        if (rolePO == null) {
            log.error("该角色数据不存在,id = [{}]", roleDTO.getId());
            throw CanteenException.ROLE_NULL_DATA_EXCEPTION;
        } else {
            BeanUtil.copyProperties(roleDTO, rolePO);
            rolePO.setId(LongUtils.StringToLong(roleDTO.getId()));
            return super.updateById(rolePO);
        }
    }

    @Override
    public Boolean deleteRoleById(Long id) {
        return super.deleteById(id);
    }

    @Override
    public Boolean deleteRoleByIds(List<Long> roleIds) {
        return super.deleteBatchIds(roleIds);
    }


    @Override
    public List<RoleVO> getAllRole() {
        List<RolePO> rolePOList = baseMapper.getAllRole();
        List<RoleVO> roleVOList = rolePOList.parallelStream().map(e -> {
            RoleVO roleVO = new RoleVO();
            BeanUtil.copyProperties(e, roleVO);
            roleVO.setId(e.getId().toString());
            return roleVO;
        }).collect(Collectors.toList());
        return roleVOList;
    }

}
