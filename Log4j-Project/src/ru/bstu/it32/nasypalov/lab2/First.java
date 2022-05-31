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
import java.lang.Math;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Выполняет решение следующих задач:.
 *
 *<p>
 *     На оси ОХY расположены три точки а, Ь, с.
 *     Определить, какая из точек b или с расположена ближе к а.
 * </p>
 * @version 1.0
 * @author Nasypalov Nikita
 */


public class First {

    /** Определяет какая из точек расположена ближе к точке A.
     *
     * <p>
     *      При вводе данных из файла происходит попытка открытия
     *      файла и в случае успеха начинается считывание данных.
     *      Считываются числа.
     * </p>
     * <p>
     *     При выборе ввода с консоли процесс считывания начинается
     *     сразу.
     * </p>
     * <p>
     *     После считывания начинается вычислеине расстояния между точками.
     *     После вычисления расстояния сравниваются. Точка находящаяся ближе
     *     выводится.
     * </p>
     * @throws Exception при открытии файла
     * @param path путь к файлу
     */
    static final Logger logger = LogManager.getLogger(Program.class);

    public static void Positioning(String path) {

       // StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int a1 = 0; // Координата x точки A
        int a2 = 0; // Координата y точки A
        int b1 = 0; // Координата x точки B
        int b2 = 0; // Координата y точки B
        int c1 = 0; // Координата x точки С
        int c2 = 0; // Координата y точки C
        final String Error = "Ошибка! В файле недостаточно данных!";

        if(path != "") {
            logger.debug("Попытка открытия файла");
            logger.info("Возможно возникновение проблем при открытии файла");
            try(FileReader file = new FileReader(path)) {
                logger.debug("Начало считывания данных из файла");
                logger.info("Возможно отсутствие данных в файле");
                Scanner scanner = new Scanner(file);
                try{
                    logger.debug("Считывание значения x для точки А(x;y)");
                    a1 = scanner.nextInt();
                }
                catch (Exception e){
                    logger.trace(e);
                    logger.error("Ошибка считывания",e);
                    System.out.println(Error);
                    return;
                }
                logger.info("a1 = " + a1);
                try{
                    logger.debug("Считывание значения y для точки А(x;y)");
                    a2 = scanner.nextInt();
                }
                catch (Exception e){
                    logger.trace(e);
                    logger.error("Ошибка считывания",e);
                    System.out.println(Error);
                    return;
                }
                logger.info("a2 = " + a2);
                try{
                    logger.debug("Считывание значения x для точки B(x;y)");
                    b1 = scanner.nextInt();
                }
                catch (Exception e){
                    logger.trace(e);
                    logger.error("Ошибка считывания",e);
                    System.out.println(Error);
                    return;
                }
                logger.info("b1 = " + b1);
                try{
                    logger.debug("Считывание значения y для точки B(x;y)");
                    b2 = scanner.nextInt();
                }
                catch (Exception e){
                    logger.trace(e);
                    logger.error("Ошибка считывания",e);
                    System.out.println(Error);
                    return;
                }
                logger.info("b2 = " + b2);
                try{
                    logger.debug("Считывание значения x для точки C(x;y)");
                    c1 = scanner.nextInt();
                }
                catch (Exception e){
                    logger.trace(e);
                    logger.error("Ошибка считывания",e);
                    System.out.println(Error);
                    return;
                }
                logger.info("c1 = " + c1);
                try{
                    logger.debug("Считывание значения y для точки C(x;y)");
                    c2 = scanner.nextInt();
                }
                catch (Exception e){
                    logger.trace(e);
                    logger.error("Ошибка считывания",e);
                    System.out.println(Error);
                    return;
                }
                logger.info("c2 = " + c2);
            }
            catch(Exception e) {
                logger.error("Отсутствие данных в файле", e);
                logger.debug("Перенаправление пользователя на выбор повторного выполнения программы");
                System.out.println("Ошибка открытия файла! Повторите попытку");
                return;
            }
        }
        else {
            logger.debug("Начало считывания данных из консоли");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите координаты точки A");
            System.out.print("\nx = ");
            try {
                a1 = scanner.nextInt();
            }
            catch(Exception e){
                logger.trace(e);
                logger.fatal("Введено недопустимое значение: ", e);
                logger.debug("Завершение работы программы");
                System.exit(-1);
            }
            System.out.print("y = ");
            try {
                a2 = scanner.nextInt();
            }
            catch(Exception e) {
                logger.trace(e);
                logger.fatal("Введено недопустимое значение: ", e);
                logger.debug("Завершение работы программы");
                System.exit(-1);
            }
            System.out.print("Введите координаты точки B");
            System.out.print("\nx = ");
            try {
                b1 = scanner.nextInt();
            }
            catch(Exception e){
                logger.trace(e);
                logger.fatal("Введено недопустимое значение: ", e);
                logger.debug("Завершение работы программы");
                System.exit(-1);
            }
            System.out.print("y = ");
            try {
                b2 = scanner.nextInt();
            }
            catch(Exception e){
                logger.trace(e);
                logger.fatal("Введено недопустимое значение: ", e);
                logger.debug("Завершение работы программы");
                System.exit(-1);
            }
            System.out.print("Введите координаты точки C");
            System.out.print("\nx = ");
            try {
                c1 = scanner.nextInt();
            }
            catch(Exception e){
                logger.trace(e);
                logger.fatal("Введено недопустимое значение: ", e);
                logger.debug("Завершение работы программы");
                System.exit(-1);
            }
            System.out.print("y = ");
            try {
                c2 = scanner.nextInt();
            }
            catch(Exception e) {
                logger.trace(e);
                logger.fatal("Введено недопустимое значение: ", e);
                logger.debug("Завершение работы программы");
                System.exit(-1);
            }
        }

        System.out.printf("A(%d,%d); B(%d,%d); C(%d,%d)  \n", a1, a2, b1, b2, c1, c2);
        logger.info("A(" + a1 + "," + a2 + "); B(" + b1 +"," +b2 + "); C(" + c1 +"," +c2 + ");");
        logger.info("Начало вычислений");
        if ( Math.sqrt(Math.pow((b1 - a1), 2) + Math.pow((b2 - a2), 2)) <
                Math.sqrt(Math.pow((c1 - a1), 2) + Math.pow((c2 - a2), 2))) {
            System.out.print("Точка B расположена ближе к A, чем точка С \n");
            logger.debug("Точка B расположена ближе к A, чем точка С");
        }
        else if ( Math.sqrt(Math.pow((b1 - a1), 2) + Math.pow((b2 - a2), 2)) ==
                     Math.sqrt(Math.pow((c1 - a1), 2) + Math.pow((c2 - a2), 2))) {
            System.out.print("Точки B и C расположены на равном расстоянии от точки A \n");
            logger.debug("Точки B и C расположены на равном расстоянии от точки A");
        }
        else {
            System.out.print("Точка С расположена ближе к A, чем точка B \n");
            logger.debug("Точка С расположена ближе к A, чем точка B");
        }
        logger.debug("Завершение работы подпрограммы");
        logger.debug("Перенаправление пользователя на выбор повторного выполнения программы");
    }
}
