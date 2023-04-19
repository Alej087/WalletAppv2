package com.wallet.apicustomer.controller;

import com.wallet.apicustomer.entities.Customer;
import com.wallet.apicustomer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/customers")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Customer customer){
        log.info("Creating the customer");
        customerService.create(customer);
        log.info("Customer created");
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer created");
    }
}
