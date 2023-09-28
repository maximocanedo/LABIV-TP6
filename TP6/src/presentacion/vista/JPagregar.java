package presentacion.vista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidad.Persona;
import javax.swing.SpringLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class JPagregar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private GridBagLayout gridBagLayout;
	private JLabel lblNombre;
	private GridBagConstraints gbc_lblNombre;
	private GridBagConstraints gbc_textField;
	private JLabel lblApellido;
	private GridBagConstraints gbc_lblApellido;
	private GridBagConstraints gbc_textField_1;
	private JLabel lblDni;
	private GridBagConstraints gbc_lblDni;
	private GridBagConstraints gbc_textField_2;
	private JButton btnAceptar;
	private GridBagConstraints gbc_btnAceptar;
	
    public JPagregar() {
		initLayout();
		initComponents();
		initUI();
		initListeners();
		
    	
        
        
    
    }
    
    

	private void initListeners() {
		// TODO Auto-generated method stub
		
	}



	private void initUI() {

    	gridBagLayout.columnWidths = new int[]{60, 37, 98, 153, 0, 0};
    	gridBagLayout.rowHeights = new int[]{56, 20, 31, 14, 31, 14, 0, 0};
    	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
    	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    	setLayout(gridBagLayout);
    	
    	gbc_lblNombre.anchor = GridBagConstraints.WEST;
    	gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
    	gbc_lblNombre.gridx = 1;
    	gbc_lblNombre.gridy = 1;
    	add(lblNombre, gbc_lblNombre);
    	
    	gbc_textField.anchor = GridBagConstraints.NORTH;
    	gbc_textField.fill = GridBagConstraints.HORIZONTAL;
    	gbc_textField.insets = new Insets(0, 0, 5, 5);
    	gbc_textField.gridx = 3;
    	gbc_textField.gridy = 1;
    	add(textField, gbc_textField);
    	textField.setColumns(10);
    	
    	gbc_lblApellido.anchor = GridBagConstraints.NORTHWEST;
    	gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
    	gbc_lblApellido.gridx = 1;
    	gbc_lblApellido.gridy = 3;
    	add(lblApellido, gbc_lblApellido);
    	
    	textField_1.setColumns(10);
    	
    	gbc_textField_1.insets = new Insets(0, 0, 5, 5);
    	gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
    	gbc_textField_1.gridx = 3;
    	gbc_textField_1.gridy = 3;
    	add(textField_1, gbc_textField_1);
    	
    	gbc_lblDni.anchor = GridBagConstraints.NORTH;
    	gbc_lblDni.fill = GridBagConstraints.HORIZONTAL;
    	gbc_lblDni.insets = new Insets(0, 0, 5, 5);
    	gbc_lblDni.gridx = 1;
    	gbc_lblDni.gridy = 5;
    	add(lblDni, gbc_lblDni);
    	
    	textField_2.setColumns(10);
    	
    	gbc_textField_2.insets = new Insets(0, 0, 5, 5);
    	gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
    	gbc_textField_2.gridx = 3;
    	gbc_textField_2.gridy = 5;
    	add(textField_2, gbc_textField_2);
    	
    	gbc_btnAceptar.gridwidth = 2;
    	gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
    	gbc_btnAceptar.gridx = 1;
    	gbc_btnAceptar.gridy = 6;
    	add(btnAceptar, gbc_btnAceptar);
		
	}



	private void initComponents() {
		gridBagLayout = new GridBagLayout();
    	lblNombre = new JLabel("Nombre");
    	gbc_lblNombre = new GridBagConstraints();
    	textField = new JTextField();
    	gbc_textField = new GridBagConstraints();
    	lblApellido = new JLabel("Apellido");
		
	}



	private void initLayout() {
		gbc_textField_1 = new GridBagConstraints();
    	gbc_lblApellido = new GridBagConstraints();
    	textField_1 = new JTextField();
    	lblDni = new JLabel("Dni");
    	gbc_lblDni = new GridBagConstraints();
    	textField_2 = new JTextField();
    	btnAceptar = new JButton("Aceptar");
    	gbc_btnAceptar = new GridBagConstraints();
    	gbc_textField_2 = new GridBagConstraints();
			
	}



	/**
	 * 
	 */
	

	

}
