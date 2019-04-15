package com.dao;

import com.entity.Skill;

public interface SkillDAO {
    Skill findById(int id);

    void save(Skill skill);

    void update(Skill skill);

    void delete(Skill skill);
}
