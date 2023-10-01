package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTable;

public class JPlistar extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public JPlistar() {
		super();
		setLayout(null);
		
		table = new JTable();
		table.setBounds(29, 28, 387, 243);
		add(table);
		this.setVisible(true);
	}
}
