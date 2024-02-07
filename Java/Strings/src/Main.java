public class Main {
    public static void main(String[] args) {

        String message = new String("Hello World");

        String literalMessage = "Hello World"; /* Initialization with a string literal */
        String concat = "Hello World" + "!!";

        System.out.println(concat);
        System.out.println(concat.endsWith("!!"));
        System.out.println(concat.length());
        System.out.println(concat.replace("!", "*"));
    }
}