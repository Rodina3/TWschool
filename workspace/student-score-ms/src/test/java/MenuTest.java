import ms_student_score.menu.InputNotice;
import ms_student_score.menu.Menu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 27/07/2017.
 */
public class MenuTest {

    private Menu menu = new Menu();
    private final ByteArrayOutputStream consoleLog = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(consoleLog));
    }

    @After
    public void tearDown() throws Exception {
        consoleLog.close();
    }

    @Test
    public void should_show_add_student_score_page_when_input_1() throws Exception {
        //given
        //when
        consoleLog.reset();
        menu.chooseFunction("1");

        //then
        assertThat(consoleLog.toString(), is(InputNotice.addWaiting));
    }

    @Test
    public void should_show_print_report_page_when_input_2() throws Exception {
        //given
        //when
        consoleLog.reset();
        menu.chooseFunction("2");

        //then
        assertThat(consoleLog.toString(), is(InputNotice.printWaiting));
    }

    @Test
    public void should_show_add_fail_page_when_student_score_input_format_illegal() throws Exception {
        //given
        //when
        menu.chooseFunction("1");
        consoleLog.reset();
        menu.chooseFunction("ejjk");

        //then
        assertThat(consoleLog.toString(), is(InputNotice.addFail));
    }

    @Test
    public void should_show_add_fail_page_when_id_empty() throws Exception {
        //given
        //when
        menu.chooseFunction("1");
        consoleLog.reset();
        menu.chooseFunction("张三, , 89, 78, 90, 84");

        //then
        assertThat(consoleLog.toString(), is(InputNotice.addFail));
    }

    @Test
    public void should_show_add_fail_page_when_id_illegal() throws Exception {
        //given
        //when
        menu.chooseFunction("1");
        consoleLog.reset();
        menu.chooseFunction("张三, 000p, 89, 78, 90, 84");

        //then
        assertThat(consoleLog.toString(), is(InputNotice.addFail));
    }

    @Test
    public void should_show_add_success_page_when_input_legal_student_info() throws Exception {
        //given
        String addSuccess = String.format(InputNotice.addSuccess,"张三") + InputNotice.mainMenu;

        //when
        menu.chooseFunction("1");
        consoleLog.reset();
        menu.chooseFunction("张三, 000, 89, 78, 90, 84");

        //then
        assertThat(consoleLog.toString(), is(addSuccess));
    }

    @Test
    public void should_show_print_fail_page_when_id_illegal() throws Exception {
        //given
        menu.chooseFunction("2");

        //when
        consoleLog.reset();
        menu.chooseFunction("qww");

        //then
        assertThat(consoleLog.toString(), is(InputNotice.printFail));
    }

    @Test
    public void should_show_print_success_page_when_input_legal_print_request() throws Exception {
        //given
        menu.chooseFunction("1");
        menu.chooseFunction("张三, 000, 89, 78, 90, 84");
        menu.chooseFunction("2");

        String result = "\n成绩单\n"
                + "姓名|数学|语文|英语|编程|平均分|总分\n"
                + "========================\n"
                + "张三|89|78|90|84|85.25|341\n"
                + "========================\n"
                + "全班总平均分：85.250\n"
                + InputNotice.mainMenu;
        //when
        consoleLog.reset();
        menu.chooseFunction("000");

        //then
        assertThat(consoleLog.toString(), is(result));
    }


}
