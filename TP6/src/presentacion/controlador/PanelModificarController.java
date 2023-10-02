package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entidad.Persona;
import negocio.LogicResponse;
import negocioImpl.PersonaLogicImpl;
import presentacion.vista.PanelModificar;

public class PanelModificarController implements ActionListener {
	
	private PanelModificar panel;
	private PersonaLogicImpl PLI = new PersonaLogicImpl();
	private String selectedDNI = "a";
	
	public PanelModificarController(PanelModificar panel) {
		this.panel = panel;
		this.panel.getBtnModificar().addActionListener(e->btnModificar_Click(e));
		JList<Persona> list = this.panel.getList();
		this.panel.getList().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
                    // Aquí puedes poner el código que se ejecutará cuando se seleccione un elemento
					if(list.getSelectedValue() != null) {
						Persona p = list.getSelectedValue();
						panel.getTxtMNombre().setText(p.getNombre());
						panel.getTxtMApellido().setText(p.getApellido());
						panel.getTxtMDNI().setText(p.getDNI());
						selectedDNI = p.getDNI();						
					}
                }
			}
		});
		updateList();
	}

	public void updateList() {
		LogicResponse<Persona> res = PLI.getAll();
		if(res.status) {
			List<Persona> list = res.listReturned;
			panel.updateList(list);
			
		} else {
			JOptionPane.showMessageDialog(null, "Hubo un problema al intentar actualizar la lista. ");
		}
	}
	
	public void btnModificar_Click(ActionEvent e) {
		String nombre = panel.getTxtMNombre().getText();
		String apellido = panel.getTxtMApellido().getText();
		String DNI = panel.getTxtMDNI().getText();
		if(selectedDNI == "a") {
			return;
		}
		LogicResponse<Persona> res = PersonaLogicImpl.create(nombre, apellido, DNI);
		Persona p = res.objectReturned;
		if(res.status) {
			try {
				LogicResponse<Persona> result = PLI.modify(p, selectedDNI);
				if(result.status) {
					JOptionPane.showMessageDialog(null, "¡El registro se actualizó con éxito!");					
				} else {
					JOptionPane.showMessageDialog(null, "Hubo un error al intentar actualizar el registro. ");					
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Hubo un error al intentar actualizar el registro. ");
				e1.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, res.message);
		}
		updateList();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
