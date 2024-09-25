package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class tablaPeliculas extends AbstractTableModel {

	private ArrayList<pelicula> listaPeliculas;
	private String[] columnas = { "Titulo", "Puntuacion", "Fecha de Estreno", "Duracion" };

	public tablaPeliculas(ArrayList<pelicula> lPeliculas) {
		super();
		listaPeliculas = lPeliculas;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public String getColumnName(int col) {
		return columnas[col];
	}

	@Override
	public int getRowCount() {
		return listaPeliculas.size();
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex != -1 && listaPeliculas.size() > rowIndex) {
			pelicula p = listaPeliculas.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return p.getTitulo();
			case 1:
				return p.getPuntuacion();
			case 2:
				return p.getFechaEstreno();
			case 3:
				return p.getDuracion();
			default:
				return null;
			}
		} else {
			return null;
		}
	}

}
