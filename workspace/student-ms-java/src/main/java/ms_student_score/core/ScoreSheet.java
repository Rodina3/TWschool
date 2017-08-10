package ms_student_score.core;

import java.util.Map;

/**
 * Created by rzhou on 10/08/2017.
 */
public class ScoreSheet {
    private String id;
    private int math;
    private int chinese;
    private int english;
    private int coding;
    private int totalScore;
    private float average;

    public ScoreSheet() {
    }


    public String getId() {
        return id;
    }

    public void setGrade(ScoreSheet scoreSheet){
        this.chinese=getChinese();
        this.math=getMath();
        this.english=getEnglish();
        this.coding=getCoding();
        getTotalScore();
        getAverage();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public void setCoding(int coding) {
        this.coding = coding;
    }

    public int getMath() {
        return math;
    }

    public int getChinese() {
        return chinese;
    }

    public int getEnglish() {
        return english;
    }

    public int getCoding() {
        return coding;
    }





    public int getTotalScore() {
        this.totalScore = this.math + this.chinese + this.english + this.coding;
        return totalScore;
    }

    public float getAverage() {
        this.average = (float) (getTotalScore() / 4.0);
        return average;
    }
}
