//Johnny Tran Section 
//3. 14. 2022
//Assignment 7. Southie Styles

//Program will convert the text of a text file into a southie accent and outputs another text file
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Southie {
    public static void main(String[] args) throws FileNotFoundException {
        writeFile(readFile("Jaws.txt"));
    }
    public static String readFile(String filename) throws FileNotFoundException{
        Scanner input = new Scanner(new File(filename)); // define the scanner to read the file.
        String script = ""; 
        input.useDelimiter(" ");
        
        while (input.hasNextLine()) { //check each line is not null
            String line = input.nextLine(); //read each line text
            Scanner lineScanner = new Scanner(line); //scanner to read the line text
            while (lineScanner.hasNext()) {
                String word = lineScanner.next();
                word = convertToAccent(word.toLowerCase());
                script += word + " ";
            }
            script += "\n";
        }
        return script;
        
    }
    public static String convertToAccent(String word) {
        //Southie Accent Rules
        //r following vowel (aeiou) r is replaced with h, car -> cah harbor -> hahboh
        //^^exception if r is at the end of a word and is preceeded by ee or i, replace r with yah instead of h. deer -> deeyah
        //^^^exception if r is at the end of a word and is preceded by oo, replace r with wah. door -> doowah
        //if word ends with an a, add an r after. tuna -> tunar
        //^exception the word a stays the same. a tuna -> a tunar =/= ar tunar
        //replace the word very with wicked. very hard -> wicked hard
        String southieWord = word;
        
        for (int i = 0; i < word.length(); i++){
            if (word.equals("very")) {
                southieWord = "wicked";
            }
            if (word.charAt(word.length()-1) == 'r' && word.charAt(word.length()-2) == 'o' && word.charAt(word.length()-3) == 'o') {
                southieWord = word.replace("r", "wah");
            }
            else if(word.charAt(word.length()-1) == 'r' && word.charAt(word.length()-2) == 'e' && word.charAt(word.length()-3) == 'e') {
                southieWord = word.replace("r", "yah");
            }
            else if(word.charAt(i) == 'r' && (word.charAt(i-1) == 'a' || word.charAt(i-1) == 'e' || word.charAt(i-1) == 'i' || word.charAt(i-1) == 'o' || word.charAt(i-1) == 'u')) {
                southieWord = word.replace('r', 'h');
            }
            if (word.charAt(word.length()-1) == 'a') {
                southieWord = word + 'r';
            }
            else if (word.charAt(i) == 'a' && word.charAt(word.length()-1) == 'a') {
                southieWord = "a";
            }
        }
        return southieWord;
    }
    public static void writeFile(String filename) {
        File x = new File(filename);
        Scanner scan = new Scanner(x);
        File newFile = new File("SouthieScript.txt");
        PrintStream y = new PrintStream(new File("SouthieScript.txt"));
        System.out.println(y);
        while (scan.hasNext()) {
           y.println(scan.nextLine());
        }
    }
}