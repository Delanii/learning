import java.util.Arrays;

public class ElectricCar extends Car{

    private double avgKmPerCharge;
    private int batterySize;
    private final String fuelType = "electricity";
    private final String gearChange = "automatic";

    public ElectricCar(String description,
                       String manufacturer,
                       boolean combi,
                       int numberOfSeats,
                       int maximumSpeed,
                       int fuelPercentage,
                       double avgKmPerCharge,
                       int batterySize){

        super(description,
                manufacturer,
                combi,
                numberOfSeats,
                maximumSpeed,
                fuelPercentage);

       this.avgKmPerCharge = avgKmPerCharge;
       this.batterySize = batterySize;
    }

    public static ElectricCar getElectricCar(String description,
                                             String manufacturer,
                                             boolean combi,
                                             int numberOfSeats,
                                             int maximumSpeed,
                                             int fuelPercentage,
                                             double avgKmPerCharge,
                                             int batterySize){

        return new ElectricCar(description,
                manufacturer,
                combi,
                numberOfSeats,
                maximumSpeed,
                fuelPercentage,
                avgKmPerCharge,
                batterySize);
    }

    public double getAvgKmPerCharge() {
        return avgKmPerCharge;
    }

    public int getBatterySize() {
        return batterySize;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getGearChange(){
        return this.gearChange;
    }

    @Override
    public void getInfo(int lineLength){

        super.getInfo(lineLength);
        for (String s : Arrays.asList(alignString("Fuel type: ", this.getFuelType(), lineLength),
                alignString("Average km per battery charge: ", Double.toString(this.getAvgKmPerCharge()), lineLength),
                alignString("Cylinders: ", Integer.toString(this.getBatterySize()), lineLength),
                alignString("Gear change: ", this.getGearChange(), lineLength))) {
            System.out.println(s);
        }
    }

    @Override
    protected void runEngine(){

        if (this.getFuelPercentage() == 0) {
            System.out.println("Low battery charge. Charge the battery before starting the engine.");
        } else {
            this.setEngineRunning(true);
            System.out.println("Engine is running.");
        }
    }
}
