package ms_student_score;

import ms_student_score.menu.Menu;
import ms_student_score.menu.MenuStatus;

import java.util.Scanner;


/**
 * Created by rzhou on 26/07/2017.
 */
public class App {


    public static void main(String[] args) {
        Menu menu = new Menu();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            menu.chooseFunction(sc.nextLine());

            if (menu.getMenuNow() == MenuStatus.EXIT_PAGE) break;
        }
        sc.close();
        System.exit(0);
    }

}
