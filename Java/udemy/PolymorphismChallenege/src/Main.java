public class Main {

    public static void main(String[] args) {

        Car aCar = new Car("This is a boring arbitrary car. How uneventful.",
                "Volkswagen", false, 4, 178,
                100);
        aCar.printType();
        aCar.getInfo(30);

        System.out.println("\n\n");
        aCar.drive();

        System.out.println("\n\n");
        aCar.startEngine();
        aCar.drive();

        GasPoweredCar gasCar = new GasPoweredCar("This is a car running on gas. A commonplace sight nowadays.",
                "BMW", false, 4, 230,
                90, "manual", 250.2, 8);
        gasCar.printType();
        gasCar.getInfo(40);

        System.out.println("\n\n");
        gasCar.drive();

        System.out.println("\n\n");
        gasCar.startEngine();
        gasCar.drive();

        ElectricCar elCar = new ElectricCar("This is a car running on battery charge. A modern take.",
                "Not Tesla", false, 4, 270,
                90, 250.2, 1800);
        elCar.printType();
        elCar.getInfo(40);

        System.out.println("\n\n");
        elCar.drive();

        System.out.println("\n\n");
        elCar.startEngine();
        elCar.drive();

        HybridCar hybCar = new HybridCar("This is a car running on battery charge" +
                " with additional fuel tank. A pinnacle of technology.",
                "Audi", false, 4, 200,
                90, "manual", 180, 1800,
                6);
        hybCar.printType();
        hybCar.getInfo(60);

        System.out.println("\n\n");
        hybCar.drive();

        System.out.println("\n\n");
        hybCar.startEngine();
        hybCar.drive();
    }
}
