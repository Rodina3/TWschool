package ms_student_score;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;


/**
 * Created by rzhou on 26/07/2017.
 */
public class App {


    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            menu.chooseMenu(sc.nextLine());

            if (menu.getMenuNow() == MenuStatus.EXIT_MENU) {
                sc.close();
                System.exit(0);
            }

        }
    }


}
