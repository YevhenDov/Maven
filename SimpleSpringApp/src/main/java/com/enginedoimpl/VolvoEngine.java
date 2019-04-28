package com.enginedoimpl;

import com.dao.Engine;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

@Log4j
@Data
@Component(value = "VolvoEngine")
public class VolvoEngine implements Engine {

    @Override
    public void work() {
        log.info("Volvo engine is working...");
    }
}
