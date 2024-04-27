public class MainChallenge {

    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 5000;
        int levelCompleted = 5;
        int bonus = 100;

        int highScore = calculateScore(gameOver,
                score,
                levelCompleted,
                bonus);
        System.out.println("The high score is " + highScore);

        score = 10_000;
        levelCompleted = 8;
        bonus = 200;

        highScore = calculateScore(gameOver,
                score,
                levelCompleted,
                bonus);

        System.out.println("The high score is " + highScore);

    }

    public static int calculateScore(boolean gameOver,
                                      int score,
                                      int levelCompleted,
                                      int bonus){

        int finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
        }

        return finalScore;
    }

}
