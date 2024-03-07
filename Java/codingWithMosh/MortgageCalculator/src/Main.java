// Mortgage calculator exercise

import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {

        // Initialize reading user input
        Console console = new Console();

        // Prompt user
        console.principal = console.setPrincipal();
        console.annualInterestRatePercent = console.setAnnualInterestRatePercent();
        console.periodYears = console.setPeriodYears();

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
                                            short remainingNumberOfPayments) {

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

        for(short i = 1; i <= calculateNumberOfPayments(periodYears); i++) {
           double remainder = calculateRemainder(principal,
                   annualInterestRatePercent, periodYears, i);
           System.out.println(NumberFormat.getCurrencyInstance().format(remainder));
        }
    }
}