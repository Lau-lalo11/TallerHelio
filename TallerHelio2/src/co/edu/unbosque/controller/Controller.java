package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.LongStream;

import co.edu.unbosque.model.FuncionDeOrdenamiento;
import co.edu.unbosque.view.Vista;
/**
 * La clase Controller representa el controlador en el patron de arquitectura MVC que unira las funciones de la vista y el modelo.
 * Además contiene ciertos metodos que nos ayudan a generar datos.
 * @author Laura Mateus, Natalia Ardila, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class Controller {

	private FuncionDeOrdenamiento funcionOrdenamiento;
	private Vista vista;
	/**
	 * Representa el método constructor de la clase Controller, en el cual, se hacen las validaciones que permiten el 
	 * correcto funcionamiento del programa.
	 */
	public Controller() {

		vista = new Vista();
		funcionOrdenamiento = new FuncionDeOrdenamiento();

		vista.mostrarVentana("Bienvenido al ordenamiento de arreglos");
		
		long tamanioNumeros =0;
		long[] numeros = null;
		long[] organizado= null;
		long startTime;
		long endTime;

		int  opcion = -1;
		while(opcion != 0) {
			try {

				opcion = Integer.parseInt(vista.recibirDato("¿Qué método de ordenamiento desea implementar?"+"\n"+
						" 0. Salir"+"\n"+
						" 1. CocktailSort"+"\n"+
						" 2. QuicSort"+"\n"+
						" 3. RadixSort"+"\n"+
						" 4. Binary tree sort"+"\n"));
				if(opcion !=0) {
					if(numeros !=null) {
						if(!vista.recibirBoolean("¿Desea utilizar el arreglo anterior?")) { 
							tamanioNumeros = Long.parseLong(vista.recibirDato("Ingrese que cantidad de datos desea ordenar\n"));

							numeros = generarNumerosAleatorios(tamanioNumeros);
						}
					}else {
						tamanioNumeros = Long.parseLong(vista.recibirDato("Ingrese que cantidad de datos desea ordenar\n"));
						numeros = generarNumerosAleatorios(tamanioNumeros);
					}
					vista.mostrarVentana("Ya se cargaron los datos.");
				}
				String resultado = "";
				
				System.gc();
				
				switch (opcion) {

				
				
				case 0: vista.mostrarVentana("¡Vuelve pronto!");
				break;



				case 1: 


					startTime = System.nanoTime();
					//organizado = 
					funcionOrdenamiento.getCocktailSort().cocktail_Sort(numeros);
					endTime = (System.nanoTime() - startTime);

					resultado = "C: "+"Tamaño:"+tamanioNumeros+" Tiempo:"+ endTime +" NanoSegundos";

					vista.mostrarVentana("Resultados:\n"+resultado);
					break;
				case 2: 

					startTime = System.nanoTime();
					//organizado = 
					funcionOrdenamiento.getQuicksort().iterativeQuicksort(numeros); 
					endTime = (System.nanoTime() - startTime);

					resultado = "Q: "+"Tamaño:"+tamanioNumeros+" Tiempo:"+ endTime +" NanoSegundos";

					vista.mostrarVentana("Resultados:\n"+resultado);
					break;
				case 3: 

					startTime = System.nanoTime();
					organizado = funcionOrdenamiento.getRadixSort().radixxsort(numeros);
					endTime = (System.nanoTime() - startTime);
					resultado = "R: "+"Tamaño:"+tamanioNumeros+" Tiempo:"+ endTime +" NanoSegundos";
					System.out.println(Arrays.toString(organizado));
					vista.mostrarVentana("Resultados:\n"+resultado);

					break;
				case 4: 
					ArrayList<Long> numerosSorted;

					startTime = System.nanoTime();
					//numerosSorted = 
					funcionOrdenamiento.treeSort(numeros);
					endTime = (System.nanoTime() - startTime);

					resultado = "B: "+"Tamaño:"+tamanioNumeros+" Tiempo:"+ endTime +" NanoSegundos";

					vista.mostrarVentana("Resultados:\n"+resultado);

					break;
				default:
					vista.mostrarVentana("La opción ingresada no existe, vuelva longentarlo");
					break;
				}

				

				if(resultado!="") vista.escribirContenido(resultado);
				resultado="";
			}catch(NumberFormatException e) {
				vista.mostrarVentana("El cáracter ingresado es invalido, vuelva longentarlo");
			}
		}

	}
	/**
	 * Representa el método que obtiene los tiempos de ejecución de cada método de ordenamiento.
	 */
	public void obtenerDatosAutomatizados() {

		long tamanioNumeros =0;
		int[] prueba = {6000,60000,600000,6000000,60000000};
		long[] numeros = null;
		long[] organizado= null;
		long startTime;
		long endTime;
		String resultado = "";

		for (long l : prueba) {

			tamanioNumeros = l;
			int opciones = 4;
			numeros = generarNumerosAleatorios(l);
			while(opciones>=1) {
				System.gc();
				funcionOrdenamiento = new FuncionDeOrdenamiento();
				switch (opciones) {


				case 1: 


					startTime = System.nanoTime();
					//organizado = 
					funcionOrdenamiento.getCocktailSort().cocktail_Sort(numeros);
					endTime = (System.nanoTime() - startTime);

					resultado = "C: "+"Tamaño:"+tamanioNumeros+" Tiempo:"+ endTime +" NanoSegundos";

					break;
				case 2: 

					startTime = System.nanoTime();
					//organizado = 
					//funcionOrdenamiento.getQuicksort().iterativeQuicksort(numeros); 
					funcionOrdenamiento.getRadixSort().radixxsort(numeros);
					endTime = (System.nanoTime() - startTime);

					resultado = "R: "+"Tamaño:"+tamanioNumeros+" Tiempo:"+ endTime +" NanoSegundos";

					break;
				case 3: 

					startTime = System.nanoTime();
					//organizado = 
					//funcionOrdenamiento.getRadixSort().radixxsort(numeros);
					funcionOrdenamiento.getQuicksort().iterativeQuicksort(numeros); 
					endTime = (System.nanoTime() - startTime);
					resultado = "Q: "+"Tamaño:"+tamanioNumeros+" Tiempo:"+ endTime +" NanoSegundos";


					break;
				case 4: 
					//ArrayList<Long> numerosSorted;

					startTime = System.nanoTime();
					//numerosSorted = 
					funcionOrdenamiento.treeSort(numeros);
					endTime = (System.nanoTime() - startTime);
					resultado = "B: "+"Tamaño:"+tamanioNumeros+" Tiempo:"+ endTime +" NanoSegundos";


					break;
				}
				vista.escribirContenido(resultado);
				opciones--;
			}
		}
	}
	/**
	 * Representa el método que se encarga de generar los datos aleatorios para organizarlos por cada método de ordenamiento.
	 * @param numeroElementos Cantidad de datos que serán ingresados.
	 * @return Retorna la versión String del array comprendido por la cantidad de datos generada en el parametro lleno de 
	 * datos aleatorios.
	 */
	public long[] generarNumerosAleatorios(long numeroElementos) {

		//usando Java 8
		long[] numerosAleatorios = LongStream.rangeClosed(1, numeroElementos).toArray();
		//desordenando los elementos
		Random r = new Random();
		for (int i = numerosAleatorios.length; i > 0; i--) {
			int posicion = r.nextInt(i);
			long tmp = numerosAleatorios[i-1];
			numerosAleatorios[i - 1] = numerosAleatorios[posicion];
			numerosAleatorios[posicion] = tmp;
		}
		System.out.println(Arrays.toString(numerosAleatorios));
		return numerosAleatorios;
	}

}

