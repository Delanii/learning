public class NextMain {

    public static void main(String[] args){


        Movie movie = Movie.getMovie("A", "Space Invaders");
        movie.watchMovie();

        Adventure invaders = (Adventure) Movie.getMovie("A", "Space Invaders"); // here, the compiler doesn't know if the Movie
          // returned from the `getMovie` factory can be assigned to the `Adventure` class, because the object is created
          // at runtime. The type has to be cast from the `Movie` class to the `Adventure` class explicitly.
        invaders.watchMovie();

        Object comedy = Movie.getMovie("C", "The Pink panther");
        Comedy comedyMovie = (Comedy) comedy;
        comedyMovie.watchComedy();

        var airplane = Movie.getMovie("C", "Airplane");
        airplane.watchMovie();

        Object unknownObject = Movie.getMovie("C", "Hot shots");
        if (unknownObject.getClass().getSimpleName() == "Comedy") {
            Comedy c = (Comedy) unknownObject;
            c.watchComedy();
        } else if (unknownObject instanceof Adventure) {
            ((Adventure) unknownObject).watchAdventure();
        } else if (unknownObject instanceof Scifi syfy) {
            syfy.watchScifi();
        }
    }
}
