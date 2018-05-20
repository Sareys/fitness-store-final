package com.moujib.backend.controller.purchase;

import com.moujib.backend.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/basket")
public class BasketController {

    private CustomerService customerService;

    @Autowired
    public BasketController (CustomerService customerService){
        this.customerService = customerService;
    }

//    @RequestMapping
//    public @ResponseBody
//    Basket getCurrentCustomerBasket(@AuthentificationPrincipal User activeUser){
//
//    }
}
