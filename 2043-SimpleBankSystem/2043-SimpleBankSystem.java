// Last updated: 18/04/2025, 22:35:09
import java.util.Arrays;

class Bank {
    private final long[] accounts;

    public Bank(long[] balance) {
        
        this.accounts = Arrays.copyOf(balance, balance.length);
    }

    private boolean isValidAccount(int account) {
        return account >= 1 && account <= accounts.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isValidAccount(account1) || !isValidAccount(account2)) return false;
        if (accounts[account1 - 1] < money) return false;

        accounts[account1 - 1] -= money;
        accounts[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!isValidAccount(account)) return false;

        accounts[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValidAccount(account)) return false;
        if (accounts[account - 1] < money) return false;

        accounts[account - 1] -= money;
        return true;
    }
}
