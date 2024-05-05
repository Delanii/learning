public class Main {

    public static void main(String[] args){

        System.out.println(getDurationString(-30));
        System.out.println(getDurationString(0));
        System.out.println(getDurationString(30));
        System.out.println(getDurationString(258));
        System.out.println(getDurationString(22258));

        System.out.println(getDurationString(-5, -3));
        System.out.println(getDurationString(-5, 3));
        System.out.println(getDurationString(5, -3));
        System.out.println(getDurationString(5, 69));
        System.out.println(getDurationString(0, 9));
        System.out.println(getDurationString(5, 9));
        System.out.println(getDurationString(129, 9));
    }

    public static String getDurationString(int seconds){
        if (isValid(seconds)) {

            int hours = convertToHours(seconds);
            int minutes = convertToMinutes(seconds) % 60;
            int remainder = seconds % 60;

            return padNumbers(hours) + "h " +
                    padNumbers(minutes) + "m " +
                    padNumbers(remainder) + "s";
        } else {
            return "The number of seconds must be a positive number.";
        }
    }

    public static String getDurationString(int minutes, int seconds){
        if (isValid(minutes, seconds)) {

            int totalSeconds = minutes * 60 + seconds;
            return getDurationString(totalSeconds);

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

    private static int convertToHours(int seconds){
        return (int)Math.floor(convertToMinutes(seconds) / 60);
    }

    private static int convertToMinutes(int seconds){
        return (int)Math.floor(seconds / 60);
    }

    private static String padNumbers(int number){
        if (number < 10){
            return "0" + number;
        } else {
            return String.valueOf(number);
        }
    }
}
