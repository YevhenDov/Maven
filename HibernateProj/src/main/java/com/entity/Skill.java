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
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_lvl")
    private String skillLvl;

    @ManyToMany(mappedBy = "skills")
    private Set<Developer> developers;
}
