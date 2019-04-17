package com.dao;

import com.entity.Developer;

public interface DeveloperDao {
    Developer findById(int id);

    void create(Developer developer);

    void update(Developer developer);

    void delete(Developer developer);
}
