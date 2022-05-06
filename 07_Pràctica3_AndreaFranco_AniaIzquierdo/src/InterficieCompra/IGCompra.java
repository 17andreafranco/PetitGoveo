package InterficieCompra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Client.Compra;
import Client.DadesClient;
import Productes.LlistaProductes;
import Productes.Productes;

public class IGCompra extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextArea missatges = new JTextArea();

	private JPanel panellBotonsOpcions = new JPanel();

	private JButton bLatLong = new JButton("Modificar localitzacio");
	private JButton bfProductor = new JButton("Filtre productor");
	private JButton bfGranel = new JButton("Filtrar granel");
	private JButton bCompra = new JButton("Fer compra");
	private JButton bGuardar = new JButton("Guardar");

	private double longitud;
	private double lat;
	private String nomProductorIG;
	private float pesMin;
	private float pesMax;

	/**
	 * interficie gràfica de la compra
	 * 
	 * @param titol
	 * @param llista
	 * @param productes
	 */
	public IGCompra(String titol, DadesClient llista, LlistaProductes productes) {
		super(titol);
		this.setLayout(new BorderLayout());// Mida finestra i quan tanca
		this.setSize(1000, 300);
		identificarLongILat(llista);
		botonsOpcions();

		escriureMissatge(llista.toString());

		ModificarLatILong boto1 = new ModificarLatILong(this, llista);
		bLatLong.addActionListener(boto1);

		FiltreProductorStock botoPS = new FiltreProductorStock(this, llista, productes);
		bfProductor.addActionListener(botoPS);
		bfGranel.addActionListener(botoPS);

		FerCompra botoCompra = new FerCompra(this, llista, productes);
		bCompra.addActionListener(botoCompra);

		Guardar botoGuardar = new Guardar(this, llista);
		bGuardar.addActionListener(botoGuardar);

		missatge();
		botonsOpcions();
		sortir(llista);
		this.setVisible(true);
	}

	/**
	 * generem els botons
	 */
	public void botonsOpcions() {

		bLatLong.setBackground(Color.orange);
		bfGranel.setBackground(Color.orange);
		bfProductor.setBackground(Color.orange);
		bCompra.setBackground(Color.orange);
		bGuardar.setBackground(Color.orange);

		panellBotonsOpcions.setLayout(new FlowLayout());
		panellBotonsOpcions.add(bLatLong);
		panellBotonsOpcions.add(bfProductor);
		panellBotonsOpcions.add(bfGranel);
		panellBotonsOpcions.add(bCompra);
		panellBotonsOpcions.add(bGuardar);

		bGuardar.setEnabled(false);

		this.add(panellBotonsOpcions, BorderLayout.SOUTH);
	}

	/**
	 * getter de la longitud
	 * 
	 * @return longitud
	 */
	public double getLongitud() {
		return longitud;
	}

	/**
	 * setter de la longitud
	 * 
	 * @param longitud
	 */
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	/**
	 * getter de la latitud
	 * 
	 * @return latitud
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * setter de la latitud
	 * 
	 * @param lat
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * getter del pes minim
	 * 
	 * @return pes minim
	 */
	public float getPesMin() {
		return pesMin;
	}

	/**
	 * setter del pes minim
	 * 
	 * @param pesMin
	 */
	public void setPesMin(float pesMin) {
		this.pesMin = pesMin;
	}

	/**
	 * getter del pes maxim
	 * 
	 * @return
	 */
	public float getPesMax() {
		return pesMax;
	}

	/**
	 * setter del pes maxim
	 * 
	 * @param pesMax
	 */
	public void setPesMax(float pesMax) {
		this.pesMax = pesMax;
	}

	/**
	 * getter del nom del productor
	 * 
	 * @return nom del productor
	 */
	public String getNomProductorIG() {
		return nomProductorIG;
	}

	/**
	 * stter del nom del productor
	 * 
	 * @param nomProductorIG
	 */
	public void setNomProductorIG(String nomProductorIG) {
		this.nomProductorIG = nomProductorIG;
	}

	/**
	 * missatge
	 */
	public void missatge() {
		missatges.setEnabled(false);
		add(missatges, BorderLayout.CENTER);

	}

	/**
	 * escriure el missatge
	 * 
	 * @param m
	 */

	public void escriureMissatge(String m) {
		missatges.append(m);
	}

	/**
	 * buidar missatge
	 */
	public void buidarMissatge() {
		missatges.setText("");
	}

	/**
	 * activar guatrdar
	 */
	public void activarGuardar() {
		bGuardar.setEnabled(true);

	}

	/**
	 * desactivar guardar
	 */
	public void desactivarGuardar() {
		bGuardar.setEnabled(false);

	}

	/**
	 * sortir
	 * 
	 * @param llista
	 */
	public void sortir(DadesClient llista) {
		try {
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					try {
						confirmarSortida(llista);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * Confirmar sortida del programa per a guardar.
	 * 
	 * @throws IOException
	 */
	public void confirmarSortida(DadesClient llista) throws IOException {
		int valor = JOptionPane.showConfirmDialog(this, "Vol guardar?", "Advertencia", JOptionPane.YES_NO_OPTION);
		if (valor == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Gracies per utilitzar l'aplicació, Fins Aviat!", "Gracies",
					JOptionPane.INFORMATION_MESSAGE);
			guardarCompraBinari(llista);
			System.exit(0);
		}
		if (valor == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "Gracies per utilitzar l'aplicació, Fins Aviat!", "Adeu",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

	/**
	 * identidicar la longitud i la latitud
	 * 
	 * @param a
	 */
	public void identificarLongILat(DadesClient a) {
		try {
		this.lat = Double.parseDouble(JOptionPane.showInputDialog("Indica la latitud:"));
		a.setlatClient(lat);
	}catch(NumberFormatException e) {
		JOptionPane.showMessageDialog(null, "Has d'introduir un valor correcte", "ERROR", JOptionPane.ERROR_MESSAGE);
		this.lat = Double.parseDouble(JOptionPane.showInputDialog("Indica la latitud:"));
		a.setlatClient(lat);
	}try {
		this.longitud = Double.parseDouble(JOptionPane.showInputDialog("Indica la longitud:"));
		a.setlongClient(longitud);
	}catch(NumberFormatException e){
		JOptionPane.showMessageDialog(null, "Has d'introduir un valor correcte", "ERROR", JOptionPane.ERROR_MESSAGE);
		this.longitud = Double.parseDouble(JOptionPane.showInputDialog("Indica la longitud:"));
		a.setlongClient(longitud);
	}
		}

	/**
	 * indicar el productor
	 * 
	 * @param llista
	 * @param productes
	 */
	public void indicarProductor(DadesClient llista, LlistaProductes productes) {

		this.nomProductorIG = JOptionPane.showInputDialog("Indica el nom del productor:");
		while (nomProductorIG.equals("") || !hihaProductorCompra(llista, productes, nomProductorIG)) {
			if (nomProductorIG == null) {
				System.exit(0);
			} else {
				JOptionPane.showMessageDialog(null, "No existeix el productor", "ERROR", JOptionPane.ERROR_MESSAGE);
				nomProductorIG = JOptionPane.showInputDialog("Indica nom del productor");
			}
		}

	}

	/**
	 * indicar els quilograms
	 */
	public void indicarQuilos() {

		this.pesMin = Float.parseFloat(JOptionPane.showInputDialog("Indica el pes minim:"));
		this.pesMax = Float.parseFloat(JOptionPane.showInputDialog("Indica el pes maxim:"));

		while (pesMin > pesMax) {
			JOptionPane.showMessageDialog(null, "Indiqui be les dades", "ERROR", JOptionPane.ERROR_MESSAGE);
			pesMin = Float.parseFloat(JOptionPane.showInputDialog("Indica el pes minim:"));
			pesMax = Float.parseFloat(JOptionPane.showInputDialog("Indica el pes maxim:"));
		}

	}

	/**
	 * productes del productor
	 * 
	 * @param client
	 * @param productes
	 * @param productor
	 * @return string
	 */
	public String productesProductorCompra(DadesClient client, LlistaProductes productes, String productor) {
		String res = "";
		Compra[] compra = client.getLlista();
		Productes[] producte = productes.getllista();
		for (int i = 0; i < compra.length; i++) {
			if (compra[i] != null) {
				for (int j = 0; j < producte.length; j++) {
					if (producte[j] != null) {
						if (compra[i].getCodiProducte().equals(producte[j].getCodiProducte())
								&& productor.equalsIgnoreCase(producte[j].getNomProductor())) {
							res = res + compra[i].toString();

						}
					}

				}
			}
		}
		return res;
	}

	/**
	 * meotde que et diu si esta el productor
	 * 
	 * @param client
	 * @param productes
	 * @param productor
	 * @return si esta o no
	 */
	public boolean hihaProductorCompra(DadesClient client, LlistaProductes productes, String productor) {

		Compra[] compra = client.getLlista();
		Productes[] producte = productes.getllista();

		for (int i = 0; i < compra.length; i++) {
			if (compra[i] != null) {
				for (int j = 0; j < producte.length; j++) {
					if (producte[j] != null) {
						if (compra[i].getCodiProducte().equals(producte[j].getCodiProducte())
								&& productor.equalsIgnoreCase(producte[j].getNomProductor())) {
							return true;

						}
					}

				}
			}
		}
		return false;
	}

	/**
	 * meotde que et pregunta si vols recuperar la compra i la recupera o no
	 * 
	 * @param llista
	 * @param productes
	 */
	public void preguntarCompra(DadesClient llista, LlistaProductes productes) {
		int compra = JOptionPane.showConfirmDialog(this, "Vols recuperar la compra?", "Recuperar Compra",
				JOptionPane.YES_NO_OPTION);
		boolean preguntar = true;

		if (compra == JOptionPane.YES_OPTION) {
			canviarUnitat(llista, productes);

			while (preguntar) {
				preguntar = preguntarSeguirCompra(llista, productes);
			}

		}
		if (compra == JOptionPane.NO_OPTION) {
			DadesClient llistaNova = new DadesClient(this.lat, this.longitud, 50);

			realitzarCompra(llistaNova, productes);
			while (preguntar) {
				preguntar = preguntarSeguirCompra(llistaNova, productes);
			}
			llista.setLlista(llistaNova.getLlista());
		}
	}

	/**
	 * metode que et pregnta si vols seguir amb la compra o no
	 * 
	 * @param llista
	 * @param productes
	 * @return si o no
	 */
	public boolean preguntarSeguirCompra(DadesClient llista, LlistaProductes productes) {

		boolean res = false;

		int compra = JOptionPane.showConfirmDialog(this, "Vols seguir realitzant la compra?", "Recuperar Compra",
				JOptionPane.YES_NO_OPTION);

		if (compra == JOptionPane.YES_OPTION) {
			realitzarCompra(llista, productes);
			res = true;
		}
		if (compra == JOptionPane.NO_OPTION) {
			res = false;
			this.setVisible(true);
		}
		return res;
	}

	/**
	 * metode per a canviar les unitats
	 * 
	 * @param llista
	 * @param productes
	 */
	public void canviarUnitat(DadesClient llista, LlistaProductes productes) {

		Compra[] compres = llista.getLlista();

		for (int i = 0; i < compres.length; i++) {
			if (compres[i] != null) {
				int numUnitats = Integer.parseInt(JOptionPane
						.showInputDialog("Indica el numero de unitats de " + compres[i].getCodiProducte() + ":"));

				while (numUnitats <= 0) {
					JOptionPane.showMessageDialog(null, "Indiqui be les dades", "ERROR", JOptionPane.ERROR_MESSAGE);
					numUnitats = Integer.parseInt(JOptionPane
							.showInputDialog("Indica el numero de unitats de " + compres[i].getCodiProducte() + ":"));
				}
				compres[i].setNumUnitats(numUnitats);
			}
		}
	}

	/**
	 * mètode per a realitzar una compra
	 * 
	 * @param llista
	 * @param productes
	 */

	public void realitzarCompra(DadesClient llista, LlistaProductes productes) {

		String codiProducte = JOptionPane.showInputDialog("Indica el codi del producte:");

		while (codiProducte == null || codiProducte.equals("") || !productes.hihaCodi(codiProducte)) {

			JOptionPane.showMessageDialog(null, "Indiqui be les dades", "ERROR", JOptionPane.ERROR_MESSAGE);
			codiProducte = (JOptionPane.showInputDialog("Indica el codi del producte:"));

		}

		int numUnitats = Integer.parseInt(JOptionPane.showInputDialog("Indica el numero de unitats:"));

		while (numUnitats <= 0) {
			JOptionPane.showMessageDialog(null, "Indiqui be les dades", "ERROR", JOptionPane.ERROR_MESSAGE);
			numUnitats = Integer.parseInt(JOptionPane.showInputDialog("Indica el numero de unitats de:"));
		}

		String data = JOptionPane.showInputDialog("Indica el la data (xx-xx-xxxx):");

		while (data == null || data.equals("")) {
			JOptionPane.showMessageDialog(null, "Indiqui be les dades", "ERROR", JOptionPane.ERROR_MESSAGE);
			numUnitats = Integer.parseInt(JOptionPane.showInputDialog("Indica el numero de unitats de:"));
		}

		afegirCompra(llista, codiProducte, productes, numUnitats, data);

	}

	/**
	 * mètode per afegir una compra
	 * 
	 * @param a
	 * @param codiProducte
	 * @param llista
	 * @param numUnitats
	 * @param data
	 * @return boolea
	 */
	public boolean afegirCompra(DadesClient a, String codiProducte, LlistaProductes llista, int numUnitats,
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

	/**
	 * mpetode per a guardar la compra
	 * 
	 * @param a
	 */
	public void guardarCompraBinari(DadesClient a) {
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

}
