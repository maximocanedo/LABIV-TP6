package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import main.Messages;

import entidad.Persona;
import negocio.LogicResponse;
import negocioImpl.PersonaLogicImpl;
import presentacion.vista.PanelAgregar;

public class PanelAgregarController implements ActionListener {
	
	private PanelAgregar panel;
	
	public PanelAgregarController(PanelAgregar panel) {
		this.panel = panel;
		panel.getBtnAceptar().addActionListener(e->btnAceptarEvent(e));
		panel.getTxtDNI().addKeyListener(onlyNumbersKL);
	}
	public KeyListener onlyNumbersKL = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c)) {
                e.consume(); // Evita que se ingrese el carácter no numérico
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // No necesitamos implementar nada aquí
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // No necesitamos implementar nada aquí
        }
    };
	public void btnAceptarEvent(ActionEvent e) {
		String nombre = panel.getTxtNombre().getText();
		String apellido = panel.getTxtApellido().getText();
		String DNI = panel.getTxtDNI().getText();
		LogicResponse<Persona> validations = PersonaLogicImpl.create(nombre, apellido, DNI, true);
		if(validations.status) {
			PersonaLogicImpl PLI = new PersonaLogicImpl();
			try {
				Persona fulanito = validations.objectReturned;
				LogicResponse<Persona> result = PLI.insert(fulanito);
				if(result.status) {
					JOptionPane.showMessageDialog(null, Messages.getString("AddedSuccessfully"));
					panel.getTxtNombre().setText("");
					panel.getTxtApellido().setText("");
					panel.getTxtDNI().setText("");
				} else {
					JOptionPane.showMessageDialog(null, Messages.getString("ErrorTryingToAddRecord"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, Messages.getString("ErrorTryingToAddRecord"));
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
