package levy.daniel.application.controllers.desktop.metier.regex.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * CLASSE RegexController :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 25 août 2018
 *
 */
public class RegexController {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * .<br/>
	 */
	private final StringProperty texte = new SimpleStringProperty();
	
	
	/**
	 * .<br/>
	 */
	private final StringProperty motifJava = new SimpleStringProperty();
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(RegexController.class);
	// *************************METHODES************************************/


	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public RegexController() {
		
		super();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return this.texte.get() : String.<br/>
	 */
	public final String getTexte() {
		return this.texte.get();
	}
	

	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pTexte : String :  .<br/>
	 */
	public final void setTexte(
			final String pTexte) {
		this.texte.set(pTexte);
	}

	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @return :  :  .<br/>
	 */
	public final StringProperty texteProperty() {
		return this.texte;
	}
	

	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @return :  :  .<br/>
	 */
	public final String getMotifJava() {
		return this.motifJava.get();
	}
	

	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pMotifJava :  :  .<br/>
	 */
	public final void setMotifJava(
			final String pMotifJava) {
		this.motifJava.set(pMotifJava);
	}
	

	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @return :  :  .<br/>
	 */
	public final StringProperty motifJavaProperty() {
		return this.motifJava;
	}

	
	
} // FIN DE LA CLASSE RegexController.---------------------------------------
