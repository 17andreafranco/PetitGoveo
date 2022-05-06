package InterficieProductor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Productes.LlistaProductes;

public class SeleccionarProducte implements ActionListener {

	private IGProductor finestra;
	private LlistaProductes llista;

	/**
	 * meotde constructor
	 * 
	 * @param finestra
	 * @param llista
	 */
	public SeleccionarProducte(IGProductor finestra, LlistaProductes llista) {

		this.finestra = finestra;
		this.llista = llista;

	}

	/**
	 * IG per a seleccionar un producte
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		String res = "";

		finestra.buidarMissatge();
		finestra.indicarProducte(llista);
		res = llista.llistarProductaCodi(finestra.getCodiProducteIG(), finestra.getNIF());
		finestra.escriureMissatge(res);
		finestra.desactivarGranelUnitatStock();
		finestra.activarmStockPreu();
	}

}
