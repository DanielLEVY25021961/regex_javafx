package levy.daniel.application.vues.desktop.metier.regex.selecteurfichier;

import java.io.File;
import java.nio.charset.Charset;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * CLASSE ISelecteurFichier :<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 10 août 2018
 *
 */
public interface ISelecteurFichier {

	/**
	 * "Classe SelecteurFichier".<br/>
	 */
	String CLASSE_SELECTEURFICHIER = "Classe SelecteurFichier";
	/**
	 * METHODE_LIRE_STRINGS_DANS_FILE : String :<br/>
	 * "méthode lireStringsDansFile(File pFile, Charset pCharset)".<br/>
	 */
	String METHODE_LIRE_STRINGS_DANS_FILE = "méthode lireStringsDansFile(File pFile, Charset pCharset)";
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
	 * englobant le FileChooser.<br/>
	 * 
	 * @return String : le contenu du fichier.<br/>
	 * 
	 * @throws Exception
	 */
	String selectionnerEtLire(Stage pStage) throws Exception; // Fin de selectionnerEtLire(...).___________________________________

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
	 * englobant le FileChooser.<br/>
	 * 
	 * @return : File : this.fichierSelectionne.<br/>
	 * 
	 * @throws Exception 
	 */
	File ouvrirEtSelectionnerFichier(Stage pStage) throws Exception; // Fin de ouvrirEtSelectionnerFichier(...).__________________________

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
	String lireContenuFichier(File pFile) throws Exception; // Fin de lireContenuFichier(...).___________________________________

	/**
	 * Getter du FileChooser (Browser : VUE) pour 
	 * sélectionner un fichier sur un disque dur.<br/>
	 *
	 * @return this.fileChooser : FileChooser.<br/>
	 */
	FileChooser getFileChooser(); // Fin de getFileChooser().__________________________________________

	/**
	 * Getter du titre du FileChooser.<br/>
	 *
	 * @return this.titre : String.<br/>
	 */
	String getTitre(); // Fin de getTitre().________________________________________________

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
	void setTitre(String pTitre); // Fin de setTitre(...)._____________________________________________

	/**
	 * Getter du répertoire sur lequel va pointer 
	 * le FileChooser à son ouverture.<br/>
	 *
	 * @return this.repertoirePrefere : File.<br/>
	 */
	File getRepertoirePrefere(); // Fin de getRepertoirePrefere().____________________________________

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
	void setRepertoirePrefere(File pRepertoirePrefere); // Fin de setRepertoirePrefere(...)._________________________________

	/**
	 * Getter du fichier sélectionné par l'utilisateur 
	 * dans le FileChooser.<br/>
	 *
	 * @return this.fichierSelectionne : File.<br/>
	 */
	File getFichierSelectionne(); // Fin de getFichierSelectionne().___________________________________

	/**
	 * Getter du contenu sous forme de String du 
	 * fichier sélectionné par l'utilisateur 
	 * dans le FileChooser.<br/>
	 *
	 * @return this.contenuFichierSelectionne : String.<br/>
	 */
	String getContenuFichierSelectionne(); // Fin de getContenuFichierSelectionne().____________________________

}