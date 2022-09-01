package co.edu.unbosque.model;

import java.util.Arrays;
/**
 * En esta clase se ubicará un método Radix Sort, el cual organizará cierta cantidad de datos.
 * @author Laura Mateus, Natalia Ardila, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class RadixSort {
	
	/**
	 * Representa el método encargado de obtener el dato mayor del arreglo.
	 * @param arr Arreglo.
	 * @param n Numero de datos en el arreglo.
	 * @return Dato de mayor valor en el arreglo.
	 */
    public long obtenerMaximo(long arr[], int n)
    {
        long mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    /**
     * Este método se encarga de contar el arreglo y de rotar los valores de este.
     * @param arr Arreglo.
     * @param n Posición del arreglo.
     * @param exp Valor para operar en la cuenta.
     */
    public void contarSort(long arr[], int n, int exp)
    {
        long output[] = new long[n];
        int i;
        long count[] = new long[10];
        Arrays.fill(count, 0);
 
        for (i = 0; i < n; i++)
            count[(int) ((arr[i] / exp) % 10)]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        for (i = n - 1; i >= 0; i--) {
            output[(int) (count[(int) ((arr[i] / exp) % 10)] - 1)] = arr[i];
            count[(int) ((arr[i] / exp) % 10)]--;
        }
 
        for (i = 0; i < n; i++)
            arr[i] = output[i];
        
        
    }
 
    /**
     * Representa el método en el cual se usaran los métodos anteriores para retornar el arreglo ya ordenado.
     * @param arr Arreglo.
     * @return Arreglo ordenado.
     */
    public long[] radixxsort(long arr[])
    {	
    	int n = arr.length;
        long m = obtenerMaximo(arr, n);
 
        for (int exp = 1; m / exp > 0; exp *= 10)
            contarSort(arr, n, exp);
        
        return arr;
    }
    
}
