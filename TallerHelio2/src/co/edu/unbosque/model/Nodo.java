package co.edu.unbosque.model;


/**
 * En esta clase se ubicará los nodos que contendran los datos, la cual se usará como tipo de dato para el Arbol.
 * @author Laura Mateus, Natalia Ardila, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class Nodo {
	
	 private Long key;
     private Nodo left, right;

     public Nodo()
     {
      
     }
     
     
     /**
      * Representa el método constructor de la clase Node en el cual se inicializarán las variables.
      * @param item Dato de inserción.
      */
     public Nodo(Long item)
     {
         key = item;
         left = right = null;
     }

 	/**
 	 * Se encarga de obtener el dato que se ingresa al nodo.
 	 * @return Dato que se ingresa al nodo.
 	 */
     public Long getKey() {
    	 return key;
     }

 	/**
 	 * Se encarga de cambiar el dato que se ingresa al nodo.
 	 * @param key Dato que se ingresa al nodo.
 	 */
     public void setKey(Long key) {
    	 this.key = key;
     }

 	/**
 	 * Se encarga de obtener el nodo a la izquierda del nodo seleccionado.
 	 * @return El nodo a la izquierda del nodo seleccionado.
 	 */
     public Nodo getLeft() {
    	 return left;
     }

 	/**
 	 * Se encarga de cambiar el nodo a la izquierda del nodo seleccionado.
 	 * @param left El nodo a la izquierda del nodo seleccionado.
 	 */
     public void setLeft(Nodo left) {
    	 this.left = left;
     }

 	/**
 	 * Se encarga de obtener el nodo a la derecha del nodo seleccionado.
 	 * @return El nodo a la derecha del nodo seleccionado.
 	 */
     public Nodo getRight() {
    	 return right;
     }

 	/**
 	 * Se encarga de cambiar el nodo a la derecha del nodo seleccionado.
 	 * @param right El nodo a la derecha del nodo seleccionado.
 	 */
     public void setRight(Nodo right) {
    	 this.right = right;
     } 
}
