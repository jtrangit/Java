//CIS 2168 Data Structures
//Section 005
//Johnny Tran, tun45633@temple.edu
//Assignment Lab 3

package assign3_template;

/**
 * Assign 3 Template.
 * Testing different methods (successful and failed calls)
 * 
 */
public class SimpleLinkedListTest {

    public static void main(String[] args) {
        
        //2.2 Revise SimpleLinkedListTest
        
        //create an empty singly linked list of int values        
        //append some integers
    
        //For method size, use one test case.
        //test all other methods using at least 2 calls:
        //  successful call, e.g. call indexOf(..) and pass an existing integer
        //  failed call, e.g. call indexOf(..) and pass a non-existing integer
   
        //You can reuse some of the code below given to you in the lectures.        
        
        //create an empty list
        SimpleLinkedList numbers = new SimpleLinkedList();
        
        //append 3 integers
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        
        //dump the contents in the list in the original order
        System.out.println("Original List Order: " + numbers);
        //or use:
        //System.out.println(numbers.toString());   
        

        //System.out.println(numbers.size()); //returns how many elements in the list
        
        //System.out.println(numbers.indexOf(10)); //successful indexOf
        //System.out.println(numbers.indexOf(40)); //unsuccessful indexOf
        
        //System.out.println(numbers.contains(10)); //successful contains
        //System.out.println(numbers.contains(40)); //unsuccessful contains

        //System.out.println(numbers.get(1)); //successful get
        //System.out.println(numbers.get(4)); //unsuccessful get

        //numbers.add(1, 21);
        //System.out.println(numbers); //successful add, results[10 -> 21 -> 20 -> 30]

        //numbers.add(4, 21); //unsuccessful add, list stays the same and we get a throw exception
        //System.out.println(numbers);

        //System.out.println(numbers.removeByValue(20)); //successful removeByValue, result [10 -> 30] and return true
        //System.out.println(numbers);

        System.out.println(numbers.removeByValue(40)); //successful removeByValue, error message return false and list is unchanged
        System.out.println(numbers);
    }   
    
}
