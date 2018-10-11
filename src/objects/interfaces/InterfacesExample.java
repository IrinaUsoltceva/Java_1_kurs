package objects.interfaces;

public class InterfacesExample {
    /*
    Интерфейсы - это абстрактные классы, в которых все методы абстрактные
    т.е. нет реализации ни одного метода

    В Java нельзя наследоваться от нескольких классов, но можно от нескольких
    интерфейсов

    Колодец extends Строение, РезервуарДляВоды

    В Java так нельзя, если Строение и РезервуарДляВоды - классы
    НО можно, если это интерфейсы

    =======================================

    Вообще, смысл интерфейса в том, что он описывает
    возможности класса.
     */

    public static void main(String[] args) {
        Animal c1 = new Cat("Барсик");
        //Animal a2 = new Animal(); //нельзя
        Animal a2 = new Animal() {
            @Override
            public String getSound() {
                return "Мияу";
            }

            @Override
            public String getName() {
                return "Мурзик";
            }
        };
    }
}
