package com.example.ProjectWithSpringGuru.services;

import com.example.ProjectWithSpringGuru.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getListOfAllCustomers();

    Customer getCustomerById(Integer id);

    Customer saveOrUpdateCustomer(Customer customer);

    void deleteCustomer(Integer id);
}
