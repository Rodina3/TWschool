package ms_student_score;

import java.util.List;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Transcript {
    static String transcriptBegin = "成绩单\n"
            + "姓名|数学|语文|英语|编程|平均分|总分 \n"
            + "========================\n";

    static String transcripteEnding = "========================\n"
            + "全班总平均分：xxx\n"
            + "全班总分中位数：xxx";

    private Klass klass =null;
    private String studentScoresItem = "";

    public Transcript(Klass klass) {
        this.klass = klass;
    }

    public String buildStudentItems(List<String> studentIDs) {
        StringBuilder studentItem = new StringBuilder();

        for (int i = 0; i < studentIDs.size(); i++) {
            int index = findStudent(studentIDs.get(i));

            if (index == -1) {
                continue;
            }

            studentItem.append(klass.getKlassScores().get(index).getName()).append("|")
                    .append(klass.getKlassScores().get(index).getMath()).append("|")
                    .append(klass.getKlassScores().get(index).getChinese()).append("|")
                    .append(klass.getKlassScores().get(index).getEnglish()).append("|")
                    .append(klass.getKlassScores().get(index).getCoding()).append("|")
                    .append(klass.getKlassScores().get(index).getAverage()).append("|")
                    .append(klass.getKlassScores().get(index).getTotalScore()).append("\n");

        }
        this.studentScoresItem += studentItem.toString();

        return studentItem.toString();

    }

    private int findStudent(String id) {
        int index=-1;
        for (int i = 0; i < klass.getKlassScores().size(); i++) {
            if (id == klass.getKlassScores().get(i).getID()) {
                index = i;
                break;
            }

        }
        return index;
    }


    public String buildTranscript(List<String> studentIDs) {
        buildStudentItems(studentIDs);
        String transcriptString = this.transcriptBegin + this.studentScoresItem + this.transcripteEnding;
        return transcriptString;
    }
}
