package presentacion.vista;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import main.Messages;

@SuppressWarnings("serial")
public class PanelAgregar extends JPanel {
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JButton btnAceptar;

	/**
	 * Create the panel.
	 */
	public PanelAgregar() {
		setLayout(new MigLayout("", "[grow][100px:n:200px,grow][grow]", "[][][][][][][][][][]"));
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		add(verticalGlue_1, "cell 1 0");
		
		JLabel lblAgregarUnRegistro = new JLabel(Messages.getString("agregarRegistroTitle")) {{ //$NON-NLS-1$
			setFont(Styles.FONT_TITLE);
		}};
		lblAgregarUnRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblAgregarUnRegistro, "cell 1 1,alignx center");
		
		Component verticalGlue = Box.createVerticalGlue();
		add(verticalGlue, "cell 1 2");
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		add(horizontalGlue_1, "cell 0 3");
		
		JLabel lblNombre = new JLabel(Messages.getString("nombreDosPuntos")) {{ //$NON-NLS-1$
			setFont(Styles.FONT_DEFAULT);
		}};
		add(lblNombre, "cell 1 3,alignx left");
		
		Component horizontalGlue = Box.createHorizontalGlue();
		add(horizontalGlue, "cell 2 3");
		
		txtNombre = new JTextField() {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(txtNombre, "cell 1 4,growx");
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel(Messages.getString("apellidoDosPuntos")) {{ //$NON-NLS-1$
			setFont(Styles.FONT_DEFAULT);
		}};
		add(lblApellido, "cell 1 5,alignx left");
		
		txtApellido = new JTextField() {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(txtApellido, "cell 1 6,growx");
		txtApellido.setColumns(10);
		
		JLabel lblDni = new JLabel(Messages.getString("dniDosPuntos")) {{ //$NON-NLS-1$
			setFont(Styles.FONT_DEFAULT);
		}};
		add(lblDni, "cell 1 7,alignx left");
		
		txtDNI = new JTextField() {{
			setFont(Styles.FONT_DEFAULT);
		}};
		add(txtDNI, "cell 1 8,growx");
		txtDNI.setColumns(10);
		
		btnAceptar = new JButton(Messages.getString("accept")) {{ //$NON-NLS-1$
			setFont(Styles.FONT_DEFAULT);
		}};
		add(btnAceptar, "cell 1 9,alignx right");
		
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

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

}
