import java.io.File;
import java.io.PrintStream;
import java.util.*;

public class MapThirdTask {
    public static void main(String[] args) {
        task4_1();
        task4_2();
        task4_3();
    }

    private static void readFileInDictionary(String filename, Map<String, Integer> map) {
        try (Scanner fileIn = new Scanner(new File(filename), "UTF-8").useDelimiter("\\s+|\\.+|,|!|\\?|\\)|\\(")) {
            String word;
            while (fileIn.hasNext()) {
                word = fileIn.next().toLowerCase();
                if (!"".equals(word)) {
                    int wordNumber = map.getOrDefault(word, 0); //получаем значение по ключу или 0
                    map.put(word, wordNumber + 1); //перезаписываем с +1
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения " + e.getMessage());
            e.printStackTrace();
        }
    } //считывает в частотный словарь

    public static void printMap(String filename, Map<String, Integer> map) {
        try (PrintStream fileOut = new PrintStream(filename, "UTF-8")) {
            map.forEach((key, value) -> {
                fileOut.println(key + " -> " + value);
            });
        } catch (Exception e) {
            System.out.println("Ошибка записи");
        }
    } //выводит частотный словарь в файл

    public static void task4_1() {
        Map<String, Integer> hMap = new HashMap<>();
        readFileInDictionary("smallerBook.txt", hMap);
        printMap("old_HMap_book.txt", hMap);
    }

    public static void task4_2() {
        Map<String, Integer> hMap = new HashMap<>();
        Map<String, Integer> tMap = new TreeMap<>();
        Map<String, Integer> lHMap = new LinkedHashMap<>();

        readFileInDictionary("smallerBook.txt", hMap);
        readFileInDictionary("smallerBook.txt", tMap);
        readFileInDictionary("smallerBook.txt", lHMap);

        printMap("HMap_book.txt", hMap);
        printMap("TMap_book.txt", tMap);
        printMap("LHMap_book.txt", lHMap);
    }

    public static void printArrayList(String filename, List<Map.Entry<String, Integer>> list) {
        try (PrintStream fileOut = new PrintStream(filename, "UTF-8")) {
            for (Map.Entry<String, Integer> e : list)
                fileOut.println(e.getKey() + " -> " + e.getValue());
        } catch (Exception e) {
            System.out.println("Ошибка записи");
        }
    }

    public static void task4_3() {
        Map<String, Integer> hM = new HashMap<>();
        readFileInDictionary("smallerBook.txt", hM);
        List<Map.Entry<String, Integer>> list = new ArrayList<>(hM.entrySet());

        printArrayList("DictionaryNotSorted.txt", list);

/*        for (int e1 = 0; e1 < list.size() - 1; e1++) {
            for (int e2 = e1 + 1; e2 < list.size(); e2++) {
                if (list.get(e1).getValue() < list.get(e2).getValue()) {//если значение 1 элемента < второго
                    Map.Entry<String, Integer> entry1 = list.get(e1); //запоминает элементы, что лежали на местах
                    Map.Entry<String, Integer> entry2 = list.get(e2);
//                    list.remove(list.get(e2)); //удаляет с мест элементы, которые там были
//                    list.remove(list.get(e1));
//                    list.add(e2, entry1);//добавляет сначала на второе место первый элемент
//                    list.add(e1, entry2);//потом на первое место второй элемент
                    list.set(e1, entry2);
                    list.set(e2, entry1);
                }
            }
        }*/

        list.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());

        printArrayList("DictionarySorted.txt", list);
    }
}


