package com.fzh.sshop.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SshopShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SshopShopApplication.class, args);
    }

}
