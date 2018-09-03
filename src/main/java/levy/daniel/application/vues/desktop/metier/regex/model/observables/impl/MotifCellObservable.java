package levy.daniel.application.vues.desktop.metier.regex.model.observables.impl;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.scene.control.ListCell;
import levy.daniel.application.vues.desktop.metier.regex.model.observables.IMotifCellObservable;
import levy.daniel.application.vues.desktop.metier.regex.model.observables.IMotifObservable;


/**
 * CLASSE <b>MotifCellObservable</b> :<br/>
 * Classe chargée de fabriquer le contenu EDITABLE 
 * d'une cellule d'un ListView EDITABLE.<br/>
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
public class MotifCellObservable extends ListCell<IMotifObservable> 
										implements IMotifCellObservable {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * locale de la plateforme.<br/>
	 */
	private final transient Locale locale = Locale.getDefault();
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(MotifCellObservable.class);
	
	// *************************METHODES************************************/
		
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MotifCellObservable() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateItem(
			final IMotifObservable pItem, 
				final boolean pEmpty) {
		
		super.updateItem(pItem, pEmpty);
		
		String affichage = null;
		final int index = this.getIndex();
		
		if (index %2 == 0) {
			this.setStyle("-fx-background-color: #b3e6b3;");			
		}
		
		if (pItem != null && !pEmpty) {
			
			final String format = "%1$-50s      %2$-45s";
			
			affichage 
			= String.format(
					this.locale
					, format 
					, pItem.getNom(), pItem.getMotifJava());
			
			/* passe la valeur à afficher à la Property text de la cellule. */
			this.setText(affichage);
			
			/* ne met pas de graphique sur la cellule. */
			this.setGraphic(null);
			
		}  else {
			
			this.setText(null);
			this.setGraphic(null);
		}		
		
	} // Fin de updateItem(...).___________________________________________
	
		
	
} // FIN DE LA CLASSE MotifCellObservable.-----------------------------------
