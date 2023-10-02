package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class PanelListar extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelListar() {
		setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		table = new JTable();
		add(table, "cell 0 0,grow");

	}

}
