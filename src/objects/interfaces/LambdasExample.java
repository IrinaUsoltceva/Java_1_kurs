package objects.interfaces;

public class LambdasExample {
    public static void main(String[] args) {
        //Создадим считателя
        //Counter c1 = можно создать класс, но нам лень и потому
        Counter c1 = new Counter() {
            @Override
            public String count(int x) {
                return "*" + x;
            }
        };

        doCount(c1);
        // String count(int x);
        Counter c2 = (int x) -> {
            return "(" + x + ")";
        };
        //Вместо анонимного класса пишем только
        // аргументы метода, потом стрелка, потом тело
        doCount(c2);

        //МЕтод Integer.toString превращает в текст по основанию
        doCount(x -> Integer.toString(x, 2));
        //тип параметра не нужен, как и раньше
        //если в теле метода только return то можно без него


    }

    private static void doCount (Counter c1) {
        for (int i = 1; i <= 10; i++)
            System.out.println(i + " -> " + c1.count(i));
    }
}
