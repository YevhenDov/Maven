package com.development.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Project {
    private int id;
    private String name;
    private String deadLine;
    private String cost;
}
