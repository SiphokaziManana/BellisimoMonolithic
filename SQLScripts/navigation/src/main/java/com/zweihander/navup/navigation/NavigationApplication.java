package com.zweihander.navup.navigation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan("com.zweihander.navup.navigation")
public class NavigationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NavigationApplication.class, args);
    }
}
