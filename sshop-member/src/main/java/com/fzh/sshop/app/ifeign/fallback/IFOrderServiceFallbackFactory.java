package com.fzh.sshop.app.ifeign.fallback;

import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.app.ifeign.IFOrderServcie;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;



@Component
public class IFOrderServiceFallbackFactory implements FallbackFactory<IFOrderServcie> {


    @Override
    public IFOrderServcie create(Throwable throwable) {
        return new IFOrderServcie() {
            @Override
            public String test(String name) {
                return fallback(name,throwable);
            }
        };
    }


    public static String fallback(String name, Throwable throwable){
        JSONObject json = new JSONObject();
        json.put("id", name);
        json.put("description", "服务异常演习专用！");
        json.put("msg", throwable.getMessage());
        return json.toJSONString();
    }

}