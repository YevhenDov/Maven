package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Log4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "skills")
public class Skill extends Model {

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_lvl")
    private String skillLvl;

    @ManyToMany(mappedBy = "skills")
    private Set<Developer> developers;

    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private LocalDateTime removeTime;
    private LocalDateTime nowTime;

    @PrePersist
    void prePersist() {
        creationTime = LocalDateTime.now();
    }

    @PostPersist
    void postPersist() {
        log.info(("Create skill: " + getSkillName() + ", at " + getCreationTime()));
    }

    @PostLoad
    void postLoad() {
        log.info("Skill " + getSkillName() + " is findById at " + getNowTime());
    }

    @PreUpdate
    void preUpdate() {
        updateTime = LocalDateTime.now();
    }

    @PostUpdate
    void postUpdate() {
        log.info("Update skill: " + getSkillName() + ", at " + getUpdateTime());
    }

    @PreRemove
    void preRemove() {
        removeTime = LocalDateTime.now();
    }

    @PostRemove
    void postRemove() {
        log.info("Remove skill: " + getSkillName() + ", at" + getRemoveTime());
    }
}
