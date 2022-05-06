package InterficieProductor;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import Productes.LlistaProductes;

public class FiltreUnitatsGranel implements ActionListener {

	private IGProductor finestra;
	private LlistaProductes llista;

	/**
	 * mètode constructor
	 * 
	 * @param finestra
	 * @param llista
	 */
	public FiltreUnitatsGranel(IGProductor finestra, LlistaProductes llista) {

		this.finestra = finestra;
		this.llista = llista;

	}

	/**
	 * filtrar per unitats o granel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		String res = "";
		res = llista.deNIFaProductor(finestra.getNIF());

		if (b.getText().equals("Filtre Granel")) {

			finestra.buidarMissatge();
			finestra.escriureMissatge(llista.llistarProductesProductorGranel(res, true));

		} else {

			finestra.buidarMissatge();
			finestra.escriureMissatge(llista.llistarProductesProductorGranel(res, false));

		}
	}
}
