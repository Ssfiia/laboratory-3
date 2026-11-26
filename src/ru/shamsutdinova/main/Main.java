package ru.shamsutdinova.main;

import ru.shamsutdinova.point.Point;
import ru.shamsutdinova.name.Name;
import ru.shamsutdinova.phone.PhoneBook;
import ru.shamsutdinova.input.Input;
import ru.shamsutdinova.weapon.Gun;
import ru.shamsutdinova.weapon.MachineGun;
import ru.shamsutdinova.weapon.Shooter;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Main {
    private static Scanner SC = new Scanner(System.in);
    private static Input IN = new Input(SC);

    public static void main(String[] args) {
        while (true) {
            printMainMenu();
            int choice = IN.readInt("Ваш выбор: ");
            switch (choice) {
                case 1: menuTask15(); break;
                case 2: menuTask17(); break;
                case 3: menuTask23(); break;
                case 4: menuTask34(); break;
                case 5: menuTask58(); break;
                case 6: menuTask62(); break;
                case 7: Task73(args); break;
                case 0:
                    System.out.println("Выход. До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Повторите.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n ЛАБОРАТОРНАЯ РАБОТА 3");
        System.out.println(" 1. Задание 1.5: Пистолет");
        System.out.println(" 2. Задание 1.7: Непустые имена");
        System.out.println(" 3. Задание 2.3: Телефонный справочник");
        System.out.println(" 4. Задание 3.4: Автомат");
        System.out.println(" 5. Задание 5.8: Стрелок");
        System.out.println(" 6. Задание 6.2: Сравнение точек");
        System.out.println(" 7. Задание 7.3: Возведение в степень");
        System.out.println(" 0. Выход");
    }

    private static void menuTask15() {
        while (true) {
            System.out.println("\n ЗАДАНИЕ 1.5: ПИСТОЛЕТ");
            System.out.println(" 1. Пример из условия");
            System.out.println(" 2. Управление пистолетом");
            System.out.println(" 0. Назад");
            int choice = IN.readInt("Ваш выбор: ");
            switch (choice) {
                case 1: demoTask15(); break;
                case 2: interactiveTask15(); break;
                case 0: return;
                default: System.out.println("Неверный выбор.");
            }
        }
    }

    private static void demoTask15() {
        Gun p = new Gun(7);
        System.out.println("В пистолете максимум " + p.getMaxAmmo() + " патронов.");
        System.out.println("Зарядили 3, лишних: " + p.reload(3));
        for (int i = 0; i < 5; i++) p.shoot();
        System.out.println("Зарядили 8, лишних: " + p.reload(8));
        p.shoot(); p.shoot();
        System.out.println("Разрядили: " + p.unload() + " патронов");
        p.shoot();
    }

    private static void interactiveTask15() {
        int maxAmmo = IN.readNonNegativeInt("Введите максимальную вместимость пистолета: ");
        Gun p = new Gun(maxAmmo);
        
        while (true) {
            System.out.println("\nМаксимальная вместимость: " + p.getMaxAmmo());
            System.out.println(p);
            System.out.println(" 1. Зарядить");
            System.out.println(" 2. Перезарядить");
            System.out.println(" 3. Выстрелить");
            System.out.println(" 4. Разрядить");
            System.out.println(" 0. Назад");
            int action = IN.readInt(" Действие: ");
            if (action == 0) break;
            
            switch (action) {
                case 1:
                    if (p.isLoaded()) {
                        System.out.println("Пистолет уже заряжен!");
                    } else {
                        int count = IN.readNonNegativeInt("Сколько патронов зарядить: ");
                        int extra = p.reload(count);
                        System.out.println("Лишних патронов возвращено: " + extra);
                    }
                    break;
                case 2:
                    int count = IN.readNonNegativeInt("Сколько патронов зарядить: ");
                    int extra = p.reload(count);
                    System.out.println("Лишних патронов возвращено: " + extra);
                    break;
                case 3:
                    int shots = IN.readNonNegativeInt("Сколько выстрелов сделать: ");
                    for (int i = 0; i < shots; i++) {
                        p.shoot();
                    }
                    break;
                case 4:
                    if (!p.isLoaded()) {
                        System.out.println("Пистолет уже разряжен!");
                    } else {
                        int unloaded = p.unload();
                        System.out.println("Возвращено при разрядке: " + unloaded);
                    }
                    break;
                default:
                    System.out.println(" Неверное действие.");
            }
        }
    }

    private static void menuTask17() {
        while (true) {
            System.out.println("\n ЗАДАНИЕ 1.7: НЕПУСТЫЕ ИМЕНА");
            System.out.println(" 1. Демонстрация");
            System.out.println(" 2. Создать имя вручную");
            System.out.println(" 0. Назад");
            int choice = IN.readInt("Ваш выбор: ");
            switch (choice) {
                case 1: demoTask17(); break;
                case 2: manualTask17(); break;
                case 0: return;
                default: System.out.println("Неверный выбор.");
            }
        }
    }

    private static void demoTask17() {
        System.out.println(new Name("Иван", "Иванов"));
        System.out.println(new Name("Иван", ""));
        System.out.println(new Name("", "Иванов"));
    }

    private static void manualTask17() {
        String f = IN.readString("Имя: ");
        String l = IN.readString("Фамилия: ");
        try {
            Name n = new Name(f, l);
            System.out.println("Создано: " + n);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void menuTask23() {
        while (true) {
            System.out.println("\n ЗАДАНИЕ 2.3: ТЕЛЕФОННЫЙ СПРАВОЧНИК");
            System.out.println(" 1. Демонстрация ");
            System.out.println(" 2. Интерактивный справочник");
            System.out.println(" 0. Назад");
            int choice = IN.readInt("Ваш выбор: ");
            switch (choice) {
                case 1: demoTask23(); break;
                case 2: interactiveTask23(); break;
                case 0: return;
                default: System.out.println("Неверный выбор.");
            }
        }
    }

    private static void demoTask23() {
        PhoneBook pb = new PhoneBook();
        pb.add("89003337788", "Вася");
        pb.add("89112223344", "Петя");
        System.out.println("Старый телефон Васи: " + pb.add("89990001122", "Вася"));
        System.out.println("Телефон Васи: " + pb.getPhone("Вася"));
        System.out.println("Имена на П: " + String.join(", ", pb.namesStartingWith("П")));
        System.out.println("Все пары: " + pb);
    }

    private static void interactiveTask23() {
        PhoneBook pb = new PhoneBook();
        while (true) {
            System.out.println(" 1 - Добавить пару");
            System.out.println(" 2 - Удалить по имени");
            System.out.println(" 3 - Получить телефон по имени");
            System.out.println(" 4 - Проверить наличие имени");
            System.out.println(" 5 - Проверить наличие телефона");
            System.out.println(" 6 - Получить все пары");
            System.out.println(" 7 - Получить все телефоны");
            System.out.println(" 8 - Получить все имена");
            System.out.println(" 9 - Количество пар");
            System.out.println(" 10 - Получить имена по префиксу");
            System.out.println(" 0 - Назад");
            
            int op = IN.readInt("Действие: ");
            if (op == 0) break;
            
            switch (op) {
                case 1:
                    String phone = IN.readString("Телефон: ");
                    String name = IN.readString("Имя: ");
                    try {
                        String old = pb.add(phone, name);
                        System.out.println(old == null ? "Добавлено." : "Заменён старый телефон: " + old);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 2:
                    String delName = IN.readString("Имя для удаления: ");
                    String removed = pb.remove(delName);
                    System.out.println(removed == null ? "Не найдено." : " Удалён телефон: " + removed);
                    break;
                case 3:
                    String findName = IN.readString("Имя: ");
                    String foundPhone = pb.getPhone(findName);
                    System.out.println(foundPhone == null ? "Нет такого имени." : "Телефон: " + foundPhone);
                    break;
                case 4:
                    if (pb.containsName(IN.readString("Имя: "))){
                        System.out.println("Есть в списке ");
                    }
                    else System.out.println("Нет в списке ");
                    break;
                case 5:
                    if (pb.containsPhone(IN.readString("Телефон: "))){
                        System.out.println("Есть в списке");
                    }
                    else System.out.println("Нет в списке ");
                    break;
                case 6:
                    System.out.println("Все пары: " + String.join(", ", pb.allPairs()));
                    break;
                case 7:
                    System.out.println("Все телефоны: " + String.join(", ", pb.allPhones()));
                    break;
                case 8:
                    System.out.println("Все имена: " + String.join(", ", pb.allNames()));
                    break;
                case 9:
                    System.out.println("Найдено: " + pb.size() + " пар");
                    break;
                case 10:
                    System.out.println("Найдено: " + String.join(", ", pb.namesStartingWith(IN.readString(" Введите префикс: "))));
                    break;
                default:
                    System.out.println("Нет такого действия.");
            }
        }
    }

    private static void menuTask34() {
        while (true) {
            System.out.println("\n ЗАДАНИЕ 3.4: АВТОМАТ");
            System.out.println(" 1. Инициализация без параметров");
            System.out.println(" 2. Скорострельность равна половине обоймы");
            System.out.println(" 3. Создать автомат");
            System.out.println(" 0. Назад");
            int choice = IN.readInt("Ваш выбор: ");
            switch (choice) {
                case 1: demoTask34(); break;
                case 2: halfTask34();break;
                case 3: manualTask34(); break;
                case 0: return;
                default: System.out.println("Неверный выбор.");
            }
        }
    }

    private static void demoTask34() {
        MachineGun mg = new MachineGun();
        System.out.println("Вместимость: " + mg.getMaxAmmo());
        System.out.println("Скорострельность: " + mg.getRate());
        int load = IN.readPositiveInt("Зарядить: ");
        System.out.println("Лишних: " + mg.reload(load));
        int sec = IN.readPositiveInt("Секунд: ");
        mg.shootSeconds(sec);
    }

    private static void halfTask34(){
        int cap = IN.readPositiveInt("Вместимость: ");
        MachineGun mg = new MachineGun(cap);
        System.out.println("Скорострельность: " + mg.getRate());
        int load = IN.readPositiveInt("Зарядить: ");
        System.out.println("Лишних: " + mg.reload(load));
        int sec = IN.readPositiveInt("Секунд: ");
        mg.shootSeconds(sec);
    }

    private static void manualTask34() {
        int cap = IN.readPositiveInt("Вместимость: ");
        int rate = IN.readPositiveInt("Скорострельность: ");
        MachineGun mg = new MachineGun(cap, rate);
        int load = IN.readPositiveInt("Зарядить: ");
        System.out.println("Лишних: " + mg.reload(load));
        int sec = IN.readPositiveInt("Секунд: ");
        mg.shootSeconds(sec);
    }

    private static void menuTask58() {
        while (true) {
            System.out.println("\n ЗАДАНИЕ 5.8: СТРЕЛОК");
            System.out.println(" 1. Демонстрация");
            System.out.println(" 2. Создать стрелка вручную");
            System.out.println(" 0. Назад");
            int choice = IN.readInt("Ваш выбор: ");
            switch (choice) {
                case 1: demoTask58(); break;
                case 2: manualTask58(); break;
                case 0: return;
                default: System.out.println("Неверный выбор.");
            }
        }
    }

    private static void demoTask58() {
        Shooter sh1 = new Shooter("Джон", null);
        System.out.println(sh1);
        sh1.shoot();

        Shooter sh2 = new Shooter("Майк", new Gun(6));
        sh2.getWeapon().load(2);
        System.out.println(sh2);
        sh2.shoot();

        Shooter sh3 = new Shooter("Билл", new MachineGun(10, 3));
        sh3.getWeapon().load(5);
        System.out.println(sh3);
        sh3.shoot();
    }

    private static void manualTask58() {
        String name = IN.readString("Имя стрелка: ");
        int type = IN.readInt("Оружие (1 пистолет, 2 автомат): ");
        Shootable weapon;
        if (type == 1) {
            weapon = new Gun(IN.readInt("Вместимость пистолета: "));
        } else {
            int cap = IN.readInt("Вместимость автомата: ");
            int rate = IN.readInt("Скорострельность: ");
            weapon = new MachineGun(cap, rate);
        }
        Shooter sh = new Shooter(name, weapon);
        int load = IN.readInt("Зарядить патронов: ");
        sh.getWeapon().load(load);
        int shots = IN.readInt("Выстрелов: ");
        for (int i = 0; i < shots; i++) sh.shoot();
        System.out.println(sh);
    }

    private static void menuTask62() {
        while (true) {
            System.out.println("\n ЗАДАНИЕ 6.2: СРАВНЕНИЕ ТОЧЕК");
            System.out.println(" 1. Демонстрация");
            System.out.println(" 2. Сравнить точки вручную");
            System.out.println(" 0. Назад");
            int choice = IN.readInt("Ваш выбор: ");
            switch (choice) {
                case 1: demoTask62(); break;
                case 2: manualTask62(); break;
                case 0: return;
                default: System.out.println("Неверный выбор.");
            }
        }
    }

    private static void demoTask62() {
        System.out.println(" {1;2} == {1;2}? ");
        if (new Point(1, 2).equals(new Point(1, 2))){
            System.out.println("Точки равны");
        }
        System.out.println(" {1;2} == {3;4}? ");
        if (!new Point(1, 2).equals(new Point(3, 4))){
            System.out.println("Точки не равны");
        }
    }

    private static void manualTask62() {
        int x1 = IN.readInt(" x1: "), y1 = IN.readInt(" y1: ");
        int x2 = IN.readInt(" x2: "), y2 = IN.readInt(" y2: ");
        Point p1 = new Point(x1, y1), p2 = new Point(x2, y2);
        if (p1.equals(p2)){
            System.out.println(" " + p1 + " == " + p2 + " Точки равны");
        }
        else System.out.println(" " + p1 + " != " + p2 + " Точки не равны");
    }

    static double power(String x, String y) {
        return pow(parseInt(x), parseInt(y));
    }

    private static void Task73(String[] args) {
        while (true) {
            System.out.println("\n ЗАДАНИЕ 7.3: ВОЗВЕДЕНИЕ В СТЕПЕНЬ");
            System.out.println(" 1. Демонстрация");
            System.out.println(" 2. Ввести числа вручную");
            System.out.println(" 0. Назад");
            int choice = IN.readInt("Ваш выбор: ");
            switch (choice) {
                case 1: 
                    System.out.println(" 2 ^ 10 = " + power("2", "10"));
                    if (args.length >= 2) {
                        System.out.println(" Из аргументов командной строки: " + args[0] + " ^ " + args[1] + " = " + power(args[0], args[1]));
                    }
                    break;
                case 2: 
                    String x = IN.readString(" Основание X: ");
                    String y = IN.readString(" Степень Y: ");
                    try {
                        System.out.println(" " + x + " ^ " + y + " = " + power(x, y));
                    } catch (NumberFormatException e) {
                        System.out.println(" Ошибка: X и Y должны быть целыми числами.");
                    }
                    break;
                case 0: return;
                default: System.out.println("Неверный выбор.");
            }
        }
    }
}