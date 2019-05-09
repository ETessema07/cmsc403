import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
public class FoodProducer extends Thread{
    private FoodBank bank;
    ReentrantLock threadLock = new ReentrantLock();


    public  FoodProducer(FoodBank bank) {
        this.bank = bank;
    }

    @Override
    public synchronized void run() {
        while(true){

            try {
                Random rand = new Random();
                int random = rand.nextInt(100)+1;
                threadLock.lock();
                this.bank.giveFood(random);
                System.out.println("I've added "+random+ " amount of food, total food amount is: "+this.bank.food);
                try {
                    Thread.sleep(100);

                }catch (InterruptedException e){
                    continue;
                }
            }finally {

                threadLock.unlock();
            }


        }
    }
}