import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // read from `stdin`

//        System.out.print("Age:");
//        byte age = scanner.nextByte();
//        System.out.println("You are " + age);

        System.out.print("name:");
        String name = scanner.nextLine().trim(); // `.next()` method reads only until the first space
        System.out.println("Your name is " + name);
    }
}