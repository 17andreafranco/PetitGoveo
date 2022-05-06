package InterficieProductor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Productes.LlistaProductes;

public class MostrarProductes implements ActionListener {

	private IGProductor finestra;
	private LlistaProductes llista;

	/**
	 * metode constructor
	 * 
	 * @param finestra
	 * @param llista
	 */
	public MostrarProductes(IGProductor finestra, LlistaProductes llista) {
		this.finestra = finestra;
		this.llista = llista;
	}

	/**
	 * IG per a mostrar els productes del productor
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		finestra.buidarMissatge();
		finestra.escriureMissatge(llista.llistarProductesProductor(llista.deNIFaProductor(finestra.getNIF())));
		finestra.activarGranelUnitatStock();
		finestra.desactivarmStockPreu();
	}

}
