package com.moujib.backend.service.purchase;

import com.moujib.backend.model.purchase.Basket;
import com.moujib.backend.model.purchase.BasketRow;
import com.moujib.backend.repository.purchase.BasketRowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketRowServiceImpl implements BasketRowService {

    private BasketRowRepository basketRowRepository;

    @Autowired
    public BasketRowServiceImpl (BasketRowRepository basketRowRepository){
        this.basketRowRepository = basketRowRepository;
    }

    @Override
    public Basket getBasketById(int basketId) {
        return null;
    }

    @Override
    public void addBasketRow(BasketRow basketRow) {

    }

    @Override
    public BasketRow getBasketRowByProductId(int productId) {
        return null;
    }

    @Override
    public void removeBasketRow(BasketRow basketRow) {

    }

    @Override
    public void removeAllBasketRows(Basket basket) {

    }
}
