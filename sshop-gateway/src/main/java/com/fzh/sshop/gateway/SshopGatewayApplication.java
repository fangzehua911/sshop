package com.fzh.sshop.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SshopGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SshopGatewayApplication.class, args);
    }


}
