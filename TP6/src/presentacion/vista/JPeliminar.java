package presentacion.vista;

import javax.swing.JPanel;

import entidad.Persona;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;

public class JPeliminar extends JPanel {

	private JLabel lblEliminarUsuarios;
	private JList<Persona> ltPersonas;
	private JButton btEliminar;
	
	private static final long serialVersionUID = 1L;

	public JPeliminar() {
		super();
		initLayout();
		initComponents();
		initUI();
	}

	private void initUI() {
		lblEliminarUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEliminarUsuarios.setBounds(150, 11, 139, 14);
		add(lblEliminarUsuarios);
		
		ltPersonas.setBounds(150, 25, 303, 287);
		add(ltPersonas);
		
		btEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btEliminar.setBounds(237, 323, 139, 23);
		add(btEliminar);
		this.setVisible(true);
	}

	private void initComponents() {
		lblEliminarUsuarios = new JLabel("Eliminar usuarios");
		ltPersonas = new JList<Persona>();
		btEliminar = new JButton("Eliminar");
	}

	private void initLayout() {
		setLayout(null);
		
	}

	public JLabel getLblEliminarUsuarios() {
		return lblEliminarUsuarios;
	}

	public void setLblEliminarUsuarios(JLabel lblEliminarUsuarios) {
		this.lblEliminarUsuarios = lblEliminarUsuarios;
	}

	public JList<Persona> getLtPersonas() {
		return ltPersonas;
	}

	public void setLtPersonas(JList<Persona> ltPersonas) {
		this.ltPersonas = ltPersonas;
	}

	public JButton getBtEliminar() {
		return btEliminar;
	}

	public void setBtEliminar(JButton btEliminar) {
		this.btEliminar = btEliminar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}