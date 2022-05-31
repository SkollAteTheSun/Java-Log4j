/*
 * Program
 *
 * v1.0
 *
 * 20/04/2020
 *
 * Copyright 2020 BSTU
 */

package ru.bstu.it32.nasypalov.lab2;

import java.io.FileReader;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Выполняет решение следующих задач:.
 *
 *<p>
 *     3) Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом n.
 *     Результат представить в виде таблицы, первый столбец которой — значения аргумента,
 *     второй — соответствующие значения функции
 *     F(x) = sinx + tg x
 * </p>
 * @version 1.0
 * @author Nasypalov Nikita
 */

public class Third {

    /** Вычисляет значение функции F(x) на отрезке [а, b] с шагом n.
     *
     * <p>
     *      При вводе данных из файла происходит попытка открытия
     *      файла и в случае успеха начинается считывание данных.
     *      Считываются начало, коннец отрезка и шаг.
     * </p>
     * <p>
     *     При выборе ввода с консоли процесс считывания начинается
     *     сразу.
     * </p>
     * <p>
     *     После считывания начинается вычисление значения функции.
     *     Значения выводятся таблицей в консоль.
     * </p>
     * @throws Exception при открытии файла
     * @param path путь к файлу
     */
    static final Logger logger = LogManager.getLogger(Program.class);

    public static void GetFuctionValue(String path) {
        double a = 0; // Координата начала отрезка
        double b = 0; // Координата конца отрезка
        double h = 0; // Шаг
        double x = 0; // Аргумент функции
        double F = 0; // Значение функции
        Scanner scanner = new Scanner(System.in);
        final String Error = "Ошибка! В файле недостаточно данных!";
        if(path != "") {
            logger.debug("Попытка открытия файла");
            logger.info("Возможно возникновение проблем при открытии файла");
            try(FileReader file = new FileReader(path)) {
                logger.debug("Начало считывания данных из файла");
                logger.info("Возможно отсутствие данных в файле");
                Scanner scan = new Scanner(file);
                try {
                    logger.debug("Считывание координаты начала отрезка");
                    a = scan.nextDouble();
                }
                catch (Exception e){
                    logger.trace(e);
                    logger.error("Ошибка считывания",e);
                    System.out.println(Error);
                    return;
                }
                logger.info("a = " + a);
                try {
                    logger.debug("Считывание координаты конца отрезка");
                    b = scan.nextDouble();
                }
                catch (Exception e) {
                    logger.trace(e);
                    logger.error("Ошибка считывания",e);
                    System.out.println(Error);
                    return;
                }
                logger.info("b = " + b);
                try {
                    logger.debug("Считывание шага");
                    h = scan.nextDouble();
                }
                catch (Exception e) {
                    logger.trace(e);
                    logger.error("Ошибка считывания",e);
                    System.out.println(Error);
                    return;
                }
                logger.info("h = " + h);
                logger.debug("Проверка корректности введённых значений из файла");
                if (a > b) {
                    if (h > 0) {
                        logger.error("Некоректно введены данные");
                        logger.debug("Перенаправление пользователя на выбор повторного выполнения программы");
                        System.out.printf("При a = %.1f и b = %.1f, значение h НЕ должно быть положительным \n", a, b);
                        return;
                    }
                }
                else
                if(a < b) {
                    if (h < 0) {
                        logger.error("Некоректно введены данные");
                        logger.debug("Перенаправление пользователя на выбор повторного выполнения программы");
                        System.out.printf("При a = %.1f и b = %.1f, значение h НЕ должно быть отрицательным \n", a, b);
                        return;
                    }
                }
                if (h == 0) {
                    logger.error("Некоректно введены данные");
                    logger.debug("Перенаправление пользователя на выбор повторного выполнения программы");
                    System.out.print("Значение h НЕ должно быть равно 0 \n");
                }

            }
            catch(Exception e) {
                logger.trace(e);
                logger.error("Отсутствие данных в файле", e);
                logger.debug("Перенаправление пользователя на выбор повторного выполнения программы");
                System.out.println("Ошибка открытия файла! Повторите попытку");
                return;
            }
        }
        else {
            boolean test = false;
            do {
                logger.debug("Начало считывания данных из консоли");
                test = true;
                System.out.print("Введите a = ");
                a = scanner.nextDouble();
                logger.info("a = " + a);
                System.out.print("Введите b = ");
                b = scanner.nextDouble();
                logger.info("b = " + b);
                System.out.print("Введите шаг h = ");
                h = scanner.nextDouble();
                logger.info("h = " + h);
                if (a == b) {
                    logger.warn("Введено некорректное значение");
                    logger.debug("Перенаправление пользователя на повторрный ввод данных");
                    System.out.print("Значенич a и b не должны совпадать \n");
                    test = false;
                }
                if (a > b) {
                    if (h > 0) {
                        logger.warn("Введено некорректное значение");
                        logger.debug("Перенаправление пользователя на повторрный ввод данных");
                        System.out.printf("При a = %.1f и b = %.1f, значение h НЕ должно быть положительным \n", a, b);
                        test = false;
                    }
                }
                else
                if(a < b) {
                    if (h < 0) {
                        logger.warn("Введено некорректное значение");
                        logger.debug("Перенаправление пользователя на повторрный ввод данных");
                        System.out.printf("При a = %.1f и b = %.1f, значение h НЕ должно быть отрицательным \n", a, b);
                        test = false;
                    }
                }
                if (h == 0) {
                    logger.warn("Введено некорректное значение");
                    logger.debug("Перенаправление пользователя на повторрный ввод данных");
                    System.out.print("Значение h НЕ должно быть равно 0 \n");
                    test = false;
                }
            } while (test != true);
        }

        System.out.print("Чтобы выполнить с помощью цикла for введите - 0 \n "
                + "               с помощью цикла while  - 1 \n ");
        byte question = scanner.nextByte();

        while (question != 0 | question !=1) {
            if (question == 0) {
                System.out.printf(" ------------------------- \n");
                logger.debug("Начало процесса вычисления при помощи цикла for");
                for (x = a; x <= b; x += h) {
                    F = Math.sin(x*180/Math.PI)* Math.tan(x*180/Math.PI);
                    logger.info("  x =" + x + " |  F(x) = " + F);
                    System.out.printf("  x = %.1f  |  F(x) = %.1f  \n", x, F);
                }
                System.out.printf(" ------------------------- \n");
                break;
            }
            else
            if (question == 1) {
                System.out.printf(" ------------------------\n");
                x = a;
                logger.debug("Начало процесса вычисления при помощи цикла while");
                while (x <= b) {
                    F = Math.sin(x*180/Math.PI)* Math.tan(x*180/Math.PI);
                    logger.info("  x =" + x + " |  F(x) = " + F);
                    System.out.printf("  x = %.1f  |  F(x) = %.1f  \n", a, F);
                    x += h;
                }
                System.out.printf(" ------------------------\n");
                break;
            }
            else {
                logger.info("Неверное значение");
                System.out.printf("Неверное значение \n");
                question = scanner.nextByte();
            }
        }
        logger.debug("Завершение работы подпрограммы");
        logger.debug("Перенаправление пользователя на выбор повторного выполнения программы");
    }
}
