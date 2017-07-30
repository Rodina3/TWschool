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




    private MenuStatus menuNow = MenuStatus.MAIN_MENU;
    private Klass klass = new Klass();

    public Menu() {
        showMenu();
    }

    public void chooseMenu(String input) {
        refreshMenu(input);
        showMenu();
    }

    private void showMenu() {
        String output = "";
        switch (menuNow) {
            case MAIN_MENU:
                output = InputNotice.mainMenu;
                break;
            case ADD_REQUEST_MENU:
                output = InputNotice.addWaiting;
                break;
            case ADD_FAIL_MENU:
                output = InputNotice.addFail;
                break;
            case ADD_SUCCESS_MENU:
                output = InputNotice.addSuccess;
                break;
            case PRINT_REQUEST_MENU:
                output = InputNotice.printWaiting;
                break;
            case PRINT_FAIL_MENU:
                output = InputNotice.printFail;
                break;
        }
        System.out.print(output);
    }


    private void refreshMenu(String input) {
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
                System.out.print(reprot.buildTranscript(studentIDs));
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
