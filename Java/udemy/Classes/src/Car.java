public class Car {

   private String manufacturer = "Tesla";
   private String model = "Model X";
   private String color = "Blue";
   private int doors = 18;
   private boolean convertible = true;

   public String getManufacturer() {
       return manufacturer;
   }

   public void setManufacturer(String manufacturer) {

       if (manufacturer == null) {
           this.manufacturer = "Unknown";
       }

       String lowercaseManufacturer = manufacturer.toLowerCase();
       switch (lowercaseManufacturer) {
           case "porsche", "toyota" -> {
               this.manufacturer = manufacturer;
           }
           default -> {
               this.manufacturer = "Not supported";
           }
       }
   }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    public void describeCar() {

       System.out.println(doors + "-Door" + " " +
               color + " " +
               manufacturer + " " +
               model + " " +
               (convertible ? "Convertible" : ""));
   }
}
