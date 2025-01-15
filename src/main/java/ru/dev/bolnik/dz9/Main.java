package ru.dev.bolnik.dz9;

import ru.dev.bolnik.dz9.annotation.Column;
import ru.dev.bolnik.dz9.annotation.Table;

import java.lang.reflect.Field;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
//        Практическое задание
//        1. Реализуйтевозможностьразметкиклассаспомощьюнаборавашихсобственныханнотаций
//                ( @Table(title),@Column).Напишитеобработчиканнотаций, которыйпозволитпоразмеченному
//        классу построить таблицу в базе данных.
//        2. * Второй обработчик аннотаций должен уметь добавлять объект размеченного класса в
//        полученную таблицу.
//        Замечание:
//        Считаем что в проекте не связанных между собой сущностей, чтобы не
//        продумывать логику их взаимодействия.
    }

    public static void createTable(Class<?> clazz) {
        String tableName = clazz.getAnnotation(Table.class).title();

        StringBuilder sql = new StringBuilder("CREATE TABLE " + tableName + " (");

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                Class<?> fieldType = field.getType();
                String sqlType = getSqlType(fieldType);
                sql.append(field.getName()).append(" ").append(sqlType).append(", ");
            }
        }
        sql.delete(sql.length() - 2, sql.length());
        sql.append(")");

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");
        Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql.toString());
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println("Table not created");
        }
    }

    private static String getSqlType(Class<?> fieldType) {
        if (String.class.equals(fieldType) || Character.class.equals(fieldType)) {
            return "VARCHAR(255)";
        } else if (Byte.class.equals(fieldType) || Short.class.equals(fieldType) ||
                   Integer.class.equals(fieldType) || Long.class.equals(fieldType)) {
            return "INT";
        } else if (Float.class.equals(fieldType) || Double.class.equals(fieldType)) {
            return "FLOAT";
        } else if (Boolean.class.equals(fieldType)) {
            return "BIT";
        } else if (Date.class.equals(fieldType)) {
            return "DATE";
        } else if (Timestamp.class.equals(fieldType)) {
            return "TIMESTAMP";
        } else {
            // Для других типов можно добавить дополнительную логику или выбросить исключение
            throw new UnsupportedOperationException("Не поддерживается тип: " + fieldType.getName());
        }
    }

    public static void insertObject(Object object) {
        Class<?> clazz = object.getClass();
        String tableName = clazz.getAnnotation(Table.class).title();
        StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");
        StringBuilder values = new StringBuilder("VALUES (");
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                sql.append(field.getName()).append(", ");
                values.append("?, ");
            }
        }

        sql.delete(sql.length() - 2, sql.length());
        values.delete(values.length() - 2, values.length());
        sql.append(") ").append(values).append(")");

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");
             PreparedStatement preparedStatement = conn.prepareStatement(sql.toString())) {
            int index = 1;
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    preparedStatement.setObject(index++, field.get(object));
                }
            }
            preparedStatement.executeUpdate();
            System.out.println("Table inserted");
        } catch (SQLException | IllegalAccessException e) {
            System.out.println("Error inserting object");
        }
    }
}
