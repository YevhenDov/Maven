package com.dao;

import com.entity.Customer;

public interface CustomerDAO {
    Customer read(int id);

    void create(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);
}
