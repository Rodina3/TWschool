package ms_student_score;

import ms_student_score.controller.Controller;
import ms_student_score.view.CurrentStatus;
import ms_student_score.view.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


/**
 * Created by rzhou on 26/07/2017.
 */
@SpringBootApplication
public class App {


//    public static void main(String[] args) {
//        Controller controller=new Controller();
//        View.showHomePage();
//
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            controller.commandMapping(sc.nextLine());
//            if (controller.getStatusNow() == CurrentStatus.EXIT_PAGE) break;
//        }
//        sc.close();
//        System.exit(0);
//    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
