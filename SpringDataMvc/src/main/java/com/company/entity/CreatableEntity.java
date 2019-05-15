package com.company.entity;

import com.company.listener.CreatableEnmityListener;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@EntityListeners(value = CreatableEnmityListener.class)
public class CreatableEntity extends BaseEntity {

    @Column(name = "created_date")
    private Long createdDate;
}
