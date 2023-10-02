package presentacion.controlador;

import java.awt.event.ActionEvent;
import main.Messages;
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
		updateControlState(false);
		this.panel.getBtnModificar().addActionListener(e->btnModificar_Click(e));
		JList<Persona> list = this.panel.getList();
		this.panel.getList().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
                    // Aqu� puedes poner el c�digo que se ejecutar� cuando se seleccione un elemento
					if(list.getSelectedValue() != null) {
						Persona p = list.getSelectedValue();
						panel.getTxtMNombre().setText(p.getNombre());
						panel.getTxtMApellido().setText(p.getApellido());
						panel.getTxtMDNI().setText(p.getDNI());
						selectedDNI = p.getDNI();	
						updateControlState(true);				
					} else {
						updateControlState(false);
					}
                }
			}
		});
		updateList();
	}

	public void updateControlState(boolean b) {
		panel.getBtnModificar().setEnabled(b);
		panel.getTxtMNombre().setEnabled(b);
		panel.getTxtMApellido().setEnabled(b);
		panel.getTxtMDNI().setEnabled(b);
		if(!b) {
			panel.getTxtMNombre().setText("");
			panel.getTxtMApellido().setText("");
			panel.getTxtMDNI().setText("");
		}
	}
	
	public void updateList() {
		LogicResponse<Persona> res = PLI.getAll();
		if(res.status) {
			List<Persona> list = res.listReturned;
			panel.updateList(list);
			
		} else {
			JOptionPane.showMessageDialog(null, Messages.getString("ErrorTryingToUpdateList"));
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
					JOptionPane.showMessageDialog(null, Messages.getString("ModifiedSuccessfully"));					
				} else {
					JOptionPane.showMessageDialog(null, Messages.getString("ErrorTryingToModifyRecord"));					
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, Messages.getString("ErrorTryingToModifyRecord"));
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
