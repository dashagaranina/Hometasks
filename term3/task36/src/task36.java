
import java.util.concurrent.atomic.AtomicReference;

public class task36 {

    public static void main(String[] args) {
        AtomicReference<Double> account = new AtomicReference<Double>();
        account.set(100.0);
        DebtAccount debtAccount = new DebtAccount(account);
        Thread customer1 = new Thread(new MyRunnable(debtAccount));
        customer1.start();
        Thread customer2 = new Thread(new MyRunnable(debtAccount));
        customer2.start();
    }


}
