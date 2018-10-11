import java.io.File;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTask {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(sumFrom1ToN(n));
        System.out.println(sumSquaresFrom1ToN(n));
        System.out.println(sumOfCubesFrom1ToN(n));
        System.out.println(sumOfBacksFrom1ToN(n));

        List<Integer> list = Arrays.asList(1, 2, 5, 9, 11, 6, 4, 23, 22);
        System.out.println(deleteEven(list));

        oldtask6();
        task6("smallerBook.txt");
        task7();
    }

    // возвращает бесконечный поток случайных целых чисел от 0 до max - 1
    private static IntStream randomStream(int max) { //возвращает поток IntStream, принимает max
        Random r = new Random(); //создаёт генератор рандомных чисел
        return IntStream.generate(() -> r.nextInt(max));
        //return            - возвращает
        //IntStream         - поток целых чисел
        // .generate(       - генерирует, далее описывается, по какому принципу
        // ()               - передаваемые аргументы в функцию (их нет)
        // ->               - указание на тело функции, т.к. только возвращает - сразу указание на то, что возвращает
        // r.nextInt(max)   - возвращает число от 0 до max не включительно
        // );
    }

    //возвращает бесконечный поток натуральных чисел 1, 2, 3 и т.д.
    @SuppressWarnings("unused")
    public static IntStream integersStream() { //ничего не получает, возвращает поток из int
        return IntStream.iterate(1, x -> x + 1);
        //return        - возвращает
        // IntStream    - поток целых чисел
        // .iterate(    - итерационный, f(аргументы), f(f(аргументы)) итд, далее описывается сама f
        // 1, x         - передаваемые в функцию аргументы
        // ->           - переход к return
        // x + 1        - возвращает x+1
        // );
    }

    //поток слов из файла
    private static Stream<String> wordsStream(File f) { //получает File f, возвращает поток
        try {
            byte[] fileAsBytes = Files.readAllBytes(f.toPath());
            String fileAsText = new String(fileAsBytes, "UTF-8");
            return Arrays.stream(fileAsText.split("\\s+|\\.+|,|!|\\?|\\)|\\("));
        } catch (Exception e) {
            System.out.println("Failed to read file " + f);
            return Stream.of();
        }

        /*
        byte[] fileAsBytes = Files.readAllBytes(f.toPath());
        byte[] fileAsBytes      - создаёт массив для байтов
        f.toPath()              - преобразовывает в путь до файла
        Files.readAllBytes()    - считывает содержимое файла в виде байт
         - считывает содержимое файла в виде байтов в соответствующий массив

        String fileAsText = new String(fileAsBytes, "UTF-8");
         - переводит массив байтов в строку

        return Arrays.stream(fileAsText.split("\\s+"));
        return              - возвращает
        Arrays.stream(      - поток из массива
        fileAsText          - строка
        .split("\\s+")      - разделенная по 1 или нескольким пробелам
        );
         - полученную строку преобразовывает в поток слов, разделив их по пробелам
         */
    }

    private static int sumFrom1ToN(int n) {
        return IntStream            //поток
                .range(1, n + 1)    //из последовательных числел от 1 до n + 1 не включая
                .sum();             //его сумма
    }

    private static int sumSquaresFrom1ToN(int n) {
        return IntStream            //поток
                .range(1, n + 1)        //из последовательных чисел от 1 до n + 1 не включая
                .map(x -> x * x)    //применяет функцию к элементам потока
                .sum();             //его сумма
    }

    private static int sumOfCubesFrom1ToN(int n) {
        return IntStream            //поток
                .range(1, n + 1)        //из последовательных чисел от 1 до n + 1 не включая
                .map(x -> x * x * x)    //применяет функцию к элементам потока
                .sum();             //его сумма
    }

    private static double sumOfBacksFrom1ToN(int n) {
        return IntStream                    //поток
                .rangeClosed(1, n)            //из последовательных чисел от 1 до n включая
                .mapToDouble(x -> 1.0 / x)    //применяет функцию к элементам потока
                .sum();                     //его сумма
    }

    private static List<Integer> deleteEven (List<Integer> list) {
         return list.stream() //поток из фиксированных элементов
                .filter(x -> x % 2 != 0) //фильтр
                .collect(Collectors.toList()); //собрать все элементы в список
    }

    private static void oldtask6() { //разбор через файл
        String filename = "smallerBook.txt";

        int amount = 0, sum = 0, max = 0, min = 1000, x;
        String word, maxword = "";
        try (Scanner fileIn = new Scanner(new File(filename), "UTF-8").useDelimiter("\\s+|\\.+|,|!|\\?|\\)|\\(")) {
            while (fileIn.hasNext()) {
                word = fileIn.next();
                if (!"".equals(word)) {
                    x = word.length();
                    sum = sum + x;
                    amount = amount + 1;
                    if (x > max) {
                        max = x;
                        maxword = word;
                    }
                    if (x < min)
                        min = x;
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println(sum / amount + " " + max + " " + min + " " + maxword);
    }

    private static void task6(String filename) {
        File f = new File(filename);

        /*long amount = wordsStream(f).count();

        int sum = wordsStream(f)
                .mapToInt(x -> x.length())
                .sum();

        int maxNum = wordsStream(f)
                .mapToInt(x -> x.length())
                .max()
                .orElse(-1);

        int minNum = wordsStream(f)
                .filter(x -> x.length() > 0)
                .mapToInt(x -> x.length())
                .min()
                .orElse(-1);*/

        IntSummaryStatistics stats = wordsStream(f)
                .mapToInt((x) -> x.length())
                .filter(x -> x > 0)
                .summaryStatistics();

        System.out.println("максимальное - " + stats.getMax() +
                            ", минимальное - " + stats.getMin() +
                            ", среднее - " + stats.getAverage());

        System.out.println("Самое длинное слово - " +
                wordsStream(f)
                    .max((w1, w2) -> w1.length() - w2.length())
                    .orElse("none"));
        }

    private static void task7() {
        long orel = randomStream(2)
                .limit(100)
                .filter(x -> x!= 0)
                .count();
        long reshka = 100 - orel;
        System.out.println(orel + " " + reshka);
    }
}
