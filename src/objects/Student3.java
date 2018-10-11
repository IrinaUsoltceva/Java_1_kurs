package objects;

/* у каждого элемента класа (метода, поля, конструктора) есть модификатор доступа
1) private      - только внутри класса
2) protected    -
3) пустой       - виден только в пакете (каталоге) класса
4) public       - виден везде
 */

public class Student3 {
    //поля делаем только приватными!
    private String name;
    private int course = 1;

    //у нас методы и конструкторы почти всегда паблик
    //приатными будем делать методы, которые вспомогательные
    //внутри класса, которые никто не должен иметь возможность вызвать

    public Student3(String name, int course) {
        this.name = name;
        this.course = course;
    }

    public void greet() {
        System.out.println(
                "Привет, я " + this.name +
                        " с курса " + this.course
        );
    }

    public String genName() {
        return name;
    }
    //метод set часто не делают, тогда поле можно читтать,
    //но не изменять
    public void setName(String name) {
        this.name = name;
    }

    //как написать то же самое для курса
    //необязательное сочетание клавиш alt+ins (alt левый!)

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
