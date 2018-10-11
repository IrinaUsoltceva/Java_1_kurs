import java.io.File;
import java.util.Arrays;

/**
 * Created by st055086 on 23.03.2018.
 */
public class LambdasExample {
    public static void main(String[] args) {
        //Сортировка массива (списка)
        String[]a = {"abc", "pq", "q", "oi"};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        /*
        Компаратор, сравниватель. Две строки ему -
        отвечает, какое из утверждений верно:
        1) первая строка "больше" второй
        2) меньше
        3) равна

        Лексикографический компаратор сравнивает первую букву
        компаратор длин сравнивает строки их длинами
        Компаратор, фактически, это функеция
        //0 - равно
        //1 или любое положительное означает, что s1 > s2
        //-1 или любое отрицательное означает, что s1 < s2
        int compare(String s1, String s2) {
            if (s1.length() > s2.length())
                return 1;
            if (s1.length() < s2.length())
                return -1;
        }

        int compare(String s1, String s2) {
        return s1.length() - s2.length();
         */

        //вторым аргументом надо как-то отдать функцию compare
        //функцию можно написать прямо внутри! и короче, чем выге
        //Пишем аргументы функции, в скобках
        //ставимл стрелку ->
        //пишем тело функеции в фигурных скобках
        Arrays.sort(a, (String s1, String s2) -> {
            return s1.length() - s2.length();
        });
        System.out.println(Arrays.toString(a));

        //Практически всегда можно не писать типы аргументов
        Arrays.sort(a, (s1, s2) -> {
            return s1.length() - s2.length();
        });
        System.out.println(Arrays.toString(a));

        //если единственное, что делает фунекция - это Return
        //то фигурные скобки и сам return можно не писать
        Arrays.sort(a, (s1, s2) -> s1.length() - s2.length());
        System.out.println(Arrays.toString(a));

        //еще один пример lambda выражений
        //мы умеем смотреть список файлов в каталоге
        String[] files = new File("c:/windows").list();
        if (files != null)
            for (String file : files)
                System.out.println(file);

        //то же самое, но фильтром
        //отфильтруем файлы
        //String[] files2 = new File("c:/windows".list(
                //фильтр, который определяет, какие файлы должны быть выбраны
                /*  boolean filter(String fileName) {
                        return file.Name.endsWith(".exe");
                    }
                 */
                //(folder, fileName) -> return fileName.endsWith(".exe") //оставит только ехе файлы
        //)
    }

}
