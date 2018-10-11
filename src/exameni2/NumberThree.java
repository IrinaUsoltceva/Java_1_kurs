package exameni2;

/**
 * Created by Alina_A on 22.06.2017.
 */
public class NumberThree {
    public static void main(String[] args) {

        //Базовые типы данных

        //1. Создание переменной базового типа

        int a; //не инициализированная переменная, ей не присвоено никакое значение, но позже мы можем его присвоить
        a = 42;
        System.out.println("Переменная типа int, которая не сразу была инициализирована: " + a);

        char c = 'k';
        System.out.println("Переменная типа char, которая сразу была инициализирована: " + c);

        boolean b = true;
        System.out.println("Переменная типа boolean: " + b);

        double d = 3.5;
        System.out.println("Переменная типа double " + d);
        System.out.println();

        //2. Арифметические операции

        int x1 = 7;
        int x2 = 5;
        double x3 = 2.5;
        double x4 = 2.0;

        //2.1 Сложение
        int rez1 = x1 + x2;
        System.out.println("Сложение int + int: " + rez1);
        double rez2 = x1 + x3;
        System.out.println("Сложение int + double: " + rez2);
        System.out.println();

        //2.2 Вычитание
        rez1 = x1 - x2;
        System.out.println("Вычитание int - int: " + rez1);
        rez2 = x1 - x3;
        System.out.println("Вычитание int - double: " + rez2);
        System.out.println();

        //2.3 Умножение
        rez1 = x1 * x2;
        System.out.println("Умножение int * int: " + rez1);
        rez2 = x1 * x3;
        System.out.println("Умножение int * double: " + rez2);
        System.out.println();

        //2.4 Целочисленное деление
        rez1 = x1 - x2;
        System.out.println("Деление int / int: " + rez1);
        rez2 = x1 - x3;
        System.out.println("Деление int / double: " + rez2);
        System.out.println();

        //2.5 Деление по остатку
        rez1 = x1 % x2;
        System.out.println("Остаток int % int: " + rez1);
        rez2 = x1 % x3;
        System.out.println("Остаток int % double: " + rez2);
        System.out.println();

        //Унарное сложение и вычитание
        rez1 = ++x1;
        rez2 = --x3;
        System.out.println("Унарное сложение: " + rez1);
        System.out.println("Унарное вычитание: " + rez2);
        System.out.println();

        //3. Приведение типов

        rez2 = x3 / x4; //double/double -> double
        System.out.println(rez2);
        rez1 = x1 / x2; //int/int -> int
        System.out.println(rez1);
        rez2 = x2 / x3; //int/double -> double
        System.out.println(rez2);
        rez2 = (double) x1 / x2;
        System.out.println(rez2);


    }
}
