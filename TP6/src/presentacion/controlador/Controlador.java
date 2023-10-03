package presentacion.controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entidad.Persona;
import negocio.PersonaNegocio;
import net.miginfocom.swing.MigLayout;
import presentacion.vista.JPagregar;
import presentacion.vista.Menu;


public class Controlador implements ActionListener {

	private Menu principal;
	
	private JPagregar panelAgregar;
	private JPAgregarControlador cpanelAgregar;
	
	private PersonaNegocio pNegocio;
	
	
	
	public Controlador(Menu vista, PersonaNegocio pNeg) {
		//Guardamos las instancias que recibe el constructor
		this.principal = vista;
		this.pNegocio = pNeg;
		
		//Instanciamos los paneles
		this.panelAgregar = new JPagregar();
		this.cpanelAgregar = new JPAgregarControlador(panelAgregar);
		
		//Eventos del menu principal
		this.principal.getMntmAgregar().addActionListener(a->EventoClickMenu_Panel_AgregarPersona(a));
		
		
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
	
	public void inicializar() {
		this.principal.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
