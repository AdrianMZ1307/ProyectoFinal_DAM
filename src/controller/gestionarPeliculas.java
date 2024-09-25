package controller;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.pelicula;

public class gestionarPeliculas {

	public static ArrayList<pelicula> listarPeliculas() {
		ArrayList<pelicula> listaPeliculas = new ArrayList<>();
		try {
			String consulta = "SELECT * FROM pelicula";
			PreparedStatement sentencia = gestionarConexion.getConexion().prepareStatement(consulta);
			ResultSet tablas = gestionarConexion.getConexion().getMetaData().getTables(null, null, "pelicula", null);
			if (tablas.next()) {
				ResultSet resultado = sentencia.executeQuery(consulta);
				while (resultado.next()) {
					listaPeliculas.add(new pelicula(resultado.getString(1), resultado.getString(2),
							resultado.getFloat(3), resultado.getInt(4), resultado.getDate(5), resultado.getBlob(6)));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar las Peliculas");
		}
		return listaPeliculas;
	}

	public static ArrayList<pelicula> listarPeliculasFiltrar(String tituloPelicula) {
		ArrayList<pelicula> listaPeliculas = new ArrayList<>();
		try {
			String consulta = "SELECT * FROM pelicula WHERE titulo LIKE CONCAT(?,'%')";
			PreparedStatement sentencia = gestionarConexion.getConexion().prepareStatement(consulta);
			sentencia.setString(1, tituloPelicula);
			ResultSet tablas = gestionarConexion.getConexion().getMetaData().getTables(null, null, "pelicula", null);
			if (tablas.next()) {
				ResultSet resultado = sentencia.executeQuery(consulta);
				while (resultado.next()) {
					listaPeliculas.add(new pelicula(resultado.getString(1), resultado.getString(2),
							resultado.getFloat(3), resultado.getInt(4), resultado.getDate(5), resultado.getBlob(6)));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar las Peliculas");
		}
		return listaPeliculas;
	}

	public static void generarPeliculas() {
		try {
			ResultSet tablas = gestionarConexion.getConexion().getMetaData().getTables(null, null, "pelicula", null);
			if (tablas.next()) {
				for (int i = 0; i < 10; i++) {
					Date fecha = new Date(i);
					fecha.setYear((i + 1) * 100);
					fecha.setMonth((i + 1));
					String consulta = "INSERT INTO pelicula VALUES(?,?,?,?,?,?)";
					PreparedStatement sentencia = gestionarConexion.getConexion().prepareStatement(consulta);
					sentencia.setString(1, "Pelicula " + (i + 1));
					sentencia.setString(2, "Ejemplo Nº " + (i + 1));
					sentencia.setFloat(3, 1.0f);
					sentencia.setInt(4, i);
					sentencia.setDate(5, fecha);
					sentencia.setString(6, "PORTADA");
					int resultado = sentencia.executeUpdate();
					gestionarConexion.getConexion().commit();
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar las Peliculas");
		}
	}

}
