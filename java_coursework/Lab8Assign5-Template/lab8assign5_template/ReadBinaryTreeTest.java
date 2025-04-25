//CIS 2168 Data Structures
//Section 005
//Johnny Tran, tun45633@temple.edu
//Assignment Lab 8

package lab8assign5_template;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Johnny Tran
 */

public class ReadBinaryTreeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree<String> binaryTree1 = new BinaryTree<>();

        try {

            //---Lab8Assign5 Start -------//
            //0. Check if you placed file WordBT_Data.txt in your project folder
            //    where the folder src is.
            
            
            //1. Create a Scanner for reading from the data file WordBT_Data.txt
            
            //2. call the static method readBinaryTree(....) to 
            //   create the binary tree of Strings using data read from file: WordBT_Data.txt
            
            //3. call each method you implemented and verify the result.
            // * You don’t need to call the main() method in BinaryTree class.
            // * For verification, I suggest that you print the return value of the called method.

            //scanner for text file
            Scanner input = new Scanner (new File("WordBT_Data.txt"));
            
            //binaryTree object with text file data
            binaryTree1 = BinaryTree.readBinaryTree(input);

            //close the scanner object.
            input.close();

            //print the string ofthe preorder inorder and postorder traversal sequence of data stored in binaryTree1.
            System.out.println(binaryTree1.toString());
            System.out.println("Preorder Traversal:  " + binaryTree1.preOrderTraverse());
            System.out.println("Inorder Traversal:  " + binaryTree1.inOrderTraverse());
            System.out.println("Postorder Traversal:  " + binaryTree1.postOrderTraverse());

            //print size and height of binaryTree1
            System.out.println("Size: " + binaryTree1.size());
            System.out.println("Height: " + binaryTree1.height());

        } catch (FileNotFoundException e) { //handle the case when WordBT_Data.txt is not found.
            e.printStackTrace();    //Print the error stack: this exception, and its backtrace for the cause of this exception.
            System.exit(1);         //terminate this program with the status code 1, indicating abnormal termination.
        }
    }

}


/*----Your output for the BT read from WordBT_Data.txt:
house
  dog
    cat
      null
      null
    null
  kiss
    null
    man
      null
      null

Preorder traversal:   house  dog  cat  kiss  man
Inorder traversal:   cat  dog  house  kiss  man
postorder traversal:   cat  dog  man  kiss  house
size: 5
height: 3

*/