import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Reading input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number:");
        String input = scanner.nextLine().trim();
        int number = Integer.parseInt(input);

        // Evaluation
        if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (number % 5 == 0) {
            System.out.println("Buzz");
        } else if (number % 3 == 0) {
            System.out.println("Fizz");
        } else {
            System.out.println(number);
        }
    }
}