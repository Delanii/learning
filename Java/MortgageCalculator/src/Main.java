// Mortgage calculator exercise

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Initialize reading user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user
        System.out.print("Principal: ");
        int principal = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Annual interest rate: ");
        double annualInterestRatePercent = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Period (in Years): ");
        byte periodYears = Byte.parseByte(scanner.nextLine().trim());

        // Utility calculations
        double monthlyInterestRate = (annualInterestRatePercent / 12) / 100;
        double incrementer = Math.pow(1 + monthlyInterestRate, periodYears * 12);

        // Monthly pay calculation
        double monthlyPay = principal * ( monthlyInterestRate * incrementer ) / ( incrementer - 1 );

        // Show the result
        String showMonthlyPay = NumberFormat.getCurrencyInstance().format(monthlyPay);
        System.out.println("Mortgage: " + showMonthlyPay);
    }
}