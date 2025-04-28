import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class numOfChars {
    public static void main(String[] args) throws FileNotFoundException{
        //System.out.println(countChar("text.txt"));
        //System.out.println(countWords("text.txt"));
        //System.out.println(lengthOfLong("text.txt"));
        //System.out.println(highestAvg("text.txt"));
        System.out.println(numOfBlank("text.txt"));
    }

    public static int countChar(String filename) throws FileNotFoundException{
        Scanner input = new Scanner(new File(filename)); // define the scanner to read the file.
        int counter = 0;
        while (input.hasNextLine()){ 
            String line = input.nextLine(); //read each line text
            Scanner lineScanner = new Scanner(line); //scanner to read the line text
            while (lineScanner.hasNext()){ //check in the line has words
                String word = lineScanner.next(); //read each word
                    for (int i = 0; i < word.length(); i++) {
                        counter ++;
                    }
            }
        }   
        return counter;
    }

    public static int countWords(String filename) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filename)); // define the scanner to read the file.
        int counter = 0;
        while (input.hasNextLine()){ 
            String line = input.nextLine(); //read each line text
            Scanner lineScanner = new Scanner(line); //scanner to read the line text
            while (lineScanner.hasNext()){ //check in the line has words
                lineScanner.next(); //read each word
                counter++;
            }
        }
        return counter;
    }

    public static int lengthOfLong(String filename) throws FileNotFoundException{
        String longest = "";
        String current = "";

        Scanner input = new Scanner(new File(filename)); // define the scanner to read the file.

        while (input.hasNextLine()){ 
            String line = input.nextLine(); //read each line text
            Scanner lineScanner = new Scanner(line); //scanner to read the line text
            while (lineScanner.hasNext()){ //check in the line has words
                current = lineScanner.next();
                if (current.length() > longest.length()) {
                    longest = line;
                }
            }
        } 
        return longest.length();
    }

    public static double highestAvg(String filename) throws FileNotFoundException {
        double a = 0;
        Scanner input = new Scanner(new File(filename));
        
        while (input.hasNextLine()) {
            int sum = 0;
            int count = 0;
            String line = input.nextLine();
                String b[] = line.split(" ");
                for (int i = 1; i < b.length; i++) {
                    sum += Integer.valueOf(b[i]);
                    count++;
                }
                sum /= count;
                if (sum > a) {
                    a = sum;
                }
            }
        return a;
    }

    public static int numOfBlank(String filename) throws FileNotFoundException {
        int empty = 0;
        Scanner input = new Scanner(new File(filename)); // define the scanner to read the file.
        while (input.hasNextLine()){ 
            String line = input.nextLine();
            if (line.isEmpty()) {
                empty++;
            }
        }
        return empty + 1;
    }
}