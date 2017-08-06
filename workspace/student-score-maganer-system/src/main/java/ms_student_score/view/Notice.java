package ms_student_score.view;

/**
 * Created by rzhou on 30/07/2017.
 */
public class Notice {
    public static String homePage = "欢迎进入学生成绩管理系统：\n"
            + "1. 添加学生 \n"
            + "2. 生成成绩单 \n"
            + "3. 退出 \n"
            + "请输入你的选择（1～3）：";

    public static String addRequest = "请输入学生信息（格式：姓名, 学号, 数学：分数, 语文：分数, 英语：分数, 编程：分数), 按回车提交:\n";
    public static String addFail = "请按正确的格式输入（格式：姓名, 学号, 数学：分数, 语文：分数, 英语：分数, 编程：分数）：\n";
    public static String addSuccess = "学生%s的成绩被添加\n\n";

    public static String printRequest = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n";
    public static String printFail = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n";
}
