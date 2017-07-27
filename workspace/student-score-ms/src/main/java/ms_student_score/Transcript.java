package ms_student_score;

import java.util.List;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Transcript {

    private Klass klass;

    public Transcript(Klass klass) {
        this.klass = klass;
    }

    public String buildStudentItems(List<String> studentIDs) {
        StringBuilder studentItem = new StringBuilder();
        for (int i = 0; i < studentIDs.size(); i++) {
            int index = findStudent(studentIDs.get(i));
            if (i > 0)
                studentItem.append("\n");
            studentItem.append(klass.getKlassScores().get(i).getName()).append("|")
                    .append(klass.getKlassScores().get(i).getMath()).append("|")
                    .append(klass.getKlassScores().get(i).getChinese()).append("|")
                    .append(klass.getKlassScores().get(i).getEnglish()).append("|")
                    .append(klass.getKlassScores().get(i).getCoding()).append("|")
                    .append(klass.getKlassScores().get(i).getAverage()).append("|")
                    .append(klass.getKlassScores().get(i).getTotalScore());

        }
        return studentItem.toString();

    }

    private int findStudent(String id) {
        int index;
        for (int i = 0; i < klass.getKlassScores().size(); i++) {
            if (id == klass.getKlassScores().get(i).getID()) {
                index = i;
                break;
            }

        }
        index = -1;
        return index;
    }
}
