package exameni2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alina_A on 22.06.2017.
 */
public class DeleteCharCorrector implements WordCorrector {
    @Override
    public Collection<String> proposeCorrections(String word) {
        Set<String> corrections = new HashSet<>();
        String s = "";
        for (int i = 0; i < word.length(); i++) {

            String correctedWord = word.substring(0, i) + word.substring(i + 1, word.length());
            corrections.add(correctedWord);
            s = "";
        }
        return corrections;
    }
}
