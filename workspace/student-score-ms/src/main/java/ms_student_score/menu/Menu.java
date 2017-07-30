package ms_student_score.menu;

import ms_student_score.core.BuildReport;
import ms_student_score.core.Klass;
import ms_student_score.core.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Menu {

    private static String mainMenu = "欢迎进入学生成绩管理系统：\n"
            + "1. 添加学生 \n"
            + "2. 生成成绩单 \n"
            + "3. 退出 \n"
            + "请输入你的选择（1～3）：";

    private static String addWaiting = "请输入学生信息（格式：姓名, 学号, 数学：分数, 语文：分数, 英语：分数, 编程：分数), 按回车提交:";
    private static String addFail = "请按正确的格式输入（格式：姓名, 学号, 数学：分数, 语文：分数, 英语：分数, 编程：分数）：";
    private static String addSuccess = "学生xxx的成绩被添加\n" + mainMenu;

    private static String printWaiting = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
    private static String printFail = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";


    private MenuStatus menuNow = MenuStatus.MAIN_MENU;
    private Klass klass = new Klass();

    public Menu() {
        showMenu();
    }

    public String chooseMenu(String input) {
        menuChange(input);
        return showMenu();
    }

    private String showMenu() {
        String output = "";
        switch (menuNow) {
            case MAIN_MENU:
                output = mainMenu;
                break;
            case ADD_REQUEST_MENU:
                output = addWaiting;
                break;
            case ADD_FAIL_MENU:
                output = addFail;
                break;
            case ADD_SUCCESS_MENU:
                output = addSuccess;
                break;
            case PRINT_REQUEST_MENU:
                output = printWaiting;
                break;
            case PRINT_FAIL_MENU:
                output = printFail;
                break;
        }
        System.out.println(output);
        return output;
    }


    private void menuChange(String input) {
        if (Objects.equals(menuNow, MenuStatus.MAIN_MENU) || Objects.equals(menuNow, MenuStatus.ADD_SUCCESS_MENU)) {
            if (Objects.equals(input, "1")) {
                menuNow = MenuStatus.ADD_REQUEST_MENU;
                //-->add student submenu

            } else if (Objects.equals(input, "2")) {
                menuNow = MenuStatus.PRINT_REQUEST_MENU;
                //-->print submenu

            } else if (Objects.equals(input, "3")) {
                menuNow = MenuStatus.EXIT_MENU;
                //-->quit

            } else {
                //do nothing
                menuNow = MenuStatus.MAIN_MENU;
            }
        } else if (Objects.equals(menuNow, MenuStatus.ADD_REQUEST_MENU) || Objects.equals(menuNow, MenuStatus.ADD_FAIL_MENU)) {
            if (isLegalStudentInfo(input)) {
                //add student
                klass.addStudent(analyzeStudent(input));
                menuNow = MenuStatus.ADD_SUCCESS_MENU;
            } else {
                menuNow = MenuStatus.ADD_FAIL_MENU;
            }

        } else if (Objects.equals(menuNow, MenuStatus.PRINT_REQUEST_MENU) || Objects.equals(menuNow, MenuStatus.PRINT_FAIL_MENU)) {
            if (isLegalPrintRequest(input)) {
                //print transcript
                BuildReport reprot = new BuildReport(klass);
                String[] ids = input.split(", ");
                List<String> studentIDs = new ArrayList<String>();
                for (int i = 0; i < ids.length; i++) {
                    studentIDs.add(ids[i]);

                }
                System.out.println(reprot.buildTranscript(studentIDs));
                menuNow = MenuStatus.MAIN_MENU;
            } else {
                menuNow = MenuStatus.PRINT_FAIL_MENU;
            }

        }
    }

    private boolean isLegalStudentInfo(String input) {
        boolean isLegal = false;
        String[] studentInfo = input.split(", ");

        if (studentInfo.length == 6) {
            isLegal = isLegalName(studentInfo[0])
                    && isLegalId(studentInfo[1])
                    && isLegalScore(studentInfo[2])
                    && isLegalScore(studentInfo[3])
                    && isLegalScore(studentInfo[4])
                    && isLegalScore(studentInfo[5]);
        }

        return isLegal;
    }

    private boolean isLegalId(String str) {

        boolean flag = false;
        if (str.length() != 0 && str.matches("\\d{3}")) {
            flag = true;
        }
        return flag;
    }

    private boolean isLegalName(String str) {
        boolean flag = false;
        if (str.length() != 0) {
            flag = true;

        }
        return flag;
    }

    private boolean isLegalScore(String str) {
        Pattern legalScore = Pattern.compile("[0-9]{1,3}");
        return legalScore.matcher(str).find() && Integer.parseInt(str) <= 100 && Integer.parseInt(str) >= 0;
    }

    private boolean isLegalPrintRequest(String str) {
        String[] ids = str.split(", ");
        boolean flag = true;
        for (int i = 0; i < ids.length; i++) {
            flag = flag && isLegalId(ids[i]);

        }
        return flag;
    }

    private Student analyzeStudent(String str) {
        String[] studentInfo = str.split(", ");
        String name = studentInfo[0],
                id = studentInfo[1];
        int math = Integer.parseInt(studentInfo[2]),
                chinese = Integer.parseInt(studentInfo[3]),
                english = Integer.parseInt(studentInfo[4]),
                coding = Integer.parseInt(studentInfo[5]);


        Student stu = new Student(name, id, math, chinese, english, coding);

        return stu;
    }

    public MenuStatus getMenuNow() {
        return menuNow;
    }
}
