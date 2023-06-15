package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

/**
 * Проверка методов на языке HQL -
 * вставка, вывод, изменение, удаление обьекта Item.
 *
 * SessionFactory - это объект конфигуратор. Он создается один раз на все приложение.
 * В нем происходит создания пулов, загрузка кешей, проверка моделей.
 * SessionFactory имеет метод openSession, который позволяет записать,
 * удалить и прочитать данные из базы. Этот объект создается быстро.
 */
public class HQLUsage {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sf.openSession();

            /* working with session */
            findAll(session);

            session.close();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static void insert(Session session, Item item) {
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void findAll(Session session) {
        Query query = session.createQuery("from Item");
        for (Object st : query.list()) {
            System.out.println(st);
        }
    }
}
