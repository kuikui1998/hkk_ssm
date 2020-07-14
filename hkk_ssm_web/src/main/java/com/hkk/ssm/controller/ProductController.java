package com.hkk.ssm.controller;

import com.hkk.ssm.domain.Product;
import com.hkk.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @auther kuikui
 * @create 2020-07-13 12:18
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    //添加产品
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }

    //查询全部产品
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list1");
        return mv;
    }

}
