package practice_9;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Practice9Test {
    @Test
    public void testPersonIntroduce() throws Exception {
        Person person = new Person(001, "Tom", 21);
        assertThat(person.introduce(), is("My name is Tom. I am 21 years old."));
    }

    @Test
    public void testStudentIntroduce() throws Exception {
        Class c2 = new Class(2);
        Student student = new Student(001, "Tom", 21, c2);
        assertThat(student.introduce(), is("My name is Tom. I am 21 years old. I am a Student. I am at Class 2."));
    }

    @Test
    public void testTeacherIntroduce() throws Exception {
        Class c2 = new Class(2);
        Teacher teacher1 = new Teacher(201, "Tom", 21, c2);
        assertThat(teacher1.introduce(), is("My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2."));

        Teacher teacher2 = new Teacher(202, "Ann", 21);
        assertThat(teacher2.introduce(), is("My name is Ann. I am 21 years old. I am a Teacher. I teach No Class."));
    }

    @Test
    public void testClassAssignLeader() throws Exception {
        Class c2 = new Class(2);
        Class c3 = new Class(3);
        Student Tom = new Student(001, "Tom", 21, c2);
        c2.assignLeader(Tom);
        assertThat(Tom.introduce(), is("My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2."));
    }
}
