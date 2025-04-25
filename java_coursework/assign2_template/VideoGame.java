//CIS 2168 Data Structures
//Section 005
//Johnny Tran, tun45633@temple.edu
//Assignment Lab 2

package assign2_template;

//newer Java API for handling date values
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class VideoGame implements Comparable<VideoGame> {

    //2.2.1 Entity Class - VideoGame
    
    private static final int DEFAULT_NUMBER_OF_PLATFORMS = 5;    

    //data fields
    private String title;
    private String developer;     //lead developer 
    private String platforms[];
    private LocalDate releaseDate;

    
    @Override
    public String toString() {
        //add your code
        //return a string including all infor. about a game
        
        // See examples in: Animal class, Computer class        
        
        // date value included in format: 9/15/2020 for Sep. 15, 2020
        
        //display date values in US format:
        //    Get a DateTimeFormatter object with the specified pattern
        //    Use the DateTimeFormatter object to call format(..) method.         
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return "Game Title: " + title + "\n" + "Lead Developer: " + developer + "\n" + "Platforms: " + Arrays.toString(platforms) + 
        "\n" + "Release Date: " + dateFormatter.format(releaseDate);
    }

    @Override
    public boolean equals(Object otherObject) {
        //add your code
        // comparing two VideoGame objects based only on title
        
        //see example in DirectoryEntryV2.java in pkg: arraylist
        String thisGame = this.title;
        String otherGame = otherObject.title;

        if (thisGame.compareTo(otherGame) != 0) { //compareTo will return -1 or 1 if the titles are different 
            return false;
        }
        else { //if compareTo does return 0 then the titles are the same
            return true;
        }
        

    }  
    
    
    //******The following code don't need to be changed.*****//
    
    //You don't need to change this method.
    //This method is used in adding VideoGame.
    @Override 
    public int compareTo(VideoGame other) {
        return this.title.compareTo(other.title);
    }   
    
    //no-argument constructor
    public VideoGame() {
        platforms = new String[DEFAULT_NUMBER_OF_PLATFORMS];
    }    
    
    //constructor taking in values for all data fields
    public VideoGame(String title, String developer, String[] platforms, LocalDate releaseDate) {
        this.title = title;
        this.developer = developer;
        this.platforms = platforms;
        this.releaseDate = releaseDate;
    }

    //getters
    public String getTitle() {
        return title;
    }

    public String getDeveloper() {
        return developer;
    }

    public String[] getPlatforms() {
        return platforms;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setPlatforms(String[] platforms) {
        this.platforms = platforms;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }    
}
