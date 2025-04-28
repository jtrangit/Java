//Johnny Tran Section 
//2. 22. 2022
//Assignment 6. A Game

//Program will ask to play a game of Uppfora with the user 
//Uppfora being a more complicated version of rock paper scissors

import java.util.Random;
import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int roundsPlayed = 0;
        int pWins = 0;
        int cWins = 0;

        startGame();
        
        while (true) {
            int x = whoWon();
    
            if (x == 1) {
                roundsPlayed++;
                cWins++;
            }
            else {
                roundsPlayed++;
                pWins++;
            }

            System.out.println("Do you want to play another round? (Y/N)");
            if (scan.nextLine().equals("Y")) {
                
            }
            else {
                System.out.println("Number of rounds played: " + roundsPlayed);
                System.out.println("Player Wins: " + pWins);
                System.out.println("Computer Wins: " + cWins);
                break;
            }
        }
    }
    static void startGame() {
        Scanner scan = new Scanner(System.in);

        //Asks user if they want to play
        System.out.println("Would you like to play a game of Uppfora? (Y or N)");
        char answer = scan.next().charAt(0);

        if (answer == 'Y' || answer == 'y') { //If player says yes, computer prints the rules and starts the game
            //Prints the Rules of the game
            System.out.println("Pershult beats Klyket, Skadis");
            System.out.println("Klyket beats Tjusig, Hovolm");
            System.out.println("Tjusig beats Pershult, Skadis");
            System.out.println("Skadis Beats Hovolm, Klyket");
            System.out.println("Hovolm beats Pershult, Tjusig");
        }
        else if (answer == 'N' || answer == 'n') { //If player says no, program ends
            System.exit(0);
        }
    }
    static String playerInput() {
        String[] validMoves = {"Skadis","Tjusig","Klyket","Hovolm","Pershult"};
        Scanner sc = new Scanner(System.in);
        
        //Player's first move
        System.out.println("Enter your move: (Skadis, Tjusig, Klyket, Hovolm, or Pershult)");
        String playerMove = sc.nextLine();
        
        while (!(playerMove.equals(validMoves[0]) || playerMove.equals(validMoves[1]) || playerMove.equals(validMoves[2]) || playerMove.equals(validMoves[3]) || playerMove.equals(validMoves[4]))) {
                System.out.println("Invalid move try again");
                playerMove = sc.nextLine();
            }
        System.out.println("Your move is " + playerMove);
        return playerMove;
        }
    static String computerInput() {
        Random rnd = new Random();
        int compRandom = rnd.nextInt(5);
        String compMove;

        if (compRandom == 0) {
            System.out.println("The Computer's move is Skadis");
            compMove = "Skadis";
        }
        else if (compRandom == 1) {
            System.out.println("The Computer's move is Tjusig");
            compMove = "Tjusig";
        }
        else if (compRandom == 2) {
            System.out.println("The Computer's move is Klyket");
            compMove = "Klyket";
        }
        else if (compRandom == 3) {
            System.out.println("The Computer's move is Hovolm");
            compMove = "Hovolm";
        }
        else {
            System.out.println("The Computer's move is Pershult");
            compMove = "Pershult";
        }
        return compMove;
    }
    static int whoWon() {
        String x = playerInput();
        String y = computerInput();
        int winner = 0; //0 meaning the player won 1 meaning computer won

    
        if (x.equals(y)) { //Tie if computer and player pick the same move
            System.out.println("Game is a tie");
            System.out.println("Computer Wins");
            winner = 1;
        }
        //Skadis outcomes
        else if (x.equals("Skadis") && y.equals("Hovolm")) {
            System.out.println("Skadis beats Hovolm");
            System.out.println("Player Wins");
        }
        else if (x.equals("Skadis") && y.equals("Klyket")) {
            System.out.println("Skadis beats Klyket");
            System.out.println("Player Wins");
        }
        else if (x.equals("Skadis") && y.equals("Tjusig")) {
            System.out.println("Tjusig beats Skadis");
            System.out.println("Computer Wins");
            winner = 1;
        }
        else if (x.equals("Skadis") && y.equals("Pershult")) {
            System.out.println("Pershult beats Skadis");
            System.out.println("Computer Wins");
            winner = 1;
        }
        //Tjusig outcomes
        else if (x.equals("Tjusig") && y.equals("Pershult")) {
            System.out.println("Tjusig beats Pershult");
            System.out.println("Player Wins");
        }
        else if (x.equals("Tjusig") && y.equals("Skadis")) {
            System.out.println("Tjusig beats Skadis");
            System.out.println("Player Wins");
        }
        else if (x.equals("Tjusig") && y.equals("Klyket")) {
            System.out.println("Klyket beats Tjusig");
            System.out.println("Computer Wins");
            winner = 1;
        }
        else if (x.equals("Tjusig") && y.equals("Hovolm")) {
            System.out.println("Hovolm beats Tjusig");
            System.out.println("Computer Wins");
            winner = 1;
        }
        //Klyket outcomes
        else if (x.equals("Klyket") && y.equals("Tjusig")) {
            System.out.println("Klyket beats Tjusig");
            System.out.println("Player Wins");
        }
        else if (x.equals("Klyket") && y.equals("Hovolm")) {
            System.out.println("Klyket beats Hovolm");
            System.out.println("Player Wins");
        }
        else if (x.equals("Klyket") && y.equals("Pershult")) {
            System.out.println("Pershult beats Klyket");
            System.out.println("Computer Wins");
            winner = 1;
        }
        else if (x.equals("Klyket") && y.equals("Skadis")) {
            System.out.println("Skadis beats Klyket");
            System.out.println("Computer Wins");
            winner = 1;
        }
        //Pershult outcomes
        else if (x.equals("Pershult") && y.equals("Klyket")) {
            System.out.println("Pershult beats Klyket");
            System.out.println("Player Wins");
        }
        else if (x.equals("Pershult") && y.equals("Skadis")) {
            System.out.println("Pershult beats Skadis");
            System.out.println("Player Wins");
        }
        else if (x.equals("Pershult") && y.equals("Hovolm")) {
            System.out.println("Hovolm beats Pershult");
            System.out.println("Computer Wins");
            winner = 1;
        }
        else if (x.equals("Pershult") && y.equals("Tjusig")) {
            System.out.println("Tjusig beats Pershult");
            System.out.println("Computer Wins");
            winner = 1;
        }
        //Hovolm outcomes
        else if (x.equals("Hovolm") && y.equals("Pershult")) {
            System.out.println("Hovolm beats Pershult");
            System.out.println("Player Wins");
        }
        else if (x.equals("Hovolm") && y.equals("Tjusig")) {
            System.out.println("Hovolm beats Tjusig");
            System.out.println("Player Wins");
        }
        else if (x.equals("Hovolm") && y.equals("Skadis")) {
            System.out.println("Skadis beats Hovolm");
            System.out.println("Computer Wins");
            winner = 1;
        }
        else if (x.equals("Hovolm") && y.equals("Klyket")) {
            System.out.println("Klyket beats Hovolm");
            System.out.println("Computer Wins");
            winner = 1;
        }
        return winner;
    }

}

        

