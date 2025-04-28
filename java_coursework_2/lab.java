import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class lab {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner scan = new Scanner(System.in);

        System.out.println("Enter File Name");
        String fileName = mostConson(scan.nextLine());


	}
    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        else { //returns false if char not a vowel
            return false;
        }
    }
    public static boolean isCoson(char c) {
        if (isVowel(c) == false) {
            return true;
        }
        else {
            return false;
        }
    }
    public static int numConson(String s) {
        int consonants = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isCoson(s.charAt(i)) == true) {
                consonants += 1;
            }
        }
        return consonants;
    }
    public static String mostConson(String filename) throws FileNotFoundException{
        Scanner input = new Scanner(new File(filename)); // define the scanner to read the file.
        String greatestConson = ""; 
        int mostCon = 0;
        input.useDelimiter(" ");
        
        while (input.hasNextLine()) { //check each line is not null
            String line = input.nextLine(); //read each line text
            Scanner lineScanner = new Scanner(line); //scanner to read the line text
            while (lineScanner.hasNext()) {
                String word = lineScanner.next();
                word = word.toLowerCase();
                if (numConson(word) > mostCon) {
                    mostCon = numConson(word);
                    greatestConson = word;
                }
                else if (numConson(word) == 0) {
                    greatestConson = "NO CONSONANTS";
                }
                
            }
        }
        return greatestConson;
    }
}

