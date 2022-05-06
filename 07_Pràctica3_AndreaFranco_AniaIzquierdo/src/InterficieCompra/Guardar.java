package InterficieCompra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.DadesClient;

public class Guardar implements ActionListener {

	private IGCompra finestra;
	private DadesClient llista;

	/**
	 * mètode constructor
	 * 
	 * @param finestra
	 * @param llista
	 */
	public Guardar(IGCompra finestra, DadesClient llista) {
		this.finestra = finestra;
		this.llista = llista;

	}

	/**
	 * per a guardar les dades
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		finestra.guardarCompraBinari(llista);
		finestra.desactivarGuardar();
	}
}
