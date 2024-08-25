public class Dog extends Animal{

    private String earShape;
    private String tailShape;

    public Dog(){
        super(
                "Mutt",
                "small",
                45
        );
    }

    public Dog(String type, double weight){
        this(type, weight, "Perky", "Curled");
    } // This constructor calls the constructor bellow with the `this` reference.

    public Dog(String type,
               double weight,
               String earShape,
               String tailShape) {
        super(
                type,
                weight < 15 ? "small" : (
                        weight < 35 ? "medium" : "large"
                        ),
                weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    }

    public void makeNoise(){

        if(type == "Wolf") {
            System.out.print("Howl ");
        }

        bark();
        System.out.println();
    }

    @Override
    public void move(String speed) {
        super.move(speed);
    //    System.out.println("Dogs walk.");

        if(speed == "slow") {
            walk();
            wagTail();
        } else {
            run();
            bark();
        }

        System.out.println();
    }

    private void bark(){
        System.out.print("Woof! ");
    }

    private void run(){
        System.out.print("Dog running ");
    }

    private void walk(){
        System.out.print("Dog walking ");
    }

    private void wagTail(){
        System.out.print("Tail wagging ");
    }
}
