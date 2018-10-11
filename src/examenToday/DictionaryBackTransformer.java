package examenToday;

public class DictionaryBackTransformer extends WordsTransformerWithList implements WordTransformer {

    public DictionaryBackTransformer(String dictionary) {
        super(dictionary);
    }

    @Override
    public String transform(String word) {
        if (word.startsWith("xxx"))
            return word.substring(3);
        else if (word.matches("\\d{1,8}"))
            return getWords().get(Integer.parseInt(word) - 1);
        else
            return "Ошибка";
    }
}
