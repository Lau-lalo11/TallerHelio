package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Stack;
/**
 * En esta clase se ubicará un método de Arboles, el cual organizará cierta cantidad de datos.
 * @author Laura Mateus, Natalia Ardila, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class Tree {
	// Root of BST
    Node root;
    ArrayList<Long> sorted;
    /**
     * Representa el método constructor de la clase Quicksort, en el cual se inicializan las variables.
     */
    Tree(){
    	sorted = new ArrayList<>();
        root = null;
    }
 
    /**
     * Representa el método en el cual se llama a insertRec().
     * @param key Dato den el nodo.
     */
    public void insert(Long key){
        root = insertRec(root, key);
    }
     
    /**
     * Representa el método en el cual se inserta de manera recursiva los nodos.
     * @param root Datos en los nodos.
     * @param key Dato en el nodo.
     * @return Nodo a la cabeza del árbol.
     */
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
     
    /**
     * Representa el método en el cual se ordenan transversalmente los datos en el arbol.
     * @param root Datos en los nodos.
     */
    public void inorderRec(Node root){
    	
    	
        if (root != null){
            inorderRec(root.left);
            sorted.add(root.key);
            inorderRec(root.right);
        }
        
    }
    
    /**
     * Representa el método en el cual se ordenan los datos del arbol.
     */
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
    
    /**
     * Representa el método en el cual se realizan las inserciones de los nodos en los arboles.
     * @param arr Arreglo.
     */
    public void treeins(long arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            insert(arr[i]);
        }
         
    }

    /**
     * Se encarga de obtener el array ordenado.
     * @return Array ordenado.
     */
	public ArrayList<Long> getSorted() {
		return sorted;
	}

	/**
	 * Se encarga de cambiar el array ordenado.
	 * @param sorted Array ordenado.
	 */
	public void setSorted(ArrayList<Long> sorted) {
		this.sorted = sorted;
	}
    
    
 

}

