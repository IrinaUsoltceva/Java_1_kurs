import java.io.File;
import java.io.PrintStream;
import java.util.*;

public class CollectionTask {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    //Task1
    public static void task1() {
        System.out.println("task 1 " + makeListString(1, 100));
        System.out.println();
    }

    public static List<String> makeListString(int a, int b) {
        List<String> list = new ArrayList<>();
        for (int i = a; i <= b; i++)
            list.add(String.valueOf(i));
        return list;
    }

    //Task2
    public static void task2() {
        List<String> task = makeListString(5, 25);

        System.out.println("list " + task);
        System.out.println("task 2.1 " + reverseListStringNew(task));
        System.out.println("list " + task);
        reverseListStringGiven(task);
        System.out.println("task 2.2 " + task);
        System.out.println();
    }

    public static List<String> reverseListStringNew(List<String> list) { //создаёт новый list, заполняет, возвращает
        List<String> reversedList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--)
            reversedList.add(list.get(i));
        return reversedList;
    }

    public static void reverseListStringGiven(List<String> list) { //изменяет имеющийся list
        String k;
        for (int i = 0; i < list.size() / 2; i++) {
            k = list.get(i);
            list.set(i, list.get(list.size() - 1 - i));
            list.set(list.size() - 1 - i, k);
        }
    }

    //Task3
    public static void task3() {
        List<String> task = makeListString(5, 25);
        System.out.println("list " + task);
        System.out.println("task 3.11 " + deleteEvenIndexNew(task));
        System.out.println("list " + task);
        deleteEvenIndexGiven(task);
        System.out.println("task 3.12 " + task);
        System.out.println();

        task = makeListString(5, 25);
        System.out.println("list " + task);
        System.out.println("task 3.21 " + deleteEvenNumbersNew(task));
        System.out.println("list " + task);
        deleteEvenNumbersGiven(task);
        System.out.println("task 3.22 " + task);
        System.out.println();

        List<Integer> taskInt = makeListInteger(5, 25);
        System.out.println("list " + taskInt);
        System.out.println("task 3.31 " + deleteEvenNumbersIntNew(taskInt));
        System.out.println("list " + taskInt);
        deleteEvenNumbersIntGiven(taskInt);
        System.out.println("task 3.32 " + taskInt);
        System.out.println();
    }

    public static List<String> deleteEvenIndexNew(List<String> list) {
        List<String> evenIndexList = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            evenIndexList.add(list.get(i));
            i++;
        }
        return evenIndexList;
    }

    public static void deleteEvenIndexGiven(List<String> list) {
        for (int i = 0; i < list.size(); i++)
            list.remove(i);
    }

    public static List<String> deleteEvenNumbersNew(List<String> list) {
        List<String> evenNumbersList = new ArrayList<>();
        for (String element : list) {
            int number = Integer.parseInt(element);
            if (number % 2 != 0)
                evenNumbersList.add(element);
        }
        return evenNumbersList;
    }

    public static void deleteEvenNumbersGiven(List<String> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            if (Integer.parseInt(list.get(i)) % 2 == 0)
                list.remove(i);
        }
    }

    //доп. к Task3
    public static List<Integer> makeListInteger(int a, int b) {
        List<Integer> list = new ArrayList<>();
        for (int i = a; i <= b; i++)
            list.add(i);
        return list;
    }

    //shift + f6
    public static List<Integer> deleteEvenNumbersIntNew(List<Integer> numbers) {
        List<Integer> notEvenNumbersList = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 != 0)
                notEvenNumbersList.add(number);
        }
        return notEvenNumbersList;
    }

    public static void deleteEvenNumbersIntGiven(List<Integer> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) % 2 == 0)
                list.remove(i);
        }
    }

    //Task4
    public static void printSet (String filename, Set<String> set) {
        try (PrintStream fileOut = new PrintStream(filename, "UTF-8")) {
            for (String s : set)
                fileOut.println(s);
        } catch (Exception e) {
            System.out.println("Ошибка записи");
        }
    }

    public static void task4() {
        String filename = "smallerBook.txt";

        Set<String> hSet = new HashSet<>();
        Set<String> tSet = new TreeSet<>();
        Set<String> lhSet = new LinkedHashSet<>();

        readFile(filename, hSet);
        readFile(filename, tSet);
        readFile(filename, lhSet);

        printSet("HSet_book.txt", hSet);
        printSet("TSet_book.txt", tSet);
        printSet("LHSet_book.txt", lhSet);

        /*
        try (PrintStream fileOutH = new PrintStream("HSet_book.txt", "UTF-8")) {
            hSet.forEach(fileOutH::println);
        } catch (Exception e) {
            System.out.println("Ошибка записи");
        }

        try (PrintStream fileOutT = new PrintStream("TSet_book.txt", "UTF-8")) {
            tSet.forEach(fileOutT::println);
        } catch (Exception e) {
            System.out.println("Ошибка записи");
        }

        try (PrintStream fileOutLH = new PrintStream("LHSet_book.txt", "UTF-8")) {
            lhSet.forEach(fileOutLH::println);
        } catch (Exception e) {
            System.out.println("Ошибка записи");
        }
        */
    }

    private static void readFile(String filename, Set<String> set) {
        try (Scanner fileIn = new Scanner(new File(filename), "UTF-8")) {
            while (fileIn.hasNext()) {
                String word = fileIn.next().toLowerCase();
                if (word.matches(".*[.!?,]"))
                    word = word.substring(0, word.length() - 1);
                set.add(word);
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения " + e.getMessage());
            e.printStackTrace();
        }
    }
}
