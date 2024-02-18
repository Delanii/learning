// Mortgage calculator exercise

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    // Principal
    private static final int PRINCIPAL_MIN = 100_000;
    private static final String PRINCIPAL_MIN_STRING = "100k";
    private static final int PRINCIPAL_MAX = 100_000_000;
    private static final String PRINCIPAL_MAX_STRING = "100M";

    // Annual interest rate
    private static final double ANNUAL_INTEREST_RATE_MIN = 0;
    private static final double ANNUAL_INTEREST_RATE_MAX = 10;

    // Period
    private static final byte PERIOD_YEARS_MIN = 1;
    private static final byte PERIOD_YEARS_MAX = 30;


    public static void main(String[] args) {

        // Initialize reading user input
        Scanner scanner = new Scanner(System.in);

        /*
         Prompt user
         */

        // Principal
        int principal = (int)readInput(scanner,
                "Principal (" + PRINCIPAL_MIN_STRING + " - " + PRINCIPAL_MAX_STRING + "): ",
                "principal",
                "Principal must be a number between " + PRINCIPAL_MIN + " and " + PRINCIPAL_MAX + ".");

        // Annual interest rate
        double annualInterestRatePercent = readInput(scanner,
                "Annual interest rate: ",
                "annualInterestRate",
                "Annual interest rate must be a number between " + ANNUAL_INTEREST_RATE_MIN + " and " + ANNUAL_INTEREST_RATE_MAX + ".");

        // Period
        byte periodYears = (byte)readInput(scanner,
                "Period (in Years): ",
                "periodYears",
                "Period must be a number between " + PERIOD_YEARS_MIN + " and " + PERIOD_YEARS_MAX + ".");

        double monthlyPay = calculateMonthlyPay(principal,
                annualInterestRatePercent,
                periodYears);

        // Show the monthly pay result
        showMonthlyPay(principal,
                annualInterestRatePercent,
                periodYears);

        // Show payment schedule
        showPaymentSchedule(principal,
                annualInterestRatePercent,
                periodYears);
    }

    public static double readInput(Scanner scanner,
                                   String prompt,
                                   String type,
                                   String errorMessage) {
        double input; // Initialization can be even without an initial value
        while (true) {
            System.out.print(prompt);
            input = Double.parseDouble(scanner.nextLine().trim());
            boolean isValid = validateInput(input, type);
            if (isValid)
                break;
            System.out.println(errorMessage);
        }
        return input;
    }

    public static boolean validateInput(double input, String type) {
        boolean isValid = false;
        switch (type) {
            case "principal": {
                int principal = (int)input;
                isValid = (principal >= PRINCIPAL_MIN) && (principal <= PRINCIPAL_MAX);
                break;
            }
            case "annualInterestRate": {
                double annualInterestRatePercent = input;
                isValid = (annualInterestRatePercent > ANNUAL_INTEREST_RATE_MIN) && (annualInterestRatePercent <= ANNUAL_INTEREST_RATE_MAX);
                break;
            }
            case "periodYears": {
                byte periodYears = (byte)input;
                isValid = (periodYears > PERIOD_YEARS_MIN) && (periodYears <= PERIOD_YEARS_MAX);
                break;
            }
        }
        return isValid;
    }

    public static double calculateMonthlyInterestRate(double annualInterestRatePercent) {
        double monthlyInterestRate = (annualInterestRatePercent / 100) / 12;
        return monthlyInterestRate;
    }

    public static short calculateNumberOfPayments(byte periodYears) {
        short payments = (short)(periodYears * 12);
        return payments;
    }

    public static double calculateMonthlyPay(int principal,
                                           double annualInterestRatePercent,
                                           byte periodYears) {

        // Utility calculations
        double monthlyInterestRate = calculateMonthlyInterestRate(annualInterestRatePercent);
        double incrementer = Math.pow(1 + monthlyInterestRate, periodYears * 12);

        // Monthly pay calculation
        double monthlyPay = principal * ( monthlyInterestRate * incrementer ) / ( incrementer - 1 );

        return monthlyPay;
    }

    public static void showHeading(String title) {
        String header = "--------";

        System.out.println(title);
        System.out.println(header);
        System.out.print("\n");
    }

    public static void showMonthlyPay(int principal,
                                      double annualInterestRatePercent,
                                      byte periodYears) {
        showHeading("Mortgage");

        double monthlyPay = calculateMonthlyPay(principal,
                annualInterestRatePercent,
                periodYears);
        String showMonthlyPay = NumberFormat.getCurrencyInstance().format(monthlyPay);
        System.out.println("Monthly payments: " + showMonthlyPay);
    }

    public static double calculateRemainder(int principal,
                                            double annualInterestRatePercent,
                                            byte periodYears,
                                            byte remainingNumberOfPayments) {

        // Utility calculations
        double monthlyInterestRate = calculateMonthlyInterestRate(annualInterestRatePercent);
        double normalizedInterest = 1 + monthlyInterestRate;

        double remainder = principal *
                (Math.pow(normalizedInterest, periodYears * 12) - (Math.pow(normalizedInterest, remainingNumberOfPayments))) /
                (Math.pow(normalizedInterest, periodYears * 12) - 1);

        return remainder;
    }

    public static void showPaymentSchedule(int principal,
                                           double annualInterestRatePercent,
                                           byte periodYears) {
        showHeading("Payment schedule");

        for(byte i = 1; i <= calculateNumberOfPayments(periodYears); i++) {
           double remainder = calculateRemainder(principal,
                   annualInterestRatePercent, periodYears, i);
           System.out.println(NumberFormat.getCurrencyInstance().format(remainder));
        }
    }
}