package ms_student_score;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Klass {

    private List<Student> klassScores = new ArrayList<Student>();
    private float averageScore = 0;

    private void calculateKlassAverage() {
        this.averageScore = 0;
        for (Student stu : this.klassScores) {
            this.averageScore += stu.getAverage();
        }
        this.averageScore /= this.klassScores.size();
    }

    public void addStudent(List<Student> students) {
        this.klassScores.addAll(students);
        calculateKlassAverage();
    }

    public void addStudent(Student stu) {
        this.klassScores.add(stu);
        calculateKlassAverage();
    }


    public List<Student> getKlassScores() {
        return this.klassScores;
    }


    public float getKlassAverage() {
        return this.averageScore;
    }
}
