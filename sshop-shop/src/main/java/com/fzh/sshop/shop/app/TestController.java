package com.fzh.sshop.shop.app;

import com.fzh.sshop.push.AppPushUtils;
import com.fzh.sshop.shop.SshopShopApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test/{name}")
    public String test(@PathVariable("name") String name){

        LOGGER.info("test log info begin");
        for (int i = 0; i < 100; i++) {

            LOGGER.debug("[ResponseEntity]:{}", "i am debug" + i);
            LOGGER.info("[ResponseEntity] i am info" + i);
            LOGGER.error("[ResponseEntity]i am error" + i);
            LOGGER.warn("[ResponseEntity]i am warn" + i);
            LOGGER.debug("[ResponseEntity]:{}", "i am debug" + i);
            LOGGER.info("[ResponseEntity] i am info" + i);
            LOGGER.error("[ResponseEntity]i am error" + i);
            LOGGER.warn("[ResponseEntity]i am warn" + i);
        }


        return "ok-order2:"+name;
    }
}



