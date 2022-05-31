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
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Выполняет решение следующих задач:.
 *
 *<p>
 *     Для каждой введенной цифры (0 — 9) вывести соответствующее ей название
 *     на английском языке (0 — zero, 1 — one,2 — two,... ).
 * </p>
 * @version 1.0
 * @author Nasypalov Nikita
 */

public class Second {

    /** Определяет название введенной цифры.
     *
     * <p>
     *      При вводе данных из файла происходит попытка открытия
     *      файла и в случае успеха начинается считывание данных.
     *      Считывается число.
     * </p>
     * <p>
     *     При выборе ввода с консоли процесс считывания начинается
     *     сразу.
     * </p>
     * <p>
     *     После считывания начинается процесс определения введенной цифры.
     *     После нахождения введенной цифры в списке, ее название выводится.
     * </p>
     * @throws Exception при открытии файла
     * @param path путь к файлу
     */
    static final Logger logger = LogManager.getLogger(Program.class);

    public static void TranslateNumber(String path) {
        byte a = 0; // Переменная для ввода числа
        final String Error = "Ошибка! В файле недостаточно данных!";
        if (path != "") {
            logger.debug("Попытка открытия файла");
            logger.info("Возможно возникновение проблем при открытии файла");
            try (FileReader file = new FileReader(path)) {
                logger.debug("Начало считывания данных из файла");
                logger.info("Возможно отсутствие данных в файле");
                Scanner scanner = new Scanner(file);
                try {
                    logger.debug("Считывание числа из файла");
                    a = scanner.nextByte();
                }
                catch (Exception e) {
                    logger.trace(e);
                    logger.error("Ошибка считывания",e);
                    System.out.println(Error);
                    return;
                }
            } catch (Exception e) {
                logger.trace(e);
                logger.error("Отсутствие данных в файле", e);
                logger.debug("Перенаправление пользователя на выбор повторного выполнения программы");
                System.out.println("Ошибка открытия файла! Повторите попытку");
                return;
            }
        } else {
            logger.debug("Начало считывания данных из консоли");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите число от 0 до 9 чтобы получить соответствующее название, 10 для завершения\n");
            a = scanner.nextByte();
        }

        logger.info("Начало прецесса определения названия числа");
        Scanner scanner = new Scanner(System.in);
        while (a != 10) {
            switch (a) {
                case 1:
                    System.out.print(" one \n");
                    break;
                case 2:
                    System.out.print(" two \n");
                    break;
                case 3:
                    System.out.print(" three \n");
                    break;
                case 4:
                    System.out.print(" four \n");
                    break;
                case 5:
                    System.out.print(" five \n");
                    break;
                case 6:
                    System.out.print(" six \n");
                    break;
                case 7:
                    System.out.print(" seven \n");
                    break;
                case 8:
                    System.out.print(" eight \n");
                    break;
                case 9:
                    System.out.print(" nine \n");
                    break;
                case 0:
                    System.out.print(" zero \n");
                    break;
                default:
                    logger.warn("Введено некорректное значение");
                    System.out.print("Не верное значение. Попробуйте еще раз\n");
                    break;
            }
            a = scanner.nextByte();
        }
        logger.debug("Завершение работы подпрограммы");
        logger.debug("Перенаправление пользователя на выбор повторного выполнения программы");
    }
}