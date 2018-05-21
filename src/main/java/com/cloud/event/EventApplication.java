package com.cloud.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class EventApplication {

    private static final Logger log = LoggerFactory.getLogger(EventApplication.class);

    @PostConstruct
    void started() { TimeZone.setDefault(TimeZone.getTimeZone("UTC"));}

    public static void main(String[] args) {
        SpringApplication.run(EventApplication.class, args);
    }
}