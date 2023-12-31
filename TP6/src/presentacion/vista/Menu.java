package presentacion.vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import main.Principal;
import java.awt.Dimension;


public class Menu extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnPersona;
	private JMenuItem mntmAgregar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmListar;
	private SpringLayout sl_contentPane;
	
	public Menu() {
		setMinimumSize(new Dimension(450, 400));
		initLayout();
		initComponents();
		initUI();
		initListeners();
		
	}

	private void initListeners() {
		
		
	}

	private void initUI() {
		setJMenuBar(menuBar);
		menuBar.add(mnPersona);
		mntmAgregar.setIcon(new ImageIcon(Principal.class.getResource("/Images/Oxygen-Icons.org-Oxygen-Actions-list-add-user.16.png")));
		mnPersona.add(mntmAgregar);
		mntmModificar.setIcon(new ImageIcon(Principal.class.getResource("/Images/Oxygen-Icons.org-Oxygen-Actions-user-properties.16.png")));
		mnPersona.add(mntmModificar);
		mntmEliminar.setIcon(new ImageIcon(Principal.class.getResource("/Images/Oxygen-Icons.org-Oxygen-Actions-list-remove-user.16.png")));
		mnPersona.add(mntmEliminar);
		mntmListar.setIcon(new ImageIcon(Principal.class.getResource("/Images/Oxygen-Icons.org-Oxygen-Apps-preferences-contact-list.16.png")));
		mnPersona.add(mntmListar);
		
		
	}

	private void initComponents() {
		menuBar = new JMenuBar();
		mnPersona = new JMenu("Persona");
		mntmAgregar = new JMenuItem("Agregar");
		mntmModificar = new JMenuItem("Modificar");
		mntmEliminar = new JMenuItem("Eliminar");
		mntmListar = new JMenuItem("Listar");
		//sl_contentPane = new SpringLayout();
		
	}

	private void initLayout() {
		setTitle("TP6 Grupo 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
	}

	

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getMnPersona() {
		return mnPersona;
	}

	public void setMnPersona(JMenu mnPersona) {
		this.mnPersona = mnPersona;
	}

	public JMenuItem getMntmAgregar() {
		return mntmAgregar;
	}

	public void setMntmAgregar(JMenuItem mntmAgregar) {
		this.mntmAgregar = mntmAgregar;
	}

	public JMenuItem getMntmModificar() {
		return mntmModificar;
	}

	public void setMntmModificar(JMenuItem mntmModificar) {
		this.mntmModificar = mntmModificar;
	}

	public JMenuItem getMntmEliminar() {
		return mntmEliminar;
	}

	public void setMntmEliminar(JMenuItem mntmEliminar) {
		this.mntmEliminar = mntmEliminar;
	}

	public JMenuItem getMntmListar() {
		return mntmListar;
	}

	public void setMntmListar(JMenuItem mntmListar) {
		this.mntmListar = mntmListar;
	}

	public SpringLayout getSl_contentPane() {
		return sl_contentPane;
	}

	public void setSl_contentPane(SpringLayout sl_contentPane) {
		this.sl_contentPane = sl_contentPane;
	}
	
	
}
