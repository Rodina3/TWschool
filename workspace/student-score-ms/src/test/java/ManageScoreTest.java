import ms_student_score.Klass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by rzhou on 26/07/2017.
 */
public class ManageScoreTest {
    @Test
    public void should_add_one_student_score() throws Exception {
        //given
        String stuInput = "张三 000 89 78 90 84";
        Klass klass = new Klass(stuInput);
        
        assertThat(klass.getStudentItem().getName(),is("张三"));
        assertThat(klass.getStudentItem().getID(),is("000"));
        assertThat(klass.getStudentItem().getMath(),is(89));
        assertThat(klass.getStudentItem().getChinese(),is(78));
        assertThat(klass.getStudentItem().getEnglish(),is(90));
        assertThat(klass.getStudentItem().getCoding(),is(84));


    }
}
