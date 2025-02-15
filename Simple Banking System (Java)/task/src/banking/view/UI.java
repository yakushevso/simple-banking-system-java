package banking.view;

import java.util.Scanner;

public class UI {
    private final Scanner sc = new Scanner(System.in);

    public String getInput() {
        return sc.nextLine().trim();
    }

    public void displayMessage(Object message) {
        System.out.println(message);
    }
}
