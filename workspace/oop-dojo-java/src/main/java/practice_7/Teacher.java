package practice_7;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Teacher extends Person {

    private int myTeachClass;

    public Teacher(String name, int age, int myTeachClass) {
        super(name, age);
        this.myTeachClass = myTeachClass;
    }


    public Teacher(String name, int age) {
        super(name, age);
        this.myTeachClass = -1;
    }

    public String introduce() {
        if (this.myTeachClass == -1) {
            return super.introduce() + " I am a Teacher. I teach No Class.";
        } else {
            return super.introduce() + " I am a Teacher. I teach Class " + this.myTeachClass + ".";

        }
    }
}
