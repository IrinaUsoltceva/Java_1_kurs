package objectTask;

public class RationalTask {

    public static void main(String[] args) {
        taskFrom1To6();
    }

    private static void taskFrom1To6() {
        Rational r1 = new Rational(3, 2);
        Rational r2 = new Rational(6, 4);
        Rational r3 = new Rational(5, 1);
        Rational r4 = new Rational(0, 2);
        Rational r5 = new Rational(-2, -2);
        Rational r6 = new Rational(-2, -3);
        Rational r7 = new Rational(2, -3);
        Rational r8 = new Rational(-3, 13);
        Rational r9 = new Rational(5);
        Rational r10 = new Rational(16,13);

        Rational[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
        System.out.println("------Тест на создание и вывод----------");
        for (Rational r : arr)
            System.out.println(r.toString() + " = " + r.toDouble());
        System.out.println(r1.getD() + " " + r1.getN());

        System.out.println();
        System.out.println("-------Арифметический тест----------");

        System.out.println();
        System.out.println("<---add--->");
        testAdd(r1, r2, new Rational(3));
        testAdd(r2, r3, new Rational(13,2));
        testAdd(new Rational(1,6),
                new Rational(1,3),
                new Rational(1,2));

        System.out.println();
        System.out.println("<---addInPlace--->");
        testAddInPlace(r1, r2, new Rational(3));
        testAddInPlace(r2, r3, new Rational(13,2));
        testAddInPlace(
                new Rational(1,6),
                new Rational(1,3),
                new Rational(1,2)
        );
        testAddInPlace(r8, r10, new Rational(1));

        System.out.println();
        System.out.println("<---sub--->");
        testSub(new Rational(1,6),
                new Rational(1,3),
                new Rational(-1,6)
        );
        testSub(new Rational(3,4),
                new Rational(4,16),
                new Rational(1,2)
        );
        testSub(new Rational(32,64),
                new Rational(1,2),
                new Rational(0,6)
        );

        System.out.println();
        System.out.println("<---subInPlace--->");
        testSubInPlace(
                new Rational(1,6),
                new Rational(1,3),
                new Rational(-1,6)
        );
        testSubInPlace(
                new Rational(3,4),
                new Rational(4,16),
                new Rational(1,2)
        );
        testSubInPlace(
                new Rational(32,64),
                new Rational(1,2),
                new Rational(0,6)
        );

        System.out.println();
        System.out.println("<---mul--->");
        testMul(new Rational(1,6),
                new Rational(1,3),
                new Rational(1,18)
        );
        testMul(new Rational(-1,4),
                new Rational(-2),
                new Rational(1,2)
        );
        testMul(new Rational(32,64),
                new Rational(0),
                new Rational(0)
        );

        System.out.println();
        System.out.println("<---MulInPlace--->");
        testMulInPlace(
                new Rational(1,6),
                new Rational(1,3),
                new Rational(1,18)
        );
        testMulInPlace(
                new Rational(-1,4),
                new Rational(-2),
                new Rational(1,2)
        );
        testMulInPlace(
                new Rational(32,64),
                new Rational(0),
                new Rational(0)
        );

        System.out.println();
        System.out.println("<---div--->");
        testDiv(new Rational(1,6),
                new Rational(1,6),
                new Rational(1)
        );
        testDiv(new Rational(1,4),
                new Rational(-4),
                new Rational(-1,16)
        );
        testDiv(new Rational(5,20),
                new Rational(1,8),
                new Rational(2)
        );

        System.out.println();
        System.out.println("<---divInPlace--->");
        testDivInPlace(
                new Rational(1,6),
                new Rational(1,6),
                new Rational(1)
        );
        testDivInPlace(
                new Rational(1,4),
                new Rational(-4),
                new Rational(-1,16)
        );
        testDivInPlace(
                new Rational(5,20),
                new Rational(1,8),
                new Rational(2)
        );
    }

    private static void vivod(Rational actualAnswer, Rational correctAnswer) {
        if (actualAnswer.toString().equals(correctAnswer.toString()))
            System.out.println(actualAnswer + ", ok");
        else
            System.out.println(
                    actualAnswer + " instead of " + correctAnswer
            );
    }

    private static void testAdd(Rational r1, Rational r2, Rational correctAnswer) {
        System.out.print(
                r1 + " + " + r2 + " = "
        );
        Rational actualAnswer = r1.add(r2);
        vivod(actualAnswer, correctAnswer);
    }

    private static void testAddInPlace(Rational r1, Rational r2, Rational correctAnswer) {
        System.out.print(
                r1 + " + " + r2 + " = "
        );
        r1.addInPlace(r2);
        vivod(r1, correctAnswer);
    }

    private static void testSub(Rational r1, Rational r2, Rational correctAnswer) {
        System.out.print(
                r1 + " - " + r2 + " = "
        );
        Rational actualAnswer = r1.sub(r2);
        vivod(actualAnswer, correctAnswer);
    }

    private static void testSubInPlace(Rational r1, Rational r2, Rational correctAnswer) {
        System.out.print(
                r1 + " - " + r2 + " = "
        );
        r1.subInPlace(r2);
        vivod(r1, correctAnswer);
    }

    private static void testMul(Rational r1, Rational r2, Rational correctAnswer) {
        System.out.print(
                r1 + " * " + r2 + " = "
        );
        Rational actualAnswer = r1.mul(r2);
        vivod(actualAnswer, correctAnswer);
    }

    private static void testMulInPlace(Rational r1, Rational r2, Rational correctAnswer) {
        System.out.print(
                r1 + " * " + r2 + " = "
        );
        r1.mulInPlace(r2);
        vivod(r1, correctAnswer);
    }

    private static void testDiv(Rational r1, Rational r2, Rational correctAnswer) {
        System.out.print(
                r1 + " / " + r2 + " = "
        );
        Rational actualAnswer = r1.div(r2);
        vivod(actualAnswer, correctAnswer);
    }

    private static void testDivInPlace(Rational r1, Rational r2, Rational correctAnswer) {
        System.out.print(
                r1 + " / " + r2 + " = "
        );
        r1.divInPlace(r2);
        vivod(r1, correctAnswer);
    }


}
