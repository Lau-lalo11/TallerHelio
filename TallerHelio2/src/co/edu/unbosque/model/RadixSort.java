package co.edu.unbosque.model;

import java.util.Arrays;

public class RadixSort {
	
	
    public static long getMax(long arr[], int n)
    {
        long mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    public static void countSort(long arr[], int n, int exp)
    {
        long output[] = new long[n]; // output array
        int i;
        long count[] = new long[10];
        Arrays.fill(count, 0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(int) ((arr[i] / exp) % 10)]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[(int) (count[(int) ((arr[i] / exp) % 10)] - 1)] = arr[i];
            count[(int) ((arr[i] / exp) % 10)]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
        
        
    }
 
    // The main function to that sorts arr[] of
    // size n using Radix Sort
    public static long[] radixxsort(long arr[])
    {	
    	int n = arr.length;
        // Find the maximum number to know number of digits
        long m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
        
        return arr;
    }
	
	
//	public static long[] radixSort(long[] arr) {
//		long[][] bucket = new long[10][arr.length];
//		long[] bucketOfElement = new long[10];
//		long max=0;
//		// Encuentra el elemento más grande en la matriz
//		for(int i = 0 ; i < arr.length;i++) {
//			if(arr[i]>max){
//				max = arr[i];
//			}
//		}
//		// Calcula el número de bits del elemento más grande
//		long maxLength = (max+"").length();
//		for(int m = 0,n=1;m<maxLength;m++,n*=10) {
//			// Coloca los números en arr en los cubos correspondientes según sus unidades, decenas, centenas, etc.
//			for(int i = 0 ; i < arr.length;i++) {
//				int digit = (int) (arr[i]/n%10);
//				// Asignar el valor de arr [i] a la matriz bidimensional en el depósito
//				bucket[digit][(int) bucketOfElement[digit]] = arr[i];
//				bucketOfElement[digit]++;
//			}
//			int index = 0;
//			// Leer los elementos en el depósito y reasignarlos a arr
//			for(int j = 0;j<10;j++) {
//				for(int k = 0 ; k<bucketOfElement[j];k++) {
//					arr[index] = bucket[j][k];
//					index++;
//				}
//				bucketOfElement[j]=0;// Borrar el número de elementos en cada uno
//			}
//			}
//		return arr;
//		}
    
}
