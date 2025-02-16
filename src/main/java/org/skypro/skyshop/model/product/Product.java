package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private final String name;
    private final UUID id;

    public Product(String name, UUID id) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Поле названия продукта не может быть пустым");
        }
        this.name = name;
        this.id = id;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract int getPriceProduct();

    public boolean isSpecial() {
        return false;
    }

    @JsonIgnore
    @Override
    public String searchTerm() {
        return name;
    }

    @JsonIgnore
    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}