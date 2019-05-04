public class FoodBankPatrons {

    public static void main(String [] args){

        FoodBank food = new FoodBank();
        FoodProducer foodProducer = new FoodProducer(food);
        FoodConsumer foodConsumer = new FoodConsumer(food);
        foodProducer.start();
        foodConsumer.start();
    }
}
