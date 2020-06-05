package com.fzh.sshop.feigncient.fallback.impl;

import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.feigncient.ShopService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


@Component
public class ShopServiceFallbackFactory implements FallbackFactory<ShopService> {

    @Override
    public ShopService create(Throwable throwable) {
        return new ShopService(){
            @Override
            public String test1() {
                return fallback(null,throwable);
            }
            @Override

            public String test2(String name) {
                return fallback(name,throwable);
            }

            @Override
            public String test3(String name) {
                return fallback(name,throwable);
            }
        };
    }




    public static String fallback(String name,Throwable throwable){
        JSONObject json = new JSONObject();
        json.put("id", name);
        json.put("description", "服务异常演习专用！");
        json.put("msg", throwable.getMessage());
        return json.toJSONString();
    }

}