package com.dao;

import com.entity.Developer;

import java.util.List;

public interface DeveloperDao {
    Developer findById(int id);

    void create(Developer developer);

    void update(Developer developer);

    void delete(Developer developer);

    List<Developer> getAll();
}