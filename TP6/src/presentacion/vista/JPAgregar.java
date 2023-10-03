package presentacion.vista;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
/*
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/

public class JPAgregar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDNI;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JButton btnAceptar;
	private JLabel lblAgregarUnRegistro;
	private Component verticalGlue;
	private Component horizontalGlue;
	private JLabel lblIngreseLosDatos;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component verticalStrut_2;

	
	public JPAgregar() {
		super();
		setBackground(Color.WHITE);
		initLayout();
		initComponents();
		initUI();
		show();
	}
	
	public void show() {
		this.setVisible(true);
	}
	
	private void initLayout() {
		setLayout(new MigLayout("", "[24px:24px:24px][60px:n:300px,grow][60px:n:300px,grow][grow][grow][24px:24px:24px]", "[16px:16px:16px][][][16px:n][][][][][][][][][][]"));
		
	}
	
	private void initComponents() {
	}
	private void initUI() {
		
		verticalGlue = Box.createVerticalGlue();
		add(verticalGlue, "cell 1 0");
		
		horizontalGlue = Box.createHorizontalGlue();
		add(horizontalGlue, "cell 0 1");
		
		lblAgregarUnRegistro = new JLabel("Agregar un registro");
		lblAgregarUnRegistro.setForeground(new Color(0, 51, 153));
		lblAgregarUnRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		add(lblAgregarUnRegistro, "cell 1 1 5 1");
		
		lblIngreseLosDatos = new JLabel("Ingrese los datos de la persona en cuesti\u00F3n.");
		lblIngreseLosDatos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		add(lblIngreseLosDatos, "cell 1 2 5 1");
		
		
		/*btnAceptar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
			}
		});*/
		lblNombre = new JLabel("Nombre:");
		
		add(lblNombre, "cell 1 4 2 1,alignx left,aligny bottom");
		txtNombre = new JTextField();
		
		
		add(txtNombre, "cell 1 5 2 1,growx,aligny top");
		txtNombre.setColumns(10);
		
		verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 8));
		verticalStrut.setMinimumSize(new Dimension(0, 8));
		add(verticalStrut, "cell 1 6");
		lblApellido= new JLabel("Apellido:");
		
		
		add(lblApellido, "cell 1 7 2 1,alignx left,aligny bottom");
		txtApellido = new JTextField();
		
		
		add(txtApellido, "cell 1 8 2 1,growx,aligny top");
		txtApellido.setColumns(10);
		
		verticalStrut_1 = Box.createVerticalStrut(8);
		add(verticalStrut_1, "cell 1 9");
		lblDNI = new JLabel("D.N.I:");
		
		
		add(lblDNI, "cell 1 10,alignx left,aligny bottom");
		txtDNI = new JTextField();
		
		
		add(txtDNI, "cell 1 11 2 1,growx,aligny top");
		txtDNI.setColumns(10);
		
		verticalStrut_2 = Box.createVerticalStrut(8);
		add(verticalStrut_2, "cell 1 12");
		btnAceptar = new JButton("Aceptar");
		add(btnAceptar, "cell 2 13,alignx right,aligny center");

	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblApellido() {
		return lblApellido;
	}

	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	public JLabel getLblDNI() {
		return lblDNI;
	}

	public void setLblDNI(JLabel lblDNI) {
		this.lblDNI = lblDNI;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtDNI() {
		return txtDNI;
	}

	public void setTxtDNI(JTextField txtDNI) {
		this.txtDNI = txtDNI;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	
	
/*	
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

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public GridBagLayout getGridBagLayout() {
		return gridBagLayout;
	}

	public void setGridBagLayout(GridBagLayout gridBagLayout) {
		this.gridBagLayout = gridBagLayout;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public GridBagConstraints getGbc_lblNombre() {
		return gbc_lblNombre;
	}

	public void setGbc_lblNombre(GridBagConstraints gbc_lblNombre) {
		this.gbc_lblNombre = gbc_lblNombre;
	}

	public GridBagConstraints getGbc_textField() {
		return gbc_textField;
	}

	public void setGbc_textField(GridBagConstraints gbc_textField) {
		this.gbc_textField = gbc_textField;
	}

	public JLabel getLblApellido() {
		return lblApellido;
	}

	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	public GridBagConstraints getGbc_lblApellido() {
		return gbc_lblApellido;
	}

	public void setGbc_lblApellido(GridBagConstraints gbc_lblApellido) {
		this.gbc_lblApellido = gbc_lblApellido;
	}

	public GridBagConstraints getGbc_textField_1() {
		return gbc_textField_1;
	}

	public void setGbc_textField_1(GridBagConstraints gbc_textField_1) {
		this.gbc_textField_1 = gbc_textField_1;
	}

	public JLabel getLblDni() {
		return lblDni;
	}

	public void setLblDni(JLabel lblDni) {
		this.lblDni = lblDni;
	}

	public GridBagConstraints getGbc_lblDni() {
		return gbc_lblDni;
	}

	public void setGbc_lblDni(GridBagConstraints gbc_lblDni) {
		this.gbc_lblDni = gbc_lblDni;
	}

	public GridBagConstraints getGbc_textField_2() {
		return gbc_textField_2;
	}

	public void setGbc_textField_2(GridBagConstraints gbc_textField_2) {
		this.gbc_textField_2 = gbc_textField_2;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public GridBagConstraints getGbc_btnAceptar() {
		return gbc_btnAceptar;
	}

	public void setGbc_btnAceptar(GridBagConstraints gbc_btnAceptar) {
		this.gbc_btnAceptar = gbc_btnAceptar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
*/
}
