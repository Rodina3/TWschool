package ms_student_score.core;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Student {
    private String name;
    private String id;
    private String email;
    private String phone;
    private Map<String, Integer> scores = new LinkedHashMap<>();

    private int totalScore;
    private float average;

    public Student() {
    }


    public Student(String name, String id, int math, int chinese, int english, int coding) {
        this.name = name;
        this.id = id;

        scores.put("math", math);
        scores.put("chinese", chinese);
        scores.put("english", english);
        scores.put("coding", coding);


        this.totalScore = scores.get("math") + scores.get("chinese") + scores.get("coding") + scores.get("english");
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

    public String getId() {
        return this.id;
    }

    public Map<String, Integer> getScores() {
        return this.scores;
    }


    public int getTotalScore() {
        this.totalScore = scores.get("math") + scores.get("chinese") + scores.get("english") + scores.get("coding");
        return this.totalScore;
    }

    public float getAverage() {
        getTotalScore();
        this.average = (float) (this.totalScore / 4.0);
        return this.average;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
