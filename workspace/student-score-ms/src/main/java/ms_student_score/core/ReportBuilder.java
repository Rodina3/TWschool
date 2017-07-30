package ms_student_score.core;

import java.util.List;

/**
 * Created by rzhou on 27/07/2017.
 */
public class ReportBuilder {
    static String reportPrefix = "\n成绩单\n"
            + "姓名|数学|语文|英语|编程|平均分|总分\n"
            + "========================\n";

    static String reportSuffix = "========================\n";

    private Klass klass = null;
    private String studentScoresItem = "";
    private String klassAverageString = "全班总平均分：%.3f\n";
    private String klassMString = " 全班总分中位数：%d\n";

    public ReportBuilder(Klass klass) {
        this.klass = klass;
    }

    private void buildStudentItems(List<String> studentIDs) {
        StringBuilder studentItem = new StringBuilder();

        for (int i = 0; i < studentIDs.size(); i++) {
            int index = findStudent(studentIDs.get(i));

            if (index == -1) {
                continue;
            }

            studentItem.append(klass.getStudentList().get(index).getName()).append("|")
                    .append(klass.getStudentList().get(index).getScores().get("数学")).append("|")
                    .append(klass.getStudentList().get(index).getScores().get("语文")).append("|")
                    .append(klass.getStudentList().get(index).getScores().get("英语")).append("|")
                    .append(klass.getStudentList().get(index).getScores().get("编程")).append("|")
                    .append(klass.getStudentList().get(index).getAverage()).append("|")
                    .append(klass.getStudentList().get(index).getTotalScore()).append("\n");

        }
        this.studentScoresItem = studentItem.toString();

    }

    private int findStudent(String id) {
        int index = -1;
        for (int i = 0; i < klass.getStudentList().size(); i++) {
            if (id .equals(klass.getStudentList().get(i).getID())) {
                index = i;
                break;
            }

        }
        return index;
    }

    public String buildReport(List<String> studentIDs) {
        buildStudentItems(studentIDs);
        buildAverageItem();

        String report = reportPrefix
                                + this.studentScoresItem
                                + reportSuffix
                                + this.klassAverageString;
        return report;
    }

    private void buildAverageItem() {
        this.klassAverageString=String.format(this.klassAverageString,this.klass.getKlassAverage());
    }

    private void buildM() {

    }
}
