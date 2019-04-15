package com.dao;

import com.entity.Customer;

public interface CustomerDAO {
    Customer findById(int id);

    void save(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);
}
