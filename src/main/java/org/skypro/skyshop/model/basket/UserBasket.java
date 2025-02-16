package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> basketItems;
    private final double total;


    public UserBasket(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
        this.total = calculateTotal(basketItems);
    }

    private double calculateTotal(List<BasketItem> basketItems) {
        return basketItems.stream()
                .mapToDouble(item -> item.getProduct().getPriceProduct() * item.getQuantity())
                .sum();
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public double getTotal() {
        return total;
    }
}
