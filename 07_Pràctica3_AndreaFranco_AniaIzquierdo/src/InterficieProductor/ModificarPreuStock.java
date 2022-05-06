package InterficieProductor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Productes.LlistaProductes;

public class ModificarPreuStock implements ActionListener {

	private IGProductor finestra;
	private LlistaProductes llista;

	/**
	 * metode constructor
	 * 
	 * @param finestra
	 * @param llista
	 */
	public ModificarPreuStock(IGProductor finestra, LlistaProductes llista) {

		this.finestra = finestra;
		this.llista = llista;

	}

	/**
	 * IG per a modificar el preu i l'estoc
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		String res = "";

		if (b.getText().equals("Modificar Stock")) {

			finestra.buidarMissatge();
			finestra.indicarStock(llista);
			llista.modificarStock(llista.deCodiaNomProducte(finestra.getCodiProducteIG()), finestra.getStockIG());
			res = llista.llistarProductaCodi(finestra.getCodiProducteIG(), finestra.getNIF());
			finestra.escriureMissatge(res);
			finestra.activarGuardar();
		} else {

			finestra.buidarMissatge();
			finestra.indicarPreu(llista);
			llista.modificarPreu(llista.deCodiaNomProducte(finestra.getCodiProducteIG()), finestra.getPreuIG());
			res = llista.llistarProductaCodi(finestra.getCodiProducteIG(), finestra.getNIF());
			finestra.escriureMissatge(res);
			finestra.activarGuardar();
		}
	}

}
