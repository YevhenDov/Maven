package com.dao;

import com.entity.Developer;

public interface DeveloperDAO {
    Developer findById(int id);

    void save(Developer developer);

    void update(Developer developer);

    void delete(Developer developer);
}
