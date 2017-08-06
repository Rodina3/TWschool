package ms_student_score;

import ms_student_score.view.CommandManager;
import ms_student_score.view.CurrentStatus;

import java.util.Scanner;


/**
 * Created by rzhou on 26/07/2017.
 */
public class App {


    public static void main(String[] args) {
        CommandManager commandManager = new CommandManager();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            commandManager.chooseFunction(sc.nextLine());

            if (commandManager.getMenuNow() == CurrentStatus.EXIT_PAGE) break;
        }
        sc.close();
        System.exit(0);
    }

}
