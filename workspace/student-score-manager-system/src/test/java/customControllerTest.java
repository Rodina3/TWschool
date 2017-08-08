import ms_student_score.controller.CustomController;

import ms_student_score.view.Notice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 *  Created by rzhou on 27/07/2017.
 */

public class customControllerTest {

    private CustomController commandManager = new CustomController();
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
        commandManager.commandMapping("1");

        //then
        assertThat(consoleLog.toString(), is(Notice.addRequest));
    }

    @Test
    public void should_show_print_report_page_when_input_2() throws Exception {
        //given
        //when
        consoleLog.reset();
        commandManager.commandMapping("2");

        //then
        assertThat(consoleLog.toString(), is(Notice.printRequest));
    }

    @Test
    public void should_show_add_fail_page_when_student_score_input_format_illegal() throws Exception {
        //given
        //when
        commandManager.commandMapping("1");
        consoleLog.reset();
        commandManager.commandMapping("ejjk");

        //then
        assertThat(consoleLog.toString(), is(Notice.addFail));
    }

    @Test
    public void should_show_add_fail_page_when_id_empty() throws Exception {
        //given
        //when
        commandManager.commandMapping("1");
        consoleLog.reset();
        commandManager.commandMapping("张三, , 89, 78, 90, 84");

        //then
        assertThat(consoleLog.toString(), is(Notice.addFail));
    }

    @Test
    public void should_show_add_fail_page_when_id_illegal() throws Exception {
        //given
        //when
        commandManager.commandMapping("1");
        consoleLog.reset();
        commandManager.commandMapping("张三, 000p, 89, 78, 90, 84");

        //then
        assertThat(consoleLog.toString(), is(Notice.addFail));
    }

    @Test
    public void should_show_add_success_page_when_input_legal_student_info() throws Exception {
        //given
        String addSuccess = String.format(Notice.addSuccess,"张三") + Notice.homePage;

        //when
        commandManager.commandMapping("1");
        consoleLog.reset();
        commandManager.commandMapping("张三, 000, 89, 78, 90, 84");

        //then
        assertThat(consoleLog.toString(), is(addSuccess));


        String addSuceess2 = String.format(Notice.addSuccess,"李四")+ Notice.homePage;
        commandManager.commandMapping("1");
        consoleLog.reset();
        commandManager.commandMapping("李四, 001, 90, 90, 90, 90");
        assertThat(consoleLog.toString(),is(addSuceess2));
    }

    @Test
    public void should_show_print_fail_page_when_id_illegal() throws Exception {
        //given
        commandManager.commandMapping("2");

        //when
        consoleLog.reset();
        commandManager.commandMapping("qww");

        //then
        assertThat(consoleLog.toString(), is(Notice.printFail));
    }

    @Test
    public void should_show_print_success_page_when_input_legal_print_request() throws Exception {
        //given
        commandManager.commandMapping("1");
        commandManager.commandMapping("张三, 000, 89, 78, 90, 84");
        commandManager.commandMapping("2");

        String result = "\n成绩单\n"
                + "姓名|数学|语文|英语|编程|平均分|总分\n"
                + "========================\n"
                + "张三|89|78|90|84|85.25|341\n"
                + "========================\n"
                + "全班总平均分：85.250\n"
                +"全班总分中位数：341.000\n\n"
                + Notice.homePage;
        //when
        consoleLog.reset();
        commandManager.commandMapping("000");

        //then
        assertThat(consoleLog.toString(), is(result));
    }


}
