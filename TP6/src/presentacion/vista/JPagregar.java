package presentacion.vista;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class JPagregar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
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
    	super();
		initLayout();
		initComponents();
		initUI();
		
    }
    
	private void initUI() {

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
    	add(txtNombre, gbc_textField);
    	txtNombre.setColumns(10);
    	
    	gbc_lblApellido.anchor = GridBagConstraints.NORTHWEST;
    	gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
    	gbc_lblApellido.gridx = 1;
    	gbc_lblApellido.gridy = 3;
    	add(lblApellido, gbc_lblApellido);
    	
    	txtApellido.setColumns(10);
    	
    	gbc_textField_1.insets = new Insets(0, 0, 5, 5);
    	gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
    	gbc_textField_1.gridx = 3;
    	gbc_textField_1.gridy = 3;
    	add(txtApellido, gbc_textField_1);
    	
    	gbc_lblDni.anchor = GridBagConstraints.NORTH;
    	gbc_lblDni.fill = GridBagConstraints.HORIZONTAL;
    	gbc_lblDni.insets = new Insets(0, 0, 5, 5);
    	gbc_lblDni.gridx = 1;
    	gbc_lblDni.gridy = 5;
    	add(lblDni, gbc_lblDni);
    	
    	txtDNI.setColumns(10);
    	
    	gbc_textField_2.insets = new Insets(0, 0, 5, 5);
    	gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
    	gbc_textField_2.gridx = 3;
    	gbc_textField_2.gridy = 5;
    	add(txtDNI, gbc_textField_2);
    	
    	gbc_btnAceptar.gridwidth = 2;
    	gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
    	gbc_btnAceptar.gridx = 1;
    	gbc_btnAceptar.gridy = 6;
    	add(btnAceptar, gbc_btnAceptar);
    	
    	this.setVisible(true);
		
	}

	private void initComponents() {
		
    	lblNombre = new JLabel("Nombre");
    	lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	gbc_lblNombre = new GridBagConstraints();
    	txtNombre = new JTextField();
    	gbc_textField = new GridBagConstraints();
    	lblApellido = new JLabel("Apellido");
    	lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gbc_textField_1 = new GridBagConstraints();
    	gbc_lblApellido = new GridBagConstraints();
    	gbc_lblDni = new GridBagConstraints();
    	txtDNI = new JTextField();
    	btnAceptar = new JButton("Aceptar");
    	gbc_btnAceptar = new GridBagConstraints();
    	gbc_textField_2 = new GridBagConstraints();
    	txtApellido = new JTextField();
    	lblDni = new JLabel("Dni");
    	lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}

	private void initLayout() {
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{60, 37, 98, 153, 0, 0};
    	gridBagLayout.rowHeights = new int[]{56, 20, 31, 14, 31, 14, 0, 0};
    	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
    	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    	setLayout(gridBagLayout);
    	
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtDNI() {
		return txtDNI;
	}

	public void setTxtDNI(JTextField txtDNI) {
		this.txtDNI = txtDNI;
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


}
