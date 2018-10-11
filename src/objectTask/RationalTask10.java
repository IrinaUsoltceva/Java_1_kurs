package objectTask;

public class RationalTask10 {
    public static void main(String[] args) {
        System.out.println("--Task9--");
        Rational x = new Rational(4,5);
        System.out.println(x.getN());
        System.out.println(x.getD());

        System.out.println("--Task10--");
        System.out.println(Rational.ONE);
        System.out.println(Rational.ZERO);
        System.out.println(Math.PI);

        System.out.println("--Task12--");
        task12();
    }

    private static void task12() {
        System.out.println("<---adds--->");
        testAdd(new Rational(3,2),
                new Rational(6,4),
                new Rational(3));
        testAdd(new Rational(3,2),
                new Rational(10,2),
                new Rational(13,2));
        testAdd(new Rational(1,6),
                new Rational(1,3),
                new Rational(1,2));

        System.out.println();
        System.out.println("<---subs--->");
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
        System.out.println("<---mul--->");
        testMulS(new Rational(1,6),
                new Rational(1,3),
                new Rational(1,18)
        );
        testMulS(new Rational(-1,4),
                new Rational(-2),
                new Rational(1,2)
        );
        testMulS(new Rational(32,64),
                new Rational(0),
                new Rational(0)
        );

        System.out.println();
        System.out.println("<---divs--->");
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
        Rational actualAnswer = Rational.adds(r1, r2);
        vivod(actualAnswer, correctAnswer);
    }

    private static void testSub(Rational r1, Rational r2, Rational correctAnswer) {
        System.out.print(
                r1 + " - " + r2 + " = "
        );
        Rational actualAnswer = Rational.subs(r1, r2);
        vivod(actualAnswer, correctAnswer);
    }

    private static void testMulS(Rational r1, Rational r2, Rational correctAnswer) {
        System.out.print(
                r1 + " * " + r2 + " = "
        );
        Rational actualAnswer = Rational.mul(r1, r2);
        vivod(actualAnswer, correctAnswer);
    }

    private static void testDiv(Rational r1, Rational r2, Rational correctAnswer) {
        System.out.print(
                r1 + " / " + r2 + " = "
        );
        Rational actualAnswer = Rational.divs(r1, r2);
        vivod(actualAnswer, correctAnswer);
    }
}
