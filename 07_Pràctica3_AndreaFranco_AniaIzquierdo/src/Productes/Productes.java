package Productes;
/**
 * 
 * @author Andrea Franco i Ania Izquierdo
 *
 */
public class Productes {

	private String nomProducte;
	private float preuProducte;
	private int stock;
	private String NIFProductor;
	private String nomProductor;
	private double latProductor;
	private double longProductor;
	private boolean esGranel;
	private String codiProducte;

	/**
	 * metode constructor
	 */
	public Productes() {
		this.nomProducte = "";
		this.preuProducte = 0;
		this.stock = 0;
		this.NIFProductor = "";
		this.nomProductor = "";
		this.latProductor = 0.0;
		this.longProductor = 0.0;
		this.esGranel = false;
		this.codiProducte = "";
	}

	/**
	 * metode constructor
	 * 
	 * @param nomProducte
	 * @param preuProducte
	 * @param stock
	 * @param nIFProductor
	 * @param nomProductor
	 * @param latProductor
	 * @param longProductor
	 * @param esGranel
	 * @param codiProducte
	 */
	public Productes(String nomProducte, float preuProducte, int stock, String nIFProductor, String nomProductor,
			double latProductor, double longProductor, boolean esGranel, String codiProducte) {
		super();
		this.nomProducte = nomProducte;
		this.preuProducte = preuProducte;
		this.stock = stock;
		NIFProductor = nIFProductor;
		this.nomProductor = nomProductor;
		this.latProductor = latProductor;
		this.longProductor = longProductor;
		this.esGranel = esGranel;
		this.codiProducte = codiProducte;
	}

	/**
	 * getter del nom del produte
	 * 
	 * @return nom del producte
	 */
	public String getNomProducte() {
		return nomProducte;
	}

	/**
	 * setter del nom del producte
	 * 
	 * @param nomProducte
	 */
	public void setNomProducte(String nomProducte) {
		this.nomProducte = nomProducte;
	}

	/**
	 * getter del preu del producte
	 * 
	 * @return preu del producte
	 */
	public float getPreuProducte() {
		return preuProducte;
	}

	/**
	 * setter del preu del producte
	 * 
	 * @param preuProducte
	 */
	public void setPreuProducte(float preuProducte) {
		this.preuProducte = preuProducte;
	}

	/**
	 * getter del stock
	 * 
	 * @return l'stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * setter del stock
	 * 
	 * @param stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * getter del NIF del productor
	 * 
	 * @return NIF del productor
	 */
	public String getNIFProductor() {
		return NIFProductor;
	}

	/**
	 * setter del NIF del productor
	 * 
	 * @param NIFProductor
	 */
	public void setNIFProductor(String NIFProductor) {
		this.NIFProductor = NIFProductor;
	}

	/**
	 * getter del nom del productor
	 * 
	 * @return
	 */
	public String getNomProductor() {
		return nomProductor;
	}

	/**
	 * setter del nom del productor
	 * 
	 * @param nomProductor
	 */
	public void setNomProductor(String nomProductor) {
		this.nomProductor = nomProductor;
	}

	/**
	 * getter de la latitud del productor
	 * 
	 * @return la latitud del productor
	 */
	public double getLatProductor() {
		return latProductor;
	}

	/**
	 * setter de la latitud del productor
	 * 
	 * @param latProductor
	 */
	public void setLatProductor(double latProductor) {
		this.latProductor = latProductor;
	}

	/**
	 * getter de la longitud del productor
	 * 
	 * @return longitud del productor
	 */
	public double getLongProductor() {
		return longProductor;
	}

	/**
	 * setter de la longitud del productor
	 * 
	 * @param longProductor
	 */
	public void setLongProductor(double longProductor) {
		this.longProductor = longProductor;
	}

	/**
	 * getter de granel
	 * 
	 * @return si es granel o no
	 */
	public boolean getEsGranel() {
		return false;
	}

	/**
	 * setter de granel
	 * 
	 * @param esGranel
	 */
	public void setEsGranel(boolean esGranel) {
		this.esGranel = esGranel;
	}

	/**
	 * getetr del codi del producte
	 * 
	 * @return el codi del producte
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
	 * setter de celiac
	 * 
	 * @param esCeliac
	 */
	public void setEsCeliac(boolean esCeliac) {

	}

	/**
	 * setter del pes de la unitat
	 */
	public void setPesUnitat(float pesUnitat) {

	}

	/**
	 * getter de celiac
	 * 
	 * @return si es celiac
	 */
	public boolean getEsCeliac() {
		return false;
	}

	/**
	 * getter del pes de la unitat
	 * 
	 * @return pes de la unitat
	 */
	public float getPesUnitat() {
		return 0;
	}

	/**
	 * to string de la informacio del producte
	 */
	public String toString() {
		return "Nom producte:" + nomProducte + ", Preu producte:" + preuProducte + ", Stock:" + stock
				+ ", NIFProductor:" + NIFProductor + ", Nom productor:" + nomProductor + ", Latitud productor:"
				+ latProductor + ", Longitud productor:" + longProductor + ", Es granel:" + esGranel
				+ ", Codi producte:" + codiProducte;
	}

}
