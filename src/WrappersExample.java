import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

public class WrappersExample {

    public static void main(String[] args) {
        /*
        В java 8 базовых типов: int, boolean, char, double, ...
        Остальное - объектные типы. String, File, Set<>, ...

        В коллекциях можно использовать только объектные типы
        Set<String> - ок, Set<int> - ошибка

        8 типов оберток Integer, Boolean, Character, Double, ...
        Это объектные варианты базовых типов, они
        хранят значение соответствующего типа.
         */

        Integer x = new Integer(42); //храним число 42
        System.out.println(x.intValue()); //достать число из объекта

        //Коллекция
        Set<Integer> s = new HashSet<>();
        s.add(new Integer(42));
        s.add(new Integer(123));

        System.out.println(s);

        //еще раз то же самое
        Integer y = 42; //автоматическое заворачивание
        s.add(42);      //автоматическое заворачивание
        s.add(123);     //автоматическое заворачивание

        System.out.println(x + y); //автоматическое разворачивание
        int xx = x; // x = Integer(42), разворачивание.

        //В большинстве случаев использовать типы-обертки не нужно,
        //значения сами разворачиваются и заворачиваются при
        //необходимости. Тип-обертка чаще всего пишется в
        //указании типа элементов коллекции
        //Set<Integer>, List<Boolean>

        for (Integer a : s) //перебор элементов множества s
            System.out.println(a);
        for (int a : s) //перебор элементов множества s
                        //здесь элементы множества автоматически
                        //разворачиваются
            System.out.println(a);

        //Оператор приведения типа,
        //int x = 2;  double y = (double)x / 3;
        //можно так
        Integer z = (Integer)42; //оператор приведения типа
                                 //может заворачивать и разворачивать

        int zz = (int)z; //разворачиваем

        //==============================================
        //классы обертки как коллекции вспомогательных функций
        //Integer.toString(42) //превращение строки в число
        //Integer.toString(42, 16) //с системой счисления
        //Integer.parseInt("42"); //превратить строку в число
        //Integer.parseInt вызывает ошибку, если не удалось превратить
        //Integer.MAX_VALUE - самое большое целое

        //Character.isUpperCase() - проверка на верхний регистр

        //Вернемся к автоматическому (за/раз)ворачиванию.

        Integer a = null; //отсутствие числа. null м.б. значением
                          //любого объектного типа
        //int b = null; ошибка

        int b = a; //Ошибка! при разворачивании null случится
                   //NullPointerException
    }

}
