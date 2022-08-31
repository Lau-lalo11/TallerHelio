package co.edu.unbosque.model;
/**
 * En esta clase se ubicará un método el cual organizará cierta cantidad de datos.
 * @author Laura Mateus, Natalia Ardila, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class CocktailSort {
	/**
	 * 
	 * @param arrayNumero
	 * @return
	 */
	public long[] cocktail_Sort(long arrayNumero[]){
		boolean organizado=true;
		
		while(organizado) {
			organizado = false;
			for (int x =0;x<=arrayNumero.length-2;x++) {
				if (arrayNumero[ x ] > arrayNumero[ x + 1 ]) {
					long temp = arrayNumero[x];
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
					long temp = arrayNumero[x];
					arrayNumero[x] = arrayNumero[x+1];
					arrayNumero[x+1]=temp;
					organizado = true;
				}
			}
		}
		return arrayNumero;
	}
}
