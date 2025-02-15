package banking.controller;

import banking.model.AccGenerator;
import banking.model.Account;
import banking.model.Database;
import banking.view.Messages;
import banking.view.UI;

public class BankingSystem {
    private final Database database;
    private final UI ui;

    public BankingSystem(Database database, UI ui) {
        this.database = database;
        this.ui = ui;
    }

    public void start() {
        while (true) {
            ui.displayMessage(Messages.MENU);

            String userChoice = ui.getInput();

            ui.displayMessage("");

            switch (userChoice) {
                case "1" -> createAccount();
                case "2" -> login();
                case "0" -> {
                    ui.displayMessage(Messages.BYE);
                    return;
                }
                default -> ui.displayMessage(Messages.INVALID_OPTION);
            }

            ui.displayMessage("");
        }
    }

    private void createAccount() {
        Account account;
        do {
            account = AccGenerator.createAccount();
        } while (database.isAccountExist(account.number()));

        database.setAccount(account);

        ui.displayMessage(Messages.CARD_CREATED);

        ui.displayMessage(Messages.YOUR_CARD);
        ui.displayMessage(account.number());

        ui.displayMessage(Messages.YOUR_PIN);
        ui.displayMessage(account.pin());
    }

    private void login() {
        ui.displayMessage(Messages.ENTER_CARD);
        String number = ui.getInput();

        ui.displayMessage(Messages.ENTER_PIN);
        String pin = ui.getInput();

        ui.displayMessage("");

        if (database.isAccountExist(number) && database.isAuth(number, pin)) {
            ui.displayMessage(Messages.LOGGED_IN);
            accountMenu(database.getAccount(number));
        } else {
            ui.displayMessage(Messages.WRONG_NUM_OR_PIN);
        }
    }

    private void accountMenu(Account account) {
        while (true) {
            ui.displayMessage("");

            ui.displayMessage(Messages.ACCOUNT_MENU);

            String userChoice = ui.getInput();

            ui.displayMessage("");

            switch (userChoice) {
                case "1" -> ui.displayMessage(Messages.BALANCE + String.valueOf(account.balance()));
                case "2" -> {
                    ui.displayMessage(Messages.LOGGED_OUT);
                    return;
                }
                case "0" -> {
                    ui.displayMessage(Messages.BYE);
                    System.exit(0);
                }
                default -> ui.displayMessage(Messages.INVALID_OPTION);
            }
        }
    }
}
