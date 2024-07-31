public class Main {

    public static void main(String[] args) {

        Car myCar = new Car();
        myCar.describeCar();

        myCar.setManufacturer("Toyota");

        System.out.println("Manufacturer = " + myCar.getManufacturer());
        System.out.println("Model = " + myCar.getModel());

        Car anotherCar = new Car();

        anotherCar.setColor("purple");
        anotherCar.describeCar();
    }
}
