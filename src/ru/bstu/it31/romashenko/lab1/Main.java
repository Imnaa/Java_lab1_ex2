package ru.bstu.it31.romashenko.lab1;

import java.util.Scanner;
import org.apache.logging.log4j.*;

/** @author Ромащенко Н.А.
 *
 * @version 1. 21.02.19
 *
 * Имя класса: Main
 *
 * Назначение: Составить программу, которая по заданным году и номеру месяца т определяет количество дней в этом месяце.
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Определение количества дней в определенному месяце определенного года.");
        System.out.println("\t> 1. Ввести в клавиатуры;");
        System.out.println("\t> 2. Считать из файла;");
        System.out.println("\t> 9. Выход.");
        // Режим ввода данных
        // 1 - клавиатура
        // 2 - файл
        // 9 - выход
        // Инициализация объекта "Сканер"
        Scanner scanner = new Scanner(System.in);
        int mode = scanner.nextInt();
        Calendar calendar = new Calendar();
        // Обработка режима работы
        switch (mode) {
            // Клавиатура
            case 1: {
                // Ввод года
                System.out.print("Год: ");
                calendar.setYear(scanner.nextInt());
                // Ввод месяца
                System.out.print("Месяц: ");
                calendar.setMounth(scanner.nextInt());
                break;
            }
            // Файл
            case 2: {
                // Функция для считывания из файла
                calendar.getValueFromFile();
                break;
            }
            // Выход
            case 9: {
                return;
            }
            // Ошибка ввода
            default: {
                System.out.println("Неправильный ввод месяца.");
                return;
            }
        }
        if (!calendar.setCountDaysOfMounth()) {
            System.out.println("Ошибка в дате.");
            return;
        }
        System.out.println("Количество дней в месяце " + calendar.getMounthString().toLowerCase() + ": " + calendar.getDays() + ".");
        calendar.printValueInFile();
    }
}