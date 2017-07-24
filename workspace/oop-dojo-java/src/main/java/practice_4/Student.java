package practice_4;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Student extends Person {
    private int myclass;

    public Student(String name, int age, int myclass) {
        super(name, age);
        this.myclass = myclass;
    }

    public String introduce() {
        return super.introduce() + " I am a Student. I am at Class " + this.myclass + ".";
    }

}
