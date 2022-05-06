package Client;

import java.io.*;
import Productes.Granel;
import Productes.LlistaProductes;
import Productes.Productes;
import Productes.Unitat;

import java.util.*;

import InterficieCompra.IGCompra;
import InterficieProductor.IGProductor;

public class PetitGoveo {

	static Scanner teclat = new Scanner(System.in);

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		LlistaProductes llista = new LlistaProductes(50);
		DadesClient f = new DadesClient(41.2167, 1.2167, 50);
		DadesClient i = new DadesClient();

		llegirFitxer(llista);
		llegirCompraBinari(i);
		// Accedir a la interficie del productor

		//new IGProductor("Petit Goveo Productor",llista);

		// Accedir a la interficie de la compra
		new IGCompra("Petit Goveo Compra", i, llista);

		//mostrarpantalla(llista, f);

	}

	/**
	 * metode per a mostrar per pantalla el menu
	 * 
	 * @param p
	 * @param t
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static void mostrarpantalla(LlistaProductes p, DadesClient t)
			throws FileNotFoundException, IOException, ClassNotFoundException {

		boolean sortir = false;

		while (!sortir) {
			try {
				System.out.println("Benvingut a Petit Goveo! Indica que vol fer:\n\n"
						+ "1. Carregar les dades dels fitxers\n" + "2. Llistar les dades de tots els productes.\n"
						+ "3. Llistar les dades dels productes que són aptes per a celíacs.\n"
						+ "4. Llistar l’oferta de productes d’un determinat productor.\n"
						+ "5. Afegir un nou producte.\n" + "6. Esborrar tots els productes que ofereix un productor.\n"
						+ "7. Modificar les dades d’un producte (preu i/o estoc).\n"
						+ "8. Llistar les compres que hem fet.\n" + "9. Modificar la nostra ubicació.\n"
						+ "10. Consultar els productors i els productes que ofereixen i que estan a una distància menor a la indicada per teclat\n"
						+ "11. Afegir una nova compra d’un producte.\r\n"
						+ "12. Sortir. Permetre sortir guardant la informació de les classes als fitxers o no.");
				int op = teclat.nextInt();

				switch (op) {
				case 1:
					llegirFitxer(p);
					break;
				case 2:
					System.out.println(p.llistarProductes());
					System.out.println(t.toString());
					break;
				case 3:
					System.out.print(p.llistarProductesCeliac());
					break;

				case 4:
					String productor = "";

					System.out.println("Introduiex el productor:");

					productor = teclat.next();

					System.out.println(p.llistarProductesProductor(productor));
					break;

				case 5:

					String nomProducte;
					float preuProducte;
					int stock;
					String NIFProductor;
					String nomProductor;
					double latProductor;
					double longProductor;
					boolean esGranel;
					String codiProducte;

					System.out.println("Introduix el nom del producte:");
					nomProducte = (teclat.next());

					System.out.println("Introdueix el preu unitat:");
					preuProducte = (teclat.nextFloat());

					System.out.println("Introdueix el stock:");
					stock = (teclat.nextInt());

					System.out.println("Introdueix el NIF del productor:");
					NIFProductor = (teclat.next());

					System.out.println("Introdueix el nom del productor:");
					nomProductor = (teclat.next());

					System.out.println("Introdueix la latitud del productor:");
					latProductor = (teclat.nextDouble());

					System.out.println("Introdueix la longitud del productor:");
					longProductor = (teclat.nextDouble());

					System.out.println("Introdueix si el producte es a granel o no: (true/false)");
					esGranel = (teclat.nextBoolean());

					System.out.println("Introdueix el codi del producte:");
					codiProducte = (teclat.next());

					if (esGranel) {
						Productes r = new Granel();

						r.setNomProducte(nomProducte);

						r.setPreuProducte(preuProducte);

						r.setStock(stock);

						r.setNIFProductor(NIFProductor);

						r.setNomProductor(nomProductor);

						r.setLatProductor(latProductor);

						r.setLongProductor(longProductor);

						r.setEsGranel(esGranel);

						r.setCodiProducte(codiProducte);

						System.out.println("Introdueix si el producte es apte per a celiacs o no: (true/false)");
						r.setEsCeliac(teclat.nextBoolean());

						p.afegirProducte(r);
					} else {
						Productes r = new Unitat();

						r.setNomProducte(nomProducte);

						r.setPreuProducte(preuProducte);

						r.setStock(stock);

						r.setNIFProductor(NIFProductor);

						r.setNomProductor(nomProductor);

						r.setLatProductor(latProductor);

						r.setLongProductor(longProductor);

						r.setEsGranel(esGranel);

						r.setCodiProducte(codiProducte);

						System.out.println("Introdueix el preu per pes:");
						r.setPesUnitat(teclat.nextFloat());

						p.afegirProducte(r);

					}

					break;

				case 6:

					String productor1 = "";

					System.out.println("Introdueix el productor que vol borrar:");

					productor1 = teclat.next();

					p.borrarProductor(productor1);

					break;

				case 7:
					String producte = "";

					System.out.println("Introdueix el producte que vol canviar:");

					producte = teclat.next();

					canviarStockPreu(p, producte);

					break;

				case 8:
					System.out.println(t.toString());
					break;
				case 9:
					System.out.println("Introdueix la latitud del client:");
					t.setlatClient(teclat.nextDouble());

					System.out.println("Introdueix la longitud del client:");
					t.setlongClient(teclat.nextDouble());
					break;

				case 10:

					System.out.println("Introdueix la distancia maxima que vol trobar els productes:");
					double distanciaMax = teclat.nextDouble();

					System.out.println(productesMenorDistancia(p, t, distanciaMax));
					break;

				case 11:
					String codiProducte1 = "";
					String data = "";

					System.out.println("Introdueix el codi del producte:");

					codiProducte1 = teclat.next();

					System.out.println("Introdueix el numero d'unitats:");
					int numUnitats = teclat.nextInt();

					System.out.println("Introdueix la data(xx-xx-xxxx):");
					data = teclat.next();

					afegirCompra(t, codiProducte1, p, numUnitats, data);
					
					break;

				case 12:
					String res = "";

					System.out.println("Vol guardar els nous productes i la llista de la compra?(Si/No)");
					res = teclat.next();

					if (res.equalsIgnoreCase("si")) {
						guardarCompraBinari(t);
						escriureFitxer(p);
						System.out.print("Els fitxers s'han guardat correctament. Adeu!");
					} else {
						System.out.print("Adeu!");
					}
					sortir = true;
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Introdueix una opcio correcta");
				teclat.nextInt();
			}
		}

	}

	/**
	 * metode per a llegir el fitxer
	 * 
	 * @param p
	 */
	private static void llegirFitxer(LlistaProductes p) {

		BufferedReader fitxer = null;

		String nomProducte;
		float preuProducte;
		int stock;
		String NIFProductor;
		String nomProductor;
		double latProductor;
		double longProductor;
		boolean esGranel;
		String codiProducte;
		float pesUnitat;
		boolean esCeliac;

		try {
			fitxer = new BufferedReader(new FileReader("ProductesFitxer"));
			String frase = fitxer.readLine();

			while (null != frase) {

				StringTokenizer st = new StringTokenizer(frase, ";");

				nomProducte = st.nextToken();

				preuProducte = Float.parseFloat(st.nextToken());

				stock = Integer.parseInt(st.nextToken());

				NIFProductor = st.nextToken();

				nomProductor = st.nextToken();

				latProductor = Double.parseDouble(st.nextToken());

				longProductor = Double.parseDouble(st.nextToken());

				esGranel = "true".equals(st.nextToken());

				codiProducte = st.nextToken();

				if (esGranel == true) {
					Productes a = new Granel();
					esCeliac = "true".equals(st.nextToken());

					a.setNomProducte(nomProducte);
					a.setPreuProducte(preuProducte);
					a.setStock(stock);
					a.setNIFProductor(NIFProductor);
					a.setNomProductor(nomProductor);
					a.setLatProductor(latProductor);
					a.setLongProductor(longProductor);
					a.setEsGranel(esGranel);
					a.setCodiProducte(codiProducte);

					a.setEsCeliac(esCeliac);
					p.afegirProducte(a);
				} else {
					Productes a = new Unitat();

					pesUnitat = Float.parseFloat(st.nextToken());

					a.setNomProducte(nomProducte);
					a.setPreuProducte(preuProducte);
					a.setStock(stock);
					a.setNIFProductor(NIFProductor);
					a.setNomProductor(nomProductor);
					a.setLatProductor(latProductor);
					a.setLongProductor(longProductor);
					a.setEsGranel(esGranel);
					a.setCodiProducte(codiProducte);

					a.setPesUnitat(pesUnitat);
					p.afegirProducte(a);

				}

				frase = fitxer.readLine();
			}

			fitxer.close();

		} catch (FileNotFoundException e) {
			System.out.println("El fitxer d'entrada no existeix.");

		} catch (IOException e) {
			System.out.println("Error en l'arxiu de sortida de text.");
		}

	}

	/**
	 * m�tode per a escriure al fitxer
	 * 
	 * @param p
	 * @throws IOException
	 */
	private static void escriureFitxer(LlistaProductes p) throws IOException {

		try {
			BufferedWriter fitxer_w = new BufferedWriter(new FileWriter("ProductesFitxer"));
			Productes[] producte = p.getllista();
			boolean primer = false;

			for (int i = 0; i < producte.length; i++) {
				if (producte[i] != null) {
					if (primer) {
						fitxer_w.write("\n");
					}
					primer = true;
					if (producte[i].getEsGranel()) {
						fitxer_w.write(producte[i].getNomProducte() + ";" + producte[i].getPreuProducte() + ";"
								+ producte[i].getStock() + ";" + producte[i].getNIFProductor() + ";"
								+ producte[i].getNomProductor() + ";" + producte[i].getLatProductor() + ";"
								+ producte[i].getLongProductor() + ";" + producte[i].getEsGranel() + ";"
								+ producte[i].getCodiProducte() + ";" + producte[i].getEsCeliac());
					} else {
						fitxer_w.write(producte[i].getNomProducte() + ";" + producte[i].getPreuProducte() + ";"
								+ producte[i].getStock() + ";" + producte[i].getNIFProductor() + ";"
								+ producte[i].getNomProductor() + ";" + producte[i].getLatProductor() + ";"
								+ producte[i].getLongProductor() + ";" + producte[i].getEsGranel() + ";"
								+ producte[i].getCodiProducte() + ";" + producte[i].getPesUnitat());
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
	 * metode per llegir el fitexr serialitzat
	 * 
	 * @param llista
	 */
	private static void llegirCompraBinari(DadesClient llista) {
		try {
			ObjectInputStream compra = new ObjectInputStream(new FileInputStream("Compra.ser"));
			Compra[] t = new Compra[50];

			for (int i = 0; i < t.length; i++) {
				t[i] = (Compra) compra.readObject();
				llista.afegirllistaCompra(t[i]);
			}

			compra.close();
		} catch (IOException e) {
			System.out.println("");
		} catch (ClassNotFoundException e) {
			System.out.println("Error, no es troba la classe Compra." + e);
		} catch (ClassCastException e) {
			System.out.println(
					"Error, el format de l'arxiu no és correcte per la definició actual de la classe Compra." + e);
		}

	}

	/**
	 * metode per a guardar al fiter serialitzat
	 * 
	 * @param a
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	private static void guardarCompraBinari(DadesClient a) throws FileNotFoundException, IOException {
		try {
			ObjectOutputStream compra = new ObjectOutputStream(new FileOutputStream("Compra.ser"));
			Compra[] llista = a.getLlista();

			for (int i = 0; i < llista.length; i++) {
				if (llista[i] != null) {
					compra.writeObject(llista[i]);
				}

			}

			compra.close();

		} catch (FileNotFoundException e) {
			System.out.println("El fitxer d'entrada no existeix");
		} catch (IOException e) {
			System.out.println("Error fitxer de sortida binari");
		}
	}

	/**
	 * metode per a modificar les dades del stock i preu
	 * 
	 * @param a
	 * @param producte
	 */
	private static void canviarStockPreu(LlistaProductes a, String producte) {

		int op, stock;
		float preu;
		boolean sortir = false;

		while (!sortir) {
			try {
				System.out.println("1.Canviar preu\n2.Canviar stock\n3.Canviar stock i preu");
				op = teclat.nextInt();

				switch (op) {
				case 1:
					System.out.println("Indica el nou preu");
					preu = teclat.nextFloat();
					a.modificarPreu(producte, preu);
					sortir = true;
					break;
				case 2:
					System.out.println("Indica el nou stock");
					stock = teclat.nextInt();
					a.modificarStock(producte, stock);
					sortir = true;

					break;
				case 3:
					System.out.println("Indica el nou preu");
					preu = teclat.nextFloat();

					System.out.println("Indica el nou stock");
					stock = teclat.nextInt();

					a.modificarPreu(producte, preu);
					a.modificarStock(producte, stock);
					sortir = true;
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println("Introdueix una opcio correcte");
				teclat.nextInt();
			}

		}
	}

	/**
	 * metode per a calcular la distancia
	 * 
	 * @param a
	 * @param b
	 * @return la distancia
	 */

	private static double distancia(Productes a, DadesClient b) {

		double latProducte = a.getLatProductor() * Math.PI / 180;
		double longProducte = a.getLongProductor() * Math.PI / 180;

		double latClient = b.getlatClient() * Math.PI / 180;
		double longClient = b.getlongClient() * Math.PI / 180;

		double dlong = longClient - longProducte;
		double dlat = latClient - latProducte;

		double p = (Math.sin(dlat / 2) * Math.sin(dlat / 2))
				+ Math.cos(latProducte) * Math.cos(latClient) * ((Math.sin(dlong / 2) * Math.sin(dlong / 2)));

		double c = 6378.137 * 2 * Math.atan2(Math.sqrt(p), Math.sqrt(1 - p));

		return c;

	}

	/**
	 * metode que et diu quins productes estan a menor distancia
	 * 
	 * @param llista
	 * @param b
	 * @param distanciaMax
	 * @return string
	 */

	private static String productesMenorDistancia(LlistaProductes llista, DadesClient b, double distanciaMax) {

		Productes[] productes = llista.getllista();
		String res = "";
		boolean primer = false;

		for (int i = 0; i < llista.getnumProductes(); i++) {
			if (distancia(productes[i], b) < distanciaMax) {
				if (primer) { // Cuidado amb l'ultim salt de linea, ara és primer
					res = res + "\n";
				}
				res = res + productes[i].toString();
				primer = true;
			}
		}

		return res;

	}

	/**
	 * m�tode per afegir compres
	 * 
	 * @param a
	 * @param codiProducte
	 * @param llista
	 * @param numUnitats
	 * @param data
	 * @return boolea
	 */

	private static boolean afegirCompra(DadesClient a,String codiProducte, LlistaProductes llista, int numUnitats,
			String data) {

		Productes[] productes = llista.getllista();

		for (int i = 0; i < productes.length; i++) {
			if (codiProducte.equalsIgnoreCase(productes[i].getCodiProducte())) {
				if (productes[i].getStock() >= numUnitats) {

					double preuTotal = numUnitats * productes[i].getPreuProducte();

					llista.modificarStock(productes[i].getNomProducte(), (productes[i].getStock() - numUnitats));

					Compra c = new Compra(codiProducte, numUnitats, data, preuTotal);

					a.afegirllistaCompra(c);
					return true;
				}
			}
		}
		return false;
	}

}
