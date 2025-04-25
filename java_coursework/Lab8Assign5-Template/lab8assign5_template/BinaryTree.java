//CIS 2168 Data Structures
//Section 005
//Johnny Tran, tun45633@temple.edu
//Assignment Lab 8

package lab8assign5_template;

import java.util.Scanner;

/**
 * Class for a binary tree that stores type E objects.
 *
 * @author Koffman and Wolfgang & Cindy & Johnny Tran
 *
 */
public class BinaryTree<E> {

    public static void main(String[] args) {        
        //root *
        Node<Character> star = new Node<>('*');

        //leaf nodes a and b
        Node<Character> a = new Node<>('a');
        Node<Character> b = new Node<>('b');

        //parent node / of a and b
        Node<Character> slash = new Node<>('/');
        
        //connect a and b to /
        slash.left = a;
        slash.right = b;

        //leaf nodes x and y
        Node<Character> x = new Node<>('x');
        Node<Character> y = new Node<>('y');
        
        //parent node + of x and y
        Node<Character> plus = new Node<>('+');
        
        //connect x and y to +
        plus.left = x;
        plus.right = y;

        //connect / and + to root *
        star.left = plus;
        star.right = slash;

        //create a binary tree named exprBT that is rooted at *
        BinaryTree<Character> exprBT = new BinaryTree<>(star);        
        System.out.println(exprBT);   
    }

    
    
    /* 
     * get a string containing all data items in this binary tree. The string is
     * a preorder traversal sequence of this binary tree.
     *
     * @return the preorder traversal sequence of this binary tree as a string.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        //call the private recursive method to do the real job.
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * Perform a preorder traversal of the binary tree rooted at node.
     *
     * @param node The local root (i.e. the current root node)
     * @param depth The depth of the local root
     * @param sb The string buffer to save the output
     */
    private void preOrderTraverse(Node<E> node, int depth,
            StringBuilder sb) {
        //add a number of spaces that is proportial to the depth value
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {         //current root node does not exist
            sb.append("null\n");
        } else {
            sb.append(node.toString()); //add current root node's data
            sb.append("\n");
            //recursively preorder traverse the left subtree of current root node
            preOrderTraverse(node.left, depth + 1, sb);
            //recursively preorder traverse the right subtree of current root node            
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }    

    //public wrapper of preOrderTraverse.
    public String preOrderTraverse() {
        StringBuilder sb = new StringBuilder();
        
        //call the private recursive method to do the real job.
        preOrderTraverse(root, sb);
        return sb.toString();

    }
    //preorder traversal
    private void preOrderTraverse(Node<E> currentRoot,
            StringBuilder currentResultSB) {

        if (currentRoot == null) {         //current root node does not exist
            currentResultSB.append("");
        } else {
            currentResultSB.append(currentRoot.toString()); //add current root node's data
            currentResultSB.append("  ");
            //recursively preorder traverse the left subtree of current root node
            preOrderTraverse(currentRoot.left, currentResultSB);
            //recursively preorder traverse the right subtree of current root node            
            preOrderTraverse(currentRoot.right, currentResultSB);
        }
    }

    //public wrapper of inOrderTraverse.
    public String inOrderTraverse() {        
        StringBuilder sb = new StringBuilder();
        
        //call the private recursive method to do the real job.
        inOrderTraverse(root, sb);
        return sb.toString();
    }

    //inorder traversal
    private void inOrderTraverse(Node<E> currentRoot,
            StringBuilder currentResultSB) {

        if (currentRoot == null) {         //current root node does not exist
            currentResultSB.append("");
        } else {
            //recursively inorder traverse the left subtree of current root node
            inOrderTraverse(currentRoot.left, currentResultSB);
            
            currentResultSB.append(currentRoot.toString()); //add current root node's data
            currentResultSB.append("  ");
            //recursively inorder traverse the right subtree of current root node            
            inOrderTraverse(currentRoot.right, currentResultSB);
        } 
    }

    //public wrapper of postOrderTraverse.
    public String postOrderTraverse() {
        StringBuilder sb = new StringBuilder();
        
        //call the private recursive method to do the real job.
        postOrderTraverse(root, sb);
        return sb.toString();
    }

    //postorder traversal
    private void postOrderTraverse(Node<E> currentRoot,
            StringBuilder currentResultSB) {  
        
        if (currentRoot == null) {         //current root node does not exist
            currentResultSB.append("");
        } else {
            //recursively postorder traverse the left subtree of current root node
            postOrderTraverse(currentRoot.left, currentResultSB);
            //recursively postorder traverse the right subtree of current root node            
            postOrderTraverse(currentRoot.right, currentResultSB);

            currentResultSB.append(currentRoot.toString()); //add current root node's data
            currentResultSB.append("  ");
        }
    }

    //traversal-based processing of BT
    //return the total number of data items in this BinaryTree
    //public wrapper of size().
    public int size() {
        return size(root);
    }

    //add your private recursive counterpart for the public wrapper: public int size()
    private int size(Node<E> currentRoot) {
        if (currentRoot == null) {
            return 0;
        }
        else {
            return (size(currentRoot.left) + 1 + size(currentRoot.right));
        }
    }    
    
    //Return the height of this BinaryTree.
    //public wrapper of height.
    public int height() {
        return height(root);
    }

    //add your private recursive counterpart for height
    private int height(Node<E> currentRoot) {
        if (currentRoot == null) {
            return 0;
        }
        else {
            if (height(currentRoot.left) == height(currentRoot.right)) { //if both right and left side of tree are the same they have the same height 
                return height(currentRoot.left) + 1; //add 1 to the height of the trees to include the root for the total height
            }
            else if (height(currentRoot.left) > height(currentRoot.right)) { //if left side is greater than right side
                return height(currentRoot.left) + 1; //add 1 to the height of left side
            }
            else { //if right side is greater than left side
                return height(currentRoot.right) + 1; //add 1 to the height of right side
            }
        }
    }    
    protected static class Node<E> {
        // Data Fields

        /**
         * The information stored in this node.
         */
        protected E data;
        /**
         * Reference to the left child.
         */
        protected Node<E> left;
        /**
         * Reference to the right child.
         */
        protected Node<E> right;

        // Constructors
        /**
         * Construct a node with given data and no children.
         *
         * @param data The data to store in this node
         */
        //This constructor should be protected, not public,
        // because classes that are not subclasses of BinaryTree do not directly use Node.
        protected Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        // Methods
        /**
         * Returns a string representation of the node.
         *
         * @return A string representation of the data fields
         */
        //must be public because it overrides what's in class Object.
        @Override
        public String toString() {
            return data.toString();
        }
    }
    /*</listing>*/

    // Data Field
    /**
     * The root of the binary tree
     */
    //use the access modifier protected to give family member classes the direct access
    //   to the root data field.
    protected Node<E> root;

    /**
     * Construct an empty BinaryTree1
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a BinaryTree1 with a specified root. Should only be used by
     * subclasses.
     *
     * @param root The node that is the root of the tree.
     */
    //Use the access modifier protected because we want to hide details of Node class
    //   from non-family member classes (i.e. classes that are not subclasses of BinaryTree).
    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * Constructs a new binary tree with data in its root,leftTree as its left
     * subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data, BinaryTree<E> leftTree,
            BinaryTree<E> rightTree) {
        root = new Node<E>(data);           //new node: right, left are both null
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;               //don't have to do this, root.left is already null
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;              //don't have to do this, root.right is already null.
        }
    }

    /**
     * Return the left subtree.
     *
     * @return The left subtree or null if either the root or the left subtree
     * is null
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) { //if there is a left subtree
            return new BinaryTree<E>(root.left);
        } else {
            return null;
        }
    }

    /**
     * Return the right sub-tree
     *
     * @return the right sub-tree or null if either the root or the right
     * subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {   //if there is a right subtree
            return new BinaryTree<E>(root.right);
        } else {
            return null;
        }
    }

    /**
     * Return the data in the root node
     *
     * @return the data in the root node or null if the root is null
     */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    /**
     * Determine whether this tree is a leaf.
     *
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        //empty tree or 1-node tree
        return (root == null || (root.left == null && root.right == null));
    }

//    /**
//     * get a string containing all data items in this binary tree. The string is
//     * a preorder traversal sequence of this binary tree.
//     *
//     * @return the preorder traversal sequence of this binary tree as a string.
//     */
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        //call the private recursive method to do the real job.
//        preOrderTraverse(root, 1, sb);
//        return sb.toString();
//    }
//
//    /**
//     * Perform a preorder traversal of the binary tree rooted at node.
//     *
//     * @param node The local root (i.e. the current root node)
//     * @param depth The depth of the local root
//     * @param sb The string buffer to save the output
//     */
//    private void preOrderTraverse(Node<E> node, int depth,
//            StringBuilder sb) {
//        //add a number of spaces that is proportial to the depth value
//        for (int i = 1; i < depth; i++) {
//            sb.append("  ");
//        }
//        if (node == null) {         //current root node does not exist
//            sb.append("null\n");
//        } else {
//            sb.append(node.toString()); //add current root node's data
//            sb.append("\n");
//            //recursively preorder traverse the left subtree of current root node
//            preOrderTraverse(node.left, depth + 1, sb);
//            //recursively preorder traverse the right subtree of current root node            
//            preOrderTraverse(node.right, depth + 1, sb);
//        }
//    }

    /*<listing chapter="6" number="2">*/
    /**
     * Method to read a binary tree.
     *
     * @pre The input consists of a preorder traversal of the binary tree. The
     * line "null" indicates a null tree.
     * @param scan the Scanner attached to the input file
     * @return The binary tree
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan) {
        // Read a line and trim leading and trailing spaces.
        String data = scan.nextLine().trim();
        if (data.equals("null")) { //data (i.e. current root node's data) is "null"
            return null;
        } else {
            //recursively keep reading and building the left subtree of current root node until it's done.
            BinaryTree<String> leftTree = readBinaryTree(scan);
            //recursively keep reading and building the right subtree of current root node until it's done.
            BinaryTree<String> rightTree = readBinaryTree(scan);
            //build and return a new binary tree that has root data in variable data, leftTree as left subtree, rightTree as right subtree.
            return new BinaryTree<String>(data, leftTree, rightTree);
        }
    }
    /*</listing>*/
}
/*</listing>*/
