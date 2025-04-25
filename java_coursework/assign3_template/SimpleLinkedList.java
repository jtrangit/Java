//CIS 2168 Data Structures
//Section 005
//Johnny Tran, tun45633@temple.edu
//Assignment Lab 3

package assign3_template;

/**
 * Assign 3 template. Implement more methods in List interface.
 */
public class SimpleLinkedList {

    //-------Start of Assign 3  --------/  
    
    //2.1.2 Coding Requirements
    //You can call other methods to complete a method.
    //You can also add private methods, and then call these methods 
    //  to complete a method required in this assignment. 
    //You are NOT allowed to add or remove data fields to/from SimpleLinkedList class. 
    //You are NOT allowed to change the definition of Node class.
    
    //2.1.1 What Code to Add
    //-----Required ---------------//    
    
    //Remove the first occurrence of the specified item from this linked list. 
    // If success, return true. Otherwise, return false.
    public boolean removeByValue(int item) {
        //add your own code
        
        //Hint:
        //  call your indexOf(...) to locate the item,
        //  convert the following in SingleLinkedList<E>
        //     private E removeFirst()        
        //     private Node<E> getNode(int index)         
        //     private E removeAfter(Node<E> node)
        
        
        //Hint: if you implement this from scratch, remember to save:
        //   predecessor node reference        
        //   current node reference
        int index = indexOf(item);
        if (index < 0 || index > size) {        //invalid index
            System.out.println("Invalid Index");
            return false;
        }
        if (index == 0) {                       //Given index is first position
            removeFirst();                     //call public method: addFirst(....) to do the insertion
            return true;
        } else {
            //call private getNode(...) to get the predecessor node
            Node predecessorNodeRef = getNode(index - 1);
            //call private removeAfter(..) to add the given item after the precedessor.
            removeAfter(predecessorNodeRef);
            return true;
        }
    }

    //add item to be at [index];
    // if index is [0, size-1], insert item between [index-1] and [index]
    // if index is size, append item to the end of this linked list.
    public void add(int index, int item) {
        //add your own code
        
        //Hint:
        //convert the following in SingleLinkedList<E>
        //    public void add(int index, E item)
 	//    public void addFirst(E item)
        //    private Node<E> getNode(int index)
    	//    private void addAfter(Node<E> node, E item)          
        if (index < 0 || index > size) {        //invalid index
            System.out.println("Invalid index");
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {                       //Given index is first position
            addFirst(item);                     //call public method: addFirst(....) to do the insertion
        } else {
            //call private getNode(...) to get the predecessor node
            Node predecessorNodeRef = getNode(index - 1);
            //call private addAfter(..) to add the given item after the precedessor.
            addAfter(predecessorNodeRef, item);
        }
    }
    //Get the integer item at the specified position and return the integer value. 
    //If the index is not valid, throw an exception or print an error message 
    //  and return Integer.MIN_VALUE.
    public int get(int index) {
        //add your own code
        
        //Hint:
	//convert the following in SingleLinkedList<E>
        //    public E get(int index)
        //    private Node<E> getNode(int index)
        if (index < 0 || index >= size) {  //invalid index
            System.out.println("Invalid index");
            return Integer.MIN_VALUE;
        }
        Node targetNode = getNode(index);     //call private method getNode(..) to get the desired node
        return targetNode.data;
        
        


    }
    //Search this linked list for the first occurrence of the specified integer: item. 
    //If the item is found, return its index. Otherwise return -1.
    public int indexOf(int item) {
        //add your own code
        
        //Hint:
        //use a looping like the one in toString()
        //in addition, add a counter, 
        //    increment the counter for each element checked 
        //can use size for loop control.
        int count = 0;
        int index = 0;

        Node current = head;        //start with first Node
        while (current != null) {   //check if there is still nodes remaining
            if(current.data == item) { //checks to see if current node matches what we are looking for
                count++; //add to counter
                return index; 
            }
            current = current.next; //next node
            index++; //next index
        }
        
        return -1;
    }

    //Find out if the specified integer: item is in this linked list. 
    // Returns true if yes, false otherwise.
    public boolean contains(int item) {
        //add your own code
        
        //Hint:
        //can either call indexOf(...) 
        //    or directly search for the item using a loop like the one in toString()
        if (indexOf(item) >= 0) {
            return true;
        }
        else {
            return false;
        }
    }

    //return how many integers are in this linked list
    public int size() {
        //add your own code
        
        //Hint: this is actually a getter
        int listSize = 1; //start at 1 since we have a linked list we assume we have at least 1 element
        for (Node i = head; i.next != null; i = i.next) { //start at the head and check to see if next is empty, if not add to count and continue
            listSize++;
        }
        return listSize;
    }

    //-----Bonus ---------------//
    //Remove the item at the specified position from this linked list and 
    //  return the removed item.
    //If the index is not valid, throw an exception or print an error message 
    //   and return Integer.MIN_VALUE.
    public int removeByIndex(int index) {
        //Add your own code
     
        //Hint:        
        //verify that index is valid
        //convert the following in SingleLinkedList<E>
        //     private Node<E> getNode(int index) 
        //     private E removeAfter(Node<E> node)        
       
        //Hint: if you implement this from scratch, remember to save:
        //   predecessor node reference        
        //   current node reference
        
        return 2;
    }

    //-------End of Assign 3 --------/ 

    //Don't change the code below.
    //Nested class Node, enclosing class: SimpleLinkedList
    private static class Node {

        private int data;
        private Node next;

        //constructor used to create a standalone node without a successor
        private Node(int data) {
            this.data = data;
            next = null;
        }
        
        //constructor used to create a Node with a given successor
        private Node(int dataNew, Node nextNew) {
            data = dataNew;
            next = nextNew;
        }
       
    }

    //the reference to the first Node in this linked list.
    private Node head;
    //the size of this linked list
    private int size;

    //create an empty linked list
    public SimpleLinkedList() {
        head = null;
        size = 0;
    }

    //append newItem
    public boolean add(int newItem) {
        Node temp = new Node(newItem);
        if (head == null) { //empty list
            head = temp;
        } else { //non-empty list
            //locate last node
            Node current = head;    //start with the first node
            while (current.next != null) {  //check if current node is not the last node
                current = current.next;     //move on to the next node on the list
            }
            current.next = temp;    //append the new node immediately following the current node
        }
        size++;
        return true;
    }
    public void addFirst(int item) {
        //Soln 1:
        //create a new Node (data: item, next: pointing to current first node)
        //make head point to this new Node
        head = new Node(item, head);
        size++;
    }
    private void addAfter(Node node, int item) {
        //The given node: the node referenced by the parameter: node.
        
        //Soln 1:
        //create a new Node (data: item, next: pointing to the given node's current successor node)
        // and make the given node's data field: next point to this new Node
        node.next = new Node(item, node.next);
        size++;
    }
    private void removeFirst() {
        //Soln 1:
        Node temp = head;    //save the reference to the first node in this single linked list
        if (head != null) {     //this list is not empty.
            head = head.next;   //make head point to the old 2nd node in this list
        }
        //return data at old first node or null if this list is empty
        if (temp != null) {     //if this list is not empty
            size--;
        } 
    }

    private Node getNode(int index) {
        Node current = head;             //make the first node the current node to be checked
        for (int i = 0;                     //initialize index counter i to first position 0
                i < index;                  //if counter i has not reached target index.
                i++) {                      //increament counter i
            current = current.next;         //move on to the next node in this linked list
        }
        return current;
    }

    private void removeAfter(Node node) { //Given node: the node referenced by the parameter: node
        Node temp = node.next;         //save a reference to the given node's successor node.
        if (temp != null) {               //if given node is not last node on this linked list
            node.next = temp.next;        //make the given node's data field: next point to its successor's successor.
            size--;
        } 
    }

    //return a string that contains all integers (in the original sequence) in this linked list.
    @Override
    public String toString() {
        String result = "";     //result string
        Node current = head;        //start with first Node
        while (current != null) {   //check if there is still nodes remaining
            result += current.data; //add the integer in current Node to the result string
            result += "-->";
            current = current.next; //move on to the next Node
        }
        return result;
    }
}
