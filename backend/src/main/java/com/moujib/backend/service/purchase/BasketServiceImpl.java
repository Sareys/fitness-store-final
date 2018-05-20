package com.moujib.backend.service.purchase;

import com.moujib.backend.model.purchase.Basket;
import com.moujib.backend.repository.purchase.BasketRepository;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService{

    private BasketRepository basketRepository;

    public BasketServiceImpl (BasketRepository basketRepository){
        this.basketRepository = basketRepository;
    }

    @Override
    public Basket getBasketById(int id) {
        return null;
    }
}
