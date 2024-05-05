public class Main {

    public static main(String[] args){

    }

    public static String getDurationString(int seconds){
        if (isValid(seconds)) {

            int hours = seconds % 3600;
            int minutes = (seconds - (hours * 3600)) % 60;
            int remainder = seconds - hours * 3600 - minutes * 60;

            return padNumbers(hours) + "h " +
                    padNumbers(minutes) + "m " +
                    padNumbers(remainder) + "s";
        } else {
            return "The number of seconds must be a positive number.";
        }
    }

    public static String getDurationString(int minutes, int seconds){
        if (isValid(minutes, seconds)) {

            int hours = minutes % 60;
            int minutesRemainder = minutes - hours * 60;

            return padNumbers(hours) + "h " +
                    padNumbers(minutesRemainder) + "m " +
                    padNumbers(seconds);
        } else {
            return "You provided invalid values. Minutes and seconds have to be a positive number," +
                    " and seconds have to also less than 59";
        }
    }

    private static boolean isValid(int seconds){
        if (seconds >= 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isValid(int minutes, int seconds){
        if ((seconds >= 0) && (seconds <= 59) && (minutes >= 0)) {
            return true;
        } else {
            return false;
        }
    }

    private static String padNumbers(int number){
        if (number < 10){
            return "0" + number;
        } else {
            return String.valueOf(number);
        }
    }
}
