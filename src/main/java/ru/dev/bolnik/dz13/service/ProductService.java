package ru.dev.bolnik.dz13.service;

import ru.dev.bolnik.dz13.entity.Product;

public interface ProductService {
    void printAll();
    Product findByTitle(String title);
}
