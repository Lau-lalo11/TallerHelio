package co.edu.unbosque.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Vista {
	
	public void mostrarVentana(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public String recibirDato(String msg) {
		return JOptionPane.showInputDialog(null, msg);
	}
	
	public boolean recibirBoolean(String msg) {
		int respuesta = JOptionPane.showConfirmDialog(null, msg, "Confirmación" ,JOptionPane.YES_NO_OPTION);
		
		if (respuesta == JOptionPane.NO_OPTION) return false;
		
		return true;
	}
	
	public void escribirContenido(String palabras) {

		try {
			String contenido =leerContenido()+palabras+"\n";
			FileWriter myWriter = new FileWriter("resultado.txt");



			myWriter.write(contenido);
			myWriter.close();
		} catch (IOException e) {
			System.out.println("Un error ocurrió.");
			e.printStackTrace();
		}
	}

	public String leerContenido(){
		String texto="";
		File file = new File("resultado.txt");
		String word;
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			word = bufferReader.readLine();
			do {
				if(word!=null) texto+=word+"\n";

				word = bufferReader.readLine();
			}while(word!=null);
			fileReader.close();

		}catch (Exception e) {

		}
		return texto;
	}

	
}
