public class Main {

    public static void main(String[] args) {

        double kilometers = (100 * 1.609344);

        int highScore = 50;
        if (highScore > 25) {
            int points = 1000 * highScore; // Add bonus points
        }

        int health = 100;
        if ((health < 25) && highScore > 100) {
            int points = highScore - 1000;
        }
    }
}
