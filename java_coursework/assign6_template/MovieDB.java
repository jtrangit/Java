//CIS 2168 Data Structures
//Section 005
//Johnny Tran, tun45633@temple.edu
//Assignment Lab 10

package assign6_template;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MovieDB {

    //movie database, to be implemented as an array list (better)
    private List<Movie> movieDB;

    //initial capacity of the movie database (max number of movies can be stored initially) 
    private static final int INITIAL_CAPACITY = 20;

    //the number of movies in the starter movie database
    private static final int STARTER_MOVIEDB_SIZE = 15;

    //titleIndex datafield
    //both Set interface and TreeSet class in Java API
    Set<IndexEntry> titleIndex = new TreeSet<>();

    
    //constructor of MovieDB
    public MovieDB() {
        //create the object for the empty movieDB
        movieDB = new ArrayList<Movie>();
        //Create the object for the empty index tree.
        titleIndex = new TreeSet<>();
        
    }

    //create a starter movie DB:
    public void createStartMovieDB() {        
        //movie counter start at 0
        int movieCount = 0;

        //random numbers
        Random randomNumberGenerator = new Random();
        
        //hashset to check number uniqueness
        HashSet<Integer> movieSet = new HashSet<Integer>();
        
        while (movieCount != STARTER_MOVIEDB_SIZE) { //loop until max movie size
            int randomNumber = randomNumberGenerator.nextInt(STARTER_MOVIEDB_SIZE) + 1; //random number between 1-15(max movie size)
             
            if (movieSet.contains(randomNumber)) { //dupe movie number
                continue; //do nothing since its a dupe
            }

            else { //unique number

                //add unique number to hashset
                movieSet.add(randomNumber);

                //create movie object for unique number and add it to movieDB
                Movie randomMovie = new Movie("Title" + randomNumber, "Director" + randomNumber, 2002);
                movieDB.add(randomMovie);
                
                //increase movie counter
                movieCount++;
            }
        }
    }

    //display the movies in the database in a nice tabular format
    public void showMovieDB() {
        System.out.println("Movie Database:");
        System.out.println("");
        System.out.println("               Title             Director                 Year        ");
        System.out.println("---------------------------------------------------------------------------------");
        for (Movie movie : movieDB) { //iterate through all movies in movieDB
            System.out.println(String.format("%20s %20s %20s", movie.getTitle(), movie.getDirector(), movie.getYear())); //print them out in TITLE  DIRECTOR  YEAR format
        }

    }

    //create the index tree for all titles (unique) in the current movieDB
    public void createIndex() {
        //add your own code
        
        //Hint:
        //  It’s very similar to createIndex() in the class IndexGenerator in the package set_map_use_demo posted for Lec#19.
        //  The difference is in handling the index entry in different stored format.    
        
        //for each movie in the moiveDB list
        //   create an index entry for this movie using IndexEntry class
        //      (example index entry in displayed format: Title15  0)
        //   add this IndexEntry object to the data field: titleIndex

        //loop through the movies
        for (int i = 0; i < movieDB.size(); i++) { 
            IndexEntry indexEntry = new IndexEntry(movieDB.get(i).getTitle(), i); //get the movie title and index
            titleIndex.add(indexEntry); //put movie title and index into titleIndex TreeSet
        }
    }

    //display the title index in in a tabular format
    public void showIndex() {
        System.out.println("Title Index:");
        System.out.println("               Title        Location  ");
        System.out.println("---------------------------------------------------");
        for (IndexEntry indexEntry : titleIndex) { //iterate through IndexEntry
            System.out.println(String.format("%20s %15s", indexEntry.getTitle(), indexEntry.getLocation())); //print out in TITLE  INDEX format 
        }
    }    
    
    public static void main(String[] args) {
         /* 
         
        //create a random number generator
         Random randomNumberGenerator = new Random();
         //get a random integer between 0 (inclusive) and 200 (exclusive)
         // 0, 1, 2, ... ,199
         int randomNumber = randomNumberGenerator.nextInt(200);
         System.out.println(randomNumber);  
         //get a random integer between 1 (inclusive) and 200 (inclusive)
         // 1, 2, 3, ...., 200
         randomNumber = randomNumberGenerator.nextInt(200) + 1;
         System.out.println(randomNumber);

         */
    }

}
