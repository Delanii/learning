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
    }
}