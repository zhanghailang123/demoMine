package com.zhl.mine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DemoMineApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMineApplication.class, args);
    }

}
