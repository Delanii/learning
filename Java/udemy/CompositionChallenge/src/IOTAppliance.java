public class IOTAppliance {

    private boolean hasWorkToDo;

    public IOTAppliance(){
        this.hasWorkToDo = false;
    };

    public boolean getHasWorkToDo() {
        return this.hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    protected void activate(String applianceName, String actionName){

        if (this.getHasWorkToDo()){
            System.out.printf("The %s is running already.%n", applianceName);
        } else {
            this.setHasWorkToDo(true);
            System.out.printf("The %s started %s.%n", applianceName, actionName);
        }
    }
}
