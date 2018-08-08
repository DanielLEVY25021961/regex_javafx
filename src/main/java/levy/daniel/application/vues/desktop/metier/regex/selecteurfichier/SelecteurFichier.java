package levy.daniel.application.vues.desktop.metier.regex.selecteurfichier;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.stage.FileChooser;


/**
 * CLASSE SelecteurFichier :<br/>
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
 * @since 8 août 2018
 *
 */
public class SelecteurFichier {
	// ************************ATTRIBUTS************************************/

	/**
	 * FileChooser (Browser : VUE) pour 
	 * sélectionner un fichier sur un disque dur.<br/>
	 */
	private FileChooser fileChooser = new FileChooser();
	
	/**
	 * titre du FileChooser.<br/>
	 */
	private String titre;
	
	/**
	 * fichier sélectionné par l'utilisateur 
	 * dans le FileChooser.<br/>
	 */
	private File fichierSelectionne;
	
	/**
	 * répertoire sur lequel va pointer 
	 * le FileChooser à son ouverture.<br/>
	 */
	private File repertoirePrefere;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(SelecteurFichier.class);
	
	// *************************METHODES************************************/
	

	
	 /**
	 * .<br/>
	 * <br/>
	 *
	 * @param pTitre
	 * @param pRepertoirePrefere
	 */
	public SelecteurFichier(String pTitre, File pRepertoirePrefere) {
		
		super();
		
		this.titre = pTitre;
		this.repertoirePrefere = pRepertoirePrefere;
		
		this.initialiserFileChooser();
				
	}
	
	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 */
	private void initialiserFileChooser() {
		
		/* met this.titre au panneau du FileChooser. */
		this.fileChooser.setTitle(this.titre);
		
		/* positionne this.fileChooser sur this.repertoirePrefere. */
		this.fileChooser.setInitialDirectory(this.repertoirePrefere);
		
	}


	
	/**
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return this.fileChooser : FileChooser.<br/>
	 */
	public FileChooser getFileChooser() {
		return this.fileChooser;
	}
	
	
	
	
} // FIN DE LA CLASSE SelecteurFichier.--------------------------------------
