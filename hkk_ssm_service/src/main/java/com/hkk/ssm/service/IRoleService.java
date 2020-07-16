package com.hkk.ssm.service;

import com.hkk.ssm.domain.Role;

import java.util.List;

/**
 * @auther kuikui
 * @create 2020-07-16 19:18
 */
public interface IRoleService {

    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(Integer roleId) throws Exception;

    void deleteRoleById(Integer roleId) throws Exception;
}
