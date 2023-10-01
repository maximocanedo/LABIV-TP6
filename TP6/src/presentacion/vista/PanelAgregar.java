package presentacion.vista;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PanelAgregar extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public PanelAgregar() {
		setLayout(new MigLayout("", "[][][grow][]", "[][][][][][][]"));
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		add(verticalGlue_1, "cell 1 0");
		
		JLabel lblAgregarUnRegistro = new JLabel("Agregar un registro");
		lblAgregarUnRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarUnRegistro.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		add(lblAgregarUnRegistro, "cell 1 1 2 1,alignx center");
		
		Component verticalGlue = Box.createVerticalGlue();
		add(verticalGlue, "cell 1 2");
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		add(horizontalGlue_1, "cell 0 3");
		
		JLabel lblNombre = new JLabel("Nombre:");
		add(lblNombre, "cell 1 3,alignx trailing");
		
		textField = new JTextField();
		add(textField, "cell 2 3,growx");
		textField.setColumns(10);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		add(horizontalGlue, "cell 3 3");
		
		JLabel lblApellido = new JLabel("Apellido:");
		add(lblApellido, "cell 1 4,alignx trailing");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 2 4,growx");
		textField_1.setColumns(10);
		
		JLabel lblDni = new JLabel("D.N.I.:");
		add(lblDni, "cell 1 5,alignx trailing");
		
		textField_2 = new JTextField();
		add(textField_2, "cell 2 5,growx");
		textField_2.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		add(btnAceptar, "cell 2 6,alignx right");
		
	}

}
