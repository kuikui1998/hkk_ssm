package com.hkk.ssm.service;

import com.hkk.ssm.domain.Orders;

import java.util.List;

/**
 * @auther kuikui
 * @create 2020-07-13 17:35
 */
public interface IOrdersService {

    List<Orders> findAll(int page,int size) throws Exception;

    Orders findById(Integer ordersId) throws Exception;
}
