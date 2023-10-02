package presentacion.vista;

import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import java.awt.ScrollPane;
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;

public class JPlistar extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablaPersonas_1;
	private static final String[] nombreColumnas= {"Nombre","Apellido","Dni"};
	private DefaultTableModel modelPersonas;

	/**
	 * Create the panel.
	 */
	public JPlistar() {
		super();
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(80, 78, 557, 339);
		this.add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 537, 317);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersonas_1 = new JTable(modelPersonas);
		
		tablaPersonas_1.getColumnModel().getColumn(0).setPreferredWidth(100);
		tablaPersonas_1.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas_1.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas_1.getColumnModel().getColumn(1).setResizable(false);
		tablaPersonas_1.getColumnModel().getColumn(2).setPreferredWidth(50);
		tablaPersonas_1.getColumnModel().getColumn(2).setResizable(false);
		tablaPersonas_1.setEnabled(false);
		spPersonas.setViewportView(tablaPersonas_1);
		
		this.setVisible(true);
	}
	
	public void llenarTabla(List<Persona> listaPersonas) {
		this.getModelPersonas().setRowCount(0); //Para vaciar la tabla y llenar luego
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (Persona persona : listaPersonas)
		{
			String nombre = persona.getNombre();
			String apellido = persona.getApellido();
			String dni = persona.getDni();
			Object[] fila = {nombre, apellido, dni};
			this.getModelPersonas().addRow(fila);
		}
		
	}

	public JTable getTablaPersonas() {
		return tablaPersonas_1;
	}

	public void setTablaPersonas(JTable tablaPersonas) {
		this.tablaPersonas_1 = tablaPersonas;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public DefaultTableModel getModelPersonas() {
		return modelPersonas;
	}

	public void setModelPersonas(DefaultTableModel modelPersonas) {
		this.modelPersonas = modelPersonas;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
