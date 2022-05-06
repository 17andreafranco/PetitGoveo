package InterficieCompra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.DadesClient;
import Productes.LlistaProductes;

public class FiltreProductorStock implements ActionListener {

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
	public FiltreProductorStock(IGCompra finestra, DadesClient llista, LlistaProductes producte) {
		this.finestra = finestra;
		this.llista = llista;
		this.producte = producte;

	}

	/**
	 * filtre del productor per stock
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();

		if (b.getText().equals("Filtre productor")) {

			finestra.buidarMissatge();
			finestra.indicarProductor(llista, producte);
			String res = finestra.productesProductorCompra(llista, producte, finestra.getNomProductorIG());
			finestra.escriureMissatge(res);

		} else {

			finestra.buidarMissatge();
			finestra.indicarQuilos();
			finestra.escriureMissatge(llista.llistarProductesPes(finestra.getPesMin(), finestra.getPesMax()));

		}
	}

}
