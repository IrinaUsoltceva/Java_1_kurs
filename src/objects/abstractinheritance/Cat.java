package objects.abstractinheritance;

/*
Ключевое слово extend означает, что
1) Cat hfcibhztn rkfcc Фтшьфд
2) Сat - Наследниек Animal
3) Cat - частный случай Animal

Ecли сделать extend, то все поля и методы
базового (родительского) класса, от которого унаследовались,
переходят в класс потомок
 */
public class Cat extends Animal {
    //поле name, метод getName, метод getSound
    //поле name Есть в классе cat, но
    //с ним ничего нельзя сделать, тк оно приватное
    //если все-таки хочется узнать Namem то можно использовать
    //getName
    //с прошлого раза вспомните можификатор доступа protected
    //поле или метод доступно только в потомке

    public Cat() {
        super("Мурзик"); //вызов конструктора базового класса
        //вызов делает ключевое слово super,
        // оно должно быть первым в конструкторе

        System.out.println("meow");

    }

    public Cat(String name) {
        super(name); //вызов конструктора класса
    }

    //можно добавлять новые поля и методы
    private int miceCount = 0;
    public void catchAMouse() {
        System.out.println(getSound() + "' " + miceCount);
    }

    //можно переопределять старый метод
    //для этого нужно в точности повторить заголовок

    //это переопределение, а не новый етод
    //overriding
    @Override
    public String getSound() {
        return "Meow";
    }
    //аннотация Override перед методом не обязательно, но рекомендуется
    //тогда комплиятро проверит, что это действие
    //является переодперекдлеим
}
