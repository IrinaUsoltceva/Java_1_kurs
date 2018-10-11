package objects;

public class Student2 {

    private String name;
    private int course = 1; //после создания объекта, но перед
                    //вызовом конструктора, course присовится 1

    //конструктор. Пишем между полями и методами.
    //(в начале класса: поля, потом конструкторы, потом методы)

    //конструктор оформляется как метод, к оторого нет возвращаемого типа,
    //а имя совпадает с именем класса

    Student2(String name, int course) {
        this.name = name;
        this.course = course;
        //здесь this убирать нельзя
    }
    //в большинстве случаев конструктор просто копирует внутрь себя переданные аргументы

    Student2() {} //пустой конструктор, но в ближайшее время пользоваться подобным не будем
    //уострукторов может быть несколько. если ни один не написан, то создается
    //"конструктор по умолчанию", он не имеет аргументов и ничего не делает. (см.Student)

    void greet() {
        System.out.println(
                "Привет, я " + this.name +
                        " с курса " + this.course
        );
    }

}