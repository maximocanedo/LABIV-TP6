package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import presentacion.vista.PanelEliminar;

public class PanelEliminarController implements ActionListener {
	
	PanelEliminar panel;
	
	public PanelEliminarController(PanelEliminar p) {
		panel = p;
		JButton btnEliminar = p.getBtnEliminar();
		btnEliminar.addActionListener(e->btnEliminar_Click(e));
	}

	public void btnEliminar_Click(ActionEvent e) {
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
