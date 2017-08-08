package ms_student_score.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Report {
//    static String reportHeader = "\n成绩单\n"
//            + "姓名|数学|语文|英语|编程|平均分|总分\n"
//            + "========================\n";
//    static String reportSuffix = "========================\n";
//    static String klassAverage = "全班总平均分：%.3f\n";
//    static String klassMedian = "全班总分中位数：%.3f\n\n";
//
//    static String reportTemplate = reportHeader + "%s" + reportSuffix + klassAverage + klassMedian;


    private List<Student> studentItem = new ArrayList<>();
    private float average = 0;
    private float median = 0;

    public void setAverage(float average) {
        this.average = average;
    }

    public void setMedian(float median) {
        this.median = median;
    }

    public void setStudentItem(List<Student> studentItem) {
        this.studentItem = studentItem;
    }

    public List<Student> getStudentItem() {
        return studentItem;
    }

    public float getAverage() {
        return average;
    }

    public float getMedian() {
        return median;
    }


//    public String toString() {
//        return String.format(reportTemplate, this.studentItem, this.average, this.median);
//    }
}
