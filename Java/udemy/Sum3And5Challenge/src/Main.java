public class Main {

    public static void main(String[] args) {

        int counter = 0;
        int sum = 0;

        for (int number = 1; number <= 1000; number++){

            if ((number % 3 == 0) && (number % 5 == 0)) {

                System.out.println(number + "is divisibe by both 3 and 5");

                sum += number;
                counter++;
            }

            if (counter == 5){
                break;
            }
        }

        System.out.println("The total is: " + sum);
    }
}
