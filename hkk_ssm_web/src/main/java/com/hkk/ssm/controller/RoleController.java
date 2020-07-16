package com.hkk.ssm.controller;

import com.hkk.ssm.domain.Role;
import com.hkk.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @auther kuikui
 * @create 2020-07-16 19:16
 */
@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    IRoleService roleService;

    @RequestMapping("/deleteRole.do")
    public String deleteRole(@RequestParam(name = "id",required = true) Integer roleId) throws Exception{
        roleService.deleteRoleById(roleId);
        return "redirect:findAll.do";
    }

    //角色详情查询
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer roleId) throws Exception{
       ModelAndView mv = new ModelAndView();
       Role role = roleService.findById(roleId);
       mv.addObject("role",role);
       mv.setViewName("role-show");
       return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {

        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();

        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

}
