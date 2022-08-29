package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class Vista {
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public int obtenerDato(String mensaje) {
		return Integer.valueOf(JOptionPane.showInputDialog(mensaje));
	}

}
