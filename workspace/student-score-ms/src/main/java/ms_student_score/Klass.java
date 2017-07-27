package ms_student_score;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Klass {

    private List<Student> klass = new ArrayList<Student>();
    private Student studentItem;

    public Klass(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
             this.klass.add(students.get(i));
        }
    }


    public List<Student> getStudentItem() {
        return this.klass;
    }
}
