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
 *     4) Задан массив с количеством элементов N. Сформировать два массива:
 *     в первый включить элементы исходного массива с четными номерами, а во второй — с нечетными.
 * </p>
 * @version 1.0
 * @author Nasypalov Nikita
 */

public class Fourth {

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

    public static void ArraySort(String path)
    {
        int myArray []; // Изначальный массив
        int evenArray []; // Массив с четными номерами
        int oddArray []; // Массив с нечетными номерами
        int evenN = 0; // Размерность массива с четным номерами
        int oddN = 0; // Размерность массива с нечетными номерами
        int E = 0; // Индекс массива с четными номерами
        int O = 0; // Индекс массива с нечетными номерами
        int N = 0; // Количество вводимых чисел
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
                    logger.debug("Считывание количества вводимых чисел");
                    N = scan.nextInt();
                }
                catch (Exception e) {
                    logger.trace(e);
                    logger.error("Ошибка считывания",e);
                    System.out.println(Error);
                    return;
                }
                logger.info("N = " + N);
                if (N <= 0) {
                    logger.error("Некоректно введены данные");
                    logger.debug("Перенаправление пользователя на выбор повторного выполнения программы");
                    System.out.print("Значение N не должно быть отрицательным или равняться 0 \n");
                    return;
                }
                logger.info("Массив будет содержать " + N + " элементов");
                logger.debug("Создание массива");
                myArray = new int [N];
                logger.debug("Считывание элементов массива");
                for (int i = 0; i < N; i ++) {
                    try {
                        myArray[i] = scan.nextInt();
                        logger.info(i + " элемент массива = " +  myArray[i]);
                    }
                    catch (Exception e){
                        logger.trace(e);
                        logger.error("Некоректно введены данные");
                        logger.debug("Перенаправление пользователя на выбор повторного выполнения программы");
                        System.out.println(Error);
                        return;
                    }
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
            logger.debug("Начало считывания данных из консоли");
            do {
                logger.debug("Считывание количества вводимых чисел");
                System.out.print("Введите количество елементов N = ");
                N = scanner.nextInt();
                if (N <=0 ) {
                    logger.error("Некоректно введены данные");
                    logger.debug("Перенаправление пользователя на выбор повторного выполнения программы");
                    System.out.print("Значение N не должно быть отрицательным или равняться 0 \n");
                }
            }while (N <=0 );
            logger.info("Массив будет содержать " + N + " элементов");
            logger.debug("Создание массива");
            myArray = new int [N];
            logger.debug("Считывание элементов массива");
            System.out.print("Введите элементы массива \n");
            for (int i = 0; i < N; i += 1) {
                myArray[i] = scanner.nextInt();
                logger.info(i + " элемент массива = " +  myArray[i]);
            }

        }
        logger.info("Вычисление размерности массивов");
        if (N % 2 == 0) {
            evenN = N / 2;
            oddN = evenN;
        }
        else {
            evenN = N / 2 + 1;
            oddN = N / 2;
        }
        logger.info("Массив будет содержать " + evenN + " элементов");
        logger.debug("Создания массива с четными номерами");
        evenArray = new int[evenN];
        logger.info("Массив будет содержать " + oddN + " элементов");
        logger.debug("Создания массива с нечетными номерами");
        oddArray = new int[oddN];
        logger.debug("Заполнение массивов элементами с четными и нечетными номерами");
        for (int i = 0; i < N; i += 1) {
            if (i % 2 == 0) {
                evenArray[E]=myArray[i];
                E += 1;
            }
            else {
                oddArray[O]=myArray[i];
                O += 1;
            }
        }
        logger.info("Вывод элеметов исходного массива: \n");
        System.out.print("Елементы исходного массива: \n");
        for (int i = 0; i < N; i += 1) {
            logger.info(" a[" + i + "] = " + myArray[i]);
            System.out.printf(" a[%d] = %d \n", i, myArray[i]);
        }
        logger.info("Вывод элементов исходного массива с четными номерами: \n");
        System.out.print("Елементы исходного массива с четными номерами: \n");
        for (int i = 0; i < evenN; i += 1) {
            logger.info(" a[" + i + "] = " + evenArray[i]);
            System.out.printf(" a[%d] = %d \n", i, evenArray[i]);
        }
        logger.info("Вывод элементов исходного массива с нечетными номерами: \n");
        System.out.print("Елементы исходного массива с нечетными номерами: \n");
        for (int i = 0; i < oddN; i += 1) {
            logger.info(" a[" + i + "] = " + oddArray[i]);
            System.out.printf(" a[%d] = %d \n", i, oddArray[i]);
        }
        logger.debug("Завершение работы подпрограммы");
        logger.debug("Перенаправление пользователя на выбор повторного выполнения программы");
    }
}

