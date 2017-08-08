package ms_student_score.core;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Student {
    private String name;
    private String id;
    private Map<String, Integer> scores = new LinkedHashMap<>();

    private int totalScore;
    private float average;
    public Student(){};

    public Student(String name, String id, int math, int chinese, int english, int coding) {
        this.name = name;
        this.id = id;

        scores.put("数学", math);
        scores.put("语文", chinese);
        scores.put("英语", english);
        scores.put("编程", coding);


        this.totalScore = scores.get("数学") + scores.get("语文") + scores.get("英语") + scores.get("编程");
        this.average = (float) (this.totalScore / 4.0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setScores(Map<String, Integer> scores) {
        this.scores = scores;
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.id;
    }

    public Map<String, Integer> getScores() {
        return this.scores;
    }

    public int getTotalScore() {
        this.totalScore = scores.get("数学") + scores.get("语文") + scores.get("英语") + scores.get("编程");
        return this.totalScore;
    }

    public float getAverage() {
        getTotalScore();
        this.average = (float) (this.totalScore / 4.0);
        return this.average;
    }
}
