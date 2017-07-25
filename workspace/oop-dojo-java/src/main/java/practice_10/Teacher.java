package practice_10;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Teacher extends Person {

    private Class myTeachClass;

    public Teacher(int id,String name, int age, Class myTeachClass) {
        super(id,name, age);
        this.myTeachClass = myTeachClass;
    }


    public Teacher(int id,String name, int age) {
        super(id,name, age);
        this.myTeachClass = null;
    }

    public String introduce() {
        if (this.myTeachClass == null) {
            return super.introduce() + " I am a Teacher. I teach No Class.";
        } else {
            return super.introduce() + " I am a Teacher. I teach Class " + this.myTeachClass.getNumber() + ".";

        }
    }

}
