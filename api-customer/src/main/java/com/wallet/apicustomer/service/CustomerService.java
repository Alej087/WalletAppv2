package com.wallet.apicustomer.service;

import com.wallet.apicustomer.entities.Customer;
import com.wallet.apicustomer.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public void create(Customer customer){
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public String update(Customer customer){
        Optional<Customer> customerSearched = customerRepository.findById(customer.getId());
        Customer newCustomer = new Customer(customer.getId(),customerSearched.get().getDocumentType(),customerSearched.get().getDocumentNumber(), customer.getName(), customer.getLastName(),customer.getGenre(),customer.getBirthDate());
        if(findById(customer.getId()).isPresent()){
            customerRepository.save(newCustomer);
        }else {
            return "customer was not found";
        }
        return "customer updated";
    }


    @Override
    public void delete(Long id) throws Exception{
        if(findById(id).isPresent()) {
            customerRepository.deleteById(id);
        }else {
            throw new Exception("The customer was not found");
        }
    }
}
