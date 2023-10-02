package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.Validacion;
import presentacion.vista.JPagregar;
import presentacion.vista.JPeliminar;
import presentacion.vista.JPlistar;
import presentacion.vista.JPmodificar;
import presentacion.vista.Menu;

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
		this.jpModificar.getBtnModificar().addActionListener(a-> btnModificarListener(a));
		this.jpModificar.getLtPersona().addListSelectionListener(l-> ltPersonaModificarListener(l));
		this.jpEliminar.getBtEliminar().addActionListener(e-> btnEliminarListener(e));

	}
	
	private void btnEliminarListener(ActionEvent e) {
		if(this.jpEliminar.getLtPersonas().getSelectedIndex()!=-1) {
			Persona persona = this.jpEliminar.getLtPersonas().getModel().getElementAt(this.jpEliminar.getLtPersonas().getSelectedIndex());

			boolean personaEliminada = pNeg.delete(persona);
			String mensaje= "";
			if(personaEliminada)
				mensaje="Persona eliminada con exito";
			else
				mensaje="Fallo al eliminar persona!";
			
			JOptionPane.showMessageDialog(null,mensaje,"Validando Datos",
					JOptionPane.INFORMATION_MESSAGE);
			this.personas = (ArrayList<Persona>) pNeg.readAll();
			this.jpEliminar.llenarJlist(this.personas);
		}
	}

	private void ltPersonaModificarListener(ListSelectionEvent l) {
		// TODO Auto-generated method stub
		if(this.jpModificar.getLtPersona().getSelectedIndex()!=-1) {
			Persona personaSeleccionada = this.jpModificar.getLtPersona().getModel().getElementAt(this.jpModificar.getLtPersona().getSelectedIndex());

			this.jpModificar.getTxtNombre().setText(personaSeleccionada.getNombre());
			this.jpModificar.getTxtApellido().setText(personaSeleccionada.getApellido());
			this.jpModificar.getTxtDNI().setText(personaSeleccionada.getDni());
		}
	}

	private void btnModificarListener(ActionEvent a) {
		String nombre = this.jpModificar.getTxtNombre().getText().toString();
		String apellido = this.jpModificar.getTxtApellido().getText().toString();
		String dni = this.jpModificar.getTxtDNI().getText().toString();
		
		Persona persona = new Persona(dni, nombre, apellido);
		
		Boolean nombreVacio= Validacion.txtVacio(jpModificar.getTxtNombre());
		Boolean apellidoVacio= Validacion.txtVacio(jpModificar.getTxtApellido());
		Boolean DNIvacio= Validacion.txtVacio(jpModificar.getTxtDNI());;
		if(nombreVacio || apellidoVacio || DNIvacio) JOptionPane.showMessageDialog(null,"Debe ingresar todos los campos","Validando Datos",
				JOptionPane.ERROR_MESSAGE);
		if(Validacion.verificarNumero(dni))  
			JOptionPane.showMessageDialog(null,"Debe ingresar numeros en DNI","Validando Datos",
					JOptionPane.ERROR_MESSAGE);
	
		
		boolean personaModificada = pNeg.modify(persona);
		String mensaje= "";
		if(personaModificada)
			mensaje="Persona modificada con exito";
		else
			mensaje="Fallo al modificar persona!";
		
		JOptionPane.showMessageDialog(null,mensaje,"Validando Datos",
				JOptionPane.INFORMATION_MESSAGE);
		this.personas = (ArrayList<Persona>) pNeg.readAll();
		this.jpModificar.llenarJlist(this.personas);
	}

	private void agregarListener(ActionEvent a) {
		
		String nombre = this.jpAgregar.getTxtNombre().getText().toString();
		String apellido = this.jpAgregar.getTxtApellido().getText().toString();
		String dni = this.jpAgregar.getTxtDNI().getText().toString();
		
		Persona persona = new Persona(dni, nombre, apellido);
		
		Boolean nombreVacio= Validacion.txtVacio(jpAgregar.getTxtNombre());
		Boolean apellidoVacio= Validacion.txtVacio(jpAgregar.getTxtApellido());
		Boolean DNIvacio= Validacion.txtVacio(jpAgregar.getTxtDNI());;
		if(nombreVacio || apellidoVacio || DNIvacio) JOptionPane.showMessageDialog(null,"Debe ingresar todos los campos","Validando Datos",
				JOptionPane.ERROR_MESSAGE);
		if(Validacion.verificarNumero(dni))  
			JOptionPane.showMessageDialog(null,"Debe ingresar numeros en DNI","Validando Datos",
					JOptionPane.ERROR_MESSAGE);
	
		
		boolean personaAgregada = pNeg.insert(persona);
		String mensaje= "";
		if(personaAgregada)
			mensaje="Persona agregada con exito";
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
		this.personas = (ArrayList<Persona>) pNeg.readAll();
		if (jp == this.jpListar) {
			
			this.jpListar.llenarTabla(this.personas);
		}
		if (jp == this.jpEliminar) {
			
			this.jpEliminar.llenarJlist(this.personas);
		}
		
		if (jp == this.jpModificar) {
			this.jpModificar.llenarJlist(this.personas);
		}
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
