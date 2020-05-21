package com.fzh.sshop.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SShopMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(SShopMemberApplication.class, args);
    }

}
