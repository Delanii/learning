public class DishWasher extends IOTAppliance{

    private final String applianceName = "dish washer";
    private final String actionName = "washing dishes";

    public void doDishes(){
        this.activate(applianceName, actionName);
    }
}
