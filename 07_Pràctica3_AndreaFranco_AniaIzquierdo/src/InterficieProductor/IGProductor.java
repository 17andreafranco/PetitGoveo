package InterficieProductor;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.*;

import Productes.LlistaProductes;

public class IGProductor extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextArea missatges = new JTextArea();

	private JPanel panellBotons = new JPanel();
	private JPanel panellBotonsOpcions = new JPanel();

	private JButton b1 = new JButton("Mostrar productes");
	private JButton b2 = new JButton("Modificar Productes");
	private JButton bfGranel = new JButton("Filtre Granel");
	private JButton bfUnitats = new JButton("Filtre Unitats");
	private JButton bfStock = new JButton("Te Stock");
	private JButton bfStock0 = new JButton("No te Stock");
	private JButton bmPreu = new JButton("Modificar Preu");
	private JButton bmStock = new JButton("Modificar Stock");
	private JButton bGuardar = new JButton("Guardar");

	private String NIF = "";
	private String codiProducteIG = "";
	private float preuIG;
	private int stockIG;

	/**
	 * interficie gràfica
	 * 
	 * @param titol
	 * @param llista
	 */
	public IGProductor(String titol, LlistaProductes llista) {
		super(titol);
		identificarNIF(llista);
		this.setLayout(new BorderLayout());
		; // Mida finestra i quan tanca
		this.setSize(1200, 300);
		botons();

		MostrarProductes boto1 = new MostrarProductes(this, llista);
		b1.addActionListener(boto1);

		FiltreUnitatsGranel botofUnitatsGranel = new FiltreUnitatsGranel(this, llista);

		bfUnitats.addActionListener(botofUnitatsGranel);
		bfGranel.addActionListener(botofUnitatsGranel);

		FiltreStock botoStock = new FiltreStock(this, llista);

		bfStock.addActionListener(botoStock);
		bfStock0.addActionListener(botoStock);

		SeleccionarProducte botoProducte = new SeleccionarProducte(this, llista);

		b2.addActionListener(botoProducte);

		ModificarPreuStock botoPreuStock = new ModificarPreuStock(this, llista);

		bmStock.addActionListener(botoPreuStock);
		bmPreu.addActionListener(botoPreuStock);

		Guardar botoGuardar = new Guardar(this, llista);

		bGuardar.addActionListener(botoGuardar);

		missatge();
		botonsOpcions();

		// Forcem la disposició dels objectes continguts en el panell botons();
		this.setVisible(true);
		sortir(llista);
	}

	/**
	 * metode per a sortir del porgrama
	 * 
	 * @param llista
	 */
	public void sortir(LlistaProductes llista) {
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
	 * @throws IOException - obrir i tancar el fitxer
	 */
	public void confirmarSortida(LlistaProductes llista) throws IOException {
		int valor = JOptionPane.showConfirmDialog(this, "Vol guardar?", "Advertencia", JOptionPane.YES_NO_OPTION);
		if (valor == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Gracies per utilitzar l'aplicació, Fins Aviat!", "Gracies",
					JOptionPane.INFORMATION_MESSAGE);
			llista.escriureFitxer();
			System.exit(0);
		}
		if (valor == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "Gracies per utilitzar l'aplicació, Fins Aviat!", "Adeu",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

	/**
	 * getter del NIF
	 * 
	 * @return NIF
	 */
	public String getNIF() {
		return this.NIF;
	}

	/**
	 * getter del codi del producte
	 * 
	 * @return codi del producte
	 */
	public String getCodiProducteIG() {
		return this.codiProducteIG;
	}

	/**
	 * getter del preu
	 * 
	 * @return preu del producte
	 */
	public float getPreuIG() {
		return this.preuIG;
	}

	/**
	 * getter del stock del producte
	 * 
	 * @return stock del producte
	 */
	public int getStockIG() {
		return this.stockIG;
	}

	/**
	 * afegir botons a la interficie
	 */
	public void botons() {

		b1.setBackground(Color.pink);
		b2.setBackground(Color.PINK);
		panellBotons.setLayout(new FlowLayout());
		panellBotons.add(b1);
		panellBotons.add(b2);
		this.add(panellBotons, BorderLayout.NORTH);
	}

	/**
	 * afegir botons
	 */
	public void botonsOpcions() {

		bfUnitats.setBackground(Color.LIGHT_GRAY);
		bfGranel.setBackground(Color.LIGHT_GRAY);
		bfStock.setBackground(Color.LIGHT_GRAY);
		bfStock0.setBackground(Color.LIGHT_GRAY);
		bmStock.setBackground(Color.LIGHT_GRAY);
		bmPreu.setBackground(Color.LIGHT_GRAY);
		bGuardar.setBackground(Color.gray);

		panellBotonsOpcions.setLayout(new FlowLayout());
		panellBotonsOpcions.add(bfUnitats);
		panellBotonsOpcions.add(bfGranel);
		panellBotonsOpcions.add(bfStock);
		panellBotonsOpcions.add(bfStock0);
		panellBotonsOpcions.add(bmStock);
		panellBotonsOpcions.add(bmPreu);
		panellBotonsOpcions.add(bGuardar);

		bfUnitats.setEnabled(false);
		bfGranel.setEnabled(false);
		bfStock.setEnabled(false);
		bfStock0.setEnabled(false);
		bmStock.setEnabled(false);
		bmPreu.setEnabled(false);
		bGuardar.setEnabled(false);

		this.add(panellBotonsOpcions, BorderLayout.SOUTH);
	}

	/**
	 * identificar el NIF del productor
	 * 
	 * @param a
	 */
	public void identificarNIF(LlistaProductes a) {
		this.NIF = JOptionPane.showInputDialog("Indica el NIF de productor:");
		if (NIF == null) {
			System.exit(0);
		} else
			while (!a.hihaProductor(NIF) || NIF.equals("")) {
				if (NIF == null) {
					System.exit(0);
				} else {
					JOptionPane.showMessageDialog(null, "NIF Incorrecte", "ERROR", JOptionPane.ERROR_MESSAGE);
					NIF = JOptionPane.showInputDialog("Indica el NIF de productor:");
				}
			}
	}

	/**
	 * missatge
	 */
	public void missatge() {
		missatges.setEnabled(false);
		add(missatges, BorderLayout.CENTER);

	}

	/**
	 * rebre missatge
	 * 
	 * @param a -llista
	 * @param NIF - nif
	 * @param m - string
	 * @return el missatge
	 */
	public String rebreMissatge(LlistaProductes a, String NIF, String m) {
		return a.llistarProductesProductor(a.deNIFaProductor(NIF));
	}

	/**
	 * escriure missatge
	 * 
	 * @param m -stirng
	 */
	public void escriureMissatge(String m) {
		missatges.append(m);
	}

	/**
	 * activar granel
	 */
	public void activarGranelUnitatStock() {

		bfUnitats.setEnabled(true);
		bfGranel.setEnabled(true);
		bfStock.setEnabled(true);
		bfStock0.setEnabled(true);

	}

	/**
	 * desctivar granel
	 */
	public void desactivarGranelUnitatStock() {

		bfUnitats.setEnabled(false);
		bfGranel.setEnabled(false);
		bfStock.setEnabled(false);
		bfStock0.setEnabled(false);

	}

	/**
	 * activar stock
	 */

	public void activarmStockPreu() {
		bmStock.setEnabled(true);
		bmPreu.setEnabled(true);

	}

	/**
	 * desactivar stock
	 */
	public void desactivarmStockPreu() {
		bmStock.setEnabled(false);
		bmPreu.setEnabled(false);

	}

	/**
	 * activar guardar
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
	 * buidar missatge
	 */
	public void buidarMissatge() {
		missatges.setText("");
	}

	/**
	 * indicar producte
	 * 
	 * @param a
	 */
	public void indicarProducte(LlistaProductes a) {

		this.codiProducteIG = JOptionPane.showInputDialog("Indica el codi del producte:");

		while (codiProducteIG == null || codiProducteIG.equals("") || !a.hihaProducte(codiProducteIG, this.NIF)) {
			JOptionPane.showMessageDialog(null, "No existeix el producte", "ERROR", JOptionPane.ERROR_MESSAGE);
			codiProducteIG = JOptionPane.showInputDialog("Indica el NIF de productor:");

		}

	}

	/**
	 * indicar el preu del producte
	 * 
	 * @param a
	 */
	public void indicarPreu(LlistaProductes a) {

		this.preuIG = Float.parseFloat(JOptionPane.showInputDialog("Indica el nou preu:"));

		while (preuIG < 0) {
			JOptionPane.showMessageDialog(null, "Ha d'introduir un valor vàlid", "ERROR", JOptionPane.ERROR_MESSAGE);
			codiProducteIG = JOptionPane.showInputDialog("Indica el nou preu:");

		}

	}

	/**
	 * indicar l'stock del producte
	 * 
	 * @param a
	 */
	public void indicarStock(LlistaProductes a) {

		this.stockIG = Integer.parseInt(JOptionPane.showInputDialog("Indica el nou stock:"));

		while (stockIG < 0) {
			JOptionPane.showMessageDialog(null, "Ha d'introduir un valor vàlid", "ERROR", JOptionPane.ERROR_MESSAGE);
			codiProducteIG = JOptionPane.showInputDialog("Indica el nou stock:");

		}

	}
}