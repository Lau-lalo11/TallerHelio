package co.edu.unbosque.model;

import java.util.ArrayList;

public class FuncionDeOrdenamiento {

	private Tree tree;
	private RadixSort radixSort;
	private CocktailSort cocktailSort;
	private Quicksort quicksort;
	
	
	public FuncionDeOrdenamiento() {
		tree =  new Tree();
		radixSort = new RadixSort();
		cocktailSort = new CocktailSort();
		quicksort = new Quicksort();
	}



	public ArrayList<Integer> treeSort(int[] array) {
		tree.treeins(array);
        tree.inorderRec(tree.root);
        return tree.getSorted();
	}
	
	public CocktailSort getCocktailSort() {
		return cocktailSort;
	}


	public Quicksort getQuicksort() {
		return quicksort;
	}

	public RadixSort getRadixSort() {
		return radixSort;
	}


	
}
