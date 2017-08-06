package ms_student_score;

import ms_student_score.controller.Controller;
import ms_student_score.view.CurrentStatus;
import ms_student_score.view.View;

import java.util.Scanner;


/**
 * Created by rzhou on 26/07/2017.
 */
public class App {


    public static void main(String[] args) {
        Controller controller=new Controller();
        View.showHomePage();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            controller.commandMapping(sc.nextLine());
            if (controller.getStatusNow() == CurrentStatus.EXIT_PAGE) break;
        }
        sc.close();
        System.exit(0);
    }

}
