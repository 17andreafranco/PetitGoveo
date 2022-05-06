package Client;

import java.util.StringTokenizer;

public class DadesClient {

	private double latClient;
	private double longClient;
	private Compra[] llista;
	private int numProductesCompra;

	/**
	 * donem valors
	 * 
	 * @param dim
	 */
	public DadesClient(int dim) {
		latClient = 0;
		longClient = 0;
		llista = new Compra[dim];
		numProductesCompra = 0;
	}

	/**
	 * metode constructor
	 * 
	 * @param latClient
	 * @param longClient
	 * @param dim
	 */
	public DadesClient(double latClient, double longClient, int dim) {
		this.latClient = latClient;
		this.longClient = longClient;
		llista = new Compra[dim];
		numProductesCompra = 0;
	}

	/**
	 * donem valors
	 */
	public DadesClient() {
		latClient = 0;
		longClient = 0;
		llista = new Compra[50];
		numProductesCompra = 0;
	}

	/**
	 * getter de la latitud del client
	 * 
	 * @return latitud del client
	 */
	public double getlatClient() {
		return this.latClient;
	}

	/**
	 * getter de la longitud del client
	 * 
	 * @return longitud del client
	 */
	public double getlongClient() {
		return this.longClient;
	}

	/**
	 * getter de la llisa
	 * 
	 * @return la llista
	 */
	public Compra[] getLlista() {
		return this.llista;
	}

	/**
	 * getter del numero de producte de la compra
	 * 
	 * @return numero del porducte
	 */
	public int getNUmProducteCompra() {
		return this.numProductesCompra;
	}

	/**
	 * setter de la latitud del client
	 * 
	 * @param latClient
	 */
	public void setlatClient(double latClient) {
		this.latClient = latClient;
	}

	/**
	 * setter de la longitud del client
	 * 
	 * @param longClient
	 */
	public void setlongClient(double longClient) {
		this.longClient = longClient;
	}

	/**
	 * setter de la llista
	 * 
	 * @param llista
	 */
	public void setLlista(Compra[] llista) {
		this.llista = llista;
	}

	/**
	 * setter del nom del producte
	 * 
	 * @param numProducteCompra
	 */
	public void setNomProducte(int numProducteCompra) {
		this.numProductesCompra = numProducteCompra;
	}

	/**
	 * meotde per afegir productes a la llista de la compra
	 * 
	 * @param a
	 * @return boolea
	 */
	public boolean afegirllistaCompra(Compra a) {

		for (int i = 0; i < llista.length; i++) {
			if (llista[i] == null) {
				llista[i] = a;
				numProductesCompra++;
				return true;
			}
		}
		return false;
	}

	/**
	 * metode per a ordenar per la data de compra
	 */
	public void ordenarDataCompra() {
		Compra aux = new Compra();
		int i = 0;

		while (i < llista.length - 1) {
			if (llista[i] != null) {
				StringTokenizer datamax = new StringTokenizer(llista[i].getData(), "-");

				int diamax = Integer.parseInt(datamax.nextToken());
				int mesmax = Integer.parseInt(datamax.nextToken());
				int anymax = Integer.parseInt(datamax.nextToken());

				int posmax = i;
				int j = i + 1;

				if (llista[j] != null) {
					while (j < llista.length) {
						if (llista[j] != null) {
							System.out.println("hola3");
							StringTokenizer data2 = new StringTokenizer(llista[j].getData(), "-");

							int dia2 = Integer.parseInt(data2.nextToken());
							int mes2 = Integer.parseInt(data2.nextToken());
							int any2 = Integer.parseInt(data2.nextToken());

							if (anymax < any2) {
								diamax = dia2;
								mesmax = mes2;
								anymax = any2;

								posmax = j;
								aux = llista[j];

							} else if ((mesmax < mes2) && (anymax == any2)) {
								diamax = dia2;
								mesmax = mes2;
								anymax = any2;

								posmax = j;
								aux = llista[j];

							} else if ((diamax < dia2) && (mesmax == mes2) && (anymax == any2)) {
								diamax = dia2;
								mesmax = mes2;
								anymax = any2;

								posmax = j;
								aux = llista[j];
							}
						}

						j++;

					}
				}
				llista[posmax] = llista[i];
				llista[i] = aux;
				i++;
				System.out.println(toString());
			}
		}
	}

	/**
	 * metode per saber si el producte esta
	 * 
	 * @param codiProducte
	 * @return si esta o no
	 */
	public boolean hihaProducte(String codiProducte) {

		for (int i = 0; i < llista.length; i++) {
			if (llista[i] != null) {
				if (llista[i].getCodiProducte().equalsIgnoreCase(codiProducte)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * metode per a llistar els productes pel seu pes
	 * 
	 * @param min
	 * @param max
	 * @return string
	 */
	public String llistarProductesPes(float min, float max) {

		String res = "";

		for (int i = 0; i < llista.length; i++) {
			if (llista[i] != null) {
				if (llista[i].getNumUnitats() >= min && llista[i].getNumUnitats() <= max) {
					res = res + llista[i].toString();
				}
			}
		}

		return res;
	}

	/**
	 * to string de la llista de la compra
	 */
	public String toString() {

		String res = "";

		for (int i = 0; i < numProductesCompra; i++) {
			if (llista[i] != null) {
				res = res + llista[i].toString();
			}
		}

		return res;
	}

}
