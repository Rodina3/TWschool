package ms_student_score.service;

import ms_student_score.core.Klass;
import ms_student_score.core.Report;
import ms_student_score.core.ReportBuilder;
import ms_student_score.core.Student;
import ms_student_score.view.*;

import java.util.List;

/**
 * Created by rzhou on 06/08/2017.
 */
public class Manager {
    Klass klass = new Klass();
    ReportBuilder reportBuilder = new ReportBuilder();

    public void addStudent(Student student) {
        klass.addStudent(student);
    }

    public Klass getKlass() {
        return klass;
    }

    public Report buildReport(List<String> studentIds)
    {
        Report report = reportBuilder.buildReport(studentIds, this.klass);
        return report;
    }
}
