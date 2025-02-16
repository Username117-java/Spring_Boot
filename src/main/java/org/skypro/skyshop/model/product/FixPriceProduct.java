package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 69;

    public FixPriceProduct(String name, UUID id) {
        super(name, id);

    }

    @Override
    public int getPriceProduct() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + getPriceProduct();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
