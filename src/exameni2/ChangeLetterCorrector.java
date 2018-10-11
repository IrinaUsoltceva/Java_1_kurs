package exameni2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alina_A on 22.06.2017.
 */
public class ChangeLetterCorrector implements WordCorrector {

    @Override
    public Collection<String> proposeCorrections(String word) {
        Set<String> corrections = new HashSet<>();
        for (int i = 0; i < word.length(); i++)
            for (char c = 'a'; c <= 'z'; c++) {
                String correctedWord = word.substring(0, i) + c + word.substring(i + 1);
                corrections.add(correctedWord);
            }
        return corrections;
    }
}
