package ms_student_score.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Klass {

    private List<Student> studentList = new ArrayList<Student>();
    private float average = 0;

    private void refreshAverage() {
        this.average = 0;
        for (Student stu : this.studentList) {
            this.average += stu.getAverage();
        }
        this.average /= this.studentList.size();
    }

    public float getKlassAverage() {
        return this.average;
    }

    public void addStudent(List<Student> students) {
        this.studentList.addAll(students);
        refreshAverage();
    }

    public void addStudent(Student stu) {
        this.studentList.add(stu);
        refreshAverage();
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

}
