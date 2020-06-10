package com.fzh.sshop.app.ifeign;

import com.fzh.sshop.app.entity.net.request.WeiXinLoginRequest;
import com.fzh.sshop.app.ifeign.fallback.IFOrderServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "sshop-order",fallbackFactory = IFOrderServiceFallbackFactory.class)
public interface IFOrderServcie {


    @GetMapping("/order/test9/{name}")
    String test(@PathVariable("name") String name );

    @PostMapping("/order/test10")
    String test2(@RequestBody WeiXinLoginRequest request);
}
