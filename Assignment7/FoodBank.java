public class FoodBank {
    int food;

    public FoodBank() {
        this.food = 0;
    }

    public void giveFood(int amount){
        food+=amount;
    }
    public void takeFood(int amount){
        food-=amount;
    }

}
