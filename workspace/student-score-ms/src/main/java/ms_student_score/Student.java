package ms_student_score;

import java.util.regex.Pattern;

/**
 * Created by rzhou on 26/07/2017.
 */
public class Student {

    private String name;
    private String studentNumber;
    private int math;
    private int chinese;
    private int english;
    private int coding;
    private float average;
    private int totalScore;


    public String getName() {
        return this.name;
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }

    public int getMath() {
        return this.math;
    }

    public int getChinese() {
        return this.chinese;
    }

    public int getCoding() {
        return this.coding;
    }

    public int getEnglish() {
        return this.english;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    public float getAverage() {
        return this.average;
    }

    public boolean isLegalInput(String input) {
        String[] str = input.split(" ");
        boolean legalStudent = (str.length == 6)
                && (isLeagalScore(str[2]))
                && (isLeagalScore(str[3]))
                && (isLeagalScore(str[4]))
                && (isLeagalScore(str[5]));

        return legalStudent;
    }


    private boolean isLeagalScore(String str) {
        return (isDigit(str) && Integer.parseInt(str) <= 100) && (Integer.parseInt(str) >= 0);

    }

    private boolean isDigit(String str) {

        Pattern pattern = Pattern.compile("[0-9]+");

        return pattern.matcher(str).matches();
    }


    public void appendScore(String input) {
        String[] str = input.split(" ");

        this.name = str[0];
        this.studentNumber = str[1];
        this.math = Integer.parseInt(str[2]);
        this.chinese = Integer.parseInt(str[3]);
        this.english = Integer.parseInt(str[4]);
        this.coding = Integer.parseInt(str[5]);
        this.totalScore = this.math + this.coding + this.chinese + this.english;
        this.average = (float) (totalScore / 4.0);

    }

}