package banking.view;

public enum Messages {
    ACCOUNT_MENU("""
            1. Balance
            2. Log out
            0. Exit"""),
    BALANCE("Balance: "),
    BYE("Bye!"),
    CARD_CREATED("Your card has been created"),
    ENTER_CARD("Enter your card number:"),
    ENTER_PIN("Enter your PIN:"),
    INVALID_OPTION("Invalid option! Please try again."),
    LOGGED_IN("You have successfully logged in!"),
    LOGGED_OUT("You have successfully logged out!"),
    MENU("""
            1. Create an account
            2. Log into account
            0. Exit"""),
    WRONG_NUM_OR_PIN("Wrong card number or PIN!"),
    YOUR_CARD("Your card number:"),
    YOUR_PIN("Your card PIN:");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
