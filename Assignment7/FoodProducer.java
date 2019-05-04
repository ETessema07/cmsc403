import java.util.Random;
public class FoodProducer extends Thread{
    private FoodBank bank;


    public FoodProducer(FoodBank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while(true){
            Random rand = new Random();
            int random = rand.nextInt(100)+1;
            this.bank.giveFood(random);
            try {
                this.sleep(100);
            }catch (InterruptedException e){
                break;
            }
        }
    }
}
