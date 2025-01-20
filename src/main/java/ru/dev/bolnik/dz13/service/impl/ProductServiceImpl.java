package ru.dev.bolnik.dz13.service.impl;

import org.springframework.stereotype.Component;
import ru.dev.bolnik.dz13.entity.Product;
import ru.dev.bolnik.dz13.service.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    private List<Product> products;

    @PostConstruct
    public void initializeProducts() {
        products = new ArrayList<>();

        // Добавление 10 фейковых продуктов
        products.add(new Product(1, "Диван", 100.0));
        products.add(new Product(2, "Стол", 50.0));
        products.add(new Product(3, "Скрипторий", 200.0));
        products.add(new Product(4, "Кровать", 150.0));
        products.add(new Product(5, "Тумбочка", 80.0));
        products.add(new Product(6, "Лампа", 30.0));
        products.add(new Product(7, "Шкаф", 120.0));
        products.add(new Product(8, "Кресло", 180.0));
        products.add(new Product(9, "Тумблер", 25.0));
        products.add(new Product(10, "Ковер", 300.0));
    }

    @Override
    public void printAll() {
        products.forEach(product -> System.out.println(product.getTitle()));
    }

    @Override
    public Product findByTitle(String title) {
        return products.stream()
                .filter(product -> product.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }
}
