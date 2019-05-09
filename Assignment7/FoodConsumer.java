import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class FoodConsumer extends Thread{
    FoodBank bank;
    ReentrantLock threadLock = new ReentrantLock();

    public FoodConsumer(FoodBank bank) {
        this.bank = bank;
    }

    @Override
    public synchronized void run() {


        while (true) {
            try{

                Random rand = new Random();
                int random = rand.nextInt(100) + 1;
                threadLock.lock();
                int difference = this.bank.food - random;
                if (difference >= 0) {
                    this.bank.takeFood(random);
                    System.out.println("I've taken " + random + " amount of food, total food amount is: " + (this.bank.food));
                } else {
                    System.out.println("waiting to get more food, consumer tried taking: "+ random + " from food bank but we only have: "+this.bank.food);
                }

                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {

                }
            }
            finally {
                threadLock.unlock();
            }

        }
    }
}
