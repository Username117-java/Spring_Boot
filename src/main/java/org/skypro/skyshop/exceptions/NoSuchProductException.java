package org.skypro.skyshop.exceptions;

public class NoSuchProductException extends RuntimeException {
    public NoSuchProductException() {
        super("Нет такого продукта, попробуй еще раз");
    }
}
