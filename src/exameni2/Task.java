package exameni2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by Alina_A on 22.06.2017.
 */
public class Task {
    public static void main(String[] args) throws FileNotFoundException {
        File f1 = new File("input.txt");
        File f2 = new File("words.txt");
        File f3 = new File("output.txt");
        Set<String> sbor = new HashSet<>();
        List<String> slovar = new ArrayList<>();
        read1(f2, slovar);
        System.out.println(slovar); //Словарь запомнен
        read2(f1, slovar, f3, sbor);

        exameni2.ChangeCorrector c = new exameni2.ChangeCorrector();
        System.out.println(c.proposeCorrections("abcd"));
    }

    public static void read1(File f2, List<String> slovar) {
        try (Scanner s = new Scanner(f2, "UTF-8")) {
            s.useDelimiter("[^a-zA-Z]+");
            while (s.hasNext())
                slovar.add(s.next());

            /*
            List<WordCorrector> rez = new LinkedList<>();
            WordCorrector corr1 = new ChangeCorrector();
            WordCorrector corr2 = new DeleteCharCorrector();
            WordCorrector corr3 = new ChangeLetterCorrector();
            WordCorrector corr4 = new LambdaCorrector();
            */


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void read2(File f1, List<String> slovar, File f3, Set<String> sbor) {
        try (
                Scanner s = new Scanner(f1, "UTF-8");
                PrintStream zapis = new PrintStream(f3)
        ) {

            ChangeLetterCorrector a = new ChangeLetterCorrector();
            DeleteCharCorrector b = new DeleteCharCorrector();
            ChangeCorrector c = new ChangeCorrector();

            s.useDelimiter("[^a-zA-Z]+");
            while (s.hasNext()) {
                String slovo = s.next();
                if (!slovar.contains(slovo)) {
                    zapis.print(slovo + " (замены букв): ");

                    for (String x : a.proposeCorrections(slovo)) {
                        if (slovar.contains(x)) {
                            zapis.print(x + " ");
                            if (!sbor.contains(x))
                                sbor.add(x);
                        }
                    }

                    zapis.println();
                    zapis.print(slovo + " (удаление букв): ");

                    for (String x : b.proposeCorrections(slovo)) {
                        if (slovar.contains(x)) {
                            zapis.print(x + " ");
                            if (!sbor.contains(x))
                                sbor.add(x);
                        }
                    }
                    zapis.println();

                    /* zapis.print(slovo + " (замена букв парами): ");
                    for (String x : c.proposeCorrections(slovo)) {
                        if (slovar.contains(x))
                            zapis.print(x + " ");
                    }

                    zapis.println();
                    */
                    zapis.println("Все возможные варианты исправлений для слова " + slovo + ": " + sbor);
                    sbor.clear();
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("Возникла какая-то ошибка при прочтении или записи какого-то файла" + e.getMessage());
        }
    }
}
