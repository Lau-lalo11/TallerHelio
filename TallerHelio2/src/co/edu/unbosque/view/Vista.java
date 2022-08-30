package co.edu.unbosque.view;

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
	
}
