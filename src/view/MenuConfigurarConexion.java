package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.gestionarConexion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuConfigurarConexion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIP;
	private JTextField txtPuerto;
	private JTextField txtBD;
	private JTextField txtUsuario;
	private JPasswordField pwdField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuConfigurarConexion dialog = new MenuConfigurarConexion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MenuConfigurarConexion() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MenuConfigurarConexion.class.getResource("/assets/icons/configuration.png")));
		setBounds(100, 100, 450, 305);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(1, 0, 0, 0));

		GridBagLayout gbl_pane1 = new GridBagLayout();
		gbl_pane1.columnWeights = new double[] { 0.0, 1.0 };
		JPanel pane1 = new JPanel(gbl_pane1);
		contentPanel.add(pane1);

		setMinimumSize(new Dimension(450, 305));
		setMaximumSize(new Dimension(1920, 1080));

		JLabel lblTitulo = new JLabel("CONFIGURACI\u00D3N DE LA CONEXI\u00D3N");
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 23));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.anchor = GridBagConstraints.NORTH;
		gbc_lblTitulo.gridwidth = 2;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		pane1.add(lblTitulo, gbc_lblTitulo);

		JLabel lblIP = new JLabel("IP");
		GridBagConstraints gbc_lblIP = new GridBagConstraints();
		gbc_lblIP.anchor = GridBagConstraints.WEST;
		gbc_lblIP.insets = new Insets(0, 0, 5, 5);
		gbc_lblIP.gridx = 0;
		gbc_lblIP.gridy = 1;
		pane1.add(lblIP, gbc_lblIP);

		txtIP = new JTextField();
		GridBagConstraints gbc_txtIP = new GridBagConstraints();
		gbc_txtIP.insets = new Insets(0, 0, 5, 0);
		gbc_txtIP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIP.gridx = 1;
		gbc_txtIP.gridy = 1;
		pane1.add(txtIP, gbc_txtIP);
		txtIP.setColumns(10);

		JLabel lblPuerto = new JLabel("Puerto");
		GridBagConstraints gbc_lblPuerto = new GridBagConstraints();
		gbc_lblPuerto.anchor = GridBagConstraints.WEST;
		gbc_lblPuerto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuerto.gridx = 0;
		gbc_lblPuerto.gridy = 2;
		pane1.add(lblPuerto, gbc_lblPuerto);

		txtPuerto = new JTextField();
		GridBagConstraints gbc_txtPuerto = new GridBagConstraints();
		gbc_txtPuerto.insets = new Insets(0, 0, 5, 0);
		gbc_txtPuerto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPuerto.gridx = 1;
		gbc_txtPuerto.gridy = 2;
		pane1.add(txtPuerto, gbc_txtPuerto);
		txtPuerto.setColumns(10);

		JLabel lblBD = new JLabel("Nombre de BD");
		GridBagConstraints gbc_lblBD = new GridBagConstraints();
		gbc_lblBD.anchor = GridBagConstraints.WEST;
		gbc_lblBD.insets = new Insets(0, 0, 5, 5);
		gbc_lblBD.gridx = 0;
		gbc_lblBD.gridy = 3;
		pane1.add(lblBD, gbc_lblBD);

		txtBD = new JTextField();
		GridBagConstraints gbc_txtBD = new GridBagConstraints();
		gbc_txtBD.insets = new Insets(0, 0, 5, 0);
		gbc_txtBD.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBD.gridx = 1;
		gbc_txtBD.gridy = 3;
		pane1.add(txtBD, gbc_txtBD);
		txtBD.setColumns(10);

		JLabel lblUser = new JLabel("Usuario");
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.anchor = GridBagConstraints.WEST;
		gbc_lblUser.gridx = 0;
		gbc_lblUser.gridy = 4;
		pane1.add(lblUser, gbc_lblUser);

		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 1;
		gbc_txtUsuario.gridy = 4;
		pane1.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblContrasenha = new JLabel("Contrase\u00F1a");
		GridBagConstraints gbc_lblContrasenha = new GridBagConstraints();
		gbc_lblContrasenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasenha.anchor = GridBagConstraints.WEST;
		gbc_lblContrasenha.gridx = 0;
		gbc_lblContrasenha.gridy = 5;
		pane1.add(lblContrasenha, gbc_lblContrasenha);

		pwdField = new JPasswordField();
		GridBagConstraints gbc_pwdField = new GridBagConstraints();
		gbc_pwdField.insets = new Insets(0, 0, 5, 0);
		gbc_pwdField.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdField.gridx = 1;
		gbc_pwdField.gridy = 5;
		pane1.add(pwdField, gbc_pwdField);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton btnRestablecer = new JButton("Restablecer Datos");
		buttonPane.add(btnRestablecer);

		JButton btnGuardar = new JButton("Guardar");
		buttonPane.add(btnGuardar);
		getRootPane().setDefaultButton(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		buttonPane.add(btnCancelar);

		// METODOS
		// --------------------------------------------------------------------------------------------------------
		// ----- BOTONES
		// --------------------------------------------------------------------------------------------------------
		// ------- GUARDAR
		// --------------------------------------------------------------------------------------------------------
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtBD.getText().isEmpty() || txtIP.getText().isEmpty() || txtPuerto.getText().isEmpty()
						|| txtUsuario.getText().isEmpty() || pwdField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Rellena todos los campos", "ADVERTENCIA",
							JOptionPane.WARNING_MESSAGE);
				} else {
					String[] datos = new String[5];
					datos[0] = txtIP.getText();
					datos[1] = txtPuerto.getText();
					datos[2] = txtBD.getText();
					datos[3] = txtUsuario.getText();
					datos[4] = pwdField.getText();
					gestionarConexion.cambiarProperties(datos);
					dispose();
				}
			}
		});

		// ------- CANCELAR
		// --------------------------------------------------------------------------------------------------------
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// ------- RESTABLECER DATOS POR DEFECTO
		// --------------------------------------------------------------------------------------------------------
		btnRestablecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] datos = gestionarConexion.leerProperties();

				datos[0] = "192.168.56.200";
				datos[1] = "3306";
				datos[2] = "peliculas";
				datos[3] = "admin";
				datos[4] = "admin";

				txtIP.setText(datos[0]);
				txtPuerto.setText(datos[1]);
				txtBD.setText(datos[2]);
				txtUsuario.setText(datos[3]);
				pwdField.setText(datos[4]);
				gestionarConexion.cambiarProperties(datos);
				
				dispose();
			}
		});

		// ----- VENTANA
		// --------------------------------------------------------------------------------------------------------
		addWindowListener(new WindowAdapter() {
			// ------- ABRIR
			// ----------------------------------------------------------------------------------------------------
			@Override
			public void windowOpened(WindowEvent e) {
				String[] datos = gestionarConexion.leerProperties();
				txtIP.setText(datos[0]);
				txtPuerto.setText(datos[1]);
				txtBD.setText(datos[2]);
				txtUsuario.setText(datos[3]);
				pwdField.setText(datos[4]);
			}
			// ------- CERRAR
			// ----------------------------------------------------------------------------------------------------

			@Override
			public void windowClosing(WindowEvent e) {
			}
		});
	}

}
