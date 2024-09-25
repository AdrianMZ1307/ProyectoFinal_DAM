package view;

import java.io.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.help.*;
import javax.swing.*;

import model.*;
import controller.*;

import java.net.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import java.awt.*;

public class MenuPrincipal {

	private JFrame frmMenuPrincipal;
	private static JTable tbPeliculas;
	private JTextField txtFiltro;
	private JMenuItem mnItAyuda;
	private HelpSet helpset = null;
	private HelpBroker browser = null;
	private ResourceBundle rb;
	public static Locale language;
	private static Properties properties = new Properties();
	private static File file = new File("./src/data/default.properties");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frmMenuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();

		language = new Locale("es", "ES");
		try {

			URL helpURL = this.getClass().getResource("/help/help.hs");

			helpset = new HelpSet(null, helpURL);
			browser = helpset.createHelpBroker();
			browser.enableHelpOnButton(mnItAyuda, "principal", helpset);
			browser.enableHelpKey(frmMenuPrincipal.getContentPane(), "principal", helpset);

		} catch (HelpSetException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuPrincipal = new JFrame();
		frmMenuPrincipal.setIconImage(
				Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/assets/icons/user.png")));
		frmMenuPrincipal.setTitle("Menu Principal | Adrian Muriel Zamora | DAM 2");
		frmMenuPrincipal.setBounds(100, 100, 450, 300);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmMenuPrincipal.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mnItReconectar = new JMenuItem("Reconectar");
		mnItReconectar.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/assets/icons/reload.png")));
		mnArchivo.add(mnItReconectar);

		JMenuItem mnItSalir = new JMenuItem("Cerrar");
		mnItSalir.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/assets/icons/exit.png")));
		mnArchivo.add(mnItSalir);

		JMenu mnConfiguracion = new JMenu("Configuracion");
		menuBar.add(mnConfiguracion);

		JMenuItem mnItConexion = new JMenuItem("Conexion");
		mnItConexion.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/assets/icons/connection.png")));
		mnConfiguracion.add(mnItConexion);

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		mnItAyuda = new JMenuItem("Ver Ayuda");
		mnAyuda.add(mnItAyuda);

		JMenu mnIdioma = new JMenu("Idioma");
		mnAyuda.add(mnIdioma);

		JMenuItem mnItSpanish = new JMenuItem("Espa\u00F1ol");
		mnIdioma.add(mnItSpanish);

		JMenuItem mnItEnglish = new JMenuItem("Ingles");
		mnIdioma.add(mnItEnglish);

		JMenuItem mnItGallego = new JMenuItem("Gallego");
		mnIdioma.add(mnItGallego);

		JMenuItem mnItItaliano = new JMenuItem("Italiano");
		mnIdioma.add(mnItItaliano);

		JMenuItem mnItBDName = new JMenuItem("BD: <NOMBRE DE LA BD>");
		mnAyuda.add(mnItBDName);
		frmMenuPrincipal.getContentPane().setLayout(new BorderLayout(0, 0));
		Panel filterPane = new Panel();
		frmMenuPrincipal.getContentPane().add(filterPane, BorderLayout.NORTH);
		Panel filmPane = new Panel();
		frmMenuPrincipal.getContentPane().add(filmPane, BorderLayout.SOUTH);

		JScrollPane scPeliculas = new JScrollPane();
		scPeliculas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		frmMenuPrincipal.getContentPane().add(scPeliculas, BorderLayout.CENTER);

		tbPeliculas = new JTable();
		tbPeliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbPeliculas.setEnabled(true);
		scPeliculas.setViewportView(tbPeliculas);
		tbPeliculas.setAutoCreateRowSorter(true);
		filterPane.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblFiltro = new JLabel();
		lblFiltro.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltro.setText("Titulo de la Pelicula");
		filterPane.add(lblFiltro);

		txtFiltro = new JTextField();
		filterPane.add(txtFiltro);
		txtFiltro.setColumns(10);

		JButton btnFiltro = new JButton("Buscar");
		filterPane.add(btnFiltro);

		JButton btnVer = new JButton("VER DATOS");
		btnVer.setEnabled(false);
		filmPane.add(btnVer);

		// METODOS
		// --------------------------------------------------------------------------------------------------------
		// ----- TRADUCIR
		// Traduce la Aplicación
		mnItSpanish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					language = new Locale("es", "ES");
					properties.setProperty("LANG", String.valueOf(language));
					FileOutputStream fileOS = new FileOutputStream(file);
					properties.store(fileOS, null);
					fileOS.close();
					Locale.setDefault(language);
					traducir(mnAyuda, mnArchivo, mnConfiguracion, mnItReconectar, mnItSalir, mnItConexion, mnItAyuda,
							mnIdioma, mnItSpanish, mnItEnglish, mnItGallego, mnItItaliano, lblFiltro, btnFiltro,
							btnVer);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		mnItEnglish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					language = new Locale("en", "US");
					properties.setProperty("LANG", String.valueOf(language));
					FileOutputStream fileOS = new FileOutputStream(file);
					properties.store(fileOS, null);
					fileOS.close();
					Locale.setDefault(language);
					traducir(mnAyuda, mnArchivo, mnConfiguracion, mnItReconectar, mnItSalir, mnItConexion, mnItAyuda,
							mnIdioma, mnItSpanish, mnItEnglish, mnItGallego, mnItItaliano, lblFiltro, btnFiltro,
							btnVer);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnItGallego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					language = new Locale("gl", "ES");
					properties.setProperty("LANG", String.valueOf(language));
					FileOutputStream fileOS;
					fileOS = new FileOutputStream(file);
					properties.store(fileOS, null);
					fileOS.close();
					Locale.setDefault(language);
					traducir(mnAyuda, mnArchivo, mnConfiguracion, mnItReconectar, mnItSalir, mnItConexion, mnItAyuda,
							mnIdioma, mnItSpanish, mnItEnglish, mnItGallego, mnItItaliano, lblFiltro, btnFiltro,
							btnVer);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnItItaliano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					language = new Locale("it", "IT");
					properties.setProperty("LANG", String.valueOf(language));
					FileOutputStream fileOS = new FileOutputStream(file);
					properties.store(fileOS, null);
					fileOS.close();
					Locale.setDefault(language);
					traducir(mnAyuda, mnArchivo, mnConfiguracion, mnItReconectar, mnItSalir, mnItConexion, mnItAyuda,
							mnIdioma, mnItSpanish, mnItEnglish, mnItGallego, mnItItaliano, lblFiltro, btnFiltro,
							btnVer);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		// --------------------------------------------------------------------------------------------------------
		// ----- MENU
		// Barra Superior de Menu de la Aplicación
		// --------------------------------------------------------------------------------------------------------
		// ------- RECONECTAR CON LA BASE DE DATOS
		// Botón encargado de realizar una reconexión con la base de datos
		// --------------------------------------------------------------------------------------------------------
		mnItReconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (gestionarConexion.getConexion() != null) {
						gestionarConexion.cerrarConexion();
					}
					gestionarConexion.conectar();
					cargarNombreBD(mnItBDName);
					cargarTabla();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error al reconectar con la base de datos", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		// ------- SALIR
		// Botón para cerrar de forma segura la Aplicación
		// --------------------------------------------------------------------------------------------------------
		mnItSalir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres salir?", "ADVERTENCIA",
						JOptionPane.WARNING_MESSAGE);
				if (opcion == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		// ------- CONEXIÓN
		// Botón para abrir el Menu de configuración de la conexión con la Base de Datos
		// --------------------------------------------------------------------------------------------------------
		mnItConexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuConfigurarConexion ventana = new MenuConfigurarConexion();
				ventana.show();
			}
		});

		// ----- VENTANA
		// --------------------------------------------------------------------------------------------------------
		frmMenuPrincipal.addWindowListener(new WindowAdapter() {
			// ------- ABRIR
			// ----------------------------------------------------------------------------------------------------
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					properties.load(new FileInputStream(file));
					String lang[] = String.valueOf(properties.get("LANG")).split("_");
					language = new Locale(lang[0], lang[1]);
					Locale.setDefault(language);
					traducir(mnAyuda, mnArchivo, mnConfiguracion, mnItReconectar, mnItSalir, mnItConexion, mnItAyuda,
							mnIdioma, mnItSpanish, mnItEnglish, mnItGallego, mnItItaliano, lblFiltro, btnFiltro,
							btnVer);

					gestionarConexion.conectar();
					if (gestionarPeliculas.listarPeliculas().isEmpty()) {
						gestionarPeliculas.generarPeliculas();
					}
					cargarNombreBD(mnItBDName);
					cargarTabla();
				} catch (SQLException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}

			// ------- CERRAR
			// ----------------------------------------------------------------------------------------------------
			@Override
			public void windowClosing(WindowEvent e) {
				gestionarConexion.cerrarConexion();
			}
		});

		// ----- BOTONES
		// --------------------------------------------------------------------------------------------------------
		// ------- RATÓN ENTRA
		// Cuando el ratón entra al area del botón "Ver" se activará si hay una película
		// seleccionada
		// ----------------------------------------------------------------------------------------------------
		btnVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (tbPeliculas.getSelectedColumn() != -1) {
					btnVer.setEnabled(true);
				} else {
					btnVer.setEnabled(false);
				}
			}
		});

		// ------- FILTRAR TABLA
		// Botón encargado de filtrar las peliculas de la tabla cuyo titulo comienze
		// como el texto indicado por el usuario
		// ----------------------------------------------------------------------------------------------------
		btnFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTablaFiltrada(txtFiltro.getText());
			}
		});

		// ------- VER DATOS DE LA PELICULA
		// Botón que abrira un dialogo emergente con información de la pelicula
		// seleccionada en la tabla
		// para poder editar la misma
		// ----------------------------------------------------------------------------------------------------
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tbPeliculas.getSelectedRow() != -1) {
					pelicula p = gestionarPeliculas.listarPeliculas().get(tbPeliculas.getSelectedRow());
					MenuEditarPelicula.main(null, p);
				}
			}
		});
	}

	// ----- METODOS
	// --------------------------------------------------------------------------------------------------------
	// ------- FILTRAR LA TABLA
	// --------------------------------------------------------------------------------------------------------
	public static void cargarTablaFiltrada(String tituloPelicula) {
		try {
			tbPeliculas.removeAll();
			ArrayList<pelicula> listaPeliculas = gestionarPeliculas.listarPeliculasFiltrar(tituloPelicula);
			if (listaPeliculas.isEmpty()) {
				gestionarPeliculas.generarPeliculas();
				listaPeliculas = gestionarPeliculas.listarPeliculas();
			}
			tbPeliculas.setModel(new tablaPeliculas(listaPeliculas));
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error al cargar la tabla", "ERROR", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}

	// ------- CARGAR LA TABLA
	// --------------------------------------------------------------------------------------------------------
	public static void cargarTabla() {
		try {
			tbPeliculas.removeAll();
			ArrayList<pelicula> listaPeliculas = gestionarPeliculas.listarPeliculas();
			if (listaPeliculas.isEmpty()) {
				gestionarPeliculas.generarPeliculas();
				listaPeliculas = gestionarPeliculas.listarPeliculas();
			}
			tbPeliculas.setModel(new tablaPeliculas(listaPeliculas));
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error al cargar la tabla", "ERROR", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}

	// ------- CARGAR EL NOMBRE DE LA BASE DE DATOS
	// --------------------------------------------------------------------------------------------------------
	public static void cargarNombreBD(JMenuItem mnItBDName) throws SQLException {
		String[] url = gestionarConexion.getConexion().getMetaData().getURL().split("/");
		String bd = url[url.length - 1];
		mnItBDName.setText("BD: " + bd);
	}

	// ------- TRADUCIR LA APLICACION
	// --------------------------------------------------------------------------------------------------------
	private void traducir(JMenu mnAyuda, JMenu mnArchivo, JMenu mnConfiguracion, JMenuItem mnItReconectar,
			JMenuItem mnItSalir, JMenuItem mnItConexion, JMenuItem mnItAyuda, JMenu mnIdioma, JMenuItem mnItSpanish,
			JMenuItem mnItEnglish, JMenuItem mnItGallego, JMenuItem mnItItaliano, JLabel lblTituloPelicula,
			JButton btnBuscar, JButton btnVerDatos) {
		rb = ResourceBundle.getBundle("data.language");
		// MENU
		String valor = rb.getString("mnAyuda");
		mnAyuda.setText(valor);
		valor = rb.getString("mnArchivo");
		mnArchivo.setText(valor);
		valor = rb.getString("mnConfiguracion");
		mnConfiguracion.setText(valor);
		// MENU ITEMS | ARCHIVO
		valor = rb.getString("mnItReconectar");
		mnItReconectar.setText(valor);
		valor = rb.getString("mnItSalir");
		mnItSalir.setText(valor);
		// MENU ITEMS | CONFIGURACION
		valor = rb.getString("mnItConexion");
		mnItConexion.setText(valor);
		// MENU ITEMS | AYUDA
		valor = rb.getString("mnItAyuda");
		mnItAyuda.setText(valor);
		valor = rb.getString("mnIdioma");
		mnIdioma.setText(valor);
		// MENU ITEMS | AYUDA | IDIOMAS
		valor = rb.getString("mnItSpanish");
		mnItSpanish.setText(valor);
		valor = rb.getString("mnItEnglish");
		mnItEnglish.setText(valor);
		valor = rb.getString("mnItGallego");
		mnItGallego.setText(valor);
		valor = rb.getString("mnItItaliano");
		mnItItaliano.setText(valor);
		// LABELS
		valor = rb.getString("lblTituloPelicula");
		lblTituloPelicula.setText(valor);
		// BOTONES
		valor = rb.getString("btnBuscar");
		btnBuscar.setText(valor);
		valor = rb.getString("btnVerDatos");
		btnVerDatos.setText(valor);
	}

}
