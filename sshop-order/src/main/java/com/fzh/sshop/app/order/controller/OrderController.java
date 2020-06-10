package com.fzh.sshop.app.order.controller;

import com.fzh.sshop.app.order.service.impl.OrderServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/test9/{name}")
    public String test9(@PathVariable("name") String name ){
        return  "succ"+name;
    }



    @GetMapping("/test/{name}")
    public String test(@PathVariable("name") String name ){
      return  orderService.test(name);
    }


    @GetMapping("/test2/{name}")
    public String test2(@PathVariable("name") String name ){
        return  orderService.test2(name);
    }

    @GetMapping("/test3/{name}")
    public String test3(@PathVariable("name") String name ){
        return  orderService.test3(name);
    }


    @HystrixCommand(fallbackMethod = "test5Error")
    @GetMapping("/test5/{name}")
    public String test5(@PathVariable("name") String name ){
        int a =10/0;
        return  orderService.test3(name);
    }


    public String test5Error(String name){
        return  "熔断："+name;
    }

}
