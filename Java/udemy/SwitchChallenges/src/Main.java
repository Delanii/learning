public class Main {

    public static void main(String[] args){

        challengeOne();

        printDayOfWeek(2);
    }

    public static void challengeOne(){

        char letter = 'A';

        switch(letter){
            case 'A' -> System.out.println("A is for Able");
            case 'B' -> System.out.println("B is for Baker");
            default -> System.out.println(letter + " not found.");
        }
    }

    public static void printDayOfWeek(int day){

        String dayName = switch(day){
          case 1 -> "Monday";
          case 2 -> "Tuesday";
          case 3 -> "Wednesday";
          case 4 -> "Thursday";
          case 5 -> "Friday";
          case 6 -> "Saturday";
          case 7 -> "Sunday";
          default -> "Unknown day";
        };

        System.out.println(day + ": " + dayName);
    }
}
