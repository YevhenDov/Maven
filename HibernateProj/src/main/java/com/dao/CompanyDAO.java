package com.dao;

import com.entity.Company;

public interface CompanyDAO {
    Company findById(int id);

    void save(Company company);

    void update(Company company);

    void delete(Company company);
}
