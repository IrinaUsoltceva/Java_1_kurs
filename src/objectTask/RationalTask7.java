package objectTask;

public class RationalTask7 {
    public static void main(String[] args) {
        System.out.println("------task7--------");
        task7();
        System.out.println();
        System.out.println("------task8--------");
        task8();
    }

    private static void task7() {
        System.out.println("f(1) = " + f(1).toDouble());
        System.out.println("f(2) = " + f(2).toDouble());
        System.out.println("f(3) = " + f(3).toDouble());
        System.out.println("f(10) = " + f(10).toDouble());
        System.out.println("f(13) = " + f(13).toDouble());
        System.out.println("f(15) = " + f(15).toDouble());
        System.out.println("f(17) = " + f(17).toDouble());
        System.out.println("f(19) = " + f(19).toDouble());
        System.out.println("f(20) = " + f(20).toDouble());
        //f(20) = 29285141/35271600
    }

    private static Rational f(int n) {
        Rational sum = new Rational(0);
        for (int i = 1; i <= n; i++)
            sum = sum.add(new Rational(1,i));
        return sum;
    }

    private static void task8 () {
        //проверка того, что ошибка происходит именно на этом шаге
        System.out.println(f(19).add(new Rational(1,20)).toDouble());

        //проверка того, что ошибка не из-за неправильного создания
        //f(19) или Rational(1, 20)
        System.out.println(f(19) + " = " + f(19).toDouble());
        System.out.println(new Rational(1, 20));

        //Проверка сложения - ошибка именно на моменте прибавления 1/20 к сумме
        System.out.print(
                new Rational(275295799, 77597520)
                .add(new Rational(1, 20))
                 + " = "
        );
        System.out.println(
                new Rational(275295799, 77597520)
                        .add(new Rational(1, 20))
                        .toDouble()
        );
        //ошибка появляется на этапе сложения
        System.out.println(275295799 * 20 + 1 * 77597520);
        //1288546204 вместо 5583513500 -> что-то с большими числами
        System.out.println(275295799 * 20);
        //что-то про numeric overflow - не влезает в int
        //надо заменить на long
        long x = 275295799 * 20;
        System.out.println(x);

        long y = 5505915980L; //без буковки ругается
        //-> надо привести к long?
        System.out.println(y);

        long x1 = (long) 275295799 * 10;
        System.out.println(x1);

        //изменила в Rational int на long,
        //больше не ругается, f(20) работает корректно

    }

}
