package com.hkk.ssm.dao;

import com.hkk.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @auther kuikui
 * @create 2020-07-15 14:30
 */
public interface IPermissionDao {
    //查询与role关联的所有权限
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(Integer id) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

    @Select("select * from permission where id = #{id}")
    Permission findById(Integer id)throws Exception;

    @Delete("delete from permission where id=#{id}")
    void deleteById(Integer id) throws Exception;

    @Delete("delete from role_permission where permissionId=#{id}")
    void deleteFromRole_Permission(Integer id) throws Exception;
}
