//CIS 2168 Data Structures
//Section 005
//Johnny Tran, tun45633@temple.edu
//Assignment Lab 6

package lab6assign5_template;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class ChangeDispenser {

    public static String makeChange(int amount) {
        List<Integer> coinValues = new ArrayList<Integer>(); //int value of coins in decreasing order
        coinValues.add(100);
        coinValues.add(50);
        coinValues.add(25);
        coinValues.add(10);
        coinValues.add(5);
        coinValues.add(1);
        
        List<String> coinNames = new ArrayList<String>(); //coin names in decreasing order
        coinNames.add("DOLLAR: ");
        coinNames.add("HALF_DOLLAR: ");
        coinNames.add("QUARTER: ");
        coinNames.add("DIME: ");
        coinNames.add("NICKLE: ");
        coinNames.add("PENNY: ");
        
        return makeChange(amount, coinValues, coinNames);

    }

    private static String makeChange(int amount, List<Integer> valueList, List<String> coinList) {
        if (valueList.isEmpty() == true) { //if list is empty stop
            return "";
        }

        int count = amount / valueList.get(0); //get the count of how many coins can be used for the current amount 
        String coin = coinList.get(0);

        amount = amount - (valueList.get(0) * count); //get the remaining amount after getting the current amount of coins
        valueList.remove(0); //remove current coin value from list
        coinList.remove(0); //remove current coin from list

        return coin + count + "\n" + makeChange(amount, valueList, coinList); 
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //scanner
        System.out.println("Enter the money in dollars and cents: ");
        double amount = scan.nextDouble() * 100; //user input double -> into cents
        int cents = (int)amount; //double cents -> int cents
        System.out.println(makeChange(cents));
    }

}