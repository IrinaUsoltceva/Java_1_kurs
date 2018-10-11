package exameni2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alina_A on 22.06.2017.
 */
public class ChangeCorrector implements WordCorrector {
    @Override
    public Collection<String> proposeCorrections(String word) {
        Set<String> corrections = new HashSet<>();
        String correctedWord = word.substring(1, 2) + word.substring(0, 1) + word.substring(2, word.length());

        corrections.add(correctedWord);
        for (int i = 1; i < word.length() - 1; i++) {
            correctedWord = word.substring(0, i) + word.charAt(i + 1) + word.charAt(i) + word.substring(i + 2, word.length());
            corrections.add(correctedWord);
        }
        return corrections;
    }
}
