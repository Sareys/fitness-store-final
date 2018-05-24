package com.moujib.backend.controller.customer;

import com.moujib.backend.model.customer.Customer;
import com.moujib.backend.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping(value="/allCustomers")
    public List<Customer> getAllCustomers(){
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setUsername("Sareys");
        customer1.setEmail("sareys@smals.be");
        customer1.setName("Moujib");
        customer1.setLastName("Souli");
        List<Customer> customers = customerService.getAllCustomers();
        customers.add(customer1);
        return customers;
    }

    @PostMapping(value = "/createUser")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createUser(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @PutMapping(value="/updateCustomer")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer){
        customerService.update(customer);
    }

    @DeleteMapping(value="/deleteCustomer")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCustomer(@RequestBody Customer customer){
        customerService.deleteCustomer(customer);
    }


}
