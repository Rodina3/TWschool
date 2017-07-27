package ms_student_score;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Menu {

    private static String mainMenu = "1. 添加学生 \n"
            + "2. 生成成绩单 \n"
            + "3. 退出 \n"
            + "请输入你的选择（1～3）：";
    private static String addWaiting = "请输入学生信息（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提交\n";
    private static String addFail = "请按正确的格式输入（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数）：\n";
    private static String addSuccess = "学生xxx的成绩被添加\n" + mainMenu;

    private static String printWaiting = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n";
    private static String printFail = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n";

    private Integer mainM = 0;
    private final Integer addM = 1;
    private final Integer addFailM = 2;
    private final Integer addSuccessM = 3;
    private final Integer printM = 4;
    private final Integer printFailM = 5;


    //  private Map<Integer, String> menuInfo = new HashMap<Integer, String>();
    private Integer menuNow = mainM;

    public String chooseMenu(String input) {
        menuManager(input);
        return showMenu();
    }

    private String showMenu() {
        String output = "";
        switch (menuNow) {
            case 0:
                output = mainMenu;
                break;
            case 1:
                output = addWaiting;
                break;
            case 2:
                output = addFail;
                break;
            case 3:
                output = addSuccess;
                break;
            case 4:
                output = printWaiting;
                break;
            case 5:
                output = printFail;
                break;
        }
        return output;
    }


    private void menuManager(String input) {
        if (Objects.equals(input, "1")) {
            menuNow = addM;
            //-->add student submenu

        } else if (Objects.equals(input, "2")) {
            menuNow = printM;
            //-->print submenu

        } else if (Objects.equals(input, "3")) {

            //-->quit

        } else {

            //do nothing
        }


    }
}
