package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import entidad.Persona;
import negocio.LogicResponse;
import negocioImpl.PersonaLogicImpl;
import presentacion.vista.PanelListar;

public class PanelListarController implements ActionListener {
	
	private PanelListar panel;
	private PersonaLogicImpl PLI = new PersonaLogicImpl();
	
	public PanelListarController(PanelListar panel) {
		this.panel = panel;
		updateTable();
		this.panel.getBtnActualizar().addActionListener(e->updateTable(e));
	}
	public void updateTable() {
		JTable t = panel.getTable();
		LogicResponse<Persona> res = PLI.getAll();
		if(res.status) {
			List<Persona> list = res.listReturned;
			panel.updateTable(list);
		} else {
			JOptionPane.showMessageDialog(null, "Hubo un error al intentar actualizar la tabla. ");
		}
	}
	public void updateTable(ActionEvent e) {
		updateTable();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
