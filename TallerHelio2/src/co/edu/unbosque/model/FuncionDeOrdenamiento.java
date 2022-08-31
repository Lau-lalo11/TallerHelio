package co.edu.unbosque.model;

import java.util.ArrayList;
/**
 * En esta clase sirve como fachada, pues se ubicarán las funciones de ordenamiento en una misma clase.
 * @author Laura Mateus, Natalia Ardila, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class FuncionDeOrdenamiento {

	private Tree tree;
	private RadixSort radixSort;
	private CocktailSort cocktailSort;
	private Quicksort quicksort;
	
	/**
	 * Representa el método constructor de la clase FuncionDeOrdenamiento, en el cual se inicializan las variables.
	 */
	public FuncionDeOrdenamiento() {
		tree =  new Tree();
		radixSort = new RadixSort();
		cocktailSort = new CocktailSort();
		quicksort = new Quicksort();
	}


	/**
	 * Representa la función de ordenamiento de arbol, ubicada en su propia clase.
	 * @param numeros Datos de inserción.
	 * @return Datos organizados.
	 */
	public ArrayList<Long> treeSort(long[] numeros) {
		tree.treeins(numeros);
        tree.inorder();
        return tree.getSorted();
	}
	
	/**
	 * Representa la función de ordenamiento de Cocktail Sort, ubicada en su propia clase.
	 * @return Métodos de la clase CocktailSort.
	 */
	public CocktailSort getCocktailSort() {
		return cocktailSort;
	}

	/**
	 * Representa la función de ordenamiento de Quick Sort, ubicada en su propia clase.
	 * @return Métodos de la clase Quicksort.
	 */
	public Quicksort getQuicksort() {
		return quicksort;
	}

	/**
	 * Representa la función de ordenamiento de Radix Sort, ubicada en su propia clase.
	 * @return Métodos de la clase RadixSort.
	 */
	public RadixSort getRadixSort() {
		return radixSort;
	}


	
}
