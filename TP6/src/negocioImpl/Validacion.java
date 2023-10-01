package negocioImpl;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validacion {
	
	public static Boolean txtVacio(JTextField txt) {
		if(txt.getText().trim().length()==0) {
			txt.setBackground(Color.RED);
			return true;
		}
		txt.setBackground(Color.WHITE);
		return false;
	}        
	
	public static boolean verificarNumero(String cadenaNumero) {
		boolean NUMERO_VALIDO = true;
		
		try {
			if(Float.parseFloat(cadenaNumero) < 1.0f || Float.parseFloat(cadenaNumero) > 10.0f) {
				NUMERO_VALIDO=false;
			}
		}catch(Exception e) {
			NUMERO_VALIDO = false;
		}			
		
		return NUMERO_VALIDO;
	}
}
