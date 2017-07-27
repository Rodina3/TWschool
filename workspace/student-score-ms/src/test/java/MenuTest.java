import ms_student_score.Menu;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 27/07/2017.
 */
public class MenuTest {
    private static String mainMenu = "1. 添加学生 \n"
            + "2. 生成成绩单 \n"
            + "3. 退出 \n"
            + "请输入你的选择（1～3）：";
    private static String addFail = "请按正确的格式输入（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数）：\n";
    private static String addSuccess = "学生xxx的成绩被添加\n" + mainMenu;

    private static String printWaiting = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n";
    private static String printFail = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n";
    private Menu menu = new Menu();

    @Test
    public void should_change_to_addWaiting_menu_when_input_1() throws Exception {
        String addWaiting = "请输入学生信息（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提交\n";
        assertThat(menu.chooseMenu("1"), is(addWaiting));
    }

    @Test
    public void should_change_to_printWaiting_menu_when_input_2() throws Exception {
        assertThat(menu.chooseMenu("2"), is(printWaiting));
    }
}
