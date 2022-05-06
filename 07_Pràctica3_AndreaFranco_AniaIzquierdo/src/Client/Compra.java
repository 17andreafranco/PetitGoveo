package Client;

import java.io.Serializable;

public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;
	private String codiProducte;
	private int numUnitats;
	private String data;
	private double preuTotal;

	/**
	 * definim valors
	 */
	public Compra() {
		codiProducte = null;
		numUnitats = 0;
		data = null;
		preuTotal = 0;

	}

	/**
	 * metode constructor
	 * 
	 * @param codiProducte
	 * @param numUnitats
	 * @param data
	 * @param preuTotal
	 */
	public Compra(String codiProducte, int numUnitats, String data, double preuTotal) {
		this.codiProducte = codiProducte;
		this.numUnitats = numUnitats;
		this.data = data;
		this.preuTotal = preuTotal;

	}

	/**
	 * getter del codi del producte
	 * 
	 * @return codi del producte
	 */
	public String getCodiProducte() {
		return codiProducte;
	}

	/**
	 * setter del codi del producte
	 * 
	 * @param codiProducte
	 */
	public void setCodiProducte(String codiProducte) {
		this.codiProducte = codiProducte;
	}

	/**
	 * getter del numero d'unitats
	 * 
	 * @return numeor d'unitats
	 */
	public int getNumUnitats() {
		return numUnitats;
	}

	/**
	 * setter del numero d'unitats
	 * 
	 * @param numUnitats
	 */
	public void setNumUnitats(int numUnitats) {
		this.numUnitats = numUnitats;
	}

	/**
	 * getter de la data
	 * 
	 * @return la data
	 */
	public String getData() {
		return data;
	}

	/**
	 * setter de la data
	 * 
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * getter del preu total
	 * 
	 * @return el preu total
	 */
	public double getPreuTotal() {
		return preuTotal;
	}

	/**
	 * setter del preu total
	 * 
	 * @param preuTotal
	 */
	public void setPreuTotal(double preuTotal) {
		this.preuTotal = preuTotal;
	}

	/**
	 * tostring de la compra
	 */
	public String toString() {
		return "Codi producte: " + codiProducte + ", Numero d'unitats: " + numUnitats + ", " + "Data: " + data + ", "
				+ "Preu total:" + preuTotal + "\n";
	}

}
