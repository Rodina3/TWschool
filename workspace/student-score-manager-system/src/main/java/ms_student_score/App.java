package ms_student_score;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by rzhou on 26/07/2017.
 */
@SpringBootApplication
public class App {


//    public static void main(String[] args) {
//        CustomController controller=new CustomController();
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

    //spring入口
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
