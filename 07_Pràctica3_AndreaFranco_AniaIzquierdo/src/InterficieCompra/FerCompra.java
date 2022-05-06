package InterficieCompra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.DadesClient;
import Productes.LlistaProductes;

public class FerCompra implements ActionListener {
	private IGCompra finestra;
	private DadesClient llista;
	private LlistaProductes producte;

	/**
	 * mètode constructor
	 * 
	 * @param finestra
	 * @param llista
	 * @param producte
	 */
	public FerCompra(IGCompra finestra, DadesClient llista, LlistaProductes producte) {
		this.finestra = finestra;
		this.llista = llista;
		this.producte = producte;

	}

	@Override
	/**
	 * interficie grafica per a comprar
	 */
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		finestra.buidarMissatge();
		finestra.preguntarCompra(llista, producte);
		finestra.escriureMissatge(llista.toString());
		finestra.activarGuardar();
	}

}
