import java.util.Random;

public class MyRunnable implements Runnable {

    private DebtAccount account;

    public MyRunnable(DebtAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        Random r = new Random();
        double amount = r.nextInt(100);
        if (account.getMoney(amount)) {
            System.out.println("С вашего счета списанны средства в размере " + amount);
        } else {
            System.out.println("Недостаточно средств на счете");
        }

    }


}
