package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customers")
public class Customer extends Model {

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_location")
    private String location;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "customers_projects",
            joinColumns = @JoinColumn(name = "customer_id"),
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
        log.info(("Create customer: " + getName() + ", at " + getCreationTime()));
    }

    @PostLoad
    void postLoad() {
        log.info("Customer " + getName() + " is read at " + getNowTime());
    }

    @PreUpdate
    void preUpdate() {
        updateTime = LocalDateTime.now();
    }

    @PostUpdate
    void postUpdate() {
        log.info("Update customer: " + getName() + ", at " + getUpdateTime());
    }

    @PreRemove
    void preRemove() {
        removeTime = LocalDateTime.now();
    }

    @PostRemove
    void postRemove() {
        log.info("Remove customer: " + getName() + ", at" + getRemoveTime());
    }
}
