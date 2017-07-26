import ms_student_score.Student;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 26/07/2017.
 */
public class StudentTest {

    private Student student = new Student();

    @Test
    public void should_return_false_when_input_lack() throws Exception {
        //given
        String input = "张三 000";

        assertThat(student.isIllegal(input), is(false));
    }

    @Test
    public void should_return_false_when_score_not_number() throws Exception {
        //given
        String input = "张三 000 a";

        assertThat(student.isIllegal(input), is(false));
    }


    @Test
    public void should_return_false_when_input_redundant() throws Exception {
        //given
        String input = "张三 000 90 89 87 100 22";
        assertThat(student.isIllegal(input), is(false));
    }

    @Test
    public void should_return_false_when_score_illegal() throws Exception {
        //given
        String input = "张三 000 90 89 87 120";

        assertThat(student.isIllegal(input), is(false));
    }

    @Test
    public void should_return_true_when_input_legal() throws Exception {
        //given
        String input = "张三 000 90 89 87 100";

        assertThat(student.isIllegal(input), is(true));

    }
}
