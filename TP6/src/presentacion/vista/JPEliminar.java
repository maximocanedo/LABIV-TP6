package presentacion.vista;

import javax.swing.JPanel;

import entidad.Persona;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;

public class JPEliminar extends JPanel {

	private JLabel lblEliminarUsuarios;
	private JList<Persona> ltPersonas;
	
	private static final long serialVersionUID = 1L;
	private JButton btnEliminar;
	private JLabel lblSeleccioneElRegistro;

	public JPEliminar() {
		setBackground(Color.WHITE);
		initLayout();
		initComponents();
		initUI();
	}

	private void initUI() {
		setLayout(new MigLayout("", "[16px:16px:16px][grow][16px:16px:16px]", "[14px][][193px][23px]"));
		add(lblEliminarUsuarios, "cell 1 0,growx,aligny center");
		
		lblSeleccioneElRegistro = new JLabel("Seleccione el registro que desee eliminar.") {{
			setFont(new Font("Segoe UI", Font.PLAIN, 12));
		}};
		add(lblSeleccioneElRegistro, "cell 1 1");
		add(ltPersonas, "cell 1 2,grow");
		
		btnEliminar = new JButton("Eliminar");
		add(btnEliminar, "cell 1 3,alignx center,aligny center");
		
	}

	private void initComponents() {
		lblEliminarUsuarios = new JLabel("Eliminar un registro")  {{
			setFont(new Font("Segoe UI", Font.PLAIN, 16));
			setForeground(new Color(0, 51, 153));
		}};
		ltPersonas = new JList<Persona>();
		ltPersonas.setBorder(new LineBorder(Color.LIGHT_GRAY));
	}

	private void initLayout() {
		
	}
}
