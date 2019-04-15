package com.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "project_name")
    private String name;

    @Column(name = "dead_line")
    private String deadLine;

    @Column(name = "cost")
    private String cost;

    @ManyToMany(mappedBy = "projects")
    private Set<Developer> developers;

    @ManyToMany(mappedBy = "projects")
    private Set<Company> companies;

    @ManyToMany(mappedBy = "projects")
    private Set<Customer> customers;
}
