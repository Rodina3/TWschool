package ms_student_score.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Klass {

    private List<Student> studentList = new ArrayList<Student>();
    private float average = 0;
    private float median = 0;

    private void refreshAverage() {
        this.average = 0;
        for (Student stu : this.studentList) {
            this.average += stu.getAverage();
        }
        this.average /= this.studentList.size();
    }

    private void refreshMedian() {
        this.median = 0;
        List<Integer> totalScoreList = new ArrayList<>();

        if (studentList.size() == 1) {
            this.median = studentList.get(0).getTotalScore();
            return;
        }

        for (int i = 0; i < studentList.size(); i++) {
            totalScoreList.add(studentList.get(i).getTotalScore());
        }
        Collections.sort(totalScoreList);
        int index = 0;
        if (studentList.size() % 2 == 0) {
            index = studentList.size() / 2;
            this.median = (float) ((studentList.get(index).getTotalScore() + studentList.get(index - 1).getTotalScore()) / 2.0);
        } else {
            index = (studentList.size() - 1) / 2;
            this.median = studentList.get(index).getTotalScore();
        }
    }


    public float getKlassAverage() {
        return this.average;
    }

    public float getKlassMedian() {
        return this.median;
    }

    public void addStudent(List<Student> students) {
        this.studentList.addAll(students);
        refreshAverage();
        refreshMedian();
    }

    public void addStudent(Student stu) {
        this.studentList.add(stu);
        refreshAverage();
        refreshMedian();
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

}
