package presentacion.vista;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import entidad.Persona;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class PanelListar extends JPanel {
	private JTable table;
	private String[] columns = { "Nombre", "Número de Documento" };
	private DefaultTableModel modelTabla;
	private JButton btnActualizar;

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * Create the panel.
	 */
	public PanelListar() {
		setLayout(new MigLayout("", "[grow]", "[grow][]"));
		modelTabla = new DefaultTableModel(null, columns);
		JScrollPane spPersonas = new JScrollPane();
		table = new JTable(modelTabla);
		add(spPersonas, "cell 0 0,grow");
		spPersonas.setViewportView(table);
		
		btnActualizar = new JButton("Actualizar");
		add(btnActualizar, "cell 0 1");

	}
	
	public void updateTable(List<Persona> personasEnTabla) {
		this.getModelTabla().setRowCount(0);
		this.getModelTabla().setColumnCount(0);
		this.getModelTabla().setColumnIdentifiers(this.getColumns());

		for (Persona p : personasEnTabla) {
			String nombre = p.getNombre() + " " + p.getApellido();
			String DNI = p.getDNI();
			Object[] fila = {nombre, DNI};
			this.getModelTabla().addRow(fila);
		}
		
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public DefaultTableModel getModelTabla() {
		return modelTabla;
	}

	public void setModelTabla(DefaultTableModel modelTabla) {
		this.modelTabla = modelTabla;
	}

}
