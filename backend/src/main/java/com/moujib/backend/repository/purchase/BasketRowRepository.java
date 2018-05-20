package com.moujib.backend.repository.purchase;

import com.moujib.backend.model.purchase.Basket;
import com.moujib.backend.model.purchase.BasketRow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRowRepository extends CrudRepository<BasketRow, Integer>{

//    @Query("")
//    void addBasketRow(BasketRow cartItem);
//
//    @Query("")
//    void removeBasketRow(BasketRow cartItem);
//
//    @Query("")
//    void removeAllBasketRows(Basket cart);
//
//    @Query("")
//    BasketRow getBasketRowByProductId (int productId);
}
