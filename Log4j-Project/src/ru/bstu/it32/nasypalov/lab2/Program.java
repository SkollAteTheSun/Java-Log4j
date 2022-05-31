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

import java.util.Scanner;
import static ru.bstu.it32.nasypalov.lab2.First.*;
import static ru.bstu.it32.nasypalov.lab2.Second.*;
import static ru.bstu.it32.nasypalov.lab2.Third.*;
import static ru.bstu.it32.nasypalov.lab2.Fourth.*;
import org.apache.logging.log4j.*;

/** Выполняет решение следующих задач:.
 *
 *<p>
 *     1) На оси ОХY расположены три точки а, Ь, с.
 *     Определить, какая из точек b или с расположена ближе к а.
 * </p>
 * <p>
 *     2) Для каждой введенной цифры (0 — 9) вывести соответствующее ей название
 *     на английском языке (0 — zero, 1 — one,2 — two,... ).
 * </p>
 * <p>
 *     3) Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом n.
 *     Результат представить в виде таблицы, первый столбец которой — значения аргумента,
 *     второй — соответствующие значения функции
 *     F(x) = sinx + tg x
 * </p>
 * <p>
 *     4) Задан массив с количеством элементов N. Сформировать два массива:
 *     в первый включить элементы исходного массива с четными номерами, а во второй — с нечетными.
 * </p>
 * @version 1.0
 * @author Nasypalov Nikita
 */


public class Program {

     /** Главная функция.
     *
     * <p>
     *     Выбор номера программы, способа ввода данных и вызов
     *     соответствующих функций. После решения задач можно
     *     повторить работы, либо выйти из программы.
     * </p>
     * @param args аргументы командной строки
     */

     static final Logger logger = LogManager.getLogger(Program.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       // StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int n = 0; // Номер программы
        int file = 0; // Ввод с файла или с клавиатуры
        logger.debug("Начало работы программы");
        while (true) {
            while (true) {
                logger.debug("Ввод пользователем номера программы");
                System.out.print("Номер программы: ");
                try {
                    n = scanner.nextInt();
                } catch (Exception e) {
                    logger.trace(e);
                    logger.fatal("Введено недопустимое значение: ", e);
                    logger.debug("Завершение работы программы");
                    return;
                }
                if ((n <= 0) || (n > 4)) {
                    logger.warn("Введено некорректное значение");
                } else break;
            }
            logger.info("Выбрана программа: " + n);
            while (true) {
                logger.debug("Ввод пользователем способа чтения данных");
                System.out.print("Ввод данных (1 - файл, 2 - консоль): ");
                try {
                    file = scanner.nextInt();
                } catch (Exception e) {
                    logger.trace(e);
                    logger.fatal("Введено недопустимое значение: ", e);
                    logger.debug("Завершение работы программы");
                    return;
                }
                if ((file != 1) && (file != 2)) {
                    logger.warn("Введено некорректное значение");
                } else break;
            }
            String path = ""; // Путь к файлу
            if (file == 1) {
                logger.info("Выбрано чтение данных из файла");
                System.out.print("Путь к файлу: ");
                path = scanner.next();
            }
            switch (n) {
                case 1: {
                    logger.debug("Запуск подпрограммы 1");
                    Positioning(path);
                    break;
                }
                case 2: {
                    logger.debug("Запуск подпрограммы 2");
                    TranslateNumber(path);
                    break;
                }
                case 3: {
                    logger.debug("Запуск подпрограммы 3");
                    GetFuctionValue(path);
                    break;
                }
                case 4: {
                    logger.debug("Запуск подпрограммы 4");
                    ArraySort(path);
                    break;
                }
            }
            do {
                logger.debug("Выбор пользователем повторного выполнения программы");
                System.out.print("Введите 1 чтобы повторить, 0 для завершения ");
                n = scanner.nextInt();
            }
            while ((n != 1) && (n != 0));
            if (n == 0)
                return;
        }
    }
}

