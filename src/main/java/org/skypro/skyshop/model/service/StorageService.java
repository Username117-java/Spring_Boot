package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.UUID;

@Service
public class StorageService {
    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;


    public StorageService () {
    this.productStorage = new TreeMap<UUID, Product>();
    this.articleStorage = new TreeMap<UUID, Article>();
    fillInStorage();
    }

    public Collection<Product> getAllProducts() {
        return new ArrayList<Product>(productStorage.values());
    }

    public Collection<Article> getAllArticles() {
        return new ArrayList<Article>(articleStorage.values());
    }

    public Collection<Searchable> getAllSearchable(){
        ArrayList<Searchable> allSearchable = new ArrayList<Searchable>(productStorage.values());
        allSearchable.addAll(articleStorage.values());
        return allSearchable;
    }

    private void fillInStorage(){
        Product tequila = new SimpleProduct("Текила", 1500, UUID.randomUUID());
        Product salt = new SimpleProduct("Соль", 20, UUID.randomUUID());
        Product stickForHittingNettles = new DiscountedProduct("Палка для битья крапивы", 500, 20, UUID.randomUUID());
        Product lime = new FixPriceProduct("Лайм", UUID.randomUUID());
        Product woodenNails = new FixPriceProduct("Деревянные гвозди", UUID.randomUUID());
        Product blackCaviar = new SimpleProduct("Черная икра", 6500, UUID.randomUUID());
        Searchable nailsArticle = new Article("О пользе деревяных гвоздей",
                "Основная польза применения деревяных гвоздей заключается в уменьшении массы изготавливаемого изделия. " +
                        "Если изделие окажется недостаточно долговечным, инженеров можно избить палкой...", UUID.randomUUID());
        Searchable stickWorkManual = new Article("Инструкция к палке для битья крапивы",
                "Ниже будут описаны все варианты применения палки для битья крапивы, а также подробная техника безопасности при эксплуатации: ...", UUID.randomUUID());
        Product test1 = new FixPriceProduct("ББ аа", UUID.randomUUID());
        Product test2 = new FixPriceProduct("Б ааа", UUID.randomUUID());
        Product test3 = new FixPriceProduct("А аа", UUID.randomUUID());
        Product test4 = new FixPriceProduct("АА аа", UUID.randomUUID());
        add(tequila);
        add(salt);
        add(stickForHittingNettles);
        add(lime);
        add(woodenNails);
        add(blackCaviar);
        add(nailsArticle);
        add(stickWorkManual);
        add(test1);
        add(test2);
        add(test3);
        add(test4);
    }

    public void add(Searchable searchable) {
        if (searchable.getTypeContent().equals("PRODUCT")) {
            productStorage.put(searchable.getId(), (Product) searchable);
        }
        else if (searchable.getTypeContent().equals("ARTICLE")) {
            articleStorage.put(searchable.getId(), (Article) searchable);
        }
        else {
            System.out.println("Неизвестный тип продукта:");
            System.out.println(searchable.getTypeContent());
        }
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(productStorage.get(id));
    }
}
