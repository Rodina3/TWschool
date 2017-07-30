package ms_student_score.core;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Student {
    private String name;
    private String id;
    private int math;
    private int chinese;
    private int english;
    private int coding;
    private int totalScore;
    private float average;

    public Student(String name, String id, int math, int chinese, int english, int coding) {
        this.name = name;
        this.id = id;
        this.math = math;
        this.chinese = chinese;
        this.english = english;
        this.coding = coding;

        this.totalScore = this.math + this.chinese + this.english + this.coding;
        this.average = (float) (this.totalScore / 4.0);
    }


    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.id;
    }

    public int getMath() {
        return this.math;
    }

    public int getChinese() {
        return this.chinese;
    }

    public int getEnglish() {
        return this.english;
    }

    public int getCoding() {
        return this.coding;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    public float getAverage() {
        return this.average;
    }
}
