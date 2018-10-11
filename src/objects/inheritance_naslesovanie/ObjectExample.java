package objects.inheritance_naslesovanie;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectExample {
    /*
    Класс Object
    Все классы прямо или косвенно наследуют класс Object

    Если написать public class X { ...
    Это значит, что
    public class X extends Object {...

    У нас в иерархии животных
    Cat extends Animal Extends Object
     */

    public static void main(String[] args) {
        //Следствие 1, переменная типа Object может хранить
        //любой тип
        Object x = "asdfg"; //x - string
        Object y = new File("c:/windows");
        Object z = new ArrayList<String>();

        Object x1 = new int[]{10, 20, 30}; //даже массив это объект
        //потому что не объекты - это только 8 базовых типов


        Object y1 = 42; //присвоили int, (автозаворачивание в Integer)
        System.out.println(new File("c:/windows"));
        //метод println может распечатать что угодно,
        //потому что он принимает Object в качестве аргумента
        //ctrl+Q = помощь
        //что можно передать внутрь метода - ctrl + P

        //Следствие 2, любой объект наследует все методы класса Object

        //например, у любого объекта есть метод toString()
        //он превращает объект в строку текста. Используется чаще всего для отладки

        List<String> list = Arrays.asList("asdf", "cc");
        System.out.println(list.toString());

        System.out.println(list);
        //здесь метод toString вызывается автоматически

        /*
        @Override
        public String toString(){} - заголовок для переопределения метода
         */

        //Метод toString внутри Object печатает
        //не очень красиво, с @
        //Указывается тип элементов
        //массива и внутренний номер массива
        System.out.println(new int[0]);

        //Еще один метод внутри Object - это equals -
        //сравнение объектов по содержанию

        //"aasdf".equals("aasdf"); сравнение содержания строк
        //== сравнивает - один объект или два разных
        //equals внутри Object сравнивает так же, как ==

    }
}
