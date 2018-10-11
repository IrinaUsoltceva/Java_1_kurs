package objectTask;

public class DrawingTask {
    public static void main(String[] args) {
        System.out.println("----Task1-2-----");
        Drawing table = new Drawing(5, 10, '.');
        table.print();

        System.out.println("----Task3-----");
        table.setPoint(2,3,'A');
        table.print();

        System.out.println("----Task4.1-----");
        table.drawVerticalLine(4,2,4,'B');
        table.print();
        System.out.println("----Task4.2-----");
        table.drawHorizontalLine(4,2,9,'C');
        table.print();

        System.out.println("----Task5-----");
        Drawing table5 = new Drawing(5,10,'.');
        table5.drawRectangle(2, 2, 4,8, 'T');
        table5.print();

        System.out.println("----Task6-----");
        Drawing table6 = new Drawing(17,41,'.');
        table6.drawLine(8,20, 0,0,'A');
        table6.drawLine(8,20, 0,12,'B');
        table6.drawLine(8,20, 0,20,'C');
        table6.drawLine(8,20, 0,28,'D');
        table6.drawLine(8,20, 0,40,'E');

        table6.drawLine(8,20, 8,40,'F');

        table6.drawLine(8,20, 16,40,'G');
        table6.drawLine(8,20, 16,28,'H');
        table6.drawLine(8,20, 16,20,'I');
        table6.drawLine(8,20, 16,12,'J');
        table6.drawLine(8,20, 16,0,'K');

        table6.drawLine(8,20, 8,0,'L');

        table6.print();

        System.out.println("----Task7-----");
        table6.drawCircle(8,20,7, '!');
        table6.print();
        table6.drawCircle(16,0, 16, '@');
        table6.print();
        table6.drawCircle(0,40, 16, '@');
        table6.print();


        System.out.println("----Task8-----");
        System.out.println(table6.getLines());
        System.out.println(table6.getColumns());
        System.out.println(table6.getPoint(8,20));

        Drawing holst = new Drawing(13,40,'.');
        holst.addNumeracia();
        holst.print();
        System.out.println("--проверка ошибок--");

        Drawing risunok1 = new Drawing(10, 20, 'A');
        Drawing risunok2 = new Drawing(30,40, 'B');
        holst.draw(4,21, risunok1);
        holst.draw(1,1, risunok2);

        System.out.println("--проверка рисования поверх--");
        holst.draw(3,20, risunok1);
        holst.draw(1,1, new Drawing(5,25,'S'));
        holst.draw(8,35, new Drawing(5,5, 'D'));
        holst.print();

        System.out.println();
        System.out.println("----Task10-----");
        Drawing osnova = new Drawing(14, 40, '.');
        osnova.addNumeracia();
        Drawing fundament = new Drawing(7, 21, 'H');
        Drawing okno = new Drawing (3,9, 'o');

        fundament.draw(2, 6, okno);
        osnova.draw(7, 11, fundament);
        osnova.drawLine(7,11,1, 21, 'A');
        osnova.drawLine(7,31,1,21,'A');
        osnova.print();
    }
}
