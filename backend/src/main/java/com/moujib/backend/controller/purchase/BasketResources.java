package com.moujib.backend.controller.purchase;

import com.moujib.backend.model.customer.Customer;
import com.moujib.backend.model.product.Product;
import com.moujib.backend.model.purchase.Basket;
import com.moujib.backend.model.purchase.BasketRow;
import com.moujib.backend.service.customer.CustomerService;
import com.moujib.backend.service.product.ProductService;
import com.moujib.backend.service.purchase.BasketRowService;
import com.moujib.backend.service.purchase.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketResources {

    private BasketService basketService;

    private BasketRowService basketRowService;

    private CustomerService customerService;

    private ProductService productService;

    @Autowired
    public BasketResources(BasketService basketService, BasketRowService basketRowService, CustomerService customerService, ProductService productService){
        this.basketService = basketService;
        this.basketRowService = basketRowService;
        this.customerService = customerService;
        this.productService = productService;
    }

    @GetMapping("/getById")
    public Basket getBasketById (@RequestParam(value = "basketId") int basketId) {
        return basketService.getBasketById(basketId);
    }

//    @PutMapping(value = "/addProductToBasket")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void addItem (@RequestParam(value ="productId") int productId, @AuthenticationPrincipal User activeUser) {
//
//        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
//        Basket basket = customer.getBasket();
//        Product product = productService.getProductById(productId);
//        List<BasketRow> basketRows = basket.getRows();
//
//        for (int i=0; i < basketRows.size(); i++) {
//            if(product.getId() == basketRows.get(i).getProduct().getId()){
//                BasketRow basketRow = basketRows.get(i);
//                basketRow.setQuantity(basketRow.getQuantity()+1);
//                basketRow.setTotalPrice(product.getPrice()* basketRow.getQuantity());
//                basketRowService.addBasketRow(basketRow);
//
//                return;
//            }
//        }
//
//        BasketRow basketRow = new BasketRow();
//        basketRow.setProduct(product);
//        basketRow.setQuantity(1);
//        basketRow.setTotalPrice(product.getPrice()*basketRow.getQuantity());
//        basketRow.setBasket(basket);
//        basketRowService.addBasketRow(basketRow);
//    }

    @PutMapping(value = "/removeFromBasket}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeRow (@RequestParam(value = "productId") int productId) {
        BasketRow basketRow = basketRowService.getBasketRowByProductId(productId);
        basketRowService.removeBasketRow(basketRow);

    }

    @DeleteMapping(value = "/clearBasket")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@RequestParam(value = "basketId") int basketId) {
        Basket basket = basketRowService.getBasketById(basketId);
        basketRowService.removeAllBasketRows(basket);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientErrors (Exception e) {}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error.")
    public void handleServerErrors (Exception e) {}

}
