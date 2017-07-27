import ms_student_score.Klass;
import ms_student_score.Student;
import ms_student_score.Transcript;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by rzhou on 26/07/2017.
 */
public class ManageScoreTest {
    @Test
    public void should_add_one_student_score() throws Exception {
        //given
        Student stu = new Student("张三", "000", 89, 78, 90, 84);
        List<Student> stuList = Arrays.asList(stu);

        Klass klass = new Klass();
        klass.addStudent(stuList);


        assertThat(klass.getKlassScores().get(0).getName(), is("张三"));
        assertThat(klass.getKlassScores().get(0).getID(), is("000"));
        assertThat(klass.getKlassScores().get(0).getMath(), is(89));
        assertThat(klass.getKlassScores().get(0).getChinese(), is(78));
        assertThat(klass.getKlassScores().get(0).getEnglish(), is(90));
        assertThat(klass.getKlassScores().get(0).getCoding(), is(84));
        assertThat(klass.getKlassScores().get(0).getTotalScore(), is(341));
        assertThat(klass.getKlassScores().get(0).getAverage() - 85.25 < 0.0001, is(true));

    }

    @Test
    public void should_add_two_students_score() throws Exception {
        //given
        Student stu1 = new Student("张三", "000", 89, 78, 90, 84);
        Student stu2 = new Student("李四", "001", 69, 79, 60, 74);
        List<Student> stuList = Arrays.asList(stu1, stu2);

        Klass klass = new Klass();
        klass.addStudent(stuList);

        assertThat(klass.getKlassScores().size(), is(2));
        assertThat(klass.getKlassScores().get(0).getCoding(), is(84));
        assertThat(klass.getKlassScores().get(1).getID(), is("001"));
    }

    @Test
    public void should_build_transcript_include_one_student() throws Exception {
        //given
        List<Student> students = Arrays.asList(new Student("张三", "000", 89, 78, 90, 84),
                new Student("李四", "001", 69, 79, 60, 74));

        Klass klass = new Klass();
        klass.addStudent(students);


        List<String> studentsIDs = Collections.singletonList("000");
        Transcript transcript = new Transcript(klass);

        //when
        String result = transcript.buildTranscript(studentsIDs);
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
        Transcript transcript = new Transcript(klass);

        assertThat(transcript.buildTranscript(studentsIDs), is(
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
        Transcript transcript = new Transcript(klass);

        assertThat(transcript.buildTranscript(studentsIDs), is("成绩单\n"
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
        Transcript transcript = new Transcript(klass);

        assertThat(transcript.buildTranscript(studentsIDs), is("成绩单\n"
                + "姓名|数学|语文|英语|编程|平均分|总分 \n"
                + "========================\n"
                + "李四|69|79|60|74|70.5|282\n"
                + "========================\n"
                + "全班总平均分：77.875\n"));
    }


}
