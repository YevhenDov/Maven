package com.dao;

import com.entity.Skill;

public interface SkillDAO {
    Skill read(int id);

    void create(Skill skill);

    void update(Skill skill);

    void delete(Skill skill);
}
