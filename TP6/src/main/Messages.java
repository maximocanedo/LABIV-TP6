package main;

import java.beans.Beans;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	////////////////////////////////////////////////////////////////////////////
	//
	// Constructor
	//
	////////////////////////////////////////////////////////////////////////////
	private Messages() {
		// do not instantiate
	}
	////////////////////////////////////////////////////////////////////////////
	//
	// Bundle access
	//
	////////////////////////////////////////////////////////////////////////////
	// Idiomas disponibles:
	public static final String CHAMPIONS_ONLY = "main.messages_es_AR";
	public static final String SPANISH_ONLY = "main.messages_es";
	public static final String ENGLISH_ONLY = "main.messages_en";
	public static final String FRENCH_ONLY = "main.messages_fr";
	public static final String DEUTSCH_ONLY = "main.messages.de";
	// Automático (Usa el idioma del sistema.)
	public static final String AUTOMATIC = "main.messages";
	// Establecer el idioma a utilizar acá:
	public static final String BUNDLE_NAME = CHAMPIONS_ONLY; //$NON-NLS-1$
	// 
	public static final ResourceBundle RESOURCE_BUNDLE = loadBundle();
	public static ResourceBundle loadBundle() {
		return ResourceBundle.getBundle(BUNDLE_NAME);
	}
	////////////////////////////////////////////////////////////////////////////
	//
	// Strings access
	//
	////////////////////////////////////////////////////////////////////////////
	public static String getString(String key) {
		try {
			ResourceBundle bundle = Beans.isDesignTime() ? loadBundle() : RESOURCE_BUNDLE;
			return bundle.getString(key);
		} catch (MissingResourceException e) {
			return "!" + key + "!";
		}
	}
}
