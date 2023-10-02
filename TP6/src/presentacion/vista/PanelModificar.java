package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import entidad.Persona;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PanelModificar extends JPanel {
	private JTextField txtMNombre;
	private JTextField txtMApellido;
	private JTextField txtMDNI;
	private JList<Persona> list;
	private DefaultListModel<Persona> dlmPersonas;
	private JButton btnModificar;

	public JButton getBtnModificar() {
		return btnModificar;
	}
	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}
	/**
	 * Create the panel.
	 * @return 
	 */
	public void updateList(List<Persona> newList) {
		dlmPersonas.clear();
		for(Persona p : newList) {
			dlmPersonas.addElement(p);
		}
	}
	public PanelModificar() {
		setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[][][grow][][]"));
		
		JLabel lblModificarUnRegistro = new JLabel("Modificar un registro") {{
			setFont(Styles.FONT_TITLE);
		}};
		add(lblModificarUnRegistro, "cell 0 0 4 1,alignx center");
		
		JLabel lblSeleccioneElRegistro = new JLabel("Seleccione el registro que desea modificar:") {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(lblSeleccioneElRegistro, "cell 0 1 4 1,alignx center");
		dlmPersonas = new DefaultListModel<Persona>();
		JScrollPane spPersonas = new JScrollPane();
		list = new JList<Persona>() {{
			setFont(Styles.FONT_DEFAULT);
			setModel(dlmPersonas);
		}};
		add(spPersonas, "cell 0 2 4 1,grow");
		spPersonas.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("Nombre:") {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(lblNewLabel, "cell 0 3");
		
		JLabel lblApellido = new JLabel("Apellido:") {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(lblApellido, "cell 1 3");
		
		JLabel lblDniN = new JLabel("D.N.I. N.\u00BA:") {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(lblDniN, "cell 2 3");
		
		txtMNombre = new JTextField() {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(txtMNombre, "cell 0 4,growx,aligny center");
		txtMNombre.setColumns(10);
		
		txtMApellido = new JTextField() {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(txtMApellido, "cell 1 4,growx,aligny center");
		txtMApellido.setColumns(10);
		
		txtMDNI = new JTextField() {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(txtMDNI, "cell 2 4,growx,aligny center");
		txtMDNI.setColumns(10);
		
		btnModificar = new JButton("Modificar") {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(btnModificar, "cell 3 4,growx,aligny center");
		

	}
	public JTextField getTxtMNombre() {
		return txtMNombre;
	}
	public void setTxtMNombre(JTextField txtMNombre) {
		this.txtMNombre = txtMNombre;
	}
	public JTextField getTxtMApellido() {
		return txtMApellido;
	}
	public void setTxtMApellido(JTextField txtMApellido) {
		this.txtMApellido = txtMApellido;
	}
	public JTextField getTxtMDNI() {
		return txtMDNI;
	}
	public void setTxtMDNI(JTextField txtMDNI) {
		this.txtMDNI = txtMDNI;
	}
	public JList<Persona> getList() {
		return list;
	}
	public void setList(JList<Persona> list) {
		this.list = list;
	}
	public DefaultListModel<Persona> getDlmPersonas() {
		return dlmPersonas;
	}
	public void setDlmPersonas(DefaultListModel<Persona> dlmPersonas) {
		this.dlmPersonas = dlmPersonas;
	}

}
