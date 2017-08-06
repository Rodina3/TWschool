package ms_student_score.view;

import ms_student_score.core.Report;
import ms_student_score.core.Klass;
import ms_student_score.core.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Created by rzhou on 27/07/2017.
 */
public class CommandManager {

    private CurrentStatus menuNow = CurrentStatus.HOME_PAGE;
    private Klass klass = new Klass();

    public CommandManager() {
        System.out.print(InputNotice.mainMenu);
        ;
    }

    //public analyzeCommand(){}
    //public excuteCommand(){}

    public void chooseFunction(String input) {
        refreshMenu(input);
        showInputNotice();
    }

    public CurrentStatus getMenuNow() {
        return menuNow;
    }


    private void refreshMenu(String input) {

        if (Objects.equals(menuNow, CurrentStatus.HOME_PAGE) || Objects.equals(menuNow, CurrentStatus.ADD_SUCCESS_PAGE)) {
            if (Objects.equals(input, "1")) {
                menuNow = CurrentStatus.ADD_REQUEST_PAGE;
            } else if (Objects.equals(input, "2")) {
                menuNow = CurrentStatus.PRINT_REQUEST_PAGE;

            } else if (Objects.equals(input, "3")) {
                menuNow = CurrentStatus.EXIT_PAGE;
            } else {
                menuNow = CurrentStatus.HOME_PAGE;
            }
        } else if (Objects.equals(menuNow, CurrentStatus.ADD_REQUEST_PAGE) || Objects.equals(menuNow, CurrentStatus.ADD_FAIL_PAGE)) {
            if (isLegalStudentInfo(input)) {
                klass.addStudent(analyzeStudent(input));

                InputNotice.addSuccess = String.format(InputNotice.addSuccess, analyzeStudent(input).getName());
                menuNow = CurrentStatus.ADD_SUCCESS_PAGE;

            } else {
                menuNow = CurrentStatus.ADD_FAIL_PAGE;
            }

        } else if (Objects.equals(menuNow, CurrentStatus.PRINT_REQUEST_PAGE) || Objects.equals(menuNow, CurrentStatus.PRINT_FAIL_PAGE)) {

            if (isLegalPrintRequest(input)) {
                Report reprot = new Report(klass);
                String[] ids = input.split(", ");
                List<String> studentIDs = new ArrayList<String>();

                for (int i = 0; i < ids.length; i++) {
                    studentIDs.add(ids[i]);

                }
                System.out.print(reprot.buildReport(studentIDs));
                menuNow = CurrentStatus.HOME_PAGE;
            } else {
                menuNow = CurrentStatus.PRINT_FAIL_PAGE;
            }

        }
    }

    private boolean isLegalStudentInfo(String input) {
        boolean isLegal = false;
        String[] studentInfo = input.split(", ");

        if (studentInfo.length == 6) {
            isLegal = isLegalName(studentInfo[0])
                    && isLegalID(studentInfo[1])
                    && isLegalScore(studentInfo[2])
                    && isLegalScore(studentInfo[3])
                    && isLegalScore(studentInfo[4])
                    && isLegalScore(studentInfo[5]);
        }

        return isLegal;
    }

    private void showInputNotice() {
        String notice = "";
        switch (menuNow) {
            case HOME_PAGE:
                notice = InputNotice.mainMenu;
                break;
            case ADD_REQUEST_PAGE:
                notice = InputNotice.addWaiting;
                break;
            case ADD_FAIL_PAGE:
                notice = InputNotice.addFail;
                break;
            case ADD_SUCCESS_PAGE:
                notice = InputNotice.addSuccess + InputNotice.mainMenu;
                break;
            case PRINT_REQUEST_PAGE:
                notice = InputNotice.printWaiting;
                break;
            case PRINT_FAIL_PAGE:
                notice = InputNotice.printFail;
                break;
        }
        System.out.print(notice);
        InputNotice.addSuccess = "学生%s的成绩被添加\n\n";
    }

    private boolean isLegalID(String str) {

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
            flag = flag && isLegalID(ids[i]);

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


        return new Student(name, id, math, chinese, english, coding);
    }

}