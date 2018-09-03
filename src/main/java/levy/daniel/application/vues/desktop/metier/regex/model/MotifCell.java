package levy.daniel.application.vues.desktop.metier.regex.model;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.scene.control.ListCell;
import levy.daniel.application.model.metier.regex.IMotif;


/**
 * CLASSE <b>MotifCell</b> :<br/>
 * Classe chargée de fabriquer le contenu 
 * d'une cellule d'un ListView.<br/>
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
public class MotifCell extends ListCell<IMotif> {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * locale de la plateforme.<br/>
	 */
	private final transient Locale locale = Locale.getDefault();
	
	/**
	 * "#ecf1f6".<br/>
	 */
	public static final String COULEUR_BLEU_PALE_TABLEAU = "#ecf1f6";
	
	/**
	 * "#b3e6b3".<br/>
	 */
	public static final String COULEUR_VERT_INTENSE_TABLEAU = "#b3e6b3";
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(MotifCell.class);
	
	// *************************METHODES************************************/
		
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MotifCell() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateItem(
			final IMotif pItem, 
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
			
			/* passe la valeur à la Property text de la cellule. */
			this.setText(affichage);
			
			/* ne met pas de graphique sur la cellule. */
			this.setGraphic(null);
			
		}  else {
			
			this.setText(null);
			this.setGraphic(null);
		}		
		
	} // Fin de updateItem(...).___________________________________________
	
		
	
} // FIN DE LA CLASSE MotifCell.---------------------------------------------
