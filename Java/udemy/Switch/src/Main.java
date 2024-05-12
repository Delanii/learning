public class Main {

    public static void main(String[] args){

        int myvalue = 3;

        switch (myvalue) {
            case 1 -> {
                System.out.println("Value was 1");
            }
            case 2 -> {
                System.out.println("Value was 2");
            }
            case 3, 4, 5 -> {
                System.out.println("Value was 3, 4 or 5");
            }
            default -> {
                System.out.println("Unknown value.");
            }
        }

        String month = "April";
        System.out.println("The month " +
                month +
                " is in the " +
                getQuarter(month) +
                " quarter.");
    }

    public static String getQuarter(String month){

        return switch(month) {
            case "January", "February", "March" -> {
                yield "1st";
            }
            case "April", "May", "June" -> "2nd";
            case "July", "August", "September" -> "3rd";
            case "October", "November", "December" -> "4th";
            default -> {
                String badResponse = month + " is bad";
                yield  badResponse;
            }
        };
    }
}
