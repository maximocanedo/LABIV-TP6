package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidad.Persona;

import java.awt.Font;

public class JPmodificar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JList<Persona> ltPersona;
	private JLabel lblSeleccioneLaPersona;
	private JButton btnModificar;
	
	public JPmodificar() {
		
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
	}

	private void initComponents() {
		ltPersona = new JList<Persona>();
		lblSeleccioneLaPersona = new JLabel("Seleccione la persona que desea modificar");
		txtNombre = new JTextField();
		txtApellido = new JTextField();
		txtDNI = new JTextField();
		btnModificar = new JButton("Modificar");
	}

	private void initLayout() {
		setLayout(null);
		
	}
}
