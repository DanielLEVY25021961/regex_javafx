package levy.daniel.application.vues.desktop.metier.regex.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import levy.daniel.application.model.metier.regex.IMotif;


/**
 * CLASSE <b>MotifCellFactory</b> :<br/>
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
 * @since 28 août 2018
 *
 */
public class MotifCellFactory 
		implements Callback<ListView<IMotif>, ListCell<IMotif>> {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(MotifCellFactory.class);
	
	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MotifCellFactory() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override	
	public ListCell<IMotif> call(
			final ListView<IMotif> pListview) {
		return new MotifCell();
	} // Fin de call(...)._________________________________________________
	
	
	
} // FIN DE LA CLASSE MotifCellFactory.--------------------------------------
