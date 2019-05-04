import java.util.Random;
public class FoodConsumer extends Thread{
    FoodBank bank;

    public FoodConsumer(FoodBank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {

        Random rand = new Random();
        int random = rand.nextInt(100) + 1;
        this.bank.takeFood(random);

        while (true){
            try {
                this.sleep(100);
                
            }catch (InterruptedException e) {
                break;
            }
        }
    }
}
