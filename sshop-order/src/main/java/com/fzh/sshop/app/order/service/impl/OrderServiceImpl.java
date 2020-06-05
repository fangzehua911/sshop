package com.fzh.sshop.app.order.service.impl;

import com.fzh.sshop.feigncient.ShopService;
import com.fzh.sshop.app.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ShopService shopService;

    @Override
    public String test(String name) {
        return shopService.test1();
    }

    @Override
    public String test2(String name) {
        return shopService.test2(name);
    }


    @Override
    public String test3(String name) {
        return shopService.test3(name);
    }



}

