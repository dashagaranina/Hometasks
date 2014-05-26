import java.util.concurrent.atomic.AtomicReference;

public class DebtAccount {

    AtomicReference<Double> account;

    public DebtAccount(AtomicReference<Double> account) {
        this.account = account;
    }

    public boolean checkMoney(double amount) {
        System.out.println(account.get() +" >= "+ amount + " = "+ (account.get() >= amount));
        return account.get() >= amount;
    }

    public void debit(double amount) {
        double s = account.get();
        s -= amount;
        account.set(s);
        System.out.println(account.get());
    }

    public synchronized boolean getMoney(double amount) {
        if (checkMoney(amount)) {
            debit(amount);
            return true;
        } else {
            return false;
        }

    }
}
