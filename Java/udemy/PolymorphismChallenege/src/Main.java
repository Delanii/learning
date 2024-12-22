public class Main {

    public static void main(String[] args) {

        Car aCar = Car.getCar("This is a boring arbitrary car. How uneventful.",
                "Volkswagen", false, 4, 178,
                100);
        testCar(aCar, 30);

        GasPoweredCar gasCar = GasPoweredCar.getGasPoweredCar("This is a car running on gas. A commonplace sight nowadays.",
                "BMW", false, 4, 230,
                90, "manual", 250.2, 8);
        testCar(gasCar, 40);

        ElectricCar elCar = ElectricCar.getElectricCar("This is a car running on battery charge. A modern take.",
                "Not Tesla", false, 4, 270,
                90, 250.2, 1800);
        testCar(elCar, 40);

        HybridCar hybCar = HybridCar.getHybridCar("This is a car running on battery charge" +
                " with additional fuel tank. A pinnacle of technology.",
                "Audi", false, 4, 200,
                90, "manual", 180, 1800,
                6);
        testCar(hybCar, 60);
    }

    public static void testCar(Car car, int lineLength){

        car.printType();
        car.getInfo(lineLength);

        System.out.println("\n");
        car.drive();

        System.out.println("\n");
        car.startEngine();
        car.drive();
    }
}
