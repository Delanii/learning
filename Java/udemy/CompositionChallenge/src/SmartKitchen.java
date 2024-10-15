public class SmartKitchen {

    private CoffeeMaker brewMaster;
    private DishWasher dishWasher;
    private Refrigerator iceBox;

    public SmartKitchen(){

        this.brewMaster = new CoffeeMaker();
        this.dishWasher = new DishWasher();
        this.iceBox = new Refrigerator();
    };

    public CoffeeMaker getBrewMaster() {
        return this.brewMaster;
    }

    public DishWasher getDishWasher() {
        return this.dishWasher;
    }

    public Refrigerator getIceBox() {
        return this.iceBox;
    }

    private void addWater(){
        this.getBrewMaster().setHasWorkToDo(true);
    };

    private void pourMilk(){
        this.getIceBox().setHasWorkToDo(true);
    };

    private void loadDishwasher(){
        this.getIceBox().setHasWorkToDo(true);
    };

    public void setKitchenState(boolean coffeeMakerState,
                                boolean dishWasherState,
                                boolean refrigeratorState){

        this.getBrewMaster().setHasWorkToDo(coffeeMakerState);
        this.getDishWasher().setHasWorkToDo(dishWasherState);
        this.getIceBox().setHasWorkToDo(refrigeratorState);

        System.out.printf("""
                Set kitchen state to:
                
                Coffee maker: %b,
                Dish washer: %b,
                Refrigerator: %b%n
                """, coffeeMakerState, dishWasherState, refrigeratorState);
    }

    public void doKitchenWork(boolean makeCoffee,
                              boolean washDishes,
                              boolean orderFood){

        if(makeCoffee){
            this.getBrewMaster().brewCoffee();
        }

        if(washDishes){
            this.getDishWasher().doDishes();
        }

        if(orderFood){
            this.getIceBox().orderFood();
        }
    };
}
