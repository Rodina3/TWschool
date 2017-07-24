package practice_9;

import java.util.ArrayList;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Class {
    private int number;
    private int leader;
    // private ArrayList students = new ArrayList();


    public Class(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void assignLeader(Student student) {
        this.leader = student.getID();
    }

    public int getLeader() {
        return this.leader;
    }


}
