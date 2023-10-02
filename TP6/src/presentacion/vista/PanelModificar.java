package presentacion.vista;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PanelModificar extends JPanel {
	private JTextField txtMNombre;
	private JTextField txtMApellido;
	private JTextField txtMDNI;

	/**
	 * Create the panel.
	 */
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
		
		JList list = new JList() {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(list, "cell 0 2 4 1,grow");
		
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
		
		JButton btnModificar = new JButton("Modificar") {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(btnModificar, "cell 3 4,growx,aligny center");

	}

}
