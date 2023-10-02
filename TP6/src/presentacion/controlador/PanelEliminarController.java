package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entidad.Persona;
import negocio.LogicResponse;
import negocioImpl.PersonaLogicImpl;
import presentacion.vista.PanelEliminar;

public class PanelEliminarController implements ActionListener {
	
	PanelEliminar panel;
	JList<Persona> jl;
	PersonaLogicImpl PLI = new PersonaLogicImpl();
	
	Persona selected = null;
	
	public PanelEliminarController(PanelEliminar p) {
		panel = p;
		JButton btnEliminar = p.getBtnEliminar();
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(e->btnEliminar_Click(e));
		updateTable();
		jl = panel.getList();
		jl.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
                    // Aquí puedes poner el código que se ejecutará cuando se seleccione un elemento
					if(jl.getSelectedValue() != null) {
						selected = jl.getSelectedValue();	
						btnEliminar.setEnabled(true);				
					} else {
						btnEliminar.setEnabled(false);
					}
                }
			}
		});
	}
	
	public void updateTable() {
		LogicResponse<Persona> result = PLI.getAll();
		if(result.status) {
			List<Persona> list = result.listReturned;
			panel.updateList(list);
		}
	}

	public void btnEliminar_Click(ActionEvent e) {
		if(this.selected != null) {
			int res = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el registro de \"" + this.selected.getNombre() + " " + this.selected.getApellido() + "\" (DNI N.º " + this.selected.getDNI() + ")?", "Confirmar baja de registro", JOptionPane.YES_NO_CANCEL_OPTION);
			if(res == JOptionPane.YES_OPTION) {
				// Sí, eliminar
				try {
					LogicResponse<Persona> result = PLI.delete(this.selected);
					if(result.status) {
						JOptionPane.showMessageDialog(null, "El registro se eliminó con éxito. ");
						updateTable();
					} else {
						JOptionPane.showMessageDialog(null, result.message);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Hubo un problema al intentar eliminar el registro. ");
				}
				
			} else {
				// No eliminar
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
