package ru.dev.bolnik.dz8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "orange", "banana", "apple", "grape", "banana"};

//         Найти наиболее часто встречающееся слово и вывести результат
        Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry ->
                        System.out.println("Наиболее часто встречающееся слово: " + entry.getKey() +
                                           " (встречается " + entry.getValue() + " раз)"));

        // найти среднюю зп сотрудника
        List<Employee> employees = Arrays.asList(
                new Employee("John", 30, 50000),
                new Employee("Alice", 25, 60000),
                new Employee("Bob", 36, 55000),
                new Employee("Dima", 35, 55000),
                new Employee("Roma", 37, 55000)
        );

        double v = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(Double.NaN);
        System.out.println(v);

        findOldestEmployees(employees, 2);





    }
        public static void findOldestEmployees(List<Employee> employees, int n) {
            List<String> list = employees.stream()
                    .sorted((e1, e2) -> e2.getAge() - e1.getAge())
                    .limit(n)
                    .map(Employee::getName)
                    .collect(Collectors.toList());

            String result = String.join(", ", list);
            System.out.printf("%d самых старших сотрудников зовут: %s%n", n, result);

        }
}

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

