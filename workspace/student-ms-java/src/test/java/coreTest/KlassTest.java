package coreTest;

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
    public void should_add_one_student_info() throws Exception {
        //given
        Student stu = new Student("张三", "000", "buaa@163.com", "123");
        Klass klass = new Klass();
        klass.addStudent(stu);

        assertThat(klass.getStudentList().get(0).getName(), is("张三"));
        assertThat(klass.getStudentList().get(0).getId(), is("000"));
        assertThat(klass.getStudentList().get(0).getEmail(), is("buaa@163.com"));
        assertThat(klass.getStudentList().get(0).getPhone(), is("123"));
    }

    @Test
    public void should_find_student_info_when_input_id() throws Exception {
        //given
        Student stu = new Student("张三", "000", "buaa@163.com", "123");
        Klass klass = new Klass();
        klass.addStudent(stu);

        assertThat(klass.getStudentList().get(klass.findStudentById("000")), is(stu));
        assertThat(klass.findStudentById("111"),is(-1));
    }

}
