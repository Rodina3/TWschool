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
    /*private static String mainMenu = "欢迎进入学生成绩管理系统：\n"
            + "1. 添加学生 \n"
            + "2. 生成成绩单 \n"
            + "3. 退出 \n"
            + "请输入你的选择（1～3）：\n";*/

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
    public void should_jump_into_addWaiting_menu_when_input_1() throws Exception {
        //given

        //when
        consoleLog.reset();
        menu.chooseMenu("1");

        //then
        assertThat(consoleLog.toString(), is(InputNotice.addWaiting));
    }

    @Test
    public void should_jump_into_printWaiting_menu_when_input_2() throws Exception {
        //given
        //when
        consoleLog.reset();
        menu.chooseMenu("2");

        //then
        assertThat(consoleLog.toString(), is(InputNotice.printWaiting));
    }

    @Test
    public void should_jump_into_addFail_submenu_when_input_illegal() throws Exception {
        //given
        //when
        menu.chooseMenu("1");
        consoleLog.reset();
        menu.chooseMenu("ejjk");

        //then
        assertThat(consoleLog.toString(), is(InputNotice.addFail));
    }

    @Test
    public void should_jump_into_addFail_submenu_when_id_illegal() throws Exception {
        //given
        //when
        menu.chooseMenu("1");
        consoleLog.reset();
        menu.chooseMenu("张三, , 89, 78, 90, 84");

        //then
        assertThat(consoleLog.toString(), is(InputNotice.addFail));
    }

    @Test
    public void should_jump_into_addFail_submenu_when_id_illegal2() throws Exception {
        //given
        //when
        menu.chooseMenu("1");
        consoleLog.reset();
        menu.chooseMenu("张三, 000p, 89, 78, 90, 84");

        //then
        assertThat(consoleLog.toString(), is(InputNotice.addFail));
    }

    @Test
    public void should_jump_into_addSuccess_when_input_legal() throws Exception {
        //given
        String addSuccess = "学生xxx的成绩被添加\n" + InputNotice.mainMenu;

        //when
        menu.chooseMenu("1");
        consoleLog.reset();
        menu.chooseMenu("张三, 000, 89, 78, 90, 84");

        //then
        assertThat(consoleLog.toString(), is(addSuccess));
    }

    @Test
    public void should_jump_into_printFail_submenu_when_input_illegal() throws Exception {
        //given
        menu.chooseMenu("2");

        //when
        consoleLog.reset();
        menu.chooseMenu("qww");

        //then
        assertThat(consoleLog.toString(), is(InputNotice.printFail));
    }

    @Test
    public void should_jump_into_printSuccess_when_input_legal() throws Exception {
        //given
        menu.chooseMenu("1");
        menu.chooseMenu("张三, 000, 89, 78, 90, 84");
        menu.chooseMenu("2");

        String result = "成绩单\n"
                + "姓名|数学|语文|英语|编程|平均分|总分\n"
                + "========================\n"
                + "张三|89|78|90|84|85.25|341\n"
                + "========================\n"
                + "全班总平均分：85.25\n"
                + InputNotice.mainMenu;
        //when
        consoleLog.reset();
        menu.chooseMenu("000");

        //then
        assertThat(consoleLog.toString(), is(result));
    }


}
