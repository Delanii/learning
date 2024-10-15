public class Main {

    public static void main(String[] args){

        CoffeeMaker brewMaster = new CoffeeMaker();
        DishWasher washwash = new DishWasher();
        Refrigerator coolerBox = new Refrigerator();

        SmartKitchen myKitchen = new SmartKitchen(brewMaster, washwash, coolerBox);

        myKitchen.doKitchenWork(true, true, false);
        myKitchen.doKitchenWork(true, false, false);

        myKitchen.setKitchenState(false, false, false);
        myKitchen.doKitchenWork(true, true, true);
        myKitchen.doKitchenWork(true, true, true);
    }
}
