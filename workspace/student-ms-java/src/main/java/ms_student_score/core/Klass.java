package ms_student_score.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Klass {

    private List<Student> studentList = new ArrayList<Student>();
    public Klass() {}

    public void addStudent(Student stu) {
        this.studentList.add(stu);
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public int findStudentById(String id) {
        int index = -1;
        for (int i = 0; i < this.getStudentList().size(); i++) {
            if (id.equals(this.getStudentList().get(i).getId())) {
                index = i;
                break;
            }

        }
        return index;
    }
}
