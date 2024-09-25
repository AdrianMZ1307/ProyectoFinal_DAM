package view;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.pelicula;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class MenuEditarPelicula extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static pelicula p;
	private JTextField txtTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, pelicula pelicula) {
		try {
			p = pelicula;
			MenuEditarPelicula dialog = new MenuEditarPelicula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MenuEditarPelicula() {
		setTitle("Editando " + p.getTitulo());
		setModal(true);
		setBounds(100, 100, 570, 535);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new GridLayout());
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{211, 107, 75, 86, 0};
		gbl_panel_1.rowHeights = new int[] {0, 22, 20, 20, 20, 330, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JMenuBar mnBar_1 = new JMenuBar();
		GridBagConstraints gbc_mnBar_1 = new GridBagConstraints();
		gbc_mnBar_1.insets = new Insets(0, 0, 5, 5);
		gbc_mnBar_1.gridx = 0;
		gbc_mnBar_1.gridy = 0;
		panel_1.add(mnBar_1, gbc_mnBar_1);
		
		JMenu mnAyuda_1_1_1 = new JMenu("Ayuda");
		mnBar_1.add(mnAyuda_1_1_1);
		
		JMenuItem mnItAyuda_1_1_1 = new JMenuItem("Ver Ayuda");
		mnAyuda_1_1_1.add(mnItAyuda_1_1_1);
		
		JMenu mnIdioma_1_1_1 = new JMenu("Idioma");
		mnAyuda_1_1_1.add(mnIdioma_1_1_1);
		
		JMenuItem mnItSpanish_1_1_1 = new JMenuItem("Espa\u00F1ol");
		mnIdioma_1_1_1.add(mnItSpanish_1_1_1);
		
		JMenuItem mnItEnglish_1_1_1 = new JMenuItem("Ingles");
		mnIdioma_1_1_1.add(mnItEnglish_1_1_1);
		
		JMenuItem mnItGallego_1_1_1 = new JMenuItem("Gallego");
		mnIdioma_1_1_1.add(mnItGallego_1_1_1);
		
		JMenuItem mnItItaliano_1_1_1 = new JMenuItem("Italiano");
		mnIdioma_1_1_1.add(mnItItaliano_1_1_1);
		
		JMenuItem mnItBDName_1_1_1 = new JMenuItem("BD: <NOMBRE DE LA BD>");
		mnAyuda_1_1_1.add(mnItBDName_1_1_1);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.VERTICAL;
		gbc_panel_2.anchor = GridBagConstraints.WEST;
		gbc_panel_2.gridheight = 5;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnImagen = new JButton("");
		panel_2.add(btnImagen);
		
		JLabel lblTitulo = new JLabel("TITULO");
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 1;
		gbc_lblTitulo.gridy = 1;
		panel_1.add(lblTitulo, gbc_lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTHEAST;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		panel_1.add(txtTitulo, gbc_textField);
		
		JLabel lblPuntuacion = new JLabel("PUNTUACION");
		GridBagConstraints gbc_lblPuntuacion = new GridBagConstraints();
		gbc_lblPuntuacion.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblPuntuacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntuacion.gridx = 1;
		gbc_lblPuntuacion.gridy = 2;
		panel_1.add(lblPuntuacion, gbc_lblPuntuacion);
		
		JSpinner spPuntuacion = new JSpinner();
		GridBagConstraints gbc_spPuntuacion = new GridBagConstraints();
		gbc_spPuntuacion.anchor = GridBagConstraints.NORTHEAST;
		gbc_spPuntuacion.insets = new Insets(0, 0, 5, 0);
		gbc_spPuntuacion.gridx = 3;
		gbc_spPuntuacion.gridy = 2;
		panel_1.add(spPuntuacion, gbc_spPuntuacion);
		
		JLabel lblDuracion = new JLabel("DURACION");
		GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
		gbc_lblDuracion.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracion.gridx = 1;
		gbc_lblDuracion.gridy = 3;
		panel_1.add(lblDuracion, gbc_lblDuracion);
		
		JSpinner spDuracion = new JSpinner();
		spDuracion.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_spDuracion = new GridBagConstraints();
		gbc_spDuracion.anchor = GridBagConstraints.NORTHEAST;
		gbc_spDuracion.insets = new Insets(0, 0, 5, 0);
		gbc_spDuracion.gridx = 3;
		gbc_spDuracion.gridy = 3;
		panel_1.add(spDuracion, gbc_spDuracion);
		
		JLabel lblFechaEstreno = new JLabel("FECHA ESTRENO");
		GridBagConstraints gbc_lblFechaEstreno = new GridBagConstraints();
		gbc_lblFechaEstreno.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblFechaEstreno.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaEstreno.gridx = 1;
		gbc_lblFechaEstreno.gridy = 4;
		panel_1.add(lblFechaEstreno, gbc_lblFechaEstreno);
		
		JSpinner spFecha = new JSpinner();
		spFecha.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_spFecha = new GridBagConstraints();
		gbc_spFecha.anchor = GridBagConstraints.NORTHEAST;
		gbc_spFecha.insets = new Insets(0, 0, 5, 0);
		gbc_spFecha.gridx = 3;
		gbc_spFecha.gridy = 4;
		panel_1.add(spFecha, gbc_spFecha);
		
		JLabel lblSinopsis = new JLabel("SINOPSIS");
		GridBagConstraints gbc_lblSinopsis = new GridBagConstraints();
		gbc_lblSinopsis.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSinopsis.insets = new Insets(0, 0, 5, 5);
		gbc_lblSinopsis.gridx = 1;
		gbc_lblSinopsis.gridy = 5;
		panel_1.add(lblSinopsis, gbc_lblSinopsis);
		
		JTextArea txtASpinopsis = new JTextArea();
		txtASpinopsis.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_txtASpinopsis = new GridBagConstraints();
		gbc_txtASpinopsis.insets = new Insets(0, 0, 5, 0);
		gbc_txtASpinopsis.fill = GridBagConstraints.VERTICAL;
		gbc_txtASpinopsis.anchor = GridBagConstraints.EAST;
		gbc_txtASpinopsis.gridwidth = 2;
		gbc_txtASpinopsis.gridx = 2;
		gbc_txtASpinopsis.gridy = 5;
		panel_1.add(txtASpinopsis, gbc_txtASpinopsis);
		
		JPanel buttonPane = new JPanel();
		GridBagConstraints gbc_buttonPane = new GridBagConstraints();
		gbc_buttonPane.gridwidth = 4;
		gbc_buttonPane.fill = GridBagConstraints.BOTH;
		gbc_buttonPane.gridx = 0;
		gbc_buttonPane.gridy = 6;
		panel_1.add(buttonPane, gbc_buttonPane);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					// IMAGEN
					int blobLength = (int) p.getPortada().length();
					byte[] blobAsBytes;
					blobAsBytes = p.getPortada().getBytes(1, blobLength);
					final BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(blobAsBytes));
					btnImagen.setIcon(new ImageIcon(bufferedImage));
					btnImagen.setBounds(0, 0, 170, 180); // 170x180

					// EL RESTO
					txtTitulo.setText(p.getTitulo());
					txtASpinopsis.setText(p.getSinopsis());
					spPuntuacion.setValue(p.getPuntuacion());
					spDuracion.setValue(p.getDuracion());
					SpinnerDateModel fecha = new SpinnerDateModel();
					fecha.setCalendarField(p.getFechaEstreno().toLocalDate().getDayOfYear());
					spFecha.setValue(fecha);
				} catch (SQLException | IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});

	}
}
