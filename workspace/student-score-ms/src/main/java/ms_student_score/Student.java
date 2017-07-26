package ms_student_score;

import java.util.regex.Pattern;

/**
 * Created by rzhou on 26/07/2017.
 */
public class Student {

    public boolean isIllegal(String input) {
        String[] str = input.split(" ");
        boolean legalStudent = (str.length == 6)
                && (isStudentNumberLegal(str[1]))
                && (isLeagalScore(str[2]))
                && (isLeagalScore(str[3]))
                && (isLeagalScore(str[4]))
                && (isLeagalScore(str[5]));

         return legalStudent;
    }


    private boolean isStudentNumberLegal(String str) {
        return (isDigit(str));

    }

    private boolean isLeagalScore(String str) {
        return (isDigit(str) && Integer.parseInt(str) <= 100) && (Integer.parseInt(str) >= 0);

    }

    private boolean isDigit(String str) {

        Pattern pattern = Pattern.compile("[0-9]+");

        return pattern.matcher(str).matches();
    }


}