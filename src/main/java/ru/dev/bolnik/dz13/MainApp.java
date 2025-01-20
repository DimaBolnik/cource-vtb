package ru.dev.bolnik.dz13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dev.bolnik.dz13.service.OrderService;
import ru.dev.bolnik.dz13.service.ProductService;
import ru.dev.bolnik.dz13.service.impl.OrderServiceImpl;
import ru.dev.bolnik.dz13.service.impl.ProductServiceImpl;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigurationApp.class);

        ProductService productService = context.getBean(ProductServiceImpl.class);
        OrderService orderService = context.getBean(OrderServiceImpl.class);
        Cart cart = (Cart) context.getBean("cart");

        System.out.println("Список доступных покупок");
        productService.printAll();

        cart.add(productService.findByTitle("Шкаф"));
        cart.add(productService.findByTitle("Кресло"));
        cart.add(productService.findByTitle("Скрипторий"));

        orderService.print();
    }
}
