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
        int checksum = createLuhn(BIN + identifier);

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

    private static int createLuhn(String num) {
        int sum = 0;
        boolean flag = true;

        for (int i = num.length() - 1; i >= 0; i--) {
            int n = num.charAt(i) - '0';

            if (flag) {
                n *= 2;

                if (n > 9) {
                    n -= 9;
                }
            }

            sum += n;
            flag = !flag;
        }

        return (10 - (sum % 10)) % 10;
    }
}
