package com.hkk.ssm.service.impl;

import com.hkk.ssm.dao.IPermissionDao;
import com.hkk.ssm.domain.Permission;
import com.hkk.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther kuikui
 * @create 2020-07-16 20:57
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception {

        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

    @Override
    public Permission findById(Integer id) throws Exception {
        return permissionDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) throws Exception{
        permissionDao.deleteFromRole_Permission(id);
        permissionDao.deleteById(id);
    }
}
