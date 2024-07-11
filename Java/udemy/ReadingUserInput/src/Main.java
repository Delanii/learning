import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int currentYear = 2024;

        /*
        try {

            System.out.println(getInputFromConsole(currentYear));

        } catch (NullPointerException e) {

            System.out.println(getInputFromScanner(currentYear));

        }
        */

        System.out.println(getInputFromScanner(currentYear));

    }

    public static String getInputFromConsole(int currentYear) {

        String name = System.console().readLine("Enter your name: ");
        System.out.println("Hi " + name + " nice meeting you!");

        String dateOfBirth = System.console().readLine("What year were you born? ");
        int age = currentYear - Integer.parseInt(dateOfBirth);

        return "So you are " + age + " years old.";
    }

    public static String getInputFromScanner(int currentYear) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        boolean validDOB = false;
        int age = 0;

        do {
            System.out.println("Enter a year of birth >= " +
                    (currentYear - 125) + " and <= " + currentYear);

            try {
                age = checkData(currentYear, scanner.nextLine());
                validDOB = age < 0 ? false : true;
            } catch (NumberFormatException badUserData) {
                System.out.println("Non-numeric characters not allowed. Try again.");
            }
        } while (!validDOB);

        return "So you are " + age + " years old.";
    }

    public static int checkData(int currentYear,
                                String dateOfBirth) {

        int dob = Integer.parseInt(dateOfBirth);
        int minimumYear = currentYear - 125;

        if ((dob < minimumYear) || (dob > currentYear)) {
            return -1;
        }

        return (currentYear - dob);
    }
}
