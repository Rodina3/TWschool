import ms_student_score.core.Klass;
import ms_student_score.core.Student;
import ms_student_score.core.BuildReport;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 27/07/2017.
 */
public class BuildReportTest {

    @Test
    public void should_build_transcript_include_one_student() throws Exception {
        //given
        List<Student> students = Arrays.asList(new Student("张三", "000", 89, 78, 90, 84),
                new Student("李四", "001", 69, 79, 60, 74));

        Klass klass = new Klass();
        klass.addStudent(students);


        List<String> studentsIDs = Collections.singletonList("000");
        BuildReport buildReport = new BuildReport(klass);

        //when
        String result = buildReport.buildTranscript(studentsIDs);
        //then
        assertThat(result, is("成绩单\n"
                + "姓名|数学|语文|英语|编程|平均分|总分 \n"
                + "========================\n"
                + "张三|89|78|90|84|85.25|341\n"
                + "========================\n"
                + "全班总平均分：77.875\n"));
    }

    @Test
    public void should_build_transcript_include_two_students() throws Exception {
        //given
        List<Student> students = Arrays.asList(new Student("张三", "000", 89, 78, 90, 84),
                new Student("李四", "001", 69, 79, 60, 74));

        Klass klass = new Klass();
        klass.addStudent(students);

        List<String> studentsIDs = Arrays.asList("000", "001");
        BuildReport buildReport = new BuildReport(klass);

        assertThat(buildReport.buildTranscript(studentsIDs), is(
                "成绩单\n"
                        + "姓名|数学|语文|英语|编程|平均分|总分 \n"
                        + "========================\n"
                        + "张三|89|78|90|84|85.25|341\n"
                        + "李四|69|79|60|74|70.5|282\n"
                        + "========================\n"
                        + "全班总平均分：77.875\n"
        ));

    }

    @Test
    public void should_not_build_transcript_when_student_is_not_exist() throws Exception {
        //given
        List<Student> students = Arrays.asList(new Student("张三", "000", 89, 78, 90, 84),
                new Student("李四", "001", 69, 79, 60, 74));

        Klass klass = new Klass();
        klass.addStudent(students);

        List<String> studentsIDs = Collections.singletonList("003");
        BuildReport buildReport = new BuildReport(klass);

        assertThat(buildReport.buildTranscript(studentsIDs), is("成绩单\n"
                + "姓名|数学|语文|英语|编程|平均分|总分 \n"
                + "========================\n"
                + "========================\n"
                + "全班总平均分：77.875\n"));
    }

    @Test
    public void should_only_build_transcript_include_exist_student() throws Exception {
        //given
        List<Student> students = Arrays.asList(new Student("张三", "000", 89, 78, 90, 84),
                new Student("李四", "001", 69, 79, 60, 74));

        Klass klass = new Klass();
        klass.addStudent(students);

        List<String> studentsIDs = Arrays.asList("001", "002");
        BuildReport buildReport = new BuildReport(klass);

        assertThat(buildReport.buildTranscript(studentsIDs), is("成绩单\n"
                + "姓名|数学|语文|英语|编程|平均分|总分 \n"
                + "========================\n"
                + "李四|69|79|60|74|70.5|282\n"
                + "========================\n"
                + "全班总平均分：77.875\n"));
    }

}
