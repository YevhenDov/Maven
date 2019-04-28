package com.cardaoimpl;

import com.dao.Car;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Log4j
@Setter
@Component
@PropertySource(value = "META-INF/spring/Truck.properties")
public class Truck implements Car {

    @Value("${payload}")
    private String  payload;

    @Override
    public void move() {
        log.info("Truck is moving...");
    }
}
