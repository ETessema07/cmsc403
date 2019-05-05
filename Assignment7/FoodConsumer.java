import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class FoodConsumer extends Thread{
    FoodBank bank;
    ReentrantLock lock = new ReentrantLock();

    public FoodConsumer(FoodBank bank) {
        this.bank = bank;
    }

    @Override
    public synchronized void run() {
        Random rand = new Random();
        boolean cond = true;
        int random = rand.nextInt(100) + 1;

        while (true) {
            lock.lock();
            try{
            int dif = this.bank.getFood() - random;
            if (dif >= 0) {
                this.bank.takeFood(random);
                System.out.println("I've taken " + random + " amount of food!, total food amount is: " + (this.bank.getFood()));
            } else {
                System.out.println("waiting to get more food!");
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }finally {
                lock.unlock();
            }

        }
    }
}
