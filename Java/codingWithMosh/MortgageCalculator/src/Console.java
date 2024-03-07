import java.util.Scanner;

public class Console {

    // Set up validation fields
    private final int PRINCIPAL_MIN = 100_000;
    public final String PRINCIPAL_MIN_STRING = "100k";
    private final int PRINCIPAL_MAX = 100_000_000;
    public final String PRINCIPAL_MAX_STRING = "100M";

    // Annual interest rate
    private final double ANNUAL_INTEREST_RATE_MIN = 0;
    private final double ANNUAL_INTEREST_RATE_MAX = 10;

    // Period
    private final byte PERIOD_YEARS_MIN = 1;
    private final byte PERIOD_YEARS_MAX = 30;

    // Create public fields for the calculator
    public int principal;
    public double annualInterestRatePercent;
    public byte periodYears;

    // System read initialization
    private static Scanner scanner = new Scanner(System.in);;

    // Principal
    public int getPrincipal(){
        return this.principal;
    }

    public int setPrincipal(){
        while(true) {
            principal = (int)readInput(scanner,
                "Principal (" + PRINCIPAL_MIN_STRING + " - " + PRINCIPAL_MAX_STRING + "): ");
            if ((principal < PRINCIPAL_MIN) || (principal > PRINCIPAL_MAX)) {
                System.out.println("Principal must be a number between " + PRINCIPAL_MIN + " and " + PRINCIPAL_MAX + ".");
            } else {
                break;
            }
        }
        return principal;
    }

    // Annual interest rate
    private double getAnnualInterestRatePercent(){
        return this.annualInterestRatePercent;
    }

   public double setAnnualInterestRatePercent(){
        while(true) {
            annualInterestRatePercent = readInput(scanner,
                "Annual interest rate: ");
            if((annualInterestRatePercent <= ANNUAL_INTEREST_RATE_MIN) || (annualInterestRatePercent > ANNUAL_INTEREST_RATE_MAX) ) {
                System.out.println("Annual interest rate must be a number between " + ANNUAL_INTEREST_RATE_MIN + " and " + ANNUAL_INTEREST_RATE_MAX + ".");
            } else {
                break;
            }
        }
        return annualInterestRatePercent;
   }

    // Period
    private byte getPeriodYears(){
        return this.periodYears;
    }

    public byte setPeriodYears(){
        while(true){
            periodYears = (byte)readInput(scanner,
                "Period (in Years): ");
            if((periodYears < PERIOD_YEARS_MIN) || (periodYears > PERIOD_YEARS_MAX)) {
                System.out.println("Period must be a number between " + PERIOD_YEARS_MIN + " and " + PERIOD_YEARS_MAX + ".");
            } else {
                break;
            }
        }
        return periodYears;
    }

    private double readInput(Scanner scanner,
                                   String prompt) {
        System.out.print(prompt);
        double input = Double.parseDouble(scanner.nextLine().trim());
        return input;
    }
}
