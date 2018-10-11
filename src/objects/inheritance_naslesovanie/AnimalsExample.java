package objects.inheritance_naslesovanie;

import java.util.ArrayList;
import java.util.List;

public class AnimalsExample {

    public static void main(String[] args) {
        Animal a1 = new Animal("Barsik");
        Animal a2 = new Animal("Bobic");
        Animal a3 = new Animal("Buronka");

        a1.greet();
        a2.greet();
        a3.greet();

        //Cat c1 = new Cat() - такой конструктор - странный.
        //животное нельзя создать, не указав имя.
        //кот - животное, но у негоо имени нет :(((

        //принцип констсруирования объекта - при создании объекта вызываются
        //по очереди конструктровы всех базовых классов.
        //т.е. при создании cat должен сначала вызваться конструктор
        //animal, и только потом конструктор cat

        //поэтому если при наследовании в конструкторе потомка
        //обязательно вызывается конструктор предка

        Cat c1 = new Cat();
        Cat c2 = new Cat("Барсик");
        c1.greet(); //мурзик
        c2.greet(); //барсик

        //если в базовом классе есть конструктор без аргументов,
        //то можно ничего не писать, даже super

        c1.catchAMouse();
        c1.catchAMouse();
        //a1.catchAMouse - нет такой возможности

        Animal a5 = new Animal("Животное 1");
        Cat c3 = new Cat("Животное 2");

        System.out.println(a5.getSound()); //ыыыыыыыыы
        System.out.println(c3.getSound());//meow

        //переменная базового класса может хранить объект класса потомка
        Animal a6 = new Cat ("Животное 3");
        System.out.println(a6.getSound());//Meow, тк а6 - кот

        //List<String> l = new ArrayList<String>()

        c1.catchAMouse(); //работает
        //a5.catchAMouse(); не работает
        //a6.catchAMouse(); не работает, тк A6 - animal,
        //но у animal нет метоа catchAMouse

        //но если мы знаем, что a6 - это кот, как всё-таки вызвать этот метод

        ((Cat)a6).catchAMouse(); //приведение типа
        Cat c6 = (Cat)a6; //объект один и тот же, но на него
        //указывают переменные разных типов

        //проверка типа делается специальным оператором instance of
        System.out.println(a6 instanceof Cat); //true
        System.out.println(a5 instanceof Cat); //false
    }
}
