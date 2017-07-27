package ms_student_score;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Klass {

    private Student [] students;
    private Student studentItem;

    public Klass(String studentScore) {
        String [] stuInfo=studentScore.split(" ");
        this.studentItem = new Student(stuInfo[0],stuInfo[1],
                Integer.parseInt(stuInfo[2]),
                Integer.parseInt(stuInfo[3]),
                Integer.parseInt(stuInfo[4]),
                Integer.parseInt(stuInfo[5]));
    }

    public Student getStudentItem() {
        return studentItem;
    }
}
