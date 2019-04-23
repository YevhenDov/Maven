package com.entity;

import com.enumrep.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "developers")
public class Developer extends Model {

    @Column(name = "developer_name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "salary")
    private Integer salary;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "developers_projects",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "developers_skills",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills;

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
        log.info(("Create developer: " + getName() + ", at " + getCreationTime()));
    }

    @PostLoad
    void postLoad() {
        log.info("Developer " + getName() + " is findById at " + getNowTime());
    }

    @PreUpdate
    void preUpdate() {
        updateTime = LocalDateTime.now();
    }

    @PostUpdate
    void postUpdate() {
        log.info("Update developer: " + getName() + ", at " + getUpdateTime());
    }

    @PreRemove
    void preRemove() {
        removeTime = LocalDateTime.now();
    }

    @PostRemove
    void postRemove() {
        log.info("Remove developer: " + getName() + ", at" + getRemoveTime());
    }
}
