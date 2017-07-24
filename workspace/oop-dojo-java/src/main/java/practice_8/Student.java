package practice_8;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Student extends Person {
    private int myclass;

    public Student(String name, int age, Class myclass) {
        super(name, age);
        this.myclass = myclass.getNumber();
    }

    public String introduce() {
        return super.introduce() + " I am a Student. I am at Class " + this.myclass + ".";
    }


    public int getMyClass() {
        return this.myclass;
    }

}
