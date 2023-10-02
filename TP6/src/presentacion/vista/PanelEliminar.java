package presentacion.vista;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PanelEliminar extends JPanel {

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
		
		JList list = new JList() {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(list, "cell 0 2 3 1,grow");
		
		JButton btnEliminar = new JButton("Eliminar") {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(btnEliminar, "cell 1 3,alignx center");

	}

}
