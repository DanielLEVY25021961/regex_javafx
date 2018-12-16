package levy.daniel.application.vues.desktop.metier.regex.selecteurrepertoire;

import java.io.File;
import java.nio.charset.Charset;

import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 * INTERFACE ISelecteurRepertoire :<br/>
 * Interface factorisant les comportements des SelecteurRepertoire concrets.<br/>
 * <br/>
 * <img src="../../../../../../../../../../../javadoc/images/selecteurfichier/selecteur_fichier.png" 
 * alt="diagramme de classes SelecteurRepertoire" border="1" align="center" />
 * <br/><br/>
 *
 * - Exemple d'utilisation :<br/>
 * <code><i>// Instancie un SelecteurRepertoire 
 * et configure son DirectoryChooser en le positionnant 
 * sur le répertoire préféré.</i></code><br/>
 * <code><b>ISelecteurRepertoire selecteur 
 * = new SelecteurRepertoire(titre, 
 * GestionnairePreferencesSelecteur.getRepertoirePrefereDirectoryChooser());</b></code><br/>
 * <code><i>// Ouvre le DirectoryChooser sur le répertoire mémorisé, 
 * permet la sélection d'un répertoire et lit le 
 * chemin absolu du répertoire.<br/>
 * // Mémorise éventuellement le nouveau répertoire.</i></code><br/>
 * <code><b>selecteur.selectionnerRepertoire(pPrimaryStage);</b></code><br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * DirectoryChooser, Properties, fichier properties, préférences, <br/>
 * preferences, lire le contenu d'un fichier, lire fichier, <br/>
 * créer une String à partir d'une liste de lignes,<br/>
 * mémoriser répertoire, écrire repertoire dans préférences,<br/>
 * sélection de répertoire, DirectoryChooser, <br/>
 * sélection de repertoire, selection de repertoire, <br/>
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
public interface ISelecteurRepertoire {


	
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
	 * <b>Ouvre un DirectoryChooser, permet la sélection d'un répertoire, 
	 * et retourne son chemin sous forme de String</b>.<br/>
	 * <ul>
	 * <li>Ouvre le DirectoryChooser et récupère le répertoire sélectionné.</li>
	 * <li>Mémorise le répertoire sélectionné dans les préférences.</li>
	 * <li>lit le chemin du répertoire sélectionné.</li>
	 * <li>retourne le chemin sous forme de String.</li>
	 * <li>alimente les attributs <code>this.repertoireSelectionne, 
	 * this.cheminRepertoireSelectionne, this.repertoirePrefere</code></li>
	 * </ul>
	 *
	 * @param pStage : Stage : Fenêtre (théâtre) 
	 * englobant le DirectoryChooser.<br/> Peut être null.<br/>
	 * 
	 * @return String : le chemin du répertoire sélectionné.<br/>
	 * 
	 * @throws Exception
	 */
	String selectionnerRepertoire(Stage pStage) throws Exception;
	
	

	/**
	 * <b>Ouvre le DirectoryChooser et retourne le 
	 * répertoire sélectionné</b>.<br/>
	 * Ne peut sélectionner qu'un répertoire 
	 * par construction du DirectoryChooser.<br/>
	 * Mémorise le répertoire sélectionné dans les préférences.<br/>
	 * <ul>
	 * <li>ouvre le DirectoryChooser.</li>
	 * <li>récupère le répertoire sélectionné par l'utilisateur 
	 * (null si pas de sélection).</li>
	 * <li>alimente <code>this.repertoireSelectionne</code> 
	 * avec le répertoire sélectionné.</li>
	 * <li>lit le chemin du répertoire et alimente 
	 * <code>this.cheminRepertoireSelectionne</code>.</li>
	 * <li>enregistre le répertoire sélectionné
	 * dans les préférences (si répertoire sélectionné pas null).</li>
	 * <li>alimente <code>this.repertoirePrefere</code> 
	 * avec le répertoire sélectionné 
	 * (si répertoire sélectionné pas null).</li>
	 * </ul>
	 * - retourne null si aucun répertoire n'est choisi.<br/>
	 * <br/>
	 *
	 * @param pStage : Stage : Fenêtre (théâtre) 
	 * englobant le DirectoryChooser.<br/> Peut être null.<br/>
	 * 
	 * @return : File : this.fichierSelectionne.<br/>
	 * 
	 * @throws Exception 
	 */
	File ouvrirEtSelectionnerRepertoire(Stage pStage) throws Exception;
	
	

	/**
	 * <b>lit le chemin du répertoire sélectionné
	 * et le retourne sous forme de String</b>.<br/>
	 * <ul>
	 * <li>alimente <code>this.cheminRepertoireSelectionne</code>.</li>
	 * </ul>
	 * - retourne null si pFile == null.<br/>
	 * - retourne null si pFile n'existe pas.<br/>
	 * - retourne null si pFile n'est pas un répertoire.<br/>
	 * <br/>
	 * 
	 *
	 * @param pFile : File : répertoire.<br/>
	 * 
	 * @return this.cheminRepertoireSelectionne : String : 
	 * chemin du répertoire sélectionné.<br/>
	 * 
	 * @throws Exception 
	 */
	String lireCheminRepertoireSelectionne(File pFile) throws Exception;
	
	

	/**
	 * Getter du DirectoryChooser (Browser : VUE) pour 
	 * sélectionner un répertoire sur un disque dur.<br/>
	 *
	 * @return this.directoryChooser : DirectoryChooser.<br/>
	 */
	DirectoryChooser getDirectoryChooser();
	
	

	/**
	 * Getter du titre du DirectoryChooser.<br/>
	 *
	 * @return this.titre : String.<br/>
	 */
	String getTitre();
	
	
	
	/**
	* Setter du titre du DirectoryChooser.<br/>
	* <ul>
	* <li>configure le DirectoryChooser à chaque appel.</li>
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
	 * le DirectoryChooser à son ouverture.<br/>
	 *
	 * @return this.repertoirePrefere : File.<br/>
	 */
	File getRepertoirePrefere();
	
	

	/**
	* Setter du répertoire sur lequel va pointer 
	* le DirectoryChooser à son ouverture.<br/>
	* <ul>
	* <li>configure le DirectoryChooser à chaque appel.</li>
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
	 * Getter du répertoire sélectionné par l'utilisateur 
	 * dans le DirectoryChooser.<br/>
	 *
	 * @return this.repertoireSelectionne : File.<br/>
	 */
	File getRepertoireSelectionne();
	
	

	/**
	 * Getter du chemin absolu sous forme de String du 
	 * répertoire sélectionné par l'utilisateur 
	 * dans le DirectoryChooser.<br/>
	 *
	 * @return this.cheminRepertoireSelectionne : String.<br/>
	 */
	String getCheminRepertoireSelectionne();
	
	

} // FIN DE L'INTERFACE ISelecteurRepertoire.-----------------------------------