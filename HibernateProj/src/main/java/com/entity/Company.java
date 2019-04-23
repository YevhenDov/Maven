package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "companies")
public class Company extends Model {

    @Column(name = "project_name")
    String name;

    @Column(name = "address")
    String address;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "companies_projects",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects;

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
        log.info(("Create company: " + getName() + ", at " + getCreationTime()));
    }

    @PostLoad
    void postLoad() {
        log.info("Company " + getName() + " is findById at " + getNowTime());
    }

    @PreUpdate
    void preUpdate() {
        updateTime = LocalDateTime.now();
    }

    @PostUpdate
    void postUpdate() {
        log.info("Update company: " + getName() + ", at " + getUpdateTime());
    }

    @PreRemove
    void preRemove() {
        removeTime = LocalDateTime.now();
    }

    @PostRemove
    void postRemove() {
        log.info("Remove company: " + getName() + ", at" + getRemoveTime());
    }
}
