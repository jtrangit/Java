//CIS 2168 Data Structures
//Section 005
//Johnny Tran, tun45633@temple.edu
//Assignment Lab 11


package assign7_template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SummaryGeneratorTest {

    public static void main(String[] args) {
        SummaryGenerator summaryGenerator = new SummaryGenerator();
        try {
            //create a BufferedReader to read from file purchases.csv
            BufferedReader br = new BufferedReader(new FileReader("purchases.csv"));

            //create country name and count summary
            summaryGenerator.createCountsByCountry(br); 

            //show country count with asterisks 
            summaryGenerator.showCountsByCountry();            

        } catch (IOException ioe) {
            System.out.println("file input error.");
            ioe.printStackTrace();
            System.exit(1);
        }
    }

}

