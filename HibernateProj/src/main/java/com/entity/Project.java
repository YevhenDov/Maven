package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "projects")
public class Project extends Model {

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
        log.info(("Create project: " + getName() + ", at " + getCreationTime()));
    }

    @PostLoad
    void postLoad() {
        log.info("Project " + getName() + " is findById at " + getNowTime());
    }

    @PreUpdate
    void preUpdate() {
        updateTime = LocalDateTime.now();
    }

    @PostUpdate
    void postUpdate() {
        log.info("Update project: " + getName() + ", at " + getUpdateTime());
    }

    @PreRemove
    void preRemove() {
        removeTime = LocalDateTime.now();
    }

    @PostRemove
    void postRemove() {
        log.info("Remove project: " + getName() + ", at" + getRemoveTime());
    }
}
