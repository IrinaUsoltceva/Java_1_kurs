package objectTask;

public class PrintableTask {
    public static void main(String[] args) {
        System.out.println("---Task1---");
        Drawing d = new Drawing(5,5,'U');
        d.print();

        System.out.println("---Task2---");
        PrintableLetter pl = new PrintableLetter('x', 10);
        pl.print();

        System.out.println();
        System.out.println("---Task3---");
        PrintableString ps = new PrintableString("asdf");
        ps.print();

        System.out.println();

        System.out.println("---Task4---");
        Printable[] massiv = new Printable[5];
        massiv[0] = new Drawing(5,5,'*');
        massiv[1] = new PrintableLetter('K', 7);
        massiv[2] = new PrintableString("qwerty");
        massiv[3] = new Printable() {
            @Override
            public void print() {
                System.out.print("Анонимный класс");
            }
        };
        massiv[4] = () -> System.out.println("Лямбда");
        for (Printable element : massiv) {
            element.print();
            System.out.println();
        }
    }
}
