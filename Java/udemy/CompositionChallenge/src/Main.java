public class Main {

    public static void main(String[] args){

        SmartKitchen myKitchen = new SmartKitchen();

        myKitchen.doKitchenWork(true, true, false);
        myKitchen.doKitchenWork(true, false, false);

        myKitchen.setKitchenState(false, false, false);
        myKitchen.doKitchenWork(true, true, true);
        myKitchen.doKitchenWork(true, true, true);
    }
}
