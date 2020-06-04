package com.fzh.sshop.fcient.fallback.impl;

import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.fcient.ShopService;
;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


@Component
public class ShopServiceFallbackFactory implements FallbackFactory<ShopService> {

    @Override
    public ShopService create(Throwable throwable) {
        return new ShopService(){

            @Override
            public String test1() {
                return "error";
            }

            @Override
            public String test2(String name) {
                return name;
            }

            @Override
            public String test3(String name) {
                JSONObject json = new JSONObject();
                json.put("id", name);
                json.put("description", "服务异常演习专用！");
                json.put("msg", throwable.getMessage());
                return json.toJSONString();
            }
        };
    }

}