package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidad.Persona;

import java.awt.Font;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;

public class JPmodificar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JList<Persona> ltPersona;
	private JLabel lblSeleccioneLaPersona;
	private JButton btnModificar;
	private DefaultListModel<Persona> modelPersonas;
	
	
	public JPmodificar() {
		super();
		initLayout();
		initComponents();
		initUI();
		
	}

	private void initUI() {

		ltPersona.setBounds(59, 22, 512, 212);
		add(ltPersona);
		
		lblSeleccioneLaPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeleccioneLaPersona.setBounds(59, 0, 399, 25);
		add(lblSeleccioneLaPersona);
		
		txtNombre.setBounds(59, 251, 131, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido.setColumns(10);
		txtApellido.setBounds(200, 251, 131, 20);
		add(txtApellido);
		
		txtDNI.setColumns(10);
		txtDNI.setBounds(341, 251, 131, 20);
		add(txtDNI);
		
		btnModificar.setBounds(482, 247, 89, 29);
		add(btnModificar);
		
		
		this.setVisible(true);
		
		
	}

	private void initComponents() {
		ltPersona = new JList<Persona>();
		lblSeleccioneLaPersona = new JLabel("Seleccione la persona que desea modificar");
		txtNombre = new JTextField();
		txtApellido = new JTextField();
		txtDNI = new JTextField();
		btnModificar = new JButton("Modificar");
		
	}

	public void llenarJlist(List<Persona> personas) {
		modelPersonas = new DefaultListModel<Persona>();
	    for (Persona persona : personas) {
	    	modelPersonas.addElement(persona);
	    }
	
	    ltPersona.setModel(modelPersonas);
	}
	
	private void initLayout() {
		setLayout(null);
	}

	
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtDNI() {
		return txtDNI;
	}

	public void setTxtDNI(JTextField txtDNI) {
		this.txtDNI = txtDNI;
	}

	public JList<Persona> getLtPersona() {
		return ltPersona;
	}

	public void setLtPersona(JList<Persona> ltPersona) {
		this.ltPersona = ltPersona;
	}

	public JLabel getLblSeleccioneLaPersona() {
		return lblSeleccioneLaPersona;
	}

	public void setLblSeleccioneLaPersona(JLabel lblSeleccioneLaPersona) {
		this.lblSeleccioneLaPersona = lblSeleccioneLaPersona;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public DefaultListModel<Persona> getModelPersonas() {
		return modelPersonas;
	}

	public void setModelPersonas(DefaultListModel<Persona> modelPersonas) {
		this.modelPersonas = modelPersonas;
	}


}
