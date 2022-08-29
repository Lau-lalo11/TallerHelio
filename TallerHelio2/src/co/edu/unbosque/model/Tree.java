package co.edu.unbosque.model;

import java.util.ArrayList;

public class Tree {
	// Root of BST
    Node root;
    ArrayList<Integer> sorted;
    // Constructor
    Tree(){
    	sorted = new ArrayList<>();
        root = null;
    }
 
    // This method mainly
    // calls insertRec()
    void insert(int key){
        root = insertRec(root, key);
    }
     
    /* A recursive function to
    insert a new key in BST */
    public Node insertRec(Node root, int key){
 
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
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
        
    }
    
    public void treeins(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            insert(arr[i]);
        }
         
    }

	public ArrayList<Integer> getSorted() {
		return sorted;
	}

	public void setSorted(ArrayList<Integer> sorted) {
		this.sorted = sorted;
	}
    
    
 

}

