package com.dao;

import com.entity.Company;

public interface CompanyDao {

    void create(Company company);

    Company findById(int id);

    void update(Company company);

    void delete(Company company);
}
