package exzameni;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ChangePairLettersCorrector implements WordCorrector{

    @Override
    public Collection<String> proposeCorrections(String word) {
        Set<String> corrections = new HashSet<>();
        for (int i = 0; i < word.length() - 1; i++) {
            String correctedWord = word.substring(0, i)
                    + word.charAt(i + 1)
                    + word.charAt(i)
                    + word.substring(i + 2);
            corrections.add(correctedWord);
        }
        return corrections;
    }

}
