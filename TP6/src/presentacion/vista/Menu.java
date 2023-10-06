package presentacion.vista;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import main.Messages;

public class Menu extends JFrame {
	private static final long serialVersionUID = 3L;
	// Controles
	private JMenuBar menuBar;	
	private JMenu mnPersona;
	private JMenuItem mntmListar;
	private JMenuItem mntmAgregar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmEliminar;
	// Fin de controles
	
	@SuppressWarnings("serial")
	public Menu() {
		setTitle("Trabajo Pr\u00E1ctico N.\u00BA 6 (Grupo N.º 3)");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/Images/UTN.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		mnPersona = new JMenu(Messages.getString("personaMenuTitle")); //$NON-NLS-1$
		mntmListar = new JMenuItem(Messages.getString("listarMenuOption")); //$NON-NLS-1$
		mntmAgregar = new JMenuItem(Messages.getString("agregarMenuOption")); //$NON-NLS-1$
		mntmModificar = new JMenuItem(Messages.getString("modificarMenuOption")); //$NON-NLS-1$
		mntmEliminar = new JMenuItem(Messages.getString("eliminarMenuOption")); //$NON-NLS-1$
		
		setJMenuBar(menuBar);
		menuBar.add(mnPersona);
		mnPersona.add(mntmListar);
		mnPersona.add(mntmAgregar);
		mnPersona.add(mntmModificar);
		mnPersona.add(mntmEliminar);
		
	}
	
	public void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	// Getters y Setters de los controles
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}
	public JMenu getMnPersona() {
		return mnPersona;
	}
	public void setMnPersona(JMenu mnPersona) {
		this.mnPersona = mnPersona;
	}
	public JMenuItem getMntmListar() {
		return mntmListar;
	}
	public void setMntmListar(JMenuItem mntmListar) {
		this.mntmListar = mntmListar;
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

}
