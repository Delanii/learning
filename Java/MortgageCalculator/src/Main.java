// Mortgage calculator exercise

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Initialize reading user input
        Scanner scanner = new Scanner(System.in);

        /*
         Prompt user
         */
        // Principal
        final int PRINCIPAL_MIN = 100_000;
        final String PRINCIPAL_MIN_STRING = "100k";
        final int PRINCIPAL_MAX = 100_000_000;
        final String PRINCIPAL_MAX_STRING = "100M";

        int principal = 0;

        while (true) {
            System.out.print("Principal (" + PRINCIPAL_MIN_STRING + " - " + PRINCIPAL_MAX_STRING + "): ");
            principal = Integer.parseInt(scanner.nextLine().trim());
            if (principal >= PRINCIPAL_MIN && principal <= PRINCIPAL_MAX )
                break;
            System.out.println("Principal must be a number between " + PRINCIPAL_MIN + " and " + PRINCIPAL_MAX + ".");
        }

        // Annual interest rate
        final double ANNUAL_INTEREST_RATE_MIN = 0;
        final double ANNUAL_INTEREST_RATE_MAX = 10;

        double annualInterestRatePercent = 0;

        while (true) {
            System.out.print("Annual interest rate: ");
            annualInterestRatePercent = Double.parseDouble(scanner.nextLine().trim());
            if (annualInterestRatePercent > ANNUAL_INTEREST_RATE_MIN && annualInterestRatePercent <= ANNUAL_INTEREST_RATE_MAX)
                break;
            System.out.println("Annual interest rate must be a number between " + ANNUAL_INTEREST_RATE_MIN + " and " + ANNUAL_INTEREST_RATE_MAX + ".");
        }

        // Period
        final byte PERIOD_YEARS_MIN = 1;
        final byte PERIOD_YEARS_MAX = 30;

        byte periodYears = 0;

        while (true) {
            System.out.print("Period (in Years): ");
            periodYears = Byte.parseByte(scanner.nextLine().trim());
            if (periodYears > PERIOD_YEARS_MIN && periodYears <= PERIOD_YEARS_MAX)
                break;
            System.out.println("Period must be a number between " + PERIOD_YEARS_MIN + " and " + PERIOD_YEARS_MAX + ".");
        }

        // Utility calculations
        double monthlyInterestRate = (annualInterestRatePercent / 100) / 12;
        double incrementer = Math.pow(1 + monthlyInterestRate, periodYears * 12);

        // Monthly pay calculation
        double monthlyPay = principal * ( monthlyInterestRate * incrementer ) / ( incrementer - 1 );

        // Show the result
        String showMonthlyPay = NumberFormat.getCurrencyInstance().format(monthlyPay);
        System.out.println("Mortgage: " + showMonthlyPay);
    }
}