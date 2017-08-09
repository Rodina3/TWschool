import ms_student_score.core.Klass;
import ms_student_score.core.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 27/07/2017.
 */
public class KlassTest {
    @Test
    public void should_add_one_student_score() throws Exception {
        //given
        Student stu = new Student("张三", "000", 89, 78, 90, 84);
        Klass klass = new Klass();
        klass.addStudent(stu);


        assertThat(klass.getStudentList().get(0).getName(), is("张三"));
        assertThat(klass.getStudentList().get(0).getId(), is("000"));
        assertThat(klass.getStudentList().get(0).getScores().get("math"), is(89));
        assertThat(klass.getStudentList().get(0).getScores().get("chinese"), is(78));
        assertThat(klass.getStudentList().get(0).getScores().get("english"), is(90));
        assertThat(klass.getStudentList().get(0).getScores().get("coding"), is(84));
        assertThat(klass.getStudentList().get(0).getTotalScore(), is(341));
        assertThat(klass.getStudentList().get(0).getAverage() - 85.25 < 0.0001, is(true));

    }

    @Test
    public void should_add_two_students_score() throws Exception {
        //given
        Student stu1 = new Student("张三", "000", 89, 78, 90, 84);
        Student stu2 = new Student("李四", "001", 69, 79, 60, 74);
        List<Student> stuList = Arrays.asList(stu1, stu2);

        Klass klass = new Klass();
        klass.addStudent(stuList);

        assertThat(klass.getStudentList().size(), is(2));
        assertThat(klass.getStudentList().get(0).getScores().get("coding"), is(84));
        assertThat(klass.getStudentList().get(1).getId(), is("001"));
    }
}
