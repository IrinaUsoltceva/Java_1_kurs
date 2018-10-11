package examenToday;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class WordsTransformerWithList {

    private List<String> words = new ArrayList<>();

    public WordsTransformerWithList(String dictionary) {
        try (Scanner in = new Scanner(new File(dictionary), "UTF-8")) {
            while (in.hasNextLine())
                this.words.add(in.nextLine());
        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла");
        }
    }

    protected List<String> getWords() {
        return words;
    }
}
