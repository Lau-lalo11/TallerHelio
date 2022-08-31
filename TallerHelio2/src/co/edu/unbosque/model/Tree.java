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
        for(int i = 0; i < arr.length; i++)
        {
            insert(arr[i]);
        }
         
    }

	public ArrayList<Long> getSorted() {
		return sorted;
	}

	public void setSorted(ArrayList<Long> sorted) {
		this.sorted = sorted;
	}
    
    
 

}

