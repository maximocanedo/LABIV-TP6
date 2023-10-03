package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.vista.JPAgregar;

public class JPAgregarControlador {
	
	private JPAgregar panel;
	private PersonaNegocioImpl pNegocio;
	
	public JPAgregarControlador(JPAgregar panel) {
		this.panel = panel;
		pNegocio = new PersonaNegocioImpl();
		applyEvents();
	}
	
	private void applyEvents() {
		//Eventos del panel Agregar
		this.panel.getTxtNombre().addKeyListener(KeyListener_txtNombre());
		this.panel.getTxtApellido().addKeyListener(KeyListener_txtApellido());
		this.panel.getTxtDNI().addKeyListener(KeyListener_txtDNI());
		this.panel.getBtnAceptar().addActionListener(a->EventoClickBoton_Agregar_PanelAgregarPersona(a));
	}
	
//EVENTOS DEL PANEL AGREGAR PERSONA---------------------------------------------------------------------

	//KeyListener textfield NOMBRE
	private KeyListener KeyListener_txtNombre(){
		return new KeyAdapter() {
	        public void keyTyped(KeyEvent e) {
	            char c = e.getKeyChar();
	            if (!(Character.isLetter(c) || c == KeyEvent.VK_SPACE || c == KeyEvent.VK_DELETE) || panel.getTxtNombre().getText().length() >= 45) {
	                e.consume();
	            }
	        }
	    };	
	}
	
	//KeyListener textfield APELLIDO
		private KeyListener KeyListener_txtApellido(){
			return new KeyAdapter() {
		        public void keyTyped(KeyEvent e) {
		            char c = e.getKeyChar();
		            if (!(Character.isLetter(c) || c == KeyEvent.VK_SPACE || c == KeyEvent.VK_DELETE) || panel.getTxtApellido().getText().length() >= 45) {
		                e.consume();
		            }
		        }
		    };	
	}
		
	//KeyListener textfield DNI
		private KeyListener KeyListener_txtDNI(){
			return new KeyAdapter() {
		        public void keyTyped(KeyEvent e) {
		            char c = e.getKeyChar();
		            if (!(Character.isDigit(c) || c == KeyEvent.VK_SPACE || c == KeyEvent.VK_DELETE) || panel.getTxtDNI().getText().length() >= 20) {
		                e.consume();
		            }
		        }
		    };	
	}	
		
	
	//Evento click al boton "Agregar" del panel "Agregar Personas"
	private void EventoClickBoton_Agregar_PanelAgregarPersona(ActionEvent a) {
		
		if(!panel.getTxtNombre().getText().isEmpty() && !panel.getTxtApellido().getText().isEmpty() && !this.panel.getTxtDNI().getText().isEmpty()) {
				String dni = this.panel.getTxtDNI().getText();
				String nombre = this.panel.getTxtNombre().getText();
				String apellido = this.panel.getTxtApellido().getText();
		
				Persona personaNueva = new Persona(dni,nombre,apellido);
		
				boolean agregado = pNegocio.insert(personaNueva);	
				if(agregado==true)
				{
					this.panel.getTxtDNI().setText("");
					this.panel.getTxtNombre().setText("");
					this.panel.getTxtApellido().setText("");
				}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Todos los campos deben estar completos","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
		}
	}
	
}
