package com.moujib.backend.repository.purchase;

import com.moujib.backend.model.purchase.Basket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends CrudRepository<Basket, Integer> {

    @Query("SELECT b FROM Basket b WHERE b.id = :id")
    Basket getBasketById (int id);
}
