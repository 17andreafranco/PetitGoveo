package InterficieProductor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Productes.LlistaProductes;

public class FiltreStock implements ActionListener {

	private IGProductor finestra;
	private LlistaProductes llista;

	/**
	 * mètode constructor
	 * 
	 * @param finestra
	 * @param llista
	 */
	public FiltreStock(IGProductor finestra, LlistaProductes llista) {

		this.finestra = finestra;
		this.llista = llista;

	}

	/**
	 * IG de filtrar l'stock
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		String res = "";
		res = llista.deNIFaProductor(finestra.getNIF());

		if (b.getText().equals("Te Stock")) {

			finestra.buidarMissatge();
			finestra.escriureMissatge(llista.llistarProductesStock(res, true));

		} else {

			finestra.buidarMissatge();
			finestra.escriureMissatge(llista.llistarProductesStock(res, false));
		}
	}

}
