package co.edu.unbosque.model;
import java.util.Stack;
/**
 * En esta clase se ubicará un método Quick Sort, el cual organizará cierta cantidad de datos.
 * @author Laura Mateus, Natalia Ardila, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class Quicksort {
	private long[] arr;
    
    /**
     * Representa el método constructor de la clase Quicksort, el cual sirve de referencia para la clase FuncionDeOrdenamiento.
     */
    public Quicksort() {
		
    }

    /**
     * Representa el método que se encarga de cambiar la posición de un dato del arreglo.
     * @param arr Arreglo.
     * @param i La posición de un dato del arreglo.
     * @param j La posición con la que cambia un dato del arreglo.
     */
  
    
    /**
     * Representa el método que se encarga de realizar cortes en determinadas secciones del arreglo y ordenarlas en funcion del pivot.
     * @param a Arreglo.
     * @param start Valor de inicio.
     * @param end Valor de fin.
     * @return Ls seccion que se ordena parcialmente periodicamente.
     */
 
    
    

    /**
     * Representa el método que en encarga de iterar el proceso de ordenamiento en funcion de las particiones.
     * @param a Arreglo.
     * @return Datos organizados.
     */
 
    
    
    
    
    
    
    
    
    public void quickSort(final int size) {
        int l = 0;
        int r = size - 1;
        int q, i = 0;
        int temp = r;
        while (true) {
            i--;
            while (l < temp) {
                q = particion(l, temp);
                arr[temp] = -arr[temp];
                temp = q - 1;
                ++i;
            }
            if (i < 0)
                break;
            l++;
            temp = encontrarElSiguiente(l, size);
            arr[temp] = -arr[temp];
        }
    }

    public int encontrarElSiguiente(final int l, final int size) {
        for (int i = l; i < size; ++i) {
            if (arr[i] < 0)
                return i;
        }
        return size - 1;
    }

    public int particion(int l, int r) {
        long pivot = arr[(l + r) / 2];
        while (l <= r) {
            while (arr[r] > pivot)
                r--;
            while (arr[l] < pivot)
                l++;
            if (l <= r) {
                long tmp = arr[r];
                arr[r] = arr[l];
                arr[l] = tmp;
                l++;
                r--;
            }
        }
        return l;
    }

	public long[] getArr() {
		return arr;
	}

	public void setArr(long[] arr) {
		this.arr = arr;
	}
      
}