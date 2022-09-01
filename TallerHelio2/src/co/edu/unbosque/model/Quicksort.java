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
     * Representa el método que se encarga de organizar el arreglo.
     * @param size Tamaño del arrego.
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
    /**
     * Se encarga de hallar el dato siguiente al seleccionado.
     * @param l Posición determinada de un dato en el areglo.
     * @param size Tamaño del arreglo.
     * @return El dato siguiente al seleccionado.
     */
    public int encontrarElSiguiente(final int l, final int size) {
        for (int i = l; i < size; ++i) {
            if (arr[i] < 0)
                return i;
        }
        return size - 1;
    }

    /**
     * Se encarga de realizar la particion en función del pivot y cambia los datos de posición.
     * @param l Posición determinada de un dato en el areglo.
     * @param r Posición determinada de un dato en el areglo.
     * @return Partición parcialmente organizado
     */
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

    /**
     * Se encarga de obtener el arreglo que contiene los datos.
     * @return Arreglo de los datos
     */
	public long[] getArr() {
		return arr;
	}
	
	/**
	 * Se encarga de cambiar el arreglo que contiene los datos.
	 * @param arr Arreglo de los datos
	 */
	public void setArr(long[] arr) {
		this.arr = arr;
	}
      
}