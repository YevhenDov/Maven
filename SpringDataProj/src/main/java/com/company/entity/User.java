package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "Users")
public class User extends CreatableEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Email
    @Column(name = "email")
    private String email;
}
