package practice_4;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Practice4Test {
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
    public void testWorkerIntroduce() throws Exception {
        Worker worker = new Worker("Tom", 21);
        assertThat(worker.introduce(), is("My name is Tom. I am 21 years old. I am a Worker. I have a job."));
    }
}
