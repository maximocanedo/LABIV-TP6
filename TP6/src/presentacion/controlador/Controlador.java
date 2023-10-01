package presentacion.controlador;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import entidad.Persona;
import negocio.PersonaNegocio;
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
		this.menu.getMntmAgregar().addActionListener(a->abrirJPagregar(a));
		this.menu.getMntmEliminar().addActionListener(a->abrirJPeliminar(a));
		this.menu.getMntmListar().addActionListener(a->abrirJPlistar(a));
		this.menu.getMntmModificar().addActionListener(a->abrirJPmodificar(a));
		//this.menu.getMntmSalir().addActionListener(a->salir(a));
/*
		this.jpAgregar;
		this.jpEliminar;
		this.jpModificar;*/
	}
	
	public void abrirJPagregar(ActionEvent a) {
		limpiar();
		cambiarPanel(jpAgregar);
		mostrar();
	}
	
	public void abrirJPeliminar(ActionEvent a) {
		limpiar();
		cambiarPanel(jpEliminar);
		mostrar();
	}
	
	public void abrirJPlistar(ActionEvent a) {
		limpiar();
		cambiarPanel(jpListar);
		mostrar();
	}
	
	public void abrirJPmodificar(ActionEvent a) {
		this.menu.getContentPane().removeAll();
		this.menu.getContentPane().add(this.jpModificar);
		this.menu.getContentPane().repaint();
		this.menu.getContentPane().revalidate();
	}
	
	public void limpiar() {
		this.menu.getContentPane().removeAll();
	}
	
	public void mostrar() {
		this.menu.getContentPane().repaint();
		this.menu.getContentPane().revalidate();
	}
	
	public void cambiarPanel(JPanel jp) {
		this.menu.getContentPane().add(jp);
		jp.setVisible(true);
	}

	public void initComponents(Menu mn, PersonaNegocio pNeg) {
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
