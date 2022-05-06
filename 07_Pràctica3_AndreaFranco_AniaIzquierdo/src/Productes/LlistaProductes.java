package Productes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class LlistaProductes {

	private Productes[] llista;
	private int numProductes;

	/**
	 * mètode constructor
	 * 
	 * @param dim
	 */
	public LlistaProductes(int dim) {
		llista = new Productes[dim];
		numProductes = 0;
	}

	/**
	 * getter del numero de productes
	 * 
	 * @return numero de productes
	 */

	public int getnumProductes() {
		return this.numProductes;
	}

	/**
	 * getter de la llista
	 * 
	 * @return llista
	 */
	public Productes[] getllista() {
		return this.llista;
	}

	/**
	 * metode per afegir un producte
	 * 
	 * @param a
	 * @return boolea
	 */
	public boolean afegirProducte(Productes a) {

		for (int i = 0; i < llista.length; i++) {
			if (llista[i] == null) {

				llista[i] = a;
				this.numProductes++;
				return true;
			}
		}
		return false;
	}

	/**
	 * mètode per escriure a un fitxer
	 * 
	 * @throws IOException
	 */
	public void escriureFitxer() throws IOException {

		try {
			BufferedWriter fitxer_w = new BufferedWriter(new FileWriter("ProductesFitxer"));
			boolean primer = false;

			for (int i = 0; i < llista.length; i++) {
				if (llista[i] != null) {
					if (primer) {
						fitxer_w.write("\n");
					}
					primer = true;
					if (llista[i].getEsGranel()) {
						fitxer_w.write(llista[i].getNomProducte() + ";" + llista[i].getPreuProducte() + ";"
								+ llista[i].getStock() + ";" + llista[i].getNIFProductor() + ";"
								+ llista[i].getNomProductor() + ";" + llista[i].getLatProductor() + ";"
								+ llista[i].getLongProductor() + ";" + llista[i].getEsGranel() + ";"
								+ llista[i].getCodiProducte() + ";" + llista[i].getEsCeliac());
					} else {
						fitxer_w.write(llista[i].getNomProducte() + ";" + llista[i].getPreuProducte() + ";"
								+ llista[i].getStock() + ";" + llista[i].getNIFProductor() + ";"
								+ llista[i].getNomProductor() + ";" + llista[i].getLatProductor() + ";"
								+ llista[i].getLongProductor() + ";" + llista[i].getEsGranel() + ";"
								+ llista[i].getCodiProducte() + ";" + llista[i].getPesUnitat());
					}

				}
			}
			fitxer_w.close();

		} catch (FileNotFoundException e) {
			System.out.println("El fitxer d'entrada no existeix.");

		} catch (IOException e) {
			System.out.println("Error en l'arxiu de sortida.");
		}
	}

	/**
	 * mètode per a llistar els productees
	 * 
	 * @return string
	 */
	public String llistarProductes() {

		String res = "";
		for (int i = 0; i < llista.length; i++) {
			if (llista[i] != null) {
				res = res + llista[i].toString() + "\n";
			}
		}

		return res;
	}

	/**
	 * llista de productes aptes per a celiacs
	 * 
	 * @return string
	 */
	public String llistarProductesCeliac() {

		String res = "";

		for (int i = 0; i < llista.length; i++) {
			if (llista[i] != null) {
				if (llista[i].getEsCeliac()) {
					res = res + llista[i].toString() + "\n";
				}
			}
		}

		return res;

	}

	/**
	 * llista de prodcutes del productor
	 * 
	 * @param productor
	 * @return string
	 */
	public String llistarProductesProductor(String productor) {

		String res = "";

		for (int i = 0; i < llista.length; i++) {
			if (llista[i] != null) {
				if (llista[i].getNomProductor().equalsIgnoreCase(productor)) {

					res = res + llista[i].toString() + "\n";
				}
			}
		}

		return res;
	}

	/**
	 * llista productes del productor a granel
	 * 
	 * @param productor
	 * @param granel
	 * @return string
	 */
	public String llistarProductesProductorGranel(String productor, boolean granel) {

		String res = "";

		for (int i = 0; i < llista.length; i++) {
			if (llista[i] != null) {
				if (llista[i].getNomProductor().equalsIgnoreCase(productor) && (llista[i].getEsGranel()) && (granel)) {

					res = res + llista[i].toString() + "\n";
				} else if (llista[i].getNomProductor().equalsIgnoreCase(productor) && (!llista[i].getEsGranel())
						&& (!granel)) {
					res = res + llista[i].toString() + "\n";
				}
			}
		}

		return res;
	}

	/**
	 * llista de producte en stock
	 * 
	 * @param productor
	 * @param teStock
	 * @return string
	 */
	public String llistarProductesStock(String productor, boolean teStock) {

		String res = "";

		for (int i = 0; i < llista.length; i++) {
			if (llista[i] != null) {
				if (llista[i].getNomProductor().equalsIgnoreCase(productor) && (llista[i].getStock() > 0)
						&& (teStock)) {
					res = res + llista[i].toString() + "\n";

				} else if (llista[i].getNomProductor().equalsIgnoreCase(productor) && (llista[i].getStock() == 0)
						&& (!teStock)) {
					res = res + llista[i].toString() + "\n";
				}
			}
		}

		return res;
	}
	/**
	 * metode per a comprovar si esta el codi del producte està a la llista
	 * @param codiProducte
	 * @return si hi es o no (booleà)
	 */
	public boolean hihaCodi(String codiProducte) {

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
	 * llista de productes pel codi
	 * 
	 * @param codiProducte
	 * @param NIF
	 * @return string
	 */
	public String llistarProductaCodi(String codiProducte, String NIF) {

		String res = "";

		for (int i = 0; i < llista.length; i++) {
			if (llista[i] != null) {
				if (llista[i].getCodiProducte().equalsIgnoreCase(codiProducte)
						&& llista[i].getNIFProductor().equalsIgnoreCase(NIF)) {
					res = res + llista[i].toString() + "\n";
				}
			}
		}

		return res;
	}

	/**
	 * saber si esta el productor a la llista o no
	 * 
	 * @param productor
	 * @return boolea
	 */
	public boolean hihaProductor(String productor) {

		for (int i = 0; i < llista.length; i++) {
			if (llista[i] != null) {
				if (llista[i].getNIFProductor().equalsIgnoreCase(productor)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * saber si esta el producte
	 * 
	 * @param codiProducte
	 * @param NIF
	 * @return boolea
	 */
	public boolean hihaProducte(String codiProducte, String NIF) {

		for (int i = 0; i < llista.length; i++) {
			if (llista[i] != null) {
				if (llista[i].getCodiProducte().equalsIgnoreCase(codiProducte)
						&& llista[i].getNIFProductor().equalsIgnoreCase(NIF)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * saber a quin NIF correspon a cada productor
	 * 
	 * @param NIF
	 * @return string
	 */
	public String deNIFaProductor(String NIF) {

		String res = "";
		for (int i = 0; i < llista.length; i++) {
			if (llista[i] != null) {
				if (llista[i].getNIFProductor().equalsIgnoreCase(NIF)) {
					return llista[i].getNomProductor();
				}
			}
		}
		return res;
	}

	/**
	 * saber quin codi pertany cada producte
	 * 
	 * @param codiProducte
	 * @return string
	 */
	public String deCodiaNomProducte(String codiProducte) {

		String res = "";
		for (int i = 0; i < llista.length; i++) {
			if (llista[i] != null) {
				if (llista[i].getCodiProducte().equalsIgnoreCase(codiProducte)) {
					return llista[i].getNomProducte();
				}
			}
		}
		return res;
	}

	/**
	 * per a borrar la llista
	 * 
	 * @param a
	 * @return boolea
	 */
	public boolean borrarLlista(Productes a) {

		for (int i = 0; i < llista.length; i++) {
			if ((llista[i] != null) && (llista[i] == a)) {

				llista[i] = null;
				numProductes--;
				return true;
			}
		}
		return false;
	}

	/**
	 * borrar productor
	 * 
	 * @param a
	 */
	public void borrarProductor(String a) {

		for (int i = 0; i < llista.length; i++) {// ??
			if ((llista[i] != null) && (llista[i].getNomProductor().equalsIgnoreCase(a))) {
				llista[i] = null;
				numProductes--;
			}
		}
	}

	/**
	 * modificar stock
	 * 
	 * @param a
	 * @param stock
	 */
	public void modificarStock(String a, int stock) {

		for (int i = 0; i < llista.length; i++) {
			if ((llista[i] != null) && (llista[i].getNomProducte().equalsIgnoreCase(a))) {
				llista[i].setStock(stock);
			}
		}
	}

	/**
	 * modificar el preu
	 * 
	 * @param a
	 * @param preuProducte
	 */
	public void modificarPreu(String a, float preuProducte) {

		for (int i = 0; i < llista.length; i++) {
			if ((llista[i] != null) && (llista[i].getNomProducte().equalsIgnoreCase(a))) {
				llista[i].setPreuProducte(preuProducte);
			}
		}
	}

}
