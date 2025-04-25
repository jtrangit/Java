//CIS 2168 Data Structures
//Section 005
//Johnny Tran, tun45633@temple.edu
//Assignment Lab 10

package assign6_template;

public class MovieDBConsole {

    public static void main(String[] args) {
        //create an empty movie database
        MovieDB myMovieDB = new MovieDB();
        //populate the movie DB with random movie data
        myMovieDB.createStartMovieDB();
        //display the starter movie DB information
        myMovieDB.showMovieDB();

        //create the movie title index
        myMovieDB.createIndex();
        //display the movie title index
        myMovieDB.showIndex();
    }

}
