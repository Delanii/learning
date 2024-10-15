public class Refrigerator extends IOTAppliance{

    private final String applianceName = "dish washer";
    private final String actionName = "washing dishes";

    public void orderFood(){
        this.activate(applianceName, actionName);
    }
}
