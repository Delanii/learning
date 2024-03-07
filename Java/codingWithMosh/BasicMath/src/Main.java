import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        int result = 6 + 9;

        System.out.println(result);

        // Explicit typecasting
        double nextResult = (double)10 / (double)3;

        System.out.println(nextResult);

        int x = 3;
        x++;
        System.out.println(x);

        int y = 4;
        y = y + 2;
        // y += 2; // the same as `y = y + 2`
        // -= ; *= and /= are also valid

        System.out.println(y);

        short a = 1;
        int b = a + 2; // `a` here is implicitly typecast from `short` to `int`. What happens in memory is that Java creates an anonymous variable with the `int` size and copies the value of `a` into the anonymous variable.
        System.out.println(b);

        // Another implicit typecast
        double c = 1.1;
        double d = c + 2;
        System.out.println(d);

        // Type conversion
        String e = "1";
        int f = Integer.parseInt(e) + 2; // `Integer` is a wrapper class for the primitive `int` type, that contains utility functions, like parsers
        System.out.println(f);

        int g = Math.round(2.1F);
        System.out.println(g);

        double h = Math.random();
        int i = Math.max(1, 5);
        System.out.println(i);

        // `NumberFormat` is a class with functions to format numbers. `NumberFormat` is an abstract class and cannot be instantiated.
        // `getCurrencyInstance` is a "factory method". Factory methods create new objects. `getCurrencyInstance` returns an object with the `NumberFormat` class
        NumberFormat price = NumberFormat.getCurrencyInstance();
        String showPrice = price.format(1345.534);
        System.out.println(showPrice);

        NumberFormat ratio = NumberFormat.getPercentInstance();
        String showRatio = ratio.format(0.654);
        System.out.println(showRatio);

        String showRatioB = NumberFormat.getPercentInstance().format(0.744);
        System.out.println(showRatioB);
    }
}