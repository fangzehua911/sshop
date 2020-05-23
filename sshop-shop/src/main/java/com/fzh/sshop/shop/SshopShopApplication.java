package com.fzh.sshop.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SshopShopApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SshopShopApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SshopShopApplication.class, args);

    }

}
