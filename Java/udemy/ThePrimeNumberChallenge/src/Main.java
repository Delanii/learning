public class Main {

    public static void main(String[] args) {

        int primeCounter = 0;

        for (int number = -1; number <= 1000; number++){
            if (isPrime(number)){
                System.out.println(number + " is a prime number.");
                primeCounter++;
            }

            if (primeCounter == 20) {
                break;
            }
        }
    }

    public static boolean isPrime(int number){

        if (number <= 2) {
            return (number == 2);
        }

        for (int divisor = 2; divisor <= number / 2 ; divisor++){ // it's good to reduce number of iterations whenever possible.
            // For example, every number divisable by a half of the number are divisable also by the actual number.
            // So the number of the iterations can be halved.
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;

    }
}
