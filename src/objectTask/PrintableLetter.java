package objectTask;

public class PrintableLetter implements Printable {
    private char letter;
    private int amount;

    public PrintableLetter (char letter, int amount) {
        this.letter = letter;
        this.amount = amount;
    }

    @Override
    public void print() {
        for (int i = 0; i < amount; i++)
            System.out.print(letter);
    }
}
