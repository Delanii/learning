import java.util.Arrays;

public class Car {

    private String description;
    private String manufacturer;
    private boolean combi;
    private int numberOfSeats;
    private int maximumSpeed;
    private int fuelPercentage;
    private boolean engineRunning;
    private boolean inMotion;

    /*
    Specific car type attributes

    gear change (manual or automatic)
    fuel type
    */

    public Car(String description,
               String manufacturer,
               boolean combi,
               int numberOfSeats,
               int maximumSpeed,
               int fuelPercentage){

        this.description = description;
        this.manufacturer = manufacturer;
        this.combi = combi;
        this.numberOfSeats = numberOfSeats;
        this.maximumSpeed = maximumSpeed;
        this.fuelPercentage = fuelPercentage;
        this.engineRunning = false;
        this.inMotion = false;
    }

    public static Car getCar(String description,
                             String manufacturer,
                             boolean combi,
                             int numberOfSeats,
                             int maximumSpeed,
                             int fuelPercentage){

        return new Car(description,
                manufacturer,
                combi,
                numberOfSeats,
                maximumSpeed,
                fuelPercentage);
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public boolean isCombi() {
        return combi;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public int getFuelPercentage() {
        return fuelPercentage;
    }

    public boolean isEngineRunning() {
        return engineRunning;
    }

    protected boolean isInMotion() {
        return inMotion;
    }

    protected void setFuelPercentage(int fuelPercentage) {
        this.fuelPercentage = fuelPercentage;
    }

    protected void setEngineRunning(boolean engineRunning) {
        this.engineRunning = engineRunning;
    }

    protected void setInMotion(boolean inMotion) {
        this.inMotion = inMotion;
    }

   /*
    public static String myPadLeft(String inputString, int alignLength){

           if (inputString.length() >= alignLength) {
               return inputString;
           } // if `inputString` is longer than `alignLength`, return the original `rawString` unchanged

           StringBuilder sb = new StringBuilder();
           while (sb.length() < alignLength - inputString.length()) {
               sb.append(' ');
           } // build the padding with a string builder, until the alignLength is smaller than the difference between
             // the `alignLength` and the `inputString` length
           sb.append(inputString); // append the `inputString` to the padding. The result is still a StringBuilder object

           return sb.toString(); // turn the StringBuilder object to a String
    }
    */

    protected static String alignString(String leftString, String rightString, int lineLength){

        if(leftString.length() + rightString.length() >= lineLength){
            return (leftString + " " + rightString);
        }

        StringBuilder sb = new StringBuilder();
        while (sb.length() < lineLength - (leftString.length() + rightString.length())){
            sb.append(" ");
        }
        sb.insert(0, leftString).append(rightString);

        return sb.toString();
    }

    protected static String booleanToEnglish(boolean bool){
        if (bool){
            return "Yes";
        } else {
            return "No";
        }
    }

    public void getInfo(int lineLength){
        System.out.printf("%n%s%n%n", this.getDescription());

        for (String s : Arrays.asList(alignString("Manufacturer: ", this.getManufacturer(), lineLength),
                alignString("Number of seats: ", Integer.toString(this.getNumberOfSeats()), lineLength),
                alignString("Maximum speed: ", Integer.toString(this.getMaximumSpeed()), lineLength),
                alignString("Combi: ", booleanToEnglish(this.isCombi()), lineLength))) {
            System.out.println(s);
        }
    }

    public void printType(){
        System.out.println(this.getClass().getSimpleName());
    }

    public void startEngine(){

        if (!(this.isEngineRunning())) {
            this.runEngine();
        } else {
            System.out.println("The engine is running already.");
        }
    }

    protected void runEngine(){

        if (this.getFuelPercentage() == 0) {
            System.out.println("Low fuel. Refill the fuel before starting the engine.");
        } else {
            this.setEngineRunning(true);
            System.out.println("Engine is running.");
        }
    }

    public void drive(){

        if (!(this.isEngineRunning())) {
            System.out.println("You have to start the engine first.");
        } else {
            this.setInMotion(true);
            System.out.println("The car is in motion.");
        }
    }

}
