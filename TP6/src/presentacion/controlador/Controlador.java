package presentacion.controlador;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.Validacion;
import presentacion.vista.JPagregar;
import presentacion.vista.JPeliminar;
import presentacion.vista.JPlistar;
import presentacion.vista.JPmodificar;
import presentacion.vista.Menu;
import java.awt.Font;

public class Controlador implements ActionListener{

	private Menu menu;
	private JPagregar jpAgregar;
	private JPeliminar jpEliminar;
	private JPmodificar jpModificar;
	private JPlistar jpListar;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personas;
	
	public Controlador(Menu mn, PersonaNegocio pNeg) {
		
		initComponents(mn, pNeg);
		initListeners();
		
	}
	
	public void initListeners() {
		//Hacemos uso de expresion lambda 
		//para no usar clases anonimas en los parametros
		menuListener();
		this.jpAgregar.getBtnAceptar().addActionListener(a-> agregarListener(a));
		//eliminarListener();
		//modificarListener();
		//listarListener();

	}
	
	private void agregarListener(ActionEvent a) {
		
		String nombre = this.jpAgregar.getTxtNombre().getText();
		String apellido = this.jpAgregar.getTxtApellido().getText();
		String dni = this.jpAgregar.getTxtDNI().getText();
		
		Persona persona = new Persona(dni, nombre, apellido);
		
		Boolean nombreVacio= Validacion.txtVacio(jpAgregar.getTxtNombre());
		Boolean apellidoVacio= Validacion.txtVacio(jpAgregar.getTxtApellido());
		Boolean DNIvacio= Validacion.txtVacio(jpAgregar.getTxtDNI());;
		if(nombreVacio || apellidoVacio || DNIvacio) JOptionPane.showMessageDialog(null,"Debe ingresar todos los campos","Validando Datos",
				JOptionPane.ERROR_MESSAGE);
		if(!Validacion.verificarNumero(dni))  
			JOptionPane.showMessageDialog(null,"Debe ingresar numeros en DNI","Validando Datos",
					JOptionPane.ERROR_MESSAGE);
	
		
		boolean personaAgregada = pNeg.insert(persona);
		String mensaje= "";
		if(personaAgregada)
		{
			mensaje="Persona agregada con exito";
			
		}
		else
			mensaje="Fallo al agregar persona!";
		
		this.jpAgregar.limpiarCampos();
		JOptionPane.showMessageDialog(null,mensaje,"Validando Datos",
				JOptionPane.INFORMATION_MESSAGE);
		
		
	}

	private void menuListener() {
		this.menu.getMntmAgregar().addActionListener(e -> cambiarJP(jpAgregar));
		this.menu.getMntmEliminar().addActionListener(e->cambiarJP(jpEliminar));
		this.menu.getMntmListar().addActionListener(e->cambiarJP(jpListar));
		this.menu.getMntmModificar().addActionListener(a->cambiarJP(jpModificar));
		this.menu.getMntmSalir().addActionListener(a->salir(a));
	}
	
	private void salir(ActionEvent a) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	private void cambiarJP(JPanel jp) {
		limpiar();
		cambiarPanel(jp);
		mostrar();
	}
	
	private void limpiar() {
		this.menu.getContentPane().removeAll();
	}
	
	private void mostrar() {
		this.menu.getContentPane().repaint();
		this.menu.getContentPane().revalidate();
	}
	
	private void cambiarPanel(JPanel jp) {
		this.menu.getContentPane().add(jp);
	}

	private void initComponents(Menu mn, PersonaNegocio pNeg) {
		this.menu= mn;
		this.setpNeg(pNeg);
		this.jpAgregar= new JPagregar();
		this.jpListar= new JPlistar();
		this.jpEliminar= new JPeliminar();
		this.jpModificar= new JPmodificar();
	}

	public void init() {
		
		this.menu.setVisible(true);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	public PersonaNegocio getpNeg() {
		return pNeg;
	}

	public void setpNeg(PersonaNegocio pNeg) {
		this.pNeg = pNeg;
	}
}
