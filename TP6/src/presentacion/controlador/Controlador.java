package presentacion.controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import entidad.Persona;
import negocio.PersonaNegocio;
import net.miginfocom.swing.MigLayout;
import presentacion.vista.JPAgregar;
import presentacion.vista.JPEliminar;
import presentacion.vista.JPModificar;
import presentacion.vista.Menu;


public class Controlador implements ActionListener {

	private Menu principal;
	
	// Panel Agregar
	private JPAgregar panelAgregar;
	private JPAgregarControlador cpanelAgregar;
	
	// Panel Eliminar
	private JPEliminar panelEliminar;
	private JPEliminarControlador cpanelEliminar;
	
	// Panel Modificar
	private JPModificar panelModificar;
	private JPModificarControlador cpanelModificar;
	
	// Panel Listar (Pendiente)
	
	// Clases de lógica
	private PersonaNegocio pNegocio;
	
	
	public Controlador(Menu vista, PersonaNegocio pNeg) {
		
		
		//Guardamos las instancias que recibe el constructor
		this.principal = vista;
		this.pNegocio = pNeg;
		
		//Instanciamos los paneles
		this.panelAgregar = new JPAgregar();
		this.cpanelAgregar = new JPAgregarControlador(panelAgregar);
		
		this.panelModificar = new JPModificar();
		this.cpanelModificar = new JPModificarControlador(panelModificar);
		
		this.panelEliminar = new JPEliminar();
		this.cpanelEliminar = new JPEliminarControlador(panelEliminar);
		
		//Eventos del menu principal
		this.principal.getMntmAgregar().addActionListener(a->EventoClickMenu_Panel_AgregarPersona(a));
		this.principal.getMntmModificar().addActionListener(a->EventoClickMenu_Panel_ModificarPersona(a));
		this.principal.getMntmEliminar().addActionListener(a->EventoClickMenu_Panel_EliminarPersona(a));
		
	}
	
	public void showView(JPanel view) {
		principal.getContentPane().removeAll();
		principal.getContentPane().add(view);
		principal.getContentPane().revalidate();
		principal.getContentPane().repaint();
	}
	
	//EVENTOS DEL MENU
	//Evento click al boton del menu "Agregar personas"
	public void EventoClickMenu_Panel_AgregarPersona(ActionEvent a) {
		showView(panelAgregar);
	}
	public void EventoClickMenu_Panel_ModificarPersona(ActionEvent a) {
		showView(panelModificar);
	}
	public void EventoClickMenu_Panel_EliminarPersona(ActionEvent a) {
		showView(panelEliminar);
	}
	
	public void inicializar() {
		this.principal.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
