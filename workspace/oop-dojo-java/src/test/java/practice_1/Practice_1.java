package practice_1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Practice_1 {
    Person person;

    @Test
    public void testIntroduce() throws Exception {
        person = new Person("Tom", 21);
        assertThat(person.introduce(), is("My name is Tom. I am 21 years old."));

    }

    @Test
    public void testModifyName() throws Exception {
        person = new Person("Tom", 21);
        person.setName("Tom Wu");
        assertThat(person.introduce(), is("My name is Tom Wu. I am 21 years old."));
    }

    @Test
    public void testToString() throws Exception {
        person = new Person("Tom Wu", 21);
        assertThat(person.toString(), is("My name is Tom Wu. I am 21 years old."));
    }
}
