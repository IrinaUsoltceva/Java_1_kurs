package objects;
public class Student4 {

    //переменная для подсчёта числа студентов - существует в единственном экземпляре
    static private int count = 0;
    public static int getStudentsCount() {
        // System.out.println(name);
        //Из статического метода нельзя обращсяться
        //к не статическим элементам класса
        //наоборот можно
        return count;
    }

    public static final double PI = 3.14;
    //static final поле часто делают публичным, это "константы"

    private String name;
    private int course;
    private final boolean b;

    public Student4(String name, int course) {
        this.name = name;
        this.course = course;
        System.out.println("Я создался! " + name);
        count++; //обновить количество студентов

        b = true;
        //значние final поля можно задать сразу или в конструкторе
    }

    //alt+insert для конструктора, но можно пока писать

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

}
