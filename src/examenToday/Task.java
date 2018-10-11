package examenToday;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        toTransformAndWrite("smallertext.txt", "p1.txt", word -> word.toUpperCase());
        toTransformAndWrite("smallertext.txt", "p4.txt", word -> String.valueOf(word.length()));
        toTransformAndWrite("smallertext.txt", "p5.txt", new DictionaryTransformer("words_alpha.txt"));
        toTransformAndWrite("p5.txt", "text_back.txt", new DictionaryBackTransformer("words_alpha.txt"));
    }

    private static void toTransformAndWrite(String input, String output, WordTransformer wordTransformer) {
        try (PrintStream out = new PrintStream(output, "UTF-8");
            Scanner in = new Scanner(new File(input), "UTF-8")) {
            in.useDelimiter("[^a-zA-Z0-9]+");
            while (in.hasNext()) {
                String word = in.next();
                out.println(wordTransformer.transform(word));
            }
        } catch (Exception e){
            System.out.println("Ошибка при чтении или записи файла");
        }
    }
}
