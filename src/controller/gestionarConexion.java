package controller;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

public class gestionarConexion {
	private static Connection con;
	private static Properties properties = new Properties();
	private static File file= new File("./src/data/connection.properties"); 

	public static Connection conectar() {
		try {
			properties.load(new FileInputStream(new File("./src/data/connection.properties")));
			Class.forName("com.mysql.jdbc.Driver");
			String dirBD = "jdbc:mysql://" + properties.get("IP") + ":" + properties.get("PORT") + "/"
					+ properties.get("BD");
			con = DriverManager.getConnection(dirBD, properties.get("USER") + "", properties.get("PASSWORD") + "");
			con.setAutoCommit(false);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ha Ocurrido un error al Conectar");
			System.exit(0);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Ha Ocurrido un error al cargar el Driver");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encuentra el fichero properties", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error al leer el fichero properties", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return con;
	}

	public static Connection getConexion() {
		return con;
	}

	public static void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ha Ocurrido un error al cerrar la conexión");
			System.exit(0);
		}
	}

	public static void cambiarProperties(String[] datos) {
		try {
			properties.load(new FileInputStream(new File("./src/data/connection.properties")));
			properties.setProperty("IP", datos[0]);
			properties.setProperty("PORT", datos[1]);
			properties.setProperty("BD", datos[2]);
			properties.setProperty("USER", datos[3]);
			properties.setProperty("PASSWORD", datos[4]);
			FileOutputStream fileOS = new FileOutputStream(file);
			properties.store(fileOS, null);
			fileOS.close();			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encuentra el fichero properties", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error al leer el fichero properties", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();

		}
	}

	public static String[] leerProperties() {
		String[] datos = new String[5];
		try {
			properties.load(new FileInputStream(file));
			datos[0] = String.valueOf(properties.get("IP"));
			datos[1] = String.valueOf(properties.get("PORT"));
			datos[2] = String.valueOf(properties.get("BD"));
			datos[3] = String.valueOf(properties.get("USER"));
			datos[4] = String.valueOf(properties.get("PASSWORD"));
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encuentra el fichero properties", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error al leer el fichero properties", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return datos;
	}
}
