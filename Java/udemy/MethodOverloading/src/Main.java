public class Main {

    public static void main(String[] args) {

        System.out.println("New score is " + calculateScore("Tom", 95));
        System.out.println("New score is " + calculateScore(25));
        calculateScore();
    }

    public static int calculateScore(String playerName,
                                     int score){

        System.out.println("Player " +
                playerName +
                " scored " +
                score +
                " points.");
        return score * 1000;
    }

    public static int calculateScore(int score){

        return calculateScore("Anonymous",
                score);
    }

    public static void calculateScore(){

        System.out.println("No player, no score.");
    }
}
