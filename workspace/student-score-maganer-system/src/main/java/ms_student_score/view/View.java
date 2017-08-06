package ms_student_score.view;

import ms_student_score.core.Student;

/**
 * Created by rzhou on 06/08/2017.
 */
public class View {
    static String homePage = "欢迎进入学生成绩管理系统：\n"
            + "1. 添加学生 \n"
            + "2. 生成成绩单 \n"
            + "3. 退出 \n"
            + "请输入你的选择（1～3）：";

    static String addRequest = "请输入学生信息（格式：姓名, 学号, 数学：分数, 语文：分数, 英语：分数, 编程：分数), 按回车提交:\n";
    static String addFail = "请按正确的格式输入（格式：姓名, 学号, 数学：分数, 语文：分数, 英语：分数, 编程：分数）：\n";
    static String addSuccess = "学生%s的成绩被添加\n\n";

    static String printRequest = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n";
    static String printFail = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n";


    public void showHomePage() {
        System.out.print(homePage);
    }

    public void showAddRequestPage() {
        System.out.print(addRequest);
    }

    public void showAddFailPage() {
        System.out.print(addFail);
    }

    public void showAddSuccessPage(Student student) {
        System.out.print(String.format(addSuccess, student.getName()));

    }

    public void showPrintRequestPage() {
        System.out.print(printRequest);

    }

    public void showReportPage(String report) {
        System.out.print(report);
    }

    public void showPrintFailPage() {
        System.out.print(printFail);
    }
}
