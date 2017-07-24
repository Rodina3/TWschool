package DemoTest;

import Demo.Animal;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by rzhou on 24/07/2017.
 */
public class AnimalTest {
    Animal animal;
    @Test
    public void testGetAnimalName() throws Exception {
        animal = new Animal("Tom");
        assertThat(animal.getAnimalName(),is("Tom"));
    }
}
