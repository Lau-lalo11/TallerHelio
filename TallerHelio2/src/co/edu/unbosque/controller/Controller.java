package co.edu.unbosque.controller;
import co.edu.unbosque.model.FuncionDeOrdenamiento;
import co.edu.unbosque.model.Quicksort;
import co.edu.unbosque.view.Vista;

public class Controller {
	
	private FuncionDeOrdenamiento funcionOrdenamiento;
	private Quicksort quick;
	private Vista vista;
	
	public Controller() {
		
		vista = new Vista();
		quick = new Quicksort();
		funcionOrdenamiento = new FuncionDeOrdenamiento();
		
		
		int[] numero=quick.OrganizarDato(generarNumerosAleatorios(vista.obtenerDato("Ingresar el tamano que va a poner a prueba")));
		for(int x=0;x<numero.length;x++) {
			System.out.println(x+" - "+numero[x]);
		}
		
	}
	
	public int[] generarNumerosAleatorios(int numeroElementos) {
		int[] numeros= new int[numeroElementos];
		for(int x=0;x<numeroElementos;x++) {
			numeros[x]= (int) (Math.random()*numeroElementos);
		}
		return numeros;
	}

}
