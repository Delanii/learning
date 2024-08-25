public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal("Generic animal", "small", 15.9);
        doAnimalStuff(animal, "fast");

        Dog dog = new Dog();
        doAnimalStuff(dog, "fast");

        Dog yorkie = new Dog("Yorkie", 15);
        doAnimalStuff(yorkie, "fast");
        Dog retriever = new Dog("Retriever",
                65,
                "Floppy",
                "Swimmer");
        doAnimalStuff(retriever, "slow");

        Dog wolf = new Dog("Wolf", 40);
        doAnimalStuff(wolf, "fast");

        Fish goldie = new Fish("Goldfish", 5, 2, 4);
        doAnimalStuff(goldie, "fast");
    }

    public static void doAnimalStuff(Animal animal, String speed){

        animal.makeNoise();
        animal.move(speed);
        System.out.println(animal);
        System.out.println("-------");
    }
}
