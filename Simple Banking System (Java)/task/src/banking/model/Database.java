package banking.model;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private final List<Account> data = new ArrayList<>();

    public void setData(Account account) {
        data.add(account);
    }

    public Account getAccount(String name, String pin) {
        for (Account account : data) {
            if (name.equals(account.number()) && pin.equals(account.pin())) {
                return account;
            }
        }

        return null;
    }
}
