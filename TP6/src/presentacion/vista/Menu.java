package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import net.miginfocom.swing.MigLayout;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		mnPersona = new JMenu("Persona");
		mntmListar = new JMenuItem("Listar");
		mntmAgregar = new JMenuItem("Agregar");
		mntmModificar = new JMenuItem("Modificar");
		mntmEliminar = new JMenuItem("Eliminar");
		
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
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Menu x = new Menu();
		x.launch();
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
