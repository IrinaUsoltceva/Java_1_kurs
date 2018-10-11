package exameni2;

import java.util.Collection;

/**
 * Created by Alina_A on 22.06.2017.
 */
public interface WordCorrector {
    Collection<String> proposeCorrections(String word);
}
