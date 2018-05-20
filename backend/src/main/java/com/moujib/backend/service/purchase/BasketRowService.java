package com.moujib.backend.service.purchase;

import com.moujib.backend.model.purchase.Basket;
import com.moujib.backend.model.purchase.BasketRow;

public interface BasketRowService {

    Basket getBasketById(int basketId);

    void addBasketRow(BasketRow basketRow);

    BasketRow getBasketRowByProductId(int productId);

    void removeBasketRow(BasketRow basketRow);

    void removeAllBasketRows(Basket basket);
}
