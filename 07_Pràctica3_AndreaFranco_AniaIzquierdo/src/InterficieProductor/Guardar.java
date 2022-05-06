package InterficieProductor;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import Productes.LlistaProductes;

public class Guardar implements ActionListener {

	private LlistaProductes llista;
	private IGProductor finestra;

	/**
	 * metode constructor
	 * 
	 * @param finestra
	 * @param llista
	 */
	public Guardar(IGProductor finestra, LlistaProductes llista) {

		this.llista = llista;
		this.finestra = finestra;

	}

	/**
	 * IG per guardar
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if (b.getText().equals("Guardar")) {
			try {
				llista.escriureFitxer();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finestra.desactivarGuardar();
		}
	}
}
