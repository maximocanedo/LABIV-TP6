package presentacion.vista;

import java.awt.MenuBar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import main.Principal;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Menu extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnPersona;
	private JMenuItem mntmAgregar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmListar;
	private SpringLayout sl_contentPane;
	private JMenuItem mntmSalir;
	
	public Menu() {
		super();
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
		mntmSalir.setIcon(new ImageIcon(Menu.class.getResource("/Images/Icons8-Windows-8-Users-Exit.16.png")));
		mnPersona.add(mntmSalir);
		
		
	}

	private void initComponents() {
		menuBar = new JMenuBar();
		mnPersona = new JMenu("Persona");
		mntmAgregar = new JMenuItem("Agregar");
		mntmModificar = new JMenuItem("Modificar");
		mntmEliminar = new JMenuItem("Eliminar");
		mntmListar = new JMenuItem("Listar");
		mntmSalir = new JMenuItem("Salir");
		
	}

	private void initLayout() {
		setTitle("TP6 Grupo 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 478);
		contentPane = new JPanel();
		sl_contentPane = new SpringLayout();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(sl_contentPane);
		
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JMenuItem getMntmSalir() {
		return mntmSalir;
	}

	public void setMntmSalir(JMenuItem mntmSalir) {
		this.mntmSalir = mntmSalir;
	}

}
