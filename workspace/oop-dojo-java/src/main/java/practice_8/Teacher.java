package practice_8;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Teacher extends Person {

    private Class myTeachClass;

    public Teacher(String name, int age, Class myTeachClass) {
        super(name, age);
        this.myTeachClass = myTeachClass;
    }


    public Teacher(String name, int age) {
        super(name, age);
        this.myTeachClass = null;
    }

    public String introduce() {
        if (this.myTeachClass == null) {
            return super.introduce() + " I am a Teacher. I teach No Class.";
        } else {
            return super.introduce() + " I am a Teacher. I teach Class " + this.myTeachClass.getNumber() + ".";

        }
    }

    public String introduceWith(Student student) {
        if (this.myTeachClass.getNumber() == student.getMyClass()) {
            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        } else {
            return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
        }
    }
}
