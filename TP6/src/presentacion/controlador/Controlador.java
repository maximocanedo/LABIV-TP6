package presentacion.controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import net.miginfocom.swing.MigLayout;
import presentacion.vista.JPagregar;
import presentacion.vista.JPMenuPrincipal;


public class Controlador implements ActionListener {

	private JPMenuPrincipal principal;
	private JPagregar panelAgregar;
	
	private PersonaNegocio pNegocio;
	
	public Controlador(JPMenuPrincipal vista, PersonaNegocio pNeg)
	{
		//Guardamos las instancias que recibe el constructor
		this.principal = vista;
		this.pNegocio = pNeg;
		
		//Instanciamos los paneles
		this.panelAgregar = new JPagregar();
		this.panelAgregar.setBounds(0,0,principal.getContentPane().getWidth(),principal.getContentPane().getHeight());
		
		
		//Elazado de eventos
		
		
		//Eventos del menu principal
		this.principal.getMntmAgregar().addActionListener(a->EventoClickMenu_Panel_AgregarPersona(a));
		
		//Eventos del panel Agregar
		this.panelAgregar.getTxtNombre().addKeyListener(KeyListener_txtNombre());
		this.panelAgregar.getTxtApellido().addKeyListener(KeyListener_txtApellido());
		this.panelAgregar.getTxtDNI().addKeyListener(KeyListener_txtDNI());
		this.panelAgregar.getBtnAceptar().addActionListener(a->EventoClickBoton_Agregar_PanelAgregarPersona(a));
	}
	
	
	
		//EVENTOS DEL MENU
		//Evento click al boton del menu "Agregar personas"
		public void EventoClickMenu_Panel_AgregarPersona(ActionEvent a)
		{
			principal.getContentPane().removeAll();
			principal.getContentPane().add(panelAgregar);
			principal.getContentPane().repaint();
			principal.getContentPane().revalidate();
		}
		//Agregar resto de eventos
		
		//EVENTOS DEL PANEL AGREGAR PERSONA---------------------------------------------------------------------
		
		//KeyListener textfield NOMBRE
		private KeyListener KeyListener_txtNombre(){
			return new KeyAdapter() {
		        public void keyTyped(KeyEvent e) {
		            char c = e.getKeyChar();
		            if (!(Character.isLetter(c) || c == KeyEvent.VK_SPACE || c == KeyEvent.VK_DELETE) || panelAgregar.getTxtNombre().getText().length() >= 45) {
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
			            if (!(Character.isLetter(c) || c == KeyEvent.VK_SPACE || c == KeyEvent.VK_DELETE) || panelAgregar.getTxtApellido().getText().length() >= 45) {
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
			            if (!(Character.isDigit(c) || c == KeyEvent.VK_SPACE || c == KeyEvent.VK_DELETE) || panelAgregar.getTxtDNI().getText().length() >= 20) {
			                e.consume();
			            }
			        }
			    };	
		}	
			
		
		//Evento click al boton "Agregar" del panel "Agregar Personas"
		private void EventoClickBoton_Agregar_PanelAgregarPersona(ActionEvent a) {
			
			if(!this.panelAgregar.getTxtNombre().getText().isEmpty() && !this.panelAgregar.getTxtApellido().getText().isEmpty() && !this.panelAgregar.getTxtDNI().getText().isEmpty()) {
					String dni = this.panelAgregar.getTxtDNI().getText();
					String nombre = this.panelAgregar.getTxtNombre().getText();
					String apellido = this.panelAgregar.getTxtApellido().getText();
			
					Persona personaNueva = new Persona(dni,nombre,apellido);
			
					boolean agregado = pNegocio.insert(personaNueva);	
					if(agregado==true)
					{
						this.panelAgregar.getTxtDNI().setText("");
						this.panelAgregar.getTxtNombre().setText("");
						this.panelAgregar.getTxtApellido().setText("");
					}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Todos los campos deben estar completos","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		
		public void inicializar()
		{
			this.principal.setVisible(true);
			
			
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	
}
