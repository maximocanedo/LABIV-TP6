package presentacion.vista;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.net.URL;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class PanelDefault extends JPanel {

	/**
	 * Create the panel.
	 */
	 
	public PanelDefault() {
		setLayout(new MigLayout("", "[grow][grow][grow]", "[72px][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		PanelLogoUTN panelLogoUTN = new PanelLogoUTN();

		
		add(panelLogoUTN, "cell 1 0,alignx center,growy");
		
		JLabel lblTrabajoPrcticoN = new JLabel("Trabajo Pr\u00E1ctico N.\u00BA 6") {{
			setFont(Styles.FONT_TITLE);
		}};
		add(lblTrabajoPrcticoN, "cell 1 1,alignx center");
		
		JLabel lblResolucinIndividualDe = new JLabel("Resoluci\u00F3n individual de M\u00E1ximo Canedo");
		lblResolucinIndividualDe.setFont(Styles.FONT_DEFAULT);
		add(lblResolucinIndividualDe, "cell 1 2,alignx center");
		
		JLabel lblLaboratorioDeComputacin = new JLabel("Laboratorio de Computaci\u00F3n IV");
		lblLaboratorioDeComputacin.setFont(Styles.FONT_DEFAULT);
		add(lblLaboratorioDeComputacin, "cell 1 3,alignx center");
		
		JLabel lblUniversidadTecnolgicaNacional = new JLabel("Universidad Tecnol\u00F3gica Nacional");
		lblUniversidadTecnolgicaNacional.setFont(Styles.FONT_DEFAULT);
		add(lblUniversidadTecnolgicaNacional, "cell 1 4,alignx center");
		
		JLabel lblFacultadRegionalGeneral = new JLabel("Facultad Regional General Pacheco");
		lblFacultadRegionalGeneral.setFont(Styles.FONT_DEFAULT);
		add(lblFacultadRegionalGeneral, "cell 1 5,alignx center");

	}

}
