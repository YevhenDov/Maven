package com.dao;

import com.entity.Company;

public interface CompanyDAO {

    void create(Company company);

    Company read(int id);

    void update(Company company);

    void delete(Company company);
}
