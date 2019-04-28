package com.enginedoimpl;

import com.dao.Engine;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Log4j
@Data
@Component(value = "MersEngine")
@Scope(value = "prototype")
public class MersEngine implements Engine {

    @Override
    public void work() {
        log.info("Mers engine is working...");
    }
}
