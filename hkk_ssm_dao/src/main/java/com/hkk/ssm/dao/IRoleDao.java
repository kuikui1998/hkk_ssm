package com.hkk.ssm.dao;

import com.hkk.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @auther kuikui
 * @create 2020-07-14 17:44
 */
public interface IRoleDao {

    //根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.hkk.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(Integer userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    @Select("select * from role where id = #{roleId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.hkk.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(Integer roleId);

    @Delete("delete from users_role where roleId = #{roleId}")
    void deleteFromUser_RoleByRoleId(Integer roleId);

    @Delete("delete from role_permission where roleId = #{roleId}")
    void deleteFromRole_PermissionByRoleId(Integer roleId);

    @Delete("delete from role where id = #{roleId}")
    void deleteRoleById(Integer roleId);
}
