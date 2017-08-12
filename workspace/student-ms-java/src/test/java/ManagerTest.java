import ms_student_score.core.*;
import ms_student_score.service.Manager;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 10/08/2017.
 */
public class ManagerTest {

    @Test
    public void can_add_and_find_student_info() throws Exception {
        Student stu = new Student("张三", "000", "buaa@163.com", "123");
        Manager manager = new Manager();
        manager.addStudent(stu);

        assertThat(manager.getAllStudents().getStudentList().get(0).getName(), is("张三"));
        assertThat(manager.getAllStudents().getStudentList().get(0).getId(), is("000"));
        assertThat(manager.getStudentById("000").getEmail(), is("buaa@163.com"));
        assertThat(manager.getStudentById("000").getPhone(), is("123"));
        assertThat(manager.buildAllReport().getStudentScoreItem().get(0).getChinese(),is(0));
        assertThat(manager.buildAllReport().getStudentScoreItem().get(0).getName(),is("张三"));
    }


    @Test
    public void can_build_report() throws Exception {
        Manager manager = new Manager();
        Student stu1 = new Student("张三", "000", "buaa@163", "123");
        Student stu2 = new Student("李四", "001", "buaa@163", "123");

        manager.addStudent(stu1);
        manager.addStudent(stu2);

        Scores scores1 = new Scores("000", 100, 100, 100, 100);
        Scores scores2 = new Scores("001", 90, 90, 90, 90);

        Report report = new Report();
        report.setStudentItem(Arrays.asList(scores1, scores2));
        report.getStudentScoreItem().get(0).setName("张三");
        report.getStudentScoreItem().get(1).setName("李四");
        report.setAverage(95);
        report.setMedian(380);

        assertThat(manager.modifyStudentScores(scores1), is(scores1));
        assertThat(manager.modifyStudentScores(scores2), is(scores2));

        assertThat(manager.buildReport(Arrays.asList("000")).getStudentScoreItem().get(0).getName(), is("张三"));
        assertThat(manager.buildReport(Arrays.asList("000", "001")).getStudentScoreItem().get(1).getName(), is("李四"));
        assertThat(manager.buildAllReport().getMedian() - report.getMedian() < 0.01, is(true));
        assertThat(manager.buildAllReport().getAverage() - report.getAverage() < 0.01, is(true));

    }

}
