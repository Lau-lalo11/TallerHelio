package co.edu.unbosque.model;

public class Quicksort {

	public int particion(int arreglo[], int izquierda, int derecha) {
		int pivote = arreglo[izquierda];
		while (true) {
			while (arreglo[izquierda] < pivote) {
				izquierda++;
			}
			while (arreglo[derecha] > pivote) {
				derecha--;
			}
			if (izquierda >= derecha) {
				return derecha;
			} else {
				int temporal = arreglo[izquierda];
				arreglo[izquierda] = arreglo[derecha];
				arreglo[derecha] = temporal;
				izquierda++;
				derecha--;
			}
		}
	}

	public int[] quicksort(int arreglo[], int izquierda, int derecha) {
		if (izquierda < derecha) {
			int indiceParticion = particion(arreglo, izquierda, derecha);
			quicksort(arreglo, izquierda, indiceParticion);
			quicksort(arreglo, indiceParticion + 1, derecha);
		}
		return arreglo;
	}

	public int[] organizarDato(int arreglo[]) {
		return quicksort(arreglo,0,arreglo.length-1);
	}

}
