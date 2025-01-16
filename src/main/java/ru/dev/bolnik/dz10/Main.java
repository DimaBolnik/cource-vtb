package ru.dev.bolnik.dz10;

public class Main {

//    Практическое задание
//● Создайте таблицу студенты (students): id, имя, серия паспорта, номер паспорта;
//● Создайте таблицу Предметы (subjects): id, название предмета;
//● Создайте таблицу Успеваемость (progress): id, студент, предмет, оценка;
//● Оценка может находиться в пределах от 2 до 5;
//● Вывести список студентов, сдавших определенный предмет, на оценку выше 3;
//● При удалении студента из таблицы, вся его успеваемость тоже должна быть удалена;
//● Посчитать средний бал по определенному предмету;
//● Посчитать средний балл по определенному студенту;
//● Пара серия-номер пасорта должны быть уникальны в таблице Студенты;
//● Найти три премета, которые сдали наибольшее количество студентов;


//    CREATE TABLE students
//            (
//                    id              serial,
//                    name            varchar(32),
//    passport_series varchar(4),
//    passport_number varchar(8),
//    PRIMARY KEY (id),
//    CONSTRAINT unique_passport UNIQUE (passport_number, passport_series)
//);
//
//    CREATE TABLE subjects
//            (
//                    id        serial,
//                    item_name varchar(32) UNIQUE,
//    PRIMARY KEY (id)
//);
//
//    CREATE TABLE progress
//            (
//                    id          serial PRIMARY KEY,
//                    student_id  int REFERENCES students (id) ON DELETE CASCADE,
//    subjects_id int REFERENCES subjects (id),
//    score       int CHECK ( score BETWEEN 2 AND 5 )
//);
//
//-- Добавляем студентов
//    INSERT INTO students (name, passport_series, passport_number)
//    VALUES ('Иван Иванов', '1234', '567890'),
//       ('Мария Петрова', '4321', '098765'),
//               ('Алексей Сидоров', '9876', '543210'),
//               ('Елена Васильева', '1111', '222333'),
//               ('Андрей Кузнецов', '4444', '888999'),
//               ('Ольга Николаева', '6666', '777000'),
//               ('Дмитрий Михайлов', '3333', '555666'),
//               ('Кристина Сергеева', '8888', '999888'),
//               ('Николай Романов', '2222', '444777'),
//               ('Юлия Иванова', '5555', '666999'),
//               ('Владимир Дмитриев', '7777', '888000'),
//               ('Анастасия Павлова', '9999', '999999'),
//               ('Сергей Алексеев', '0000', '111111'),
//               ('Екатерина Борисова', '1111', '222222'),
//               ('Максим Андреев', '2222', '333333'),
//               ('Александра Васильева', '3333', '444444'),
//               ('Денис Егоров', '4444', '555555'),
//               ('Вера Федорова', '5555', '666666'),
//               ('Роман Григорьев', '6666', '777777'),
//               ('Наталия Семенова', '7777', '888888');
//
//-- Добавляем предметы
//    INSERT INTO subjects (item_name)
//    VALUES ('Математика'),
//       ('Физика'),
//               ('Химия'),
//               ('Информатика');
//
//    DO
//            $$
//    DECLARE
//    student_id INT;
//    subject_id INT;
//    score      INT;
//    BEGIN
//        -- Цикл по всем студентам
//    FOR student_id IN 1..20
//    LOOP
//                -- Цикл по всем предметам
//    FOR subject_id IN 1..4
//    LOOP
//                        -- Генерируем случайную оценку от 2 до 5
//    score := FLOOR(RANDOM() * 4) + 2;
//
//                        -- Вставляем оценку в таблицу progress
//    INSERT INTO progress (student_id, subjects_id, score)
//    VALUES (student_id, subject_id, score);
//    END LOOP;
//    END LOOP;
//    END
//            $$;
//
//    SELECT students.name
//    FROM students
//    left join progress p on students.id = p.student_id
//    left join subjects s on p.subjects_id = s.id
//    where s.item_name = 'Физика'
//    and p.score > 3;
//
//    SELECT s.item_name, avg(p.score)
//    FROM progress p
//    LEFT JOIN subjects s on p.subjects_id = s.id
//    GROUP BY s.item_name;
//
//    SELECT AVG(p.score)
//    FROM progress p
//    JOIN students s ON p.student_id = s.id
//    WHERE s.name = 'Елена Васильева';
//
//
//    SELECT s.item_name,
//    COUNT(DISTINCT p.student_id)
//    FROM progress p
//            JOIN
//    subjects s ON p.subjects_id = s.id
//    GROUP BY s.item_name
//    LIMIT 3;
}
