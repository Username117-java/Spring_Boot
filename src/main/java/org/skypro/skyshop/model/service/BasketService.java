package org.skypro.skyshop.model.service;

import org.skypro.skyshop.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProductToBasket(UUID uuid) {
        if (storageService.getProductById(uuid).isEmpty()) {
            throw new NoSuchProductException();
        }
        productBasket.addProduct(uuid);
    }

    public UserBasket getUserBasket() {
        List<BasketItem> basketItems = productBasket.getProducts().entrySet().stream()
                .map(entry -> {
                    return new BasketItem(storageService.getProductById(entry.getKey()).orElseThrow(), entry.getValue());
                })
                .collect(Collectors.toList());

        return new UserBasket(basketItems);
    }


}
