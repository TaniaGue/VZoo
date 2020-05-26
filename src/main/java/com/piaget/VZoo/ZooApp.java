package com.piaget.VZoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZooApp {
    private static final Logger log = LoggerFactory.getLogger(ZooApp.class);

    public static void main(String[] args) {
        SpringApplication.run(ZooApp.class, args);
    }

}
