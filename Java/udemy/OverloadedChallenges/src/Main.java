public class Main {

    public static void main(String[] args){

        System.out.println(convertToCentimeters(6));
        System.out.println(convertToCentimeters(6, 6));
    }

    public static double convertToCentimeters(int inches){
        return inches * 2.54;
    }

    public static double convertToCentimeters(int feet, int inches){
        return feet * 30.48 + convertToCentimeters(inches);
    }
}
