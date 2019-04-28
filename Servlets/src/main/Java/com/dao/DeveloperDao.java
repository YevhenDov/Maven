package com.dao;

import com.entity.Developer;

import java.util.List;
import java.util.Optional;

public interface DeveloperDao {
    Optional<Developer> findById(int id);

    void create(Developer developer);

    void update(Developer developer);

    void delete(Developer developer);

    List<Developer> findAll();
}
