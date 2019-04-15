package com.dao;

import com.entity.Project;

public interface ProjectDAO {
    Project findById(int id);

    void save(Project project);

    void update(Project project);

    void delete(Project project);
}
