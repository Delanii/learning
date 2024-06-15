import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {

        System.out.println("First test: " + sumDigits(156) +
                " Second test: " + sumDigits(1000) +
                " Third test: " + sumDigits(3) +
                " Fourth test: " + sumDigits(-5));
    }

    public static int sumDigits(int number) {

        if (number < 0) {
            return -1;
        }

        int sum = 0;

        do {
            int smallEndian = number % 10;
            sum += smallEndian;
            number = (int)number / 10;
        } while (number > 0);

        return sum;
    }
}
