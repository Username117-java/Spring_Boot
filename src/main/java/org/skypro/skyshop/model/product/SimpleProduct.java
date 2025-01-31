package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private int priceProduct;

    public SimpleProduct(String name, int priceProduct, UUID id) {
        super(name, id);
        if (priceProduct <= 0) {
            throw new IllegalArgumentException("Цена должна быть строго больше нуля");
        }
        this.priceProduct = priceProduct;
    }

    @Override
    public int getPriceProduct() {
        return priceProduct;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPriceProduct();
    }

}


