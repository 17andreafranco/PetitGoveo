package Productes;
/**
 * 
 * @author Andrea Franco i Ania Izquierdo
 *
 */
public class Unitat extends Productes {

	private float pesUnitat;
	private Productes producte;
/**
 * unitat
 */
	public Unitat() {
		super();
		this.pesUnitat = 0;
	}

	/**
	 * metode constructor
	 * 
	 * @param producte -el producte
	 * @param pesUnitat - el pes de la unitat
	 */
	public Unitat(Productes producte, float pesUnitat) {
		super(producte.getNomProducte(), producte.getPreuProducte(), producte.getStock(), producte.getNIFProductor(),
				producte.getNomProductor(), producte.getLatProductor(), producte.getLongProductor(),
				producte.getEsGranel(), producte.getCodiProducte());
		this.producte = producte;
		this.pesUnitat = pesUnitat;
	}

	/**
	 * getter del pes de la unitat
	 * 
	 * @return pes de la unitat
	 */
	public float getPesUnitat() {
		return pesUnitat;
	}

	/**
	 * setter del pes de la unuitat
	 * 
	 * @param pesUnitat - el pes de la unitat
	 */
	public void setPesUnitat(float pesUnitat) {
		this.pesUnitat = pesUnitat;
	}

	/**
	 * getter del producte
	 * 
	 * @return el producte
	 */
	public Productes getProducte() {
		return producte;
	}

	/**
	 * setter del producte
	 * 
	 * @param producte - el producte
	 */
	public void setProducte(Productes producte) {
		this.producte = producte;
	}

	/**
	 * to string del que pesa una unitat
	 */
	public String toString() {
		return (super.toString() + ", Pes unitat:" + pesUnitat);
	}

}
