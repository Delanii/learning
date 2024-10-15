public class Refrigerator extends IOTAppliance{

    private final String applianceName = "refrigerator";
    private final String actionName = "ordering food";

    public void orderFood(){
        this.activate(applianceName, actionName);
    }
}
