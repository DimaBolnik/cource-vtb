package ru.dev.bolnik.dz12;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.OptimisticLockException;
import java.util.Random;


public class MainClass {
    private static SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Item.class)
            .buildSessionFactory();

    public static void main(String[] args) {
        createTableWithInitialData();

        for (int i = 0; i < 8; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long count =(long) new Random().nextInt(40) +1;
                    for (int i = 0; i < 20000; i++) {
                        boolean updated = false;
                        while (!updated) {
                            Session session = sessionFactory.getCurrentSession();
                            session.beginTransaction();
                            try {
//                                Thread.sleep(5);
                                Item item = session.get(Item.class, count);
                                item.setVal(item.getVal() + 1);
                                session.getTransaction().commit();
                                updated = true;
                            }catch (OptimisticLockException e) {
                                session.getTransaction().rollback();
                            } /*catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            } */finally {
                                session.close();
                            }
                        }
                    }
                }
            }).start();
        }
    }

    private static void createTableWithInitialData() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            for (int i = 1; i <= 40; i++) {
                Item item = new Item(0);
                session.save(item);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}
