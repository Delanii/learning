public class Main {

    public static void main(String[] args) {

        int number = 5;
        int evenCount = 0;
        int oddCount = 0;

        while (true) {

            if (number > 20 || evenCount >= 5) {
                break;
            }

            if(isEvenNumber(number)) {
                System.out.println(number);
                evenCount++;
            } else {
                oddCount++;
            }

            number++;
        }

        System.out.println("Count of even numbers: " + evenCount);
        System.out.println("Count of odd numbers: " + oddCount);
    }

    public static boolean isEvenNumber(int number){

        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
