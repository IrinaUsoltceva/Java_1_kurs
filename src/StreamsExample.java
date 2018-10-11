import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by st055086 on 23.03.2018.
 */
public class StreamsExample {
    public static void main(String[] args) {
        /*
        Потоки (Stream) - последовательности элементов, которую
        можно обработать только один раз, которая не обязательно хранится в памяти
        и потенциально даже может быть бесконечной

        Примеры потоков
        1) Любую коллекцию можно рассмотреть как поток,
        для этого у нее надо вызвать метод .stream()

        2) IntStream.range(1, 100) - поток, состоящий из int
        от одного до 99, есть ещё IntStream.rangeClosed(1.100)

        3) Бесконечный поток единичек. Бесконечный поток случайных чисел

        С потоками можно делать два вида операций:
        -промежуточные
        -терминальные

        Промежуточные превращают поток в другой поток, описывают правило для превращения.
        Например, добавление 1 к каждому числу исходного потока.
        Другой пример промежуточной операции - фильтрация.
        Т.е. некоторые элементы исходного потока удаляются

        Терминальные операции превращают поток в какое-то другое значение.
        Например, вычисление количества элементов в потоке.
        Или собрать поток в список (list). Или сложить все числа потока.
        Надо одним потоком можно выполнить только одну терминальную операцию.
         */

        System.out.println(
                IntStream.rangeClosed(1, 10).sum() //55
        );

        System.out.println(
                //поток из фиксированных элементов
                Stream.of("abc", "xyz", "pq")
                    //собрать все элементы в список
                    .collect(Collectors.toList())
        );

        System.out.println(
                IntStream.range(1, 100)
                .boxed() //int -> Integer
                .collect(Collectors.toList())//поток в список, заклинание
        );

        System.out.println(
                //можно передать массив
                //массив превратится в поток
                Stream.of("abc", "xyz", "pq")
                    //замеинть все элементы по определенному правилу
                    //.map((String S) -> s + "!")
                    .map(s -> s + "!")
                    //функция в boolean, оставить ли элемент
                    .filter(s -> s.length() > 3)
                .collect(Collectors.toList())
        );

        List<Integer> l1 = IntStream.range(1, 100)
                .skip(10) //пропустить первые 10 элементов потока
                .limit(20) //взять первые 20 элементов
                .boxed()
                .collect(Collectors.toList());
        //l1 - список от 11 до 30
        System.out.println(l1); //ctrl + 1 = помощ

        IntStream.range(1, 10)
                .map(x -> 2 * x)
                //действие для каждого элемента int -> void
                .forEach(
                        x -> System.out.println(x)
                );
    }

}
