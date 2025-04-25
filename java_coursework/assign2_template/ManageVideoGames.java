//CIS 2168 Data Structures
//Section 005
//Johnny Tran, tun45633@temple.edu
//Assignment Lab 2

package assign2_template;

import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import javafx.application.Platform;

public class ManageVideoGames {

    public static void main(String[] args) {
        
        //2.2.2 Application Class - ManageVideoGames
                
        //create an empty list of VideoGames
        List<VideoGame> gameList = new LinkedList<>();
        
        int exit = 0;

        while (exit == 0) {
        //1. display menu
        displayMenu();
        //2. get user choice
            switch(getUserChoice()) {
                //3. take action based on user choice
                case 1:
                addGame(gameList);
                break;
                case 2: 
                removeGame(gameList);
                break;
                case 3:
                System.out.println(gameList);
                break;
                case 4:
                System.out.println(getLatestRelease(gameList));
                break;
                case 5:
                System.out.println("Did not do the bonus");
                break;
                case 6:
                exit++;
            }
        }
        
        //4. loop through steps 1, 2, 3 above until user quits
        
    }

    //define other methods for modularization, samples are listed below.
    
    //method to display menu
    public static void displayMenu() {
        //add your code
        //display the menu like the one in Page 5 of Assign2.pdf 
        System.out.println("1. Add new game");
        System.out.println("2. Remove an existing game");
        System.out.println("3. Display the games in the order they were inserted");
        System.out.println("4. Find games with latest release");
        System.out.println("5. Add a new game in the alphabetical order of game titles");
        System.out.println("6. Exit");        
    }    
    
    //method to get and return the user choice of menu items.
    public static int getUserChoice() {
        //add your code
        // keep reading user input until user enters correct menu choice number,
        // then return the user choice number
        Scanner kb = new Scanner(System.in); //scanner

        while (true) {
            System.out.println("Enter a number to make your selection: ");
            int userChoice = kb.nextInt();
            if (userChoice >= 1 && userChoice <= 6) { //valid user input 1-6
                return userChoice;
            }
            else { 
            // if invalid input ask user to input again
            }
        }
    }    
    
    
    //method to get user input, create and return a video game
    public static VideoGame getNewGame() {
        //add your code here
        /*
        get new game based on user input:
        keyboard input
          game title:
             use nextLine() to avoid problems caused by newline character
          platforms: 
             get how-many: int
             then use a loop to get each platform.

          date value: 
            get 3 integers: month, day, year
            use LocaleDate.of(year, month, day) to create a date
            (see TestDate.java for details)
        */               
        Scanner kb = new Scanner(System.in); //scanner

        System.out.println("Enter game title: ");
        String title = kb.nextLine();

        System.out.println("Enter the lead developer: ");
        String leadDev = kb.nextLine();

        //num of platforms
        System.out.println("Enter number of platforms: ");
        int numPlat = kb.nextInt();
        String gameplats[] = new String[numPlat];
        
        //loop to enter the amount of platforms
        for (int i = 0; i < numPlat; i++) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the platforms: ");
            gameplats[i] = scan.nextLine();
        }
       
        //getting month day and year 
        System.out.println("Enter release month: ");
        int month = kb.nextInt();  
        System.out.println("Enter release day: ");
        int day = kb.nextInt();
        System.out.println("Enter release year: ");
        int year = kb.nextInt();

        LocalDate releaseDate = LocalDate.of(year, month, day);
        System.out.println("Release Date: " + releaseDate);

        //returning the new video game object
        VideoGame newGame = new VideoGame(title, leadDev, gameplats, releaseDate);
        return newGame;
    }     
    
    //method to add a video game without maintaining sorted order
    //add your own code
    public static void addGame(List<VideoGame> gameList) {
        gameList.add(getNewGame());
    }

    //method to remove a game based on user input
    //add your own code  
    public static void removeGame(List<VideoGame> gameList) {
        Scanner kb = new Scanner(System.in); //scanner
        System.out.println("Title of game to remove: ");
        String gameTitle = kb.nextLine();

        for (int i = 0; i < gameList.size(); i++) {
            if (gameList.get(i).getTitle().equals(gameTitle)) {
                gameList.remove(i);
            }
        }
    }

    //method to find the game with latest release date
    //add your own code    
    /*
    find game with latest release date
       simple assumption: only one game has the latest release date.
       need to loop through the collection and find the latest release date                                                        (largest)
            while looping, 
               record and update the current latest release date value 
                   and the corresponding VideoGame object.

       compare dates: isBefore, isAfter, or compareTo
          (see TestDate.java for details)
    */    
    public static VideoGame getLatestRelease(List<VideoGame> gameList) {
        LocalDate latestRelease = gameList.get(0).getReleaseDate();
        VideoGame latestGame = gameList.get(0);
        for (int i = 1; i < gameList.size(); i++) {
            if (gameList.get(i).getReleaseDate().compareTo(latestRelease) > 0) {
                latestRelease = gameList.get(i).getReleaseDate();
                latestGame = gameList.get(i);
            }
        }
        return latestGame;
    }
    
    //OPTIONAL BONUS:
    //  method to add a video game in alphabetical order of game titles
    //add your own code   
    /*    
     add new game in alphabetical order of game titles
        Do not append the new game to the current collection and then sort the entire collection. 
	Instead,
           start with the first game, 
           loop through the collection and 
               find the first game whose title is alphabetically larger than the new game. 
               Then insert the new game at the location, say [j], of this target.
                  As the result of the insertion, this target will be at [j+1].
           If no existing game title is larger than the new game,
               append the new game to the end of game collection list.     
   */  
}
