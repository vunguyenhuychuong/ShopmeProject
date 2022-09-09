package com.shopme.shopmebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

@SpringBootApplication
@EntityScan({"com.shopme.common.entity", "com.shopme.backend"})
public class ShopmeBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopmeBackEndApplication.class, args);
    }

}
