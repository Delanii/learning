import java.util.Date;

public class Main {

    public static void main(String[] args) {
        byte age = 10; /* Initialization */
        age = 25; /* Just assignment */

        byte myAge = 16;
        byte newAge = myAge; /* Copy the `myAge` variable into the `age` variable */

        int viewsCount = 123_456_789; /* For large numbers, you can separate thousands with underscores */

        long aLotOfViews = 3_123_456_789L; /* Suffix numbers with the `long` type with `L`; otherwise IDE recognizes number with underscores as the `int` type */

        float price = 10.99F; /* Again, Java sets the type of a floating-point value to `double`. If I want float, I have to add a `F` suffix. */

        char letter = 'A'; /* For chars, use single quotes */

        boolean isEligible = true;

        Date now = new Date();

        System.out.println(age);
        System.out.println(newAge);
    }
}