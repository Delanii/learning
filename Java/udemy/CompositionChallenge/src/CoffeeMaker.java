public class CoffeeMaker extends IOTAppliance{

    private final String applianceName = "coffee maker";
    private final String actionName = "brewing coffee";

    public void brewCoffee(){
        this.activate(applianceName, actionName);
    }
}
