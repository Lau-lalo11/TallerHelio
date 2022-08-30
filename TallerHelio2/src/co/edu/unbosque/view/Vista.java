package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class Vista {
	
	public void mostrarVentana(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public String recibirDato(String msg) {
		return JOptionPane.showInputDialog(null, msg);
	}

}
