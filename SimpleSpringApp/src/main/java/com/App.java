package com;

import com.cardaoimpl.Sedan;
import com.cardaoimpl.Truck;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/context.xml");
        Sedan sedan = (Sedan) context.getBean(Sedan.class);
        Sedan sedan1 = (Sedan) context.getBean(Sedan.class);
        log.info(sedan);
        log.info(sedan1);
        log.info(sedan.getEngine());
        log.info(sedan.getSpeed());

        Truck truck = (Truck) context.getBean(Truck.class);
        Truck truck1 = (Truck) context.getBean(Truck.class);
        log.info(truck);
        log.info(truck1);
    }
}
