package objectTask;

public class PrintableString implements Printable {
    private String string;

    public PrintableString (String string) {
        this.string = string;
    }

    @Override
    public void print() {
        System.out.print(string);
    }
}
