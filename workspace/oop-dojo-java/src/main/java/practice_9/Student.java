package practice_9;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Student extends Person {
    private Class myclass;

    public Student(int id, String name, int age, Class myclass) {
        super(id, name, age);
        this.myclass = myclass;
    }

    public String introduce() {
        if (this.myclass.getLeader() != this.getID()) {
            return super.introduce() + " I am a Student. I am at Class " + this.myclass.getNumber() + ".";
        }
        else
        {
            return super.introduce() +" I am a Student. I am Leader of Class "+this.myclass.getNumber()+".";
        }
    }


    public int getMyClass() {
        return this.myclass.getNumber();
    }

}
