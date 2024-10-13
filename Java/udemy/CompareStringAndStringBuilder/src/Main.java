public class Main {

    public static void main(String[] args){

        String hello = "Hello";
        hello.concat(" and bye"); // Since Strings are immutable, Java creates another object for the concatenation result.
                                      // This new object is not assigned to any variable/value, so it's not printed.
                                      // `hello` still has it's original value.

        StringBuilder helloBuilder = new StringBuilder("Hello");
        helloBuilder.append(" and bye");

        printInformation(hello);
        printInformation(helloBuilder);
    }

    public static void printInformation(String string){

        System.out.println("String = " + string);
        System.out.println("String length = " + string.length());
    }

    public static void printInformation(StringBuilder builder){

        System.out.println("StringBuilder = " + builder);
        System.out.println("StringBuilder length = " + builder.length());
    }
}
