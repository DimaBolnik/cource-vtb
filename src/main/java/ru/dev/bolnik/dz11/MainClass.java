package ru.dev.bolnik.dz11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dev.bolnik.dz11.hibernate.*;

import java.util.Scanner;

public class MainClass {
    private static SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Book.class)
            .addAnnotatedClass(Author.class)
            .addAnnotatedClass(Reader.class)
            .addAnnotatedClass(Catalog.class)
            .addAnnotatedClass(Product.class)
            .addAnnotatedClass(Buyer.class)
            .buildSessionFactory();
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите опцию:");
            System.out.println("1. Показать товары покупателя");
            System.out.println("2. Найти покупателей по названию товара");
            System.out.println("3. Удалить покупателя");
            System.out.println("4. Удалить товар");
            System.out.println("5. Купить товар");
            System.out.println("0. Выход");
            System.out.print("Введите номер опции: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (option == 0) {
                break;
            }

            switch (option) {
                case 1:
                    System.out.print("Введите имя покупателя: ");
                    String buyerName = scanner.nextLine();
                    showProductsByPerson(buyerName);
                    break;
                case 2:
                    System.out.print("Введите название товара: ");
                    String productName = scanner.nextLine();
                    findPersonsByProductTitle(productName);
                    break;
                case 3:
                    System.out.print("Введите имя покупателя для удаления: ");
                    String buyerNameToRemove = scanner.nextLine();
                    removePerson(buyerNameToRemove);
                    break;
                case 4:
                    System.out.print("Введите название товара для удаления: ");
                    String productNameToRemove = scanner.nextLine();
                    removeProduct(productNameToRemove);
                    break;
                case 5:
                    System.out.print("Введите имя покупателя: ");
                    String buyerNameToBuy = scanner.nextLine();
                    System.out.print("Введите название товара: ");
                    String productNameToBuy = scanner.nextLine();
                    buyProduct(buyerNameToBuy, productNameToBuy);
                    break;
                default:
                    System.out.println("Неверная опция");
            }
        }
        scanner.close();
        sessionFactory.close();
    }
    private static void showProductsByPerson(String buyerName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Buyer buyer = session.createQuery("FROM Buyer WHERE name = :name", Buyer.class)
                .setParameter("name", buyerName)
                .uniqueResult();
        if (buyer != null) {
            System.out.println("Товары, купленные " + buyerName + ":");
            for (Product product : buyer.getProducts()) {
                System.out.println(product.getName());
            }
        } else {
            System.out.println("Покупатель не найден");
        }
        session.getTransaction().commit();
        session.close();
    }

    private static void findPersonsByProductTitle(String productName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.createQuery("FROM Product WHERE name = :name", Product.class)
                .setParameter("name", productName)
                .uniqueResult();
        if (product != null) {
            System.out.println("Покупатели, купившие " + productName + ":");
            for (Buyer buyer : product.getBuyers()) {
                System.out.println(buyer.getName());
            }
        } else {
            System.out.println("Товар не найден");
        }
        session.getTransaction().commit();
        session.close();
    }

    private static void removePerson(String buyerName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Buyer buyer = session.createQuery("FROM Buyer WHERE name = :name", Buyer.class)
                .setParameter("name", buyerName)
                .uniqueResult();
        if (buyer != null) {
            session.delete(buyer);
            System.out.println("Покупатель удален");
        } else {
            System.out.println("Покупатель не найден");
        }
        session.getTransaction().commit();
        session.close();
    }

    private static void removeProduct(String productName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.createQuery("FROM Product WHERE name = :name", Product.class)
                .setParameter("name", productName)
                .uniqueResult();
        if (product != null) {
            session.delete(product);
            System.out.println("Товар удален");
        } else {
            System.out.println("Товар не найден");
        }
        session.getTransaction().commit();
        session.close();
    }

    private static void buyProduct(String buyerName, String productName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Проверяем, существует ли покупатель
        Buyer buyer = session.createQuery("FROM Buyer WHERE name = :name", Buyer.class)
                .setParameter("name", buyerName)
                .uniqueResult();

        // Если покупатель не существует, создаем нового
        if (buyer == null) {
            buyer = new Buyer();
            buyer.setName(buyerName);
            session.save(buyer);
            System.out.println("Новый покупатель добавлен: " + buyerName);
        }

        // Проверяем, существует ли товар
        Product product = session.createQuery("FROM Product WHERE name = :name", Product.class)
                .setParameter("name", productName)
                .uniqueResult();

        // Если товар не существует, создаем новый
        if (product == null) {
            product = new Product();
            product.setName(productName);
            // Устанавливаем цену товара (можно запросить у пользователя или установить по умолчанию)
            product.setPrice(0.0f); // Установите нужную цену
            session.save(product);
            System.out.println("Новый товар добавлен: " + productName);
        }

        // Устанавливаем связь между покупателем и товаром
        buyer.getProducts().add(product);
        session.saveOrUpdate(buyer);
        System.out.println("Товар куплен успешно");

        session.getTransaction().commit();
        session.close();
    }
}
