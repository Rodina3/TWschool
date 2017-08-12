package ms_student_score.view;

import ms_student_score.core.Report;
import ms_student_score.core.Scores;
import ms_student_score.core.Student;

/**
 * Created by rzhou on 06/08/2017.
 */
public class CommandView {

    public static void showHomePage() {
        System.out.print(Notice.homePage);
    }

    public static void showAddRequestPage() {
        System.out.print(Notice.addRequest);
    }

    public static void showAddFailPage() {
        System.out.print(Notice.addFail);
    }

    public static void showAddSuccessPage(Scores scores) {
        System.out.print(String.format(Notice.addSuccess, scores.getName()));

    }

    public static void showPrintRequestPage() {
        System.out.print(Notice.printRequest);

    }

    public static void showReportPage(Report report) {
        String studentItems = "";
        for (int i = 0; i < report.getStudentScoreItem().size(); i++) {
            studentItems += String.format("%s|%d|%d|%d|%d|%.2f|%d\n",
                    report.getStudentScoreItem().get(i).getName(),
                    report.getStudentScoreItem().get(i).getMath(),
                    report.getStudentScoreItem().get(i).getChinese(),
                    report.getStudentScoreItem().get(i).getEnglish(),
                    report.getStudentScoreItem().get(i).getCoding(),
                    report.getStudentScoreItem().get(i).getAverage(),
                    report.getStudentScoreItem().get(i).getTotalScore());
        }

        String str = String.format(Notice.printReport, studentItems, report.getAverage(), report.getMedian());
        System.out.print(str);
    }

    public static void showPrintFailPage() {
        System.out.print(Notice.printFail);
    }
}
