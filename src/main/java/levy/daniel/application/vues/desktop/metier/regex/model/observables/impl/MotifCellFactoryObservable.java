package levy.daniel.application.vues.desktop.metier.regex.model.observables.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import levy.daniel.application.vues.desktop.metier.regex.model.observables.IMotifObservable;


/**
 * CLASSE <b>MotifCellFactoryObservable</b> :<br/>
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
 * @since 1 sept. 2018
 *
 */
public class MotifCellFactoryObservable 
				implements Callback<ListView<IMotifObservable>
									, ListCell<IMotifObservable>> {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(MotifCellFactoryObservable.class);
	
	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MotifCellFactoryObservable() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override	
	public ListCell<IMotifObservable> call(
			final ListView<IMotifObservable> pListview) {
		return new MotifCellObservable();
	} // Fin de call(...)._________________________________________________
	
	
	
} // FIN DE LA CLASSE MotifCellFactoryObservable.----------------------------
