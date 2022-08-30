package co.edu.unbosque.model;

public class CocktailSort {
	public int[] cocktail_Sort(int arrayNumero[]){
		boolean organizado=true;
		
		while(organizado) {
			organizado = false;
			for (int x =0;x<=arrayNumero.length-2;x++) {
				if (arrayNumero[ x ] > arrayNumero[ x + 1 ]) {
					int temp = arrayNumero[x];
					arrayNumero[x] = arrayNumero[x+1];
					arrayNumero[x+1]=temp;
					organizado = true;
				}
			}
			if (!organizado) {
				return null;
			}
			organizado = false;
			for (int x=arrayNumero.length-2;x>=0;x--) {
				if (arrayNumero[ x ] > arrayNumero[ x + 1 ]) {
					int temp = arrayNumero[x];
					arrayNumero[x] = arrayNumero[x+1];
					arrayNumero[x+1]=temp;
					organizado = true;
				}
			}
		}
		return arrayNumero;
	}
}
