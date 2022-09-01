package co.edu.unbosque.model;
import java.util.Stack;
/**
 * En esta clase se ubicará un método Quick Sort, el cual organizará cierta cantidad de datos.
 * @author Laura Mateus, Natalia Ardila, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class Quicksort {
	private long[] arr;
    private int x;
    private int y;
    
    /**
     * Representa el método constructor de la clase Quicksort, el cual sirve de referencia para la clase FuncionDeOrdenamiento.
     */
    public Quicksort() {
		// TODO Auto-generated constructor stub
    }
    
    /**
     * Representa el método constructor de la clase Quicksort, en el cual se establecen pivotes en los cuales el programa se basa
     * para ordenar los datos.
     * @param x Dato de inicio.
     * @param y Dato de fin.
     */
    Quicksort(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

	/**
	 * Se encarga de obtener el dato de inicio.
	 * @return Dato de inicio.
	 */
    public int getX() {
        return x;
    }

	/**
	 * Se encarga de cambiar el dato de inicio.
	 * @param x Dato de inicio.
	 */
    public void setX(int x) {
        this.x = x;
    }

	/**
	 * Se encarga de obtener el dato de fin.
	 * @return Dato de fin.
	 */
    public int getY() {
        return y;
    }


	/**
	 * Se encarga de cambiar el dato de fin.
	 * @param y Dato de fin.
	 */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Representa el método que se encarga de cambiar la posición de un dato del arreglo.
     * @param arr Arreglo.
     * @param i La posición de un dato del arreglo.
     * @param j La posición con la que cambia un dato del arreglo.
     */
    public void swap(long[] arr, int i, int j){
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * Representa el método que se encarga de realizar cortes en determinadas secciones del arreglo y ordenarlas en funcion del pivot.
     * @param a Arreglo.
     * @param start Valor de inicio.
     * @param end Valor de fin.
     * @return Ls seccion que se ordena parcialmente periodicamente.
     */
    public int partition(long a[], int start, int end){
        long pivot = a[end];
        int pIndex = start;

        for (int i = start; i < end; i++){
            if (a[i] <= pivot)
            {
                swap(a, i, pIndex);
                pIndex++;
            }
        }

        swap (a, pIndex, end);
        return pIndex;
    }

    /**
     * Representa el método que en encarga de iterar el proceso de ordenamiento en funcion de las particiones.
     * @param a Arreglo.
     * @return Datos organizados.
     */
    public long[] iterativeQuicksort(long[] a){

        Stack<Quicksort> stack = new Stack<>();

        int start = 0;
        int end = a.length - 1;

        stack.push(new Quicksort(start, end));

        while (!stack.empty())
        {
            start = stack.peek().getX();
            end = stack.peek().getY();
            stack.pop();
            int pivot = partition(a, start, end);

            if (pivot - 1 > start) {
                stack.push(new Quicksort(start, pivot - 1));
            }

            if (pivot + 1 < end) {
                stack.push(new Quicksort(pivot + 1, end));
            }
            System.out.println();
        }
        return a;
    }
    
    public void quickSort(final int size) {
        int l = 0;
        int r = size - 1;
        int q, i = 0;
        int tmpr = r;
        while (true) {
            i--;
            while (l < tmpr) {
                q = partition(l, tmpr);
                arr[tmpr] = -arr[tmpr];
                tmpr = q - 1;
                ++i;
            }
            if (i < 0)
                break;
            l++;
            tmpr = findNextR(l, size);
            arr[tmpr] = -arr[tmpr];
        }
    }

    private int findNextR(final int l, final int size) {
        for (int i = l; i < size; ++i) {
            if (arr[i] < 0)
                return i;
        }
        return size - 1;
    }

    private int partition(int l, int r) {
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