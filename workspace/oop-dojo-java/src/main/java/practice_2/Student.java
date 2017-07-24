package practice_2;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Student {

    private String name;
    private int age;
    private int myclass;

    public Student(String name, int age, int myclass) {
        this.name = name;
        this.age = age;
        this.myclass = myclass;
    }


    public String introduce() {
        return "My name is " + this.name + ". I am " + this.age + " years old. I am a Student. I am at Class " + this.myclass + ".";
    }
}
