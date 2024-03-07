import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int x = 1;
        int y = 1;
        System.out.println(x == y); // `==`, `!=`, `<`, `>`, `>=`, `<=`

        int temperature = 22;
        boolean isWarm = temperature > 20 && temperature < 30; // AND = && ; OR = ||
        System.out.println(isWarm);

        boolean hasIncome = true;
        boolean hasCredit = true;
        boolean hasCriminalRecord = false;
        boolean isEligible = (hasIncome || hasCriminalRecord ) && !hasCriminalRecord;
        System.out.println(isEligible);

        int newTemperature = 35;
        if (newTemperature > 30) {
            System.out.println("It's a hot day.");
        } else if (newTemperature < 30 && newTemperature > 20) {
            System.out.println("It's a warm day.");
        } else {
            System.out.println("It's a cold day.");
        }

        // Ternary operator
        int income = 120_000;
        String className = (income > 100_000) ? "First class" : "Economy";

        String userRole = "admin";
        switch(userRole) {
            case "admin": {
                System.out.println("You are an admin.");
                break; // The `break` is necessary, otherwise the other case expressions get evaluated regardless of the condition!
            }
            case "moderator": {
                System.out.println("Lead the discussion.");
                break;
            }
            default: {
                System.out.println("You are a guest");
            }
        }

        // For loop
        for (int i = 0; i < 5; i++) {
            System.out.println("Heyo" + i);
        }

        // While loop
        int i = 0;
        while (i < 5) {
            System.out.println("Aloha" + i);
            i++;
        }
        // User inputs + reference types comparison
        Scanner scanner = new Scanner(System.in);
        String input = "";
        // while (input != "quit")
        /*
        Doesn't work, because string is a reference type. Reference types return the memory address, so the comparison would compare the memory address of the `input` variable with the memory address of the temporary variable that holds the `quit` string.
         */
        while (!input.equals("quit")) {
            System.out.println("Input: ");
            input = scanner.nextLine()
                    .trim()
                    .toLowerCase();
            System.out.println(input);
        }
        // A better version -- the loop ends only with the input "quit"
        while (true) {
            System.out.println("Input: ");
            input = scanner.nextLine()
                    .trim()
                    .toLowerCase();
            if (input.equals("continue"))
                continue; // Continue resets the control flow back to the start of the loop
            if (input.equals("quit"))
                break; // Don't print "quit" when the `input` is "quit"
            System.out.println(input);
        }
        // Do-while
        // The `do` code block runs before Java evaluates the `while` condition; so the `do` code block runs always. In contrast, the `while` loop doesn't have to run if it's loop condition evaluates to `false` before the first iteration.
        do {
            System.out.println("Input: ");
            input = scanner.nextLine()
                    .trim()
                    .toLowerCase();
            System.out.println(input);
        } while (!input.equals("quit"));
        // For-each
        String[] fruits = {"Orange", "Mango", "Papaya"};
        for (String fruit : fruits) {
            System.out.println(fruit);
        } // The type of the iterating variable `fruit` should match the type of the items in the iterated array `fruits`
        // There's no access to the index of each item in the for-each loop; the for loop has access to the index of array items.
    }
}