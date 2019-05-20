package com.company.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "Users")
public class UserEntity extends CreatableEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Email
    @Column(name = "email")
    private String email;
}
