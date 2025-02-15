package banking;

import banking.controller.BankingSystem;
import banking.model.Database;
import banking.view.UI;

public class Main {
    public static void main(String[] args) {
        new BankingSystem(new Database(), new UI()).start();
    }
}