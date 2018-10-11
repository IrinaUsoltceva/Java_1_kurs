package examenToday;

public class DictionaryTransformer extends WordsTransformerWithList implements WordTransformer {

    public DictionaryTransformer(String dictionary) {
        super(dictionary);
    }

    @Override
    public String transform(String word) {
        int index = getWords().indexOf(word);
        if (index == -1)
            return "xxx" + word;
        else
            return String.valueOf(index + 1);
    }
}
