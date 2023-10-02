package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entidad.Persona;
import negocio.LogicResponse;
import negocioImpl.PersonaLogicImpl;
import main.Messages;
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
                    // Aqu� puedes poner el c�digo que se ejecutar� cuando se seleccione un elemento
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
			String fullName = "\"" + this.selected.getNombre() + " " + this.selected.getApellido() + "\"";
			String dnis = this.selected.getDNI();
			MessageFormat patronRUSD = new MessageFormat(Messages.getString("AreYouSureDelete"));
			Object[] patronRUSDP = {fullName, dnis};
			String formattedRUSD = patronRUSD.format(patronRUSDP);
			int res = JOptionPane.showConfirmDialog(null, 
					formattedRUSD, Messages.getString("AreYouSureDeleteTitle"), JOptionPane.YES_NO_CANCEL_OPTION);
			if(res == JOptionPane.YES_OPTION) {
				// S�, eliminar
				try {
					LogicResponse<Persona> result = PLI.delete(this.selected);
					if(result.status) {
						JOptionPane.showMessageDialog(null, Messages.getString("DeletedSuccessfully"));
						updateTable();
					} else {
						JOptionPane.showMessageDialog(null, result.message);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, Messages.getString("ErrorTryingToDeleteRecord"));
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
