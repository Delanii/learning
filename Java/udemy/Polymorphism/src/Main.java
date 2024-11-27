import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Movie theMovie = new Movie("Star Wars");
        theMovie.watchMovie();

        Movie otherMovie = new Adventure("Indiana Jones");
        otherMovie.watchMovie();

        Movie another = Movie.getMovie("Adventure", "Star Trek");
        another.watchMovie();

        // User input variation
        Scanner s = new Scanner(System.in);

        while(true){

            System.out.println("Enter type (A for Adventure, C for Comedy," +
                    "S for Science or Q for quit)");
            String typeInput = s.nextLine();
            char type = typeInput.charAt(0);

            if ((type == 'A') || (type == 'C') || (type == 'S')){

                System.out.println("Write the movie title: ");
                String title = s.nextLine();
                Movie loopMovie = Movie.getMovie(typeInput, title);
                loopMovie.watchMovie();

            } else if (type == 'Q') {
                break;
            } else {
                System.out.println("Invalid input.");
            }
        }
    }
}
