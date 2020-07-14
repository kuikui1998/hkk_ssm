package com.hkk.ssm.dao;

import com.hkk.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @auther kuikui
 * @create 2020-07-14 11:56
 */
public interface IMemberDao {

    @Select("select * from member where id=#{id}")
    public Member findById(Integer id) throws Exception;

}
