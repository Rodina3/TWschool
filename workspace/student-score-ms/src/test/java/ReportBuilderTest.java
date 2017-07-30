import ms_student_score.core.Klass;
import ms_student_score.core.Student;
import ms_student_score.core.ReportBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 27/07/2017.
 */
public class ReportBuilderTest {

    private String outputString = "\n成绩单\n"
            + "姓名|数学|语文|英语|编程|平均分|总分\n"
            + "========================\n"
            + "%s"
            + "========================\n"
            + "全班总平均分：77.875\n";
    private String stuZS = "张三|89|78|90|84|85.25|341\n";
    private String stuLS = "李四|69|79|60|74|70.5|282\n";
    private Klass klass = new Klass();

    @Before
    public void setUp() throws Exception {
        List<Student> students = Arrays.asList(new Student("张三", "000", 89, 78, 90, 84),
                new Student("李四", "001", 69, 79, 60, 74));
        klass.addStudent(students);
    }

    @Test
    public void should_generate_report_include_one_student() throws Exception {
        //given
        List<String> studentsIDs = Collections.singletonList("000");
        ReportBuilder reportBuilder = new ReportBuilder(klass);

        //when
        String result = reportBuilder.buildReport(studentsIDs);
        //then
        assertThat(result, is(String.format(outputString, stuZS)));
    }

    @Test
    public void should_generate_report_include_two_students() throws Exception {
        //given
        List<String> studentsIDs = Arrays.asList("000", "001");
        ReportBuilder reportBuilder = new ReportBuilder(klass);

        assertThat(reportBuilder.buildReport(studentsIDs), is(String.format(outputString,stuZS+stuLS)));

    }

    @Test
    public void should_not_generate_report_when_student_is_not_exist() throws Exception {
        //given

        List<String> studentsIDs = Collections.singletonList("003");
        ReportBuilder reportBuilder = new ReportBuilder(klass);

        assertThat(reportBuilder.buildReport(studentsIDs), is(String.format(outputString,"")));
    }

    @Test
    public void should_only_generate_report_include_exist_student() throws Exception {
        //given
        List<String> studentsIDs = Arrays.asList("001", "002");
        ReportBuilder reportBuilder = new ReportBuilder(klass);

        assertThat(reportBuilder.buildReport(studentsIDs), is(String.format(outputString,stuLS)));
    }

}
