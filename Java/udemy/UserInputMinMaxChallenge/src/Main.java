import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = "";
        double number = 0;
        double min = 0;
        double max = 0;
        int count = 0;

        while(true) {
            System.out.println("Enter a number. Enter a letter to quit:");

            input = scanner.nextLine();

            try{
               number =  Double.parseDouble(input);
            } catch (NumberFormatException notANumber) {
                break;
            }

            count++;
            if (count == 1) {
                min = number;
                max = number;
            } else {
                min = number < min ? number : min;
                max = number > max ? number : max;
            }
        }

        System.out.println("Min: " + min + ", Max: " + max);
    }
}
