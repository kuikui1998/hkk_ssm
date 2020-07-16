package com.hkk.ssm.service;

import com.hkk.ssm.domain.Permission;

import java.util.List;

/**
 * @auther kuikui
 * @create 2020-07-16 20:57
 */
public interface IPermissionService {

    public List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(Integer id) throws Exception;

    void deleteById(Integer id) throws  Exception;
}
