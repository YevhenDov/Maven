package com.cardaoimpl;

import com.dao.Car;
import com.dao.Engine;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Log4j
@Getter
@Component
@Scope(value = "prototype")
@PropertySource(value = "META-INF/spring/Sedan.properties")
public class Sedan implements Car {

    @Value("${speed}")
    private String speed;

    @Autowired
    @Qualifier(value = "MersEngine")
    private Engine engine;

    @Override
    public void move() {
        log.info("Sedan is moving...");
    }

    @PostConstruct
    private void postConstruct() {
        log.info("Bean 'Sedan' is initialized");
    }

    @PreDestroy
    private void preDestroy() {
        log.info("Bean 'Sedan' is destroyed");
    }
}
