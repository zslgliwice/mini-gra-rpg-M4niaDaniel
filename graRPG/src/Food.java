public class Food extends Item {
    public enum FoodType {
        FRUIT,
        MEAT,
        VEGETABLE
    }

    private FoodType foodType;
    private String name;
    private int healthRestore;

    Food(FoodType foodType, String name, int healthRestore) {
        super(Item.ItemType.FOOD, name, healthRestore);
        this.foodType = foodType;
        this.name = name;
        this.healthRestore = healthRestore;
    }

    public void setHealthRestore(int healthRestore) {
        this.healthRestore = healthRestore;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthRestore() {
        return healthRestore;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public String getName() {
        return name;
    }
    
}
