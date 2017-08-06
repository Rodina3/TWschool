package ms_student_score.controller;

import ms_student_score.core.Manager;
import ms_student_score.core.Student;
import ms_student_score.view.CurrentStatus;
import ms_student_score.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by rzhou on 06/08/2017.
 */
public class Controller {
    private Manager manager = new Manager();
    private CurrentStatus statusNow = CurrentStatus.HOME_PAGE;

    private boolean isLegalAddRequest(String input) {
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

    private boolean isLegalName(String str) {
        boolean flag = false;
        if (str.length() != 0) {
            flag = true;
        }
        return flag;
    }

    private boolean isLegalID(String str) {

        boolean flag = false;
        if (str.length() != 0 && str.matches("\\d{3}")) {
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

    private Student parseAddCommand(String str) {
        String[] studentInfo = str.split(", ");
        String name = studentInfo[0],
                id = studentInfo[1];
        int math = Integer.parseInt(studentInfo[2]),
                chinese = Integer.parseInt(studentInfo[3]),
                english = Integer.parseInt(studentInfo[4]),
                coding = Integer.parseInt(studentInfo[5]);
        return new Student(name, id, math, chinese, english, coding);
    }

    private List<String> parsePrintCommand(String str) {
        String[] ids = str.split(", ");
        List<String> studentIDs = new ArrayList<String>();
        studentIDs.addAll(Arrays.asList(ids));
        return studentIDs;
    }

    public void commandMapping(String command) {
        switch (statusNow) {
            case HOME_PAGE:
                switch (command) {
                    case "1":
                        statusNow = CurrentStatus.ADD_REQUEST_PAGE;
                        View.showAddRequestPage();
                        break;
                    case "2":
                        statusNow = CurrentStatus.PRINT_REQUEST_PAGE;
                        View.showPrintRequestPage();
                        break;

                    case "3":
                        statusNow = CurrentStatus.EXIT_PAGE;
                        break;
                    default:
                        break;
                }
                break;
            case ADD_REQUEST_PAGE:
            case ADD_FAIL_PAGE:
                if (isLegalAddRequest(command)) {
                    statusNow = CurrentStatus.HOME_PAGE;
                    manager.addStudent(parseAddCommand(command));
                    View.showHomePage();
                } else {
                    statusNow = CurrentStatus.ADD_FAIL_PAGE;
                    View.showAddFailPage();
                }
                break;
            case PRINT_REQUEST_PAGE:
            case PRINT_FAIL_PAGE:
                if (isLegalPrintRequest(command)) {
                    statusNow = CurrentStatus.HOME_PAGE;
                    manager.buildReport(parsePrintCommand(command));
                    View.showHomePage();
                } else {
                    statusNow = CurrentStatus.PRINT_FAIL_PAGE;
                    View.showPrintFailPage();
                }
                break;
        }
    }

    public CurrentStatus getStatusNow() {
        return this.statusNow;
    }
}
