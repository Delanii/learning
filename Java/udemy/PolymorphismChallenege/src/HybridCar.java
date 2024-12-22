import java.util.Arrays;

public class HybridCar extends Car{

    private double avgKmPerLitre;
    private int batterySize;
    private int cylinders;
    private String gearChange;
    private final String fuelType = "gasoline and electricity";

    public HybridCar(String description,
                     String manufacturer,
                     boolean combi,
                     int numberOfSeats,
                     int maximumSpeed,
                     int fuelPercentage,
                     String gearChange,
                     double avgKmPerLitre,
                     int batterySize,
                     int cylinders){

        super(description,
                manufacturer,
                combi,
                numberOfSeats,
                maximumSpeed,
                fuelPercentage);

        this.gearChange = gearChange;
        this.avgKmPerLitre = avgKmPerLitre;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }

    public static HybridCar getHybridCar(String description,
                                         String manufacturer,
                                         boolean combi,
                                         int numberOfSeats,
                                         int maximumSpeed,
                                         int fuelPercentage,
                                         String gearChange,
                                         double avgKmPerLitre,
                                         int batterySize,
                                         int cylinders){

        return new HybridCar(description,
                manufacturer,
                combi,
                numberOfSeats,
                maximumSpeed,
                fuelPercentage,
                gearChange,
                avgKmPerLitre,
                batterySize,
                cylinders);
    }

    public double getAvgKmPerLitre() {
        return avgKmPerLitre;
    }

    public int getBatterySize() {
        return batterySize;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getGearChange() {
        return gearChange;
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public void getInfo(int lineLength){

        super.getInfo(lineLength);
        for (String s : Arrays.asList(alignString("Fuel type: ", this.getFuelType(), lineLength),
                alignString("Average km per battery charge: ", Double.toString(this.getAvgKmPerLitre()), lineLength),
                alignString("Cylinders: ", Integer.toString(this.getBatterySize()), lineLength),
                alignString("Gear change: ", this.getGearChange(), lineLength))) {
            System.out.println(s);
        }
    }

    @Override
    protected void runEngine(){

        if (this.getFuelPercentage() == 0) {
            System.out.println("Low fuel and battery charge. Charge the battery or" +
                    " refill the fuel tank before starting the engine.");
        } else {
            this.setEngineRunning(true);
            System.out.println("Engine is running.");
        }
    }
}
