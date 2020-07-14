package com.hkk.ssm.service;

import com.hkk.ssm.domain.Product;

import java.util.List;

/**
 * @auther kuikui
 * @create 2020-07-13 12:03
 */
public interface IProductService {

    public List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;
}
