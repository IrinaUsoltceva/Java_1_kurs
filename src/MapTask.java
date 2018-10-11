import java.io.File;
import java.io.PrintStream;
import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        String word = "banana";
        printMap(task1(word));
        System.out.println();
        printMap(task2(word));
    }


    private static void printMap(Map<?, ?> m) {
        for (Object key : m.keySet())
            System.out.println(key + " -> " + m.get(key));
    }

    public static Map<Character, Integer> task1(String word) {
        Map<Character, Integer> m = new HashMap<>();
        for (Character letter : word.toCharArray()) {
            int amountOfLetters = m.getOrDefault(letter, 0); //получаем значение по ключу или 0
            m.put(letter, amountOfLetters + 1); //перезаписываем с +1
        }
        return m;
    }

    public static Map<Character, List<Integer>> task2(String word) {
        Map<Character, List<Integer>> m = new HashMap<>();
        char[] wordCharArray = word.toCharArray();

        //1 вариант
        for (int i = 0; i < wordCharArray.length; i++) {
            List<Integer> indexes = m.get(wordCharArray[i]); //получаем тот список, который уже есть

            if (indexes == null) { //если в m нет ключа
                indexes = new LinkedList<>(); //создаётся список
                m.put(wordCharArray[i],  indexes); //список добавляется по ключу в значение
            }

            indexes.add(i); //в список добавляется i
        }

        return m;

        /*for (Character key : m.keySet())
            System.out.println(key + " -> " + m.get(key));

        System.out.println();

        //2 вариант, как в предыдущем задании
        Map<Character, List<Integer>> m2 = new HashMap<>();
        for (int i = 0; i < wordCharArray.length; i++) { //вариант, как выше
            //получаем значение по ключу или пустой лист
//            List<Integer> indexes2 = m2.getOrDefault(wordCharArray[i], new ArrayList<>());
            List<Integer> indexes2 = m2.computeIfAbsent(wordCharArray[i], k -> new ArrayList<>());
            indexes2.add(i); //добавляем в полученный лист i
            m2.put(wordCharArray[i], indexes2); //отправляем список по ключу в значение
        }

        for (Character key : m2.keySet())
            System.out.println(key + " -> " + m2.get(key));*/
    }
}
