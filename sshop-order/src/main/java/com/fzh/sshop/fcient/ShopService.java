package com.fzh.sshop.fcient;

import com.fzh.sshop.fcient.fallback.impl.ShopServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "sshop-shop",fallbackFactory = ShopServiceFallbackFactory.class)
public interface ShopService {

    @GetMapping("/shop/test2")
    String test1();


    @RequestMapping(value = "/shop/test2",method = RequestMethod.POST)
    String test2(@RequestBody String name);



    @RequestMapping(value = "/shop/test3",method = RequestMethod.POST)
    String test3(@RequestBody String name);

}
