package InterficieCompra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.DadesClient;

public class ModificarLatILong implements ActionListener {

	private IGCompra finestra;
	private DadesClient llista;

	/**
	 * mètode constructor
	 * 
	 * @param finestra
	 * @param llista
	 */
	public ModificarLatILong(IGCompra finestra, DadesClient llista) {
		this.finestra = finestra;
		this.llista = llista;

	}

	/**
	 * finestra de a longtud i la latitud
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();

		finestra.identificarLongILat(llista);

	}

}
