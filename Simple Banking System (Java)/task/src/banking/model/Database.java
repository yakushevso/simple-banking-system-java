package banking.model;

import java.util.*;

public class Database {
    private final Map<String, Account> data = new HashMap<>();

    public void setAccount(Account account) {
        data.put(account.number(), account);
    }

    public Account getAccount(String number) {
        return data.get(number);
    }

    public boolean isAccountExist(String number) {
        return data.containsKey(number);
    }

    public boolean isAuth(String number, String pin) {
        return pin.equals(data.get(number).pin());
    }
}
