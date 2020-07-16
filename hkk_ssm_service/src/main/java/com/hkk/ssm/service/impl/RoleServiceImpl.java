package com.hkk.ssm.service.impl;

import com.hkk.ssm.dao.IRoleDao;
import com.hkk.ssm.domain.Role;
import com.hkk.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther kuikui
 * @create 2020-07-16 19:18
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(Integer roleId) throws Exception {

        return roleDao.findById(roleId);
    }

    @Override
    public void deleteRoleById(Integer roleId) throws Exception {
        //从user_role表中删除
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        //从role_permission表中删除
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        //从role表中删除
        roleDao.deleteRoleById(roleId);
    }
}
