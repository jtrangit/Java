//CIS 2168 Data Structures
//Section 005
//Johnny Tran, tun45633@temple.edu
//Assign 4, HiringApp

package assign4_template;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class HiringApp {

    public static void main(String[] args) {        
        Queue<Person> applicants = new ArrayDeque<>(); //Queue for applicants since first person gets hired
        Deque<Person> currentEmployees = new ArrayDeque<>(); //stack for current employees since last person gets fired
        Deque<Person> pastEmployees = new ArrayDeque<>(); //stack for past employees since last person fired gets rehired

        int exit = 0;

        while (exit == 0) {
            System.out.println("(1 to accept)"); //menu
            System.out.println("(2 to hire)");
            System.out.println("(3 to fire)");
            System.out.println("(4 to exit)");

            switch(getChoice()) {
                case 1:
                applicants.add(getApplication()); //new applicants
                break;
                case 2: //hiring
                    if (applicants.size() == 0 && pastEmployees.size() == 0) { //no recently fired employee or new applicants we cant hire anyone
                        System.out.println("There is no one to hire");
                    }
                    else if (pastEmployees.size() == 0) { //if there are no recently fired employees hire a new applicant
                        currentEmployees.push(applicants.poll());
                        System.out.println(currentEmployees.peek() + " hired");
                    }
                    else if (pastEmployees.size() >= 1) { //hire the most recently fired employee
                        currentEmployees.push(pastEmployees.pop());
                        System.out.println(currentEmployees.peek() + " hired");
                    }
                    break;
                case 3:
                    if (currentEmployees.size() == 0) { //empty employee stack cannot fire anyone
                        System.out.println("There is no one to fire");
                    }
                    else if (currentEmployees.size() >= 1) { //if we can fire, fire the most recent employee and push them to the past employee stack
                        pastEmployees.push(currentEmployees.pop());
                        System.out.println(pastEmployees.peek() + " fired");
                    }
                    break;
                case 4:
                exit++;
            }
        }
    }

    //get user choice
    public static int getChoice() {
        Scanner kb = new Scanner(System.in); //scanner

        while (true) {
            //System.out.println("(Action: 1 to accept, 2 to hire, 3 to fire, 4 to quit): ");
            int userChoice = kb.nextInt();
            if (userChoice >= 1 && userChoice <= 3) { //valid user input 1-3
                return userChoice;
            }
        }
    }

    //method for accepting an applicant and return this applicant as a Person object
    public static Person getApplication() {
        Scanner kb = new Scanner(System.in); //scanner
        
        System.out.println("Enter applicant's name: "); //user input for person name
        String name = kb.nextLine();

        System.out.println("Enter applicant's degree: "); //user input for person degree
        String degree = kb.nextLine();

        System.out.println("Enter number of applicant's skills: "); //user input for person skills
        int numSkills = kb.nextInt(); //number of skills 

        ArrayList<String> skills = new ArrayList<String>();

        for (int i = 0; i < numSkills; i++) { //iterates number of skills for user to input them individually
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the applicant's skills: ");
            skills.add(scan.nextLine());
        }

        Person newApplicant = new Person(name, degree, skills); //returns applicant Person object
        return newApplicant;
    }
}
