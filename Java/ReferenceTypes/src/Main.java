import java.awt.*;

public class Main {
    public static void main(String[] args) {
        byte a = 1;
        byte b = a;
        b = 2;

        System.out.println(b);

        Point point1 = new Point(1,1);
        Point point2 = point1;

        System.out.println(point2);

        point1.y = 2;

        System.out.println(point2); /* But the change's been made with the `point1` variable :scream: */
    }
}