public class MethodChallenge {

    public static void main(String[] args) {

        int position;

        position = calculateHighScorePosition(1500);
        displayHighScorePosition("Test 1",
                position);

        position = calculateHighScorePosition(1000);
        displayHighScorePosition("Test 2",
                position);

        position = calculateHighScorePosition(500);
        displayHighScorePosition("Test 3",
                position);

        position = calculateHighScorePosition(100);
        displayHighScorePosition("Test 4",
                position);

        position = calculateHighScorePosition(25);
        displayHighScorePosition("Test 5",
                position);

    }

        public static void displayHighScorePosition(String playerName,
        int position){

            System.out.println(playerName +
                    " managed to get into the position " +
                    position +
                    " in player rankings.");
        }

        public static int calculateHighScorePosition(int score){
            int position = 4; // default position

            if(score >= 1000){
                position = 1;
            }

            if((score >= 500) && (score < 1000)){
                position = 2;
            }

            if((score >= 100) && (score < 500)) {
                position = 3;
            }

            return position;
        }

    }
