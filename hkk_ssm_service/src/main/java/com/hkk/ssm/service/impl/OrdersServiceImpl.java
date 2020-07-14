package com.hkk.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.hkk.ssm.dao.IOrdersDao;
import com.hkk.ssm.domain.Orders;
import com.hkk.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther kuikui
 * @create 2020-07-13 17:36
 */
@Service
@Transactional
public class OrdersServiceImpl  implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page , int size) throws Exception {

        //参数pageNum是页码值  参数pageSize代表是每页显示条数
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(Integer ordersId) throws Exception {

        return ordersDao.findById(ordersId);
    }
}
