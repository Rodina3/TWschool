package ms_student_score.view;

import ms_student_score.core.Student;

/**
 * Created by rzhou on 06/08/2017.
 */
public class View {

    public static void showHomePage() {
        System.out.print(Notice.homePage);
    }

    public static void showAddRequestPage() {
        System.out.print(Notice.addRequest);
    }

    public static void showAddFailPage() {
        System.out.print(Notice.addFail);
    }

    public static void showAddSuccessPage(Student student) {
        System.out.print(String.format(Notice.addSuccess, student.getName()));

    }

    public static void showPrintRequestPage() {
        System.out.print(Notice.printRequest);

    }

    public static void showReportPage(String report) {
        System.out.print(report);
    }

    public static void showPrintFailPage() {
        System.out.print(Notice.printFail);
    }
}
