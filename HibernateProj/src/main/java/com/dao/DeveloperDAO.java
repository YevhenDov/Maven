package com.dao;

import com.entity.Developer;

public interface DeveloperDAO {
    Developer read(int id);

    void create(Developer developer);

    void update(Developer developer);

    void delete(Developer developer);
}
