package com.moujib.backend.service.customer;

import com.moujib.backend.model.customer.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomerById(int id);

    void createCustomer(Customer customer);

    Customer getCustomerByUsername(String username);

    void update (Customer customer);

    List<Customer> getAllCustomers();

    void deleteCustomer(Customer customer);
}
