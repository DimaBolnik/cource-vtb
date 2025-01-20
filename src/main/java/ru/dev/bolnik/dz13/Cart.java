package ru.dev.bolnik.dz13;

import org.springframework.stereotype.Component;
import ru.dev.bolnik.dz13.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {

    List<Product> products;

    public void add(Product product) {
        if (products == null) products = new ArrayList<>();
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
