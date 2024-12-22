import java.util.Arrays;

public class GasPoweredCar extends Car{

    private String gearChange;
    private final String fuelType = "gasoline";
    private double avgKmPerLitre;
    private int cylinders;

    public GasPoweredCar(String description,
                         String manufacturer,
                         boolean combi,
                         int numberOfSeats,
                         int maximumSpeed,
                         int fuelPercentage,
                         String gearChange,
                         double avgKmPerLitre,
                         int cylinders){

        super(description,
                manufacturer,
                combi,
                numberOfSeats,
                maximumSpeed,
                fuelPercentage);

        this.gearChange = gearChange;
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    public String getGearChange() {
        return gearChange;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getAvgKmPerLitre() {
        return avgKmPerLitre;
    }

    public int getCylinders() {
        return cylinders;
    }

    @Override
    public void getInfo(int lineLength){

        super.getInfo(lineLength);
        for (String s : Arrays.asList(alignString("Fuel type: ", this.getFuelType(), lineLength),
                alignString("Average km per fuel litre: ", Double.toString(this.getAvgKmPerLitre()), lineLength),
                alignString("Cylinders: ", Integer.toString(this.getCylinders()), lineLength),
                alignString("Gear change: ", this.getGearChange(), lineLength))) {
            System.out.println(s);
        }
    }
}
