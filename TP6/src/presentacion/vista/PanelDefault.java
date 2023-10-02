package presentacion.vista;

import javax.swing.ImageIcon;
import main.Messages;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.net.URL;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;

@SuppressWarnings("serial")
public class PanelDefault extends JPanel {

	/**
	 * Create the panel.
	 */
	 
	public PanelDefault() {
		setLayout(new MigLayout("", "[grow][grow][grow]", "[72px][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		Pic pic = new Pic();
		Dimension sz = new Dimension(48,48);
		pic.setSize(100, 100);
		pic.setMinimumSize(sz);
		add(pic, "cell 1 0,alignx center,aligny center");
		repaint();
		
		JLabel lblTrabajoPrcticoN = new JLabel(Messages.getString("tpn6")) {{ //$NON-NLS-1$
			setFont(Styles.FONT_TITLE);
		}};
		add(lblTrabajoPrcticoN, "cell 1 1,alignx center");
		
		JLabel lblResolucinIndividualDe = new JLabel(Messages.getString("resolucionDeMaximo")); //$NON-NLS-1$
		lblResolucinIndividualDe.setFont(Styles.FONT_DEFAULT);
		add(lblResolucinIndividualDe, "cell 1 2,alignx center");
		
		JLabel lblLaboratorioDeComputacin = new JLabel(Messages.getString("labiv")); //$NON-NLS-1$
		lblLaboratorioDeComputacin.setFont(Styles.FONT_DEFAULT);
		add(lblLaboratorioDeComputacin, "cell 1 3,alignx center");
		
		JLabel lblUniversidadTecnolgicaNacional = new JLabel(Messages.getString("utn")); //$NON-NLS-1$
		lblUniversidadTecnolgicaNacional.setFont(Styles.FONT_DEFAULT);
		add(lblUniversidadTecnolgicaNacional, "cell 1 4,alignx center");
		
		JLabel lblFacultadRegionalGeneral = new JLabel(Messages.getString("frgp")); //$NON-NLS-1$
		lblFacultadRegionalGeneral.setFont(Styles.FONT_DEFAULT);
		add(lblFacultadRegionalGeneral, "cell 1 5,alignx center");

	}

}
