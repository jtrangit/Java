//CIS 2168 Data Structures
//Section 005
//Johnny Tran, tun45633@temple.edu
//Assignment Lab 11

package assign7_template;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

public class SummaryGenerator {

    //the delimiter comma in the data file: purchases.csv
    private final String COMMA_DELIMITER = ",";

    Map<String, Integer> countsByCountryMap = new HashMap<String, Integer>(); //hashmap 
    
    //Map<String, Integer> countsByCountryMap = new TreeMap<String, Integer>(); //treemap

    public SummaryGenerator() {        
        countsByCountryMap = new HashMap<>(); //hashmap constructor
        
        //countsByCountryMap = new TreeMap<>(); //treemap constructor
    }      
    
    //takes in a BufferedReader object that is already associated with
    //   the file purchases.csv, read the data line by line,
    //   create the country summary and save the summary entries in the summary map.
    public void createCountsByCountry(BufferedReader br) {      
        //build country summary
        List<String> purchase = new ArrayList<>();
        Map<String, Integer> countsByCountry = new HashMap<>();
        try {
            String line;
            //read the first line (column heading), and do not do anything with it.
            br.readLine();
            //read line by line until file reading is completed            
            while ((line = br.readLine()) != null) {
                //split values in each line using the delimiter comma,
                //  store values as String in a String array.
                String[] fields = line.split(COMMA_DELIMITER);
                //convert the array to an ArrayList
                purchase = Arrays.asList(fields);
                //System.out.println(purchase);
                
                //get country name from ArrayList purchase
                String country = purchase.get(7);
                    //if country is not in hashmap, add it and set count to 1
                    if (!countsByCountry.containsKey(country)) {
                        countsByCountry.put(country, 1);
                    }
                    //if country is already in hashmap, update count of country
                    else {
                        Integer count = countsByCountry.get(country);
                        count++;
                        countsByCountry.put(country, count);
                    }
            }
            
        } catch (IOException ioe) { 
            System.out.println("file input error.");
            ioe.printStackTrace();
            System.exit(1);
        } catch (PatternSyntaxException pse) {
            System.out.println("pattern specification error.");            
            pse.printStackTrace();
            System.exit(1);            
        }
        //summary to countsByCountry map
        countsByCountryMap = countsByCountry;
    }
    
    //---- Assign 7 Continues ------------//
    
    //print the content of the data summary map in the format given in the sample output
    public void showCountsByCountry(){
        //header
        System.out.println("Country                       Count    ");
        System.out.println("-----------------------------------------------");
        
        //print country and country count
        for (String country : countsByCountryMap.keySet()) {
            int countryCount = countsByCountryMap.get(country);
            System.out.printf("%-30s", country);
            printNChars('*', countryCount);
        }

    }
    
    //print the character ch count number of times in one line
    private void printNChars(char ch, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(ch);
        }
        //line break so each country and count occupies 1 line
        System.out.println();
    }
}