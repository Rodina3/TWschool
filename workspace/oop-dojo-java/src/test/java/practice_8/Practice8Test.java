package practice_8;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Practice8Test {
    @Test
    public void testPersonIntroduce() throws Exception {
        Person person = new Person("Tom", 21);
        assertThat(person.introduce(), is("My name is Tom. I am 21 years old."));
    }

    @Test
    public void testStudentIntroduce() throws Exception {
        Class c2 = new Class(2);
        Student student = new Student("Tom", 21, c2);
        assertThat(student.introduce(), is("My name is Tom. I am 21 years old. I am a Student. I am at Class 2."));
    }

    @Test
    public void testTeacherIntroduce() throws Exception {
        Class c2 = new Class(2);
        Teacher teacher1 = new Teacher("Tom", 21, c2);
        assertThat(teacher1.introduce(), is("My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2."));

        Teacher teacher2 = new Teacher("Tom", 21);
        assertThat(teacher2.introduce(), is("My name is Tom. I am 21 years old. I am a Teacher. I teach No Class."));
    }

    @Test
    public void testTeacherIntroduceWith() throws Exception {
        Class c2 = new Class(2);
        Class c3 = new Class(3);
        Student jerry = new Student("Jerry", 21, c2);
        Student lucy = new Student("Lucy", 21, c3);
        Teacher tom = new Teacher("Tom", 21, c2);
        assertThat(tom.introduceWith(jerry), is("My name is Tom. I am 21 years old. I am a Teacher. I teach Jerry."));
        assertThat(tom.introduceWith(lucy), is("My name is Tom. I am 21 years old. I am a Teacher. I don't teach Lucy."));
    }

}
