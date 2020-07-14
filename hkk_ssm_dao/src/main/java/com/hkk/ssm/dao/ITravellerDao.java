package com.hkk.ssm.dao;

import com.hkk.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @auther kuikui
 * @create 2020-07-14 12:00
 */
public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(Integer ordersId) throws Exception;

}
