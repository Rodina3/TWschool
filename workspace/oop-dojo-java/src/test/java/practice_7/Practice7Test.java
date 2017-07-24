package practice_7;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by rzhou on 24/07/2017.
 */
public class Practice7Test {
    @Test
    public void testPersonIntroduce() throws Exception {
        Person person = new Person("Tom", 21);
        assertThat(person.introduce(), is("My name is Tom. I am 21 years old."));
    }

    @Test
    public void testStudentIntroduce() throws Exception {
        Student student = new Student("Tom", 21, 2);
        assertThat(student.introduce(), is("My name is Tom. I am 21 years old. I am a Student. I am at Class 2."));
    }

    @Test
    public void testTeacherIntroduce() throws Exception {
        Teacher teacher1 = new Teacher("Tom", 21, 2);
        assertThat(teacher1.introduce(), is("My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2."));

        Teacher teacher2 = new Teacher("Tom", 21);
        assertThat(teacher2.introduce(), is("My name is Tom. I am 21 years old. I am a Teacher. I teach No Class."));
    }
}

