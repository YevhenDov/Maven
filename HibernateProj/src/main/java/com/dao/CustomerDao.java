package com.dao;

import com.entity.Customer;

public interface CustomerDao {
    Customer findById(int id);

    void create(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);
}
