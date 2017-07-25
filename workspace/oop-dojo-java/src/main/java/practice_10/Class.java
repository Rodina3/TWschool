package practice_10;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Class {
    private int number;
    private int leader;


    public Class(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public String assignLeader(Student student) {
        if (student.getMyClass().getNumber() != this.number) {
            return "It is not one of us.";
        } else {
            this.leader = student.getID();
            return "";
        }
    }

    public int getLeader() {
        return this.leader;
    }

    public void appendMember(Student student) {
        student.setMyclass(this);
    }


}
