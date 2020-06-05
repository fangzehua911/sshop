package com.fzh.sshop.app.payment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/payment")
@RestController
public class PayMentController {

    @GetMapping("/test")
    public String test(){

        return "payment/succ";
    }
}
