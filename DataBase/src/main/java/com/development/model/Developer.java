package com.development.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Developer {
    private int id;
    private String name;
    private String age;
    private String gender;
    private int salary;
}
