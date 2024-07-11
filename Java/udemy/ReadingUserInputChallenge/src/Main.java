import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = 1;
        int number = 0;
        int sum = 0;

        while (count <= 5) {

           System.out.println("Enter number #" + count);
           String input = scanner.nextLine();

           try {
               number = Integer.parseInt(input);
           } catch (NumberFormatException notANumber) {
               System.out.println("Invalid number.");
               continue;
           }

           sum += number;
           count ++;
        }

        System.out.println(sum);
    }
}
