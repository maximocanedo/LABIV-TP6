package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.LogicResponse;
import negocioImpl.PersonaLogicImpl;
import presentacion.vista.PanelAgregar;

public class PanelAgregarController implements ActionListener {
	
	private PanelAgregar panel;
	
	public PanelAgregarController(PanelAgregar panel) {
		this.panel = panel;
		panel.getBtnAceptar().addActionListener(e->btnAceptarEvent(e));
	}
	public void btnAceptarEvent(ActionEvent e) {
		String nombre = panel.getTxtNombre().getText();
		String apellido = panel.getTxtApellido().getText();
		String DNI = panel.getTxtDNI().getText();
		LogicResponse<Persona> validations = PersonaLogicImpl.create(nombre, apellido, DNI);
		if(validations.status) {
			PersonaLogicImpl PLI = new PersonaLogicImpl();
			try {
				Persona fulanito = validations.objectReturned;
				LogicResponse<Persona> result = PLI.insert(fulanito);
				if(result.status) {
					JOptionPane.showMessageDialog(null, "¡El registro se añadió con éxito!");
					panel.getTxtNombre().setText("");
					panel.getTxtApellido().setText("");
					panel.getTxtDNI().setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Error al añadir el registro");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al añadir el registro");
			}
		} else {
			JOptionPane.showMessageDialog(null, validations.message);
			panel.getTxtNombre().setText("");
			panel.getTxtApellido().setText("");
			panel.getTxtDNI().setText("");
			panel.getTxtNombre().grabFocus();
		}
		//JOptionPane.showMessageDialog(null, "¡Presionaste el @btnAceptar!");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
