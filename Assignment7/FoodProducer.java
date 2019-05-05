import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
public class FoodProducer extends Thread{
    private FoodBank bank;
    ReentrantLock lock = new ReentrantLock();


    public  FoodProducer(FoodBank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while(true){
            lock.lock();
            try {
                Random rand = new Random();
                int random = rand.nextInt(100)+1;
                this.bank.giveFood(random);
                System.out.println("I've added "+random+ " amount of food!, total food amount is:"+this.bank.getFood());
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    continue;
                }
            }finally {
                lock.unlock();
            }


        }
    }
}
