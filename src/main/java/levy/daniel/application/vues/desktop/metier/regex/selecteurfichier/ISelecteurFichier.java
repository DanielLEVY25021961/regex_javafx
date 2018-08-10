package levy.daniel.application.vues.desktop.metier.regex.selecteurfichier;

import java.io.File;
import java.nio.charset.Charset;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * INTERFACE ISelecteurFichier :<br/>
 * Interface factorisant les comportements des SelecteurFichier concrets.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * <code><i>// Instancie un SelecteurFichier 
 * et configure son FileChooser en le positionnant 
 * sur le répertoire préféré.</i></code><br/>
 * <code><b>ISelecteurFichier selecteur 
 * = new SelecteurFichier(titre, 
 * GestionnairePreferencesSelecteur.getRepertoirePrefereFileChooser());</b></code><br/>
 * <code><i>// Ouvre le FileChooser sur le répertoire mémorisé, 
 * permet la sélection d'un fichier et lit le 
 * contenu du fichier en UTF8.<br/>
 * // Mémorise éventuellement le nouveau répertoire.</i></code><br/>
 * <code><b>selecteur.selectionnerEtLire(pPrimaryStage);</b></code><br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * FileChooser, Properties, fichier properties, préférences, <br/>
 * preferences, lire le contenu d'un fichier, lire fichier, <br/>
 * créer une String à partir d'une liste de lignes,<br/>
 * mémoriser répertoire, écrire repertoire dans préférences,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 10 août 2018
 *
 */
public interface ISelecteurFichier {


	/**
	 * "méthode lireStringsDansFile(File pFile, Charset pCharset)".<br/>
	 */
	String METHODE_LIRE_STRINGS_DANS_FILE 
		= "méthode lireStringsDansFile(File pFile, Charset pCharset)";
	
	/**
	 * " - ".<br/>
	 */
	String SEPARATEUR_MOINS_AERE = " - ";
	
	
	//*****************************************************************/
	//**************************** CHARSETS ***************************/
	//*****************************************************************/
	/**
	 * Charset.forName("UTF-8").<br/>
	 * Eight-bit Unicode (or UCS) Transformation Format.<br/> 
	 */
	Charset CHARSET_UTF8 = Charset.forName("UTF-8");
	
	
	//*****************************************************************/
	//**************************** SAUTS ******************************/
	//*****************************************************************/	
	/**
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	String NEWLINE = System.getProperty("line.separator");
	
	

	/**
	 * Ouvre un FileChooser, permet la sélection d'un fichier, 
	 * et retourne son contenu sous forme de String.<br/>
	 * <ul>
	 * <li>Ouvre le FileChooser et récupère le fichier sélectionné.</li>
	 * <li>Mémorise le répertoire de sélection dans les préférences.</li>
	 * <li>Lit le contenu du fichier sélectionné en UTF8.</li>
	 * <li>retourne le contenu sous forme de String.</li>
	 * <li>alimente les attributs <code>this.fichierSelectionne, 
	 * this.contenuFichierSelectionne, this.repertoirePrefere</code></li>
	 * </ul>
	 *
	 * @param pStage : Stage : Fenêtre (théâtre) 
	 * englobant le FileChooser.<br/> Peut être null.<br/>
	 * 
	 * @return String : le contenu du fichier.<br/>
	 * 
	 * @throws Exception
	 */
	String selectionnerEtLire(Stage pStage) throws Exception;
	
	

	/**
	 * Ouvre le FileChooser et récupère le fichier sélectionné.<br/>
	 * Ne peut sélectionner qu'un fichier simple 
	 * par construction du FileChooser.<br/>
	 * Mémorise le répertoire de sélection dans les préférences.<br/>
	 * <ul>
	 * <li>ouvre le FileChooser.</li>
	 * <li>récupère le fichier sélectionné par l'utilisateur 
	 * (null si pas de sélection).</li>
	 * <li>alimente this.fichierSelectionne 
	 * avec le fichier sélectionné.</li>
	 * <li>lit le contenu du fichier et alimente alimente 
	 * this.fichierSelectionne.</li>
	 * <li>enregistre le répertoire de sélection 
	 * dans les préférences (si fichier sélectionné pas null).</li>
	 * <li>alimente this.repertoirePrefere 
	 * avec le répertoire de sélection 
	 * (si fichier sélectionné pas null).</li>
	 * </ul>
	 * - retourne null si aucun fichier n'est choisi.<br/>
	 * <br/>
	 *
	 * @param pStage : Stage : Fenêtre (théâtre) 
	 * englobant le FileChooser.<br/> Peut être null.<br/>
	 * 
	 * @return : File : this.fichierSelectionne.<br/>
	 * 
	 * @throws Exception 
	 */
	File ouvrirEtSelectionnerFichier(Stage pStage) throws Exception;
	
	

	/**
	 * lit (en UTF8) le contenu d'un fichier "textuel"
	 * et le retourne sous forme de String.<br/>
	 * <ul>
	 * <li>lit le contenu sous forme de liste de lignes 
	 * avec le Charset UTF8.</li>
	 * <li>transforme la liste de lignes en String en mettant 
	 * un NEWLINE à chaque saut de ligne.</li>
	 * <li>alimente this.contenuFichierSelectionne.</li>
	 * </ul>
	 * - retourne null si pFile == null.<br/>
	 * - retourne null si pFile n'existe pas.<br/>
	 * - retourne null si pFile n'est pas un fichier simple 
	 * (répertoire).<br/>
	 * - retourne null si le fihier n'est pas "textuel" 
	 * et lisible avec un Charset UTF8 
	 * (images .png, sons .mp3, ...).<br/>
	 * <br/>
	 * 
	 *
	 * @param pFile : File : fichier simple à lire.<br/>
	 * 
	 * @return this.contenuFichierSelectionne : String : 
	 * contenu du fichier.<br/>
	 * 
	 * @throws Exception 
	 */
	String lireContenuFichier(File pFile) throws Exception;
	
	

	/**
	 * Getter du FileChooser (Browser : VUE) pour 
	 * sélectionner un fichier sur un disque dur.<br/>
	 *
	 * @return this.fileChooser : FileChooser.<br/>
	 */
	FileChooser getFileChooser();
	
	

	/**
	 * Getter du titre du FileChooser.<br/>
	 *
	 * @return this.titre : String.<br/>
	 */
	String getTitre();
	
	
	
	/**
	* Setter du titre du FileChooser.<br/>
	* <ul>
	* <li>configure le FileChooser à chaque appel.</li>
	* </ul>
	* ne fait rien si pTitre est null ou egal à this.titre.<br/>
	* <br/>
	*
	* @param pTitre : String : 
	* valeur à passer à this.titre.<br/>
	*/
	void setTitre(String pTitre);
	
	

	/**
	 * Getter du répertoire sur lequel va pointer 
	 * le FileChooser à son ouverture.<br/>
	 *
	 * @return this.repertoirePrefere : File.<br/>
	 */
	File getRepertoirePrefere();
	
	

	/**
	* Setter du répertoire sur lequel va pointer 
	* le FileChooser à son ouverture.<br/>
	* <ul>
	* <li>configure le FileChooser à chaque appel.</li>
	* </ul>
	* - ne fait rien si pRepertoirePrefere est null 
	* ou egal à this.repertoirePrefere.<br/>
	* <br/>
	*
	* @param pRepertoirePrefere : File : 
	* valeur à passer à this.repertoirePrefere.<br/>
	*/
	void setRepertoirePrefere(File pRepertoirePrefere);
	
	

	/**
	 * Getter du fichier sélectionné par l'utilisateur 
	 * dans le FileChooser.<br/>
	 *
	 * @return this.fichierSelectionne : File.<br/>
	 */
	File getFichierSelectionne();
	
	

	/**
	 * Getter du contenu sous forme de String du 
	 * fichier sélectionné par l'utilisateur 
	 * dans le FileChooser.<br/>
	 *
	 * @return this.contenuFichierSelectionne : String.<br/>
	 */
	String getContenuFichierSelectionne();
	
	

} // FIN DE L'INTERFACE ISelecteurFichier.-----------------------------------