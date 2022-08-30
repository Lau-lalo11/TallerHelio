package co.edu.unbosque.controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.FuncionDeOrdenamiento;
import co.edu.unbosque.view.Vista;

public class Controller {

	private FuncionDeOrdenamiento funcionOrdenamiento;
	private Vista vista;

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
				String resultado = "";
				switch (opcion) {

				case 0: vista.mostrarVentana("¡Vuelve pronto!");
				break;



				case 1: 


					startTime = System.nanoTime();
					organizado = funcionOrdenamiento.getCocktailSort().cocktail_Sort(numeros);
					endTime = (System.nanoTime() - startTime);

					resultado = "C: "+"Tamaño:"+tamanioNumeros+" Tiempo:"+ endTime +" NanoSegundos";

					vista.mostrarVentana("Resultados:\n"+resultado);
					break;
				case 2: 

					startTime = System.nanoTime();
					organizado = funcionOrdenamiento.getQuicksort().iterativeQuicksort(numeros); 
					endTime = (System.nanoTime() - startTime);

					resultado = "Q: "+"Tamaño:"+tamanioNumeros+" Tiempo:"+ endTime +" NanoSegundos";

					vista.mostrarVentana("Resultados:\n"+resultado);
					break;
				case 3: 

					startTime = System.nanoTime();
					organizado = funcionOrdenamiento.getRadixSort().radixSort(numeros);
					endTime = (System.nanoTime() - startTime);

					resultado = "R: "+"Tamaño:"+tamanioNumeros+" Tiempo:"+ endTime +" NanoSegundos";

					vista.mostrarVentana("Resultados:\n"+resultado);
					break;
				case 4: 
					ArrayList<Long> numerosSorted;

					startTime = System.nanoTime();
					numerosSorted = funcionOrdenamiento.treeSort(numeros);
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

	
	public long[] generarNumerosAleatorios(long numeroElementos) {
		long[] numeros= new long[(int) numeroElementos];
		ArrayList<Long> numeross = new ArrayList<>();

		while(numeross.size() != numeroElementos) {
			long aleatorio= (long) (Math.random()*numeroElementos*100);
			if(!numeross.contains(aleatorio)) { 
				numeross.add(aleatorio);
			}
		}

		for(int x=0;x<numeroElementos;x++) {
			numeros[x] = numeross.get(x);
		}

		return numeros;
	}

}
