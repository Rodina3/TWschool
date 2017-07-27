import ms_student_score.Klass;
import ms_student_score.Student;
import org.junit.Test;
import sun.jvm.hotspot.utilities.KlassArray;

import java.util.Arrays;
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

        Klass klass = new Klass(stuList);

        assertThat(klass.getStudentItem().get(0).getName(), is("张三"));
        assertThat(klass.getStudentItem().get(0).getID(), is("000"));
        assertThat(klass.getStudentItem().get(0).getMath(), is(89));
        assertThat(klass.getStudentItem().get(0).getChinese(), is(78));
        assertThat(klass.getStudentItem().get(0).getEnglish(), is(90));
        assertThat(klass.getStudentItem().get(0).getCoding(), is(84));
        assertThat(klass.getStudentItem().get(0).getTotalScore(),is(341));
        assertThat(klass.getStudentItem().get(0).getAverage()-85.25<0.0001,is(true));

    }

    @Test
    public void should_add_two_students_score() throws Exception {
        //given
        Student stu1 = new Student("张三", "000", 89, 78, 90, 84);
        Student stu2 = new Student("李四", "001", 69, 79, 60, 74);
        List<Student> stuList = Arrays.asList(stu1, stu2);

        Klass klass = new Klass(stuList);
        assertThat(klass.getStudentItem().size(), is(2));
        assertThat(klass.getStudentItem().get(0).getCoding(), is(84));
        assertThat(klass.getStudentItem().get(1).getID(), is("001"));
    }


}
