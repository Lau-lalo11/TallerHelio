package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Stack;

public class Tree {
	// Root of BST
    Node root;
    ArrayList<Long> sorted;
    // Constructor
    Tree(){
    	sorted = new ArrayList<>();
        root = null;
    }
 
    // This method mainly
    // calls insertRec()
    public void insert(Long key){
        root = insertRec(root, key);
    }
     
    
    public void insertt(Long e) {        
        if (root == null) {
            root = new Node(e); //how would this work with a null root?
             //that's it, we're done (when is this ever false by the way?)
        }
        Node current = root; 
        while (true) { //brackets! indenting is important for readabilty
            Node parent=current;
            if (current.getKey().compareTo(e) < 0) {
                current = current.getRight();
                if(current==null) { //we don't have a right node, need to make one
                  current = new Node();
                  parent.setRight(current);
                  break; //we have a new node in "current" that is empty
                }
            } else { 
                current= current.getLeft();
                if(current==null) { //we don't have a left node, need to make one
                  current = new Node();
                  parent.setLeft(current);
                  break;  //we have a new node in "current" that is empty
                }
            }
        }
        current.setKey(e);
        
    }
    
    public Node insert2(long key)
    {
        // Create a new Node containing
        // the new element
        Node newnode = new Node(key);
 
        // Pointer to start traversing from root and
        // traverses downward path to search
        // where the new node to be inserted
        Node x = root;
 
        // Pointer y maintains the trailing
        // pointer of x
        Node y = null;
 
        while (x != null) {
            y = x;
            if (key < x.key)
                x = x.left;
            else
                x = x.right;
        }
 
        // If the root is null i.e the tree is empty
        // The new node is the root node
        if (y == null)
            y = newnode;
 
        // If the new key is less than the leaf node key
        // Assign the new node to be its left child
        else if (key < y.key)
            y.left = newnode;
 
        // else assign the new node its right child
        else
            y.right = newnode;
 
        // Returns the pointer where the
        // new node is inserted
        return y;
    }
    
    /* A recursive function to
    insert a new key in BST */
    public Node insertRec(Node root, Long key){
 
        /* If the tree is empty,
        return a new node */
        if (root == null){
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur
        down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
 
        /* return the root */
        return root;
    }
     
    // A function to do
    // inorder traversal of BST
    public void inorderRec(Node root){
    	
    	
        if (root != null){
            inorderRec(root.left);
            sorted.add(root.key);
            inorderRec(root.right);
        }
        
    }
    
    public void inorder()
    {
    	System.gc();
    	
        if(root ==null)
        return ;
        Node temp=null;
        Stack<Node> stack=new Stack<Node>(); //Creating an empty Stack 
        for(temp=root; stack.size()>0 || temp!=null ;temp=temp.right)
        {
        /*loop until we are on the left most node of the current node */
         while(temp!=null)
         {
                 stack.push(temp);  //inserting an element into stack
                 temp=temp.left;
        }
        /* removing the top element from the stack */
        temp=stack.pop();
        sorted.add(temp.key);
       }
    }
    
    
    public void treeins(long arr[])
    {
    	for (long l : arr) {
    		insert2(l);
		}
         
    }

	public ArrayList<Long> getSorted() {
		return sorted;
	}

	public void setSorted(ArrayList<Long> sorted) {
		this.sorted = sorted;
	}
    
    
 

}

