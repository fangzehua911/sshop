package com.fzh.sshop.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shop")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);


    @GetMapping("/test1")
    public String test1() {


        return "shop:102";
    }

    @PostMapping("/test2")
    public String test2(@RequestBody String string) {

        return "shop:"+string;
    }


    @PostMapping("/test3")
    public String test3(@RequestBody String string) {
            int a= 1/0;
        return "shop:"+string;
    }


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



