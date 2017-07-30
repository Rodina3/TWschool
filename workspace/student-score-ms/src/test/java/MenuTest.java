import ms_student_score.Menu;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 27/07/2017.
 */
public class MenuTest {
    private static String mainMenu = "欢迎进入学生成绩管理系统：\n"
            + "1. 添加学生 \n"
            + "2. 生成成绩单 \n"
            + "3. 退出 \n"
            + "请输入你的选择（1～3）：";

    private Menu menu = new Menu();

    @Test
    public void should_jump_into_addWaiting_menu_when_input_1() throws Exception {
        //given
        String addWaiting = "请输入学生信息（格式：姓名, 学号, 数学：分数, 语文：分数, 英语：分数, 编程：分数), 按回车提交:";

        assertThat(menu.chooseMenu("1"), is(addWaiting));
    }

    @Test
    public void should_jump_into_printWaiting_menu_when_input_2() throws Exception {
        //given
        String printWaiting = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";

        assertThat(menu.chooseMenu("2"), is(printWaiting));
    }

    @Test
    public void should_jump_into_addFail_submenu_when_input_illegal() throws Exception {
        //given
        String addFail = "请按正确的格式输入（格式：姓名, 学号, 数学：分数, 语文：分数, 英语：分数, 编程：分数）：";
        menu.chooseMenu("1");

        assertThat(menu.chooseMenu("ejjk"), is(addFail));
    }

    @Test
    public void should_jump_into_addFail_submenu_when_id_illegal() throws Exception {
        //given
        String addFail = "请按正确的格式输入（格式：姓名, 学号, 数学：分数, 语文：分数, 英语：分数, 编程：分数）：";
        menu.chooseMenu("1");

        assertThat(menu.chooseMenu("张三, , 89, 78, 90, 84"), is(addFail));
    }

    @Test
    public void should_jump_into_addFail_submenu_when_id_illegal2() throws Exception {
        //given
        String addFail = "请按正确的格式输入（格式：姓名, 学号, 数学：分数, 语文：分数, 英语：分数, 编程：分数）：";
        menu.chooseMenu("1");

        assertThat(menu.chooseMenu("张三, 000p, 89, 78, 90, 84"), is(addFail));
    }

    @Test
    public void should_jump_into_addSuccess_when_input_legal() throws Exception {
        //given
        String addSuccess = "学生xxx的成绩被添加\n" + mainMenu;
        menu.chooseMenu("1");

        assertThat(menu.chooseMenu("张三, 000, 89, 78, 90, 84"), is(addSuccess));
    }

    @Test
    public void should_jump_into_printFail_submenu_when_input_illegal() throws Exception {
        //given
        String printFail = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
        menu.chooseMenu("2");
        assertThat(menu.chooseMenu("qww"), is(printFail));
    }

    @Test
    public void should_jump_into_printSuccess_when_input_legal() throws Exception {
        //given
        menu.chooseMenu("2");
        assertThat(menu.chooseMenu("000"), is(mainMenu));
    }


}
