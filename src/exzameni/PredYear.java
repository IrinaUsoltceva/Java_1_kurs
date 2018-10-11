package exzameni;

import java.io.File;
import java.io.PrintStream;
import java.util.*;

public class PredYear {
    public static void main(String[] args) {
        analiz("input.txt", "output.txt", "words_alpha.txt");

    }

    private static void analiz(String input, String output, String dictionary) {
        Set<String> dictionarySet = new HashSet<>();
        createDictionary(dictionary, dictionarySet);

        try (PrintStream out = new PrintStream (output, "UTF-8");
             Scanner in = new Scanner (new File(input), "UTF-8")) {
            in.useDelimiter("[^a-zA-Z]+");
            while (in.hasNext()) {
                String word = in.next().toLowerCase();
                if (!dictionarySet.contains(word)) {
                    out.print(word + ": ");

                    List<WordCorrector> wordCorrectorList = new ArrayList<>();
                    WordCorrector correctorDeleteLC = new DeleteLetterCorrector();
                    WordCorrector correctorChangeLC = new ChangeLetterCorrector();
                    WordCorrector correctorPutLC = theWord -> {
                        Set<String> corrections = new HashSet<>();
                        for (int i = 0; i <= theWord.length(); i++)
                            for (char c = 'a'; c <= 'z'; c++)
                                corrections.add(theWord.substring(0, i) + c + theWord.substring(i));
                        return corrections;
                    };
                    WordCorrector correctorChangePLC = new ChangePairLettersCorrector();

                    wordCorrectorList.add(correctorDeleteLC);
                    wordCorrectorList.add(correctorChangeLC);
                    wordCorrectorList.add(correctorPutLC);
                    wordCorrectorList.add(correctorChangePLC);

                    Set<String> corrections = new HashSet<>();
                    for (WordCorrector wordCorrector : wordCorrectorList)
                        for (String correctedWord : wordCorrector.proposeCorrections(word))
                            if (dictionarySet.contains(correctedWord))
                                corrections.add(correctedWord);

                    for (String correctedWord : corrections)
                        out.print(correctedWord + " ");

                    out.println();

                }
            }
            } catch(Exception e){
                System.out.println("Ошибка при чтении или записи файла");
            }
        }

    private static void createDictionary(String dictionary, Set<String> dictionarySet) {
        try (Scanner in = new Scanner (new File(dictionary), "UTF-8")) {
            while (in.hasNextLine())
                dictionarySet.add(in.nextLine());
        } catch (Exception e) {
            System.out.println("Ошибка при чтении словаря");
        }
    }
}
