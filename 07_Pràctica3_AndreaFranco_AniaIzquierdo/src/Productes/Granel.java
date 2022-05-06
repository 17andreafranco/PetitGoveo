package Productes;

public class Granel extends Productes {

	private boolean esCeliac;
	private Productes producte;

	public Granel() {
		super();
		this.esCeliac = false;
	}

	/**
	 * metode constructor
	 * 
	 * @param producte
	 * @param esCeliac
	 */
	public Granel(Productes producte, boolean esCeliac) {
		super(producte.getNomProducte(), producte.getPreuProducte(), producte.getStock(), producte.getNIFProductor(),
				producte.getNomProductor(), producte.getLatProductor(), producte.getLongProductor(),
				producte.getEsGranel(), producte.getCodiProducte());
		this.producte = producte;
		this.esCeliac = esCeliac;
	}

	/**
	 * getter de si es celiac
	 * 
	 * @return si es o no celiac
	 */
	public boolean getEsCeliac() {
		return esCeliac;
	}

	/**
	 * setter de si es celiac
	 * 
	 * @param esCeliac
	 */
	public void setEsCeliac(boolean esCeliac) {
		this.esCeliac = esCeliac;
	}

	/**
	 * getter del producte
	 * 
	 * @return producte
	 */
	public Productes getProducte() {
		return producte;
	}

	/**
	 * setter del producte
	 * 
	 * @param producte
	 */
	public void setProducte(Productes producte) {
		this.producte = producte;
	}

	/**
	 * getter de granel
	 * 
	 * @return si es o no a granel
	 */
	public boolean getEsGranel() {
		return true;
	}

	/**
	 * to string de si es celiac o no
	 * 
	 * @return frase de si es o no celiac
	 */

	public String toString() {
		return (super.toString() + ", Es celiac:" + esCeliac);
	}

}
