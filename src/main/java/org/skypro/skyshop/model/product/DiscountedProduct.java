package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private int basePrise;
    private int discount;


    public DiscountedProduct(String name, int basePrise, int discount, UUID id) {
        super(name, id);
        if (basePrise <= 0) {
            throw new IllegalArgumentException("Цена должна быть строго болше нуля");
        }
        this.basePrise = basePrise;

        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100%");
        }
        this.discount = discount;

    }

    @Override
    public int getPriceProduct() {
        return (int) (basePrise - ((basePrise * discount) / 100));
    }

    @Override
    public String toString() {
        return getName() + ": " + getPriceProduct() + " (" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }


}
