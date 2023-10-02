package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import presentacion.vista.*;

public class Controller implements ActionListener {
	
	private Menu menu;
	private PanelAgregar panelAgregar;
	private PanelDefault panelDefault;
	private PanelEliminar panelEliminar;
	private PanelModificar panelModificar;
	private PanelListar panelListar; 
	private PanelAgregarController panelAgregarController;
	private PanelListarController panelListarController;
	private PanelModificarController panelModificarController;
	private PanelEliminarController panelEliminarController;
	
	public void setView(JPanel view) {
		menu.getContentPane().removeAll();
		menu.getContentPane().add(view);
		menu.getContentPane().revalidate();
		menu.getContentPane().repaint();
	}
	
	public void launch() {
		try {
            // Set cross-platform Java L&F (also called "Metal")
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		menu = new Menu();
		panelAgregar = new PanelAgregar();
		panelAgregarController = new PanelAgregarController(panelAgregar);
		panelDefault = new PanelDefault();
		panelEliminar = new PanelEliminar();
		panelEliminarController = new PanelEliminarController(panelEliminar);
		panelModificar = new PanelModificar();
		panelModificarController = new PanelModificarController(panelModificar);
		panelListar = new PanelListar();
		panelListarController = new PanelListarController(panelListar);
		menu.setVisible(true);
		setView(panelDefault);
		menu.getMntmAgregar().addActionListener(e->Ev_Abrir_PanelAgregar(e));
		menu.getMntmModificar().addActionListener(e->Ev_Abrir_PanelModificar(e));
		menu.getMntmEliminar().addActionListener(e->Ev_Abrir_PanelEliminar(e));
		menu.getMntmListar().addActionListener(e->Ev_Abrir_PanelListar(e));
		
	}
	
	public void Ev_Abrir_PanelAgregar(ActionEvent e) {
		setView(panelAgregar);
	}
	public void Ev_Abrir_PanelModificar(ActionEvent e) {
		setView(panelModificar);
		panelModificarController.updateList();
	}
	public void Ev_Abrir_PanelEliminar(ActionEvent e) {
		setView(panelEliminar);
		panelEliminarController.updateTable();
	}
	public void Ev_Abrir_PanelListar(ActionEvent e) {
		setView(panelListar);
		panelListarController.updateTable();
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
