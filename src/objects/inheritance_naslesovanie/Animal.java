package objects.inheritance_naslesovanie;

public class Animal {

    private String name;

    public Animal (String name) {
        this.name = name;
    }

    public String getSound() {
        return "ыыыыыыыыыыыыы";
    }

    public void greet() {
        //вызывается getSound у объекта, а не класса
        //т.е. если вызывать greet у потомка и getSound будет у потомка
        System.out.println("Hello, I'm " + name + " " + getSound());
    }
}
