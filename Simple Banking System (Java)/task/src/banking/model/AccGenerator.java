package banking.model;

import java.util.Random;

public class AccGenerator {
    private final static String BIN = "400000";

    public static Account createAccount() {
        String number = generateCardNumber();
        String pin = generatePin();
        return new Account(number, pin, 0);
    }

    private static String generateCardNumber() {
        int identifier = new Random().nextInt(100000000, 999999999);
        String checksum = "4";

        return BIN + identifier + checksum;
    }

    private static String generatePin() {
        Random random = new Random();
        StringBuilder pin = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            pin.append(random.nextInt(9));
        }

        return String.valueOf(pin);
    }
}
