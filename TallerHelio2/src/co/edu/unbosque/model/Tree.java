package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Stack;
/**
 * En esta clase se ubicará un método de Arboles, el cual organizará cierta cantidad de datos.
 * @author Laura Mateus, Natalia Ardila, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class Tree {

    private Nodo root;
    private ArrayList<Long> sorted;
    /**
     * Representa el método constructor de la clase Quicksort, en el cual se inicializan las variables.
     */
    public Tree(){
    	sorted = new ArrayList<>();
        root = null;
    }
 
    /**
     * Representa el método en el cual se llama a insertRec().
     * @param key Dato den el nodo.
     */
    public void insertar(Long key){
        root = insertRec(root, key);
    }
     
    
    public void insertt(Long e) {        
        if (root == null) {
            root = new Nodo(e);
        }
        Nodo current = root; 
        while (true) { 
            Nodo parent=current;
            if (current.getKey().compareTo(e) < 0) {
                current = current.getRight();
                if(current==null) { 
                  current = new Nodo();
                  parent.setRight(current);
                  break; 
                }
            } else { 
                current= current.getLeft();
                if(current==null) { 
                  current = new Nodo();
                  parent.setLeft(current);
                  break; 
                }
            }
        }
        current.setKey(e);
        
    }
    
    public Nodo insert2(long key)
    {
        
        Nodo newnode = new Nodo(key);
 
        Nodo x = root;
 
        Nodo y = null;
 
        while (x != null) {
            y = x;
            if (key < x.getKey())
                x = x.getLeft();
            else
                x = x.getRight();
        }
 
        if (y == null)
            y = newnode;
 
        else if (key < y.getKey())
            y.setLeft(newnode);
 
        else
            y.setRight(newnode);
 
        return y;
    }
    
    /**
     * Representa el método en el cual se inserta de manera recursiva los nodos.
     * @param root Datos en los nodos.
     * @param key Dato en el nodo.
     * @return Nodo a la cabeza del árbol.
     */

    public Nodo insertRec(Nodo root, Long key){
 
        if (root == null){
            root = new Nodo(key);
            return root;
        }

        if (key < root.getKey())
            root.setLeft(insertRec(root.getLeft(), key));
        else if (key > root.getKey())
            root.setRight(insertRec(root.getRight(), key));
 
        /* return the root */
        return root;
    }
     
    /**
     * Representa el método en el cual se ordenan transversalmente los datos en el arbol.
     * @param root Datos en los nodos.
     */
    public void inorderRec(Nodo root){
    	
    	
        if (root != null){
            inorderRec(root.getLeft());
            sorted.add(root.getKey());
            inorderRec(root.getRight());
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
        Nodo temp=null;
        Stack<Nodo> stack=new Stack<Nodo>(); 
        for(temp=root; stack.size()>0 || temp!=null ;temp=temp.getRight())
        {
         while(temp!=null)
         {
                 stack.push(temp);  
                 temp=temp.getLeft();
        }
        temp=stack.pop();
        sorted.add(temp.getKey());
       }
    }
    
    /**
     * Representa el método en el cual se realizan las inserciones de los nodos en los arboles.
     * @param arr Arreglo.
     */
    public void treeins(long arr[])
    {
    	for (long l : arr) {
    		insert2(l);
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

