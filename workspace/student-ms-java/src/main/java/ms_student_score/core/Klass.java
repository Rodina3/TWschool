package ms_student_score.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Klass {

    public Klass(){};
    private List<Student> studentList = new ArrayList<Student>();

    public void addStudent(List<Student> students) {
        this.studentList.addAll(students);
    }

    public void addStudent(Student stu) {
        this.studentList.add(stu);
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

}
