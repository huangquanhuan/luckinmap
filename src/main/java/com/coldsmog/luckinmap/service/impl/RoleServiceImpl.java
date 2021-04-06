package com.coldsmog.luckinmap.service.impl;

import com.coldsmog.luckinmap.mapper.RoleMapper;
import com.coldsmog.luckinmap.model.entity.Role;
import com.coldsmog.luckinmap.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色表，保存角色名和对应权限等级(Role)表服务实现类
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:26
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Integer insertByProperty(Role role) {
        return this.roleMapper.insertByProperty(role);
    }

    @Override
    public Integer insertBatchByProperty(List<Role> list) {
        return this.roleMapper.insertBatchByProperty(list);
    }

    @Override
    public Integer updateByPrimaryKey(Role role) {
        return this.roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public Integer updateBatchByPrimaryKey(List<Role> list) {
        return this.roleMapper.updateBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return this.roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatchByPrimaryKey(List<Integer> list) {
        return this.roleMapper.deleteBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByProperty(Role role) {
        return this.roleMapper.deleteByProperty(role);
    }

    @Override
    public Role selectByPrimaryKey(Integer id) {
        return this.roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> selectByProperty(Role role) {
        return this.roleMapper.selectByProperty(role);
    }

    @Override
    public Long countByProperty(Role role) {
        return this.roleMapper.countByProperty(role);
    }
}
