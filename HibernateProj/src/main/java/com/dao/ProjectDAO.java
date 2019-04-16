package com.dao;

import com.entity.Project;

public interface ProjectDAO {
    Project read(int id);

    void create(Project project);

    void update(Project project);

    void delete(Project project);
}
