package com.wallet.apicustomer.service;

import com.wallet.apicustomer.entities.Customer;

import java.util.Optional;

public interface ICustomerService {

    void create(Customer customer);
    String update(Customer customer);

    Optional<Customer> findById(Long id);
    void delete(Long id) throws Exception;
}
