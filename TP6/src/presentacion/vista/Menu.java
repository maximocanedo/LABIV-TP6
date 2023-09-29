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
	
	public Menu() {
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(sl_contentPane);
		
	}

	private void initComponents() {
		menuBar = new JMenuBar();
		mnPersona = new JMenu("Persona");
		mntmAgregar = new JMenuItem("Agregar");
		mntmModificar = new JMenuItem("Modificar");
		mntmEliminar = new JMenuItem("Eliminar");
		mntmListar = new JMenuItem("Listar");
		contentPane = new JPanel();
		sl_contentPane = new SpringLayout();
		
	}

	private void initLayout() {
		setTitle("TP6 Grupo 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
	}
}
