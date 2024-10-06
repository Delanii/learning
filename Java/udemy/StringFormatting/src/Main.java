public class Main {

    public static void main(String[] args){

        String bulletIt = "Print a bullet list:\n" +
                "\t\u2022 First point\n" +
                "\t\u2022 Second point";

        System.out.println(bulletIt);

        String textBlock =
                """
                Print a bulleted list:
                
                \u2022 First point
                \u2022 Second point
                """;

        System.out.println("\n\n");
        System.out.println(textBlock);

        int age = 35;
        System.out.printf("Your age is %d%n.", age);

        System.out.printf("Your age is %.2f%n", (float)age);

        for(int i = 0; i < 5; i++){
            System.out.printf("Set the number width: %3d%n", i);
        }

        String formattedString = String.format("Your age is %d", age);
        System.out.println(formattedString);

        String otherString = "Your age is %d".formatted(age);
        System.out.println(otherString);

        String myTestString = "My test string.";
        printStatistics(myTestString);
        printStatistics("");

        System.out.printf("Index of r in \"%s\" is: %d%n", myTestString, myTestString.indexOf('r'));
        System.out.printf("Last index of s in \"%s\" is: %d%n", myTestString, myTestString.lastIndexOf('s'));

        String dateString = "14/11/2011";
        System.out.println(dateString.replace('/', '-'));
        System.out.println(dateString.replace("1", "-x-"));
        System.out.println(dateString.replaceFirst("1", "-*-"));
        System.out.println(dateString.replaceAll("1", "-#-"));

        int headerLength = 20;
        System.out.println("-".repeat(headerLength));
    }

    public static void printStatistics(String string) {

        if (string.isEmpty() || string.isBlank()) {
            System.out.println("\nString is either empty or contains only white space characters.\n");
            return;
        }

        int length = string.length();
        System.out.printf("%n" +
                "Length: %d%n" +
                "First character: %c%n" +
                "Last character: %c%n",
                length, string.charAt(0), string.charAt(length - 1));
    }
}
