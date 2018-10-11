package objects.interfaces;

//Интерфейсы реализуют (implemetns), а не расширяют (extends)
public class Cat implements Animal {

    private String name;

    public Cat(String name) {//кот при создании запоминает своё имя
        this.name = name;
    }

    @Override
    public String getSound() {
        return "MEOW";
    }

    @Override
    public String getName() {
        return name;
    }
}
