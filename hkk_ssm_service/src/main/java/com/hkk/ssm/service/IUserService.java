package com.hkk.ssm.service;

import com.hkk.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @auther kuikui
 * @create 2020-07-14 16:39
 */
public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(Integer id) throws Exception;
}
