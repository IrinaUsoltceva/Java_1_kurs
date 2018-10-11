package objects.abstractinheritance;

public class AnimalsExample {

    public static void main(String[] args) {
        //У абстрактного класса нельзя создавать Объект
        //Animal a1 = new Animal("Barsik");
        //Ошибка, потому что класс абстрактный

        Animal a = new Cat("Арик");
        //А вот так можно
        //т.е. объектные классы - классы, где какие-то методы остались без тела

        Animal[] zoo = new Animal[]{
                new Cat("Барсик"),
                new Dog("Шарик"),
                //анонимные классы
                //иногда хотим реализовать классы прямо в коде
                new Animal("Вуу") { //после оператора new сразу стоят открывающие фигурные скобки
                    @Override            //внутри них - тело класса. Там могут быть поля, методы
                    public String getSound() { //Это - "безымянные классы", потому что у них нет имени
                        return "Вууууууууу"; //Этот класс, зато, наследник Animal
                    }
                }
        };
        for(Animal animal : zoo)
            animal.greet();
    }
}
