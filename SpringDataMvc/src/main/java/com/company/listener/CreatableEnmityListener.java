package com.company.listener;

import com.company.entity.CreatableEntity;

import javax.persistence.PrePersist;
import java.util.Date;

public class CreatableEnmityListener {

    @PrePersist
    public void prePersist(CreatableEntity entity){
        entity.setCreatedDate(new Date().getTime());
    }
}
