package com.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
