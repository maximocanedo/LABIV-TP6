package presentacion.vista;

import javax.swing.JPanel;

import entidad.Persona;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PanelEliminar extends JPanel {
	private DefaultListModel<Persona> dlmPersona;
	private JList<Persona> list;
	private JButton btnEliminar;
	public DefaultListModel<Persona> getDlmPersona() {
		return dlmPersona;
	}
	public void setDlmPersona(DefaultListModel<Persona> dlmPersona) {
		this.dlmPersona = dlmPersona;
	}
	public JList<Persona> getList() {
		return list;
	}
	public void setList(JList<Persona> list) {
		this.list = list;
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
	/**
	 * Create the panel.
	 */
	public PanelEliminar() {
		setLayout(new MigLayout("", "[grow][grow][grow]", "[][][grow][]"));
		
		JLabel lblEliminarUnRegistro = new JLabel("Eliminar un registro") {{
			setFont(Styles.FONT_TITLE);
		}};
		add(lblEliminarUnRegistro, "cell 1 0,alignx center");
		
		JLabel lblSeleccioneEnLa = new JLabel("Seleccione en la lista el elemento a eliminar:") {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(lblSeleccioneEnLa, "cell 1 1,alignx center");
		
		list = new JList<Persona>() {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(list, "cell 0 2 3 1,grow");
		
		btnEliminar = new JButton("Eliminar") {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(btnEliminar, "cell 1 3,alignx center");

	}

}
