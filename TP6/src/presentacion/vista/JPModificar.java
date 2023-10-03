package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidad.Persona;

import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;

public class JPModificar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JList<Persona> ltPersona;
	private JButton btnModificar;
	private JLabel lblModificarUnRegistro;
	private JLabel lblElijaUnElemento;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDniN;
	
	public JPModificar() {
		setBackground(Color.WHITE);
		
		initLayout();
		initComponents();
		initUI();
		
	}

	private void initUI() {
		setLayout(new MigLayout("", "[16px:16px:16px][grow][grow][grow][grow][16px:16px:16px]", "[][][234px][][29px]"));
		
		lblModificarUnRegistro = new JLabel("Modificar un registro") {{
			setFont(new Font("Segoe UI", Font.PLAIN, 16));
			setForeground(new Color(0, 51, 153));
		}};
		add(lblModificarUnRegistro, "cell 1 0 4 1");
		
		lblElijaUnElemento = new JLabel("Elija el elemento que desea modificar.") {{
			setFont(new Font("Segoe UI", Font.PLAIN, 12));
		}};
		add(lblElijaUnElemento, "cell 1 1 4 1");
		add(ltPersona, "cell 1 2 4 1,grow");
		
		lblNombre = new JLabel("Nombre:");
		add(lblNombre, "cell 1 3,aligny bottom");
		
		lblApellido = new JLabel("Apellido:");
		add(lblApellido, "cell 2 3,aligny bottom");
		
		lblDniN = new JLabel("D.N.I. N.\u00BA:");
		add(lblDniN, "cell 3 3,aligny bottom");
		add(txtNombre, "cell 1 4,growx,aligny center");
		txtNombre.setColumns(10);
		
		txtApellido.setColumns(10);
		add(txtApellido, "cell 2 4,growx,aligny center");
		
		txtDNI.setColumns(10);
		add(txtDNI, "cell 3 4,growx,aligny center");
		add(btnModificar, "cell 4 4,growx,aligny center");
	}

	private void initComponents() {
		ltPersona = new JList<Persona>();
		ltPersona.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtNombre = new JTextField();
		txtApellido = new JTextField();
		txtDNI = new JTextField();
		btnModificar = new JButton("Modificar");
	}

	private void initLayout() {
		
	}
}
