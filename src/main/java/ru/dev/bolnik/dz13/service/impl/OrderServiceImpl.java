package ru.dev.bolnik.dz13.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dev.bolnik.dz13.Cart;
import ru.dev.bolnik.dz13.entity.Product;
import ru.dev.bolnik.dz13.service.OrderService;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private Cart cart;

    @Override
    public void print() {
        double count = 0;
        System.out.println("Список продуктов:");
        for (Product product : cart.getProducts()) {
            System.out.println("- " + product.getTitle());
            count+= product.getCost();
        }
        System.out.println("Стоимость всех продуктов = " + count);
    }
}
