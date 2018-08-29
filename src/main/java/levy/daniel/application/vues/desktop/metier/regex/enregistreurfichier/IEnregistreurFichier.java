package levy.daniel.application.vues.desktop.metier.regex.enregistreurfichier;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * <b>INTERFACE IEnregistreurFichier</b> :<br/>
 * Interface factorisant les comportements des EnregistreurFichier concrets.<br/>
 * <br/>
 * <img src="../../../../../../../../../../../javadoc/images/diagramme_classe_enregistreurfichier.png" 
 * alt="diagramme de classes EnregistreurFichier" border="1" align="center" />
 * <br/><br/>
 *
 * - Exemple d'utilisation :<br/>
 *<code><i>// Instancie un EnregistreurFichier 
 * et configure son FileChooser en le positionnant 
 * sur le répertoire préféré.</i></code><br/>
 * <code><b>IEnregistreurFichier enregistreur 
 * = new EnregistreurFichier(titre, 
 * GestionnairePreferencesSelecteur.getRepertoirePrefereFileChooser());</b></code><br/>
 * <code><i>// Ouvre le FileChooser sur le répertoire mémorisé, 
 * permet la création d'un fichier et y enregistre le 
 * contenu en UTF8.<br/>
 * // Mémorise éventuellement le nouveau répertoire.</i></code><br/>
 * <code><b>enregistreur.selectionnerEtEnregistrer(pPrimaryStage, this.contenu);</b></code><br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * FileChooser, Properties, fichier properties, préférences, <br/>
 * preferences, écrire contenu dans fichier, ecrire fichier, <br/>
 * mémoriser répertoire, écrire repertoire dans préférences,<br/>
 * enregistrer fichier, enregistrer String dans fichier,<br/>
 * enregistrer contenu dans fichier,<br/> 
 * enregistrer contenu String dans fichier, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 11 août 2018
 *
 */
public interface IEnregistreurFichier {

	/**
	 * "méthode lireStringsDansFile(File pFile, Charset pCharset)".<br/>
	 */
	String METHODE_ENREGISTRER_CONTENU_DANS_FICHIER 
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
	 * SAUTDELIGNE_UNIX : String :<br/>
	 * Saut de ligne généré par les éditeurs Unix.<br/>
	 * "\n" (Retour Ligne = LINE FEED (LF)).
	 */
	String SAUTDELIGNE_UNIX = "\n";

	/**
	 * SAUTDELIGNE_MAC : String :<br/>
	 * Saut de ligne généré par les éditeurs Mac.<br/>
	 * "\r" (Retour Chariot RC = CARRIAGE RETURN (CR))
	 */
	String SAUTDELIGNE_MAC = "\r";

	/**
	 * SAUTDELIGNE_DOS_WINDOWS : String :<br/>
	 * Saut de ligne généré par les éditeurs DOS/Windows.<br/>
	 * "\r\n" (Retour Chariot RC + Retour Ligne LF).
	 */
	String SAUTDELIGNE_DOS_WINDOWS = "\r\n";

	/**
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	String NEWLINE = System.getProperty("line.separator");

	/**
	 * SLASH : char :<br/>
	 * Séparateur générique des fichiers slash.<br/>
	 * '/'.<br/>
	 */
	char SLASH = '/';



	/**
	 * <b>Ouvre le FileChooser et retourne le fichier sélectionné</b>.<br/>
	 * <b>Enregistre le contenu pContenu dans le fichier sélectionné</b>.<br/>
	 * Ne peut sélectionner qu'un fichier simple 
	 * par construction du FileChooser.<br/>
	 * Mémorise le répertoire de sélection dans les préférences.<br/>
	 * <ul>
	 * <li>ouvre le FileChooser.</li>
	 * <li>récupère le fichier sélectionné par l'utilisateur 
	 * (null si pas de sélection).</li>
	 * <li><b>crée le fichier choisi sur disque si il n'existe pas</b>.</li>
	 * <li>alimente <code>this.fichierSelectionne</code> 
	 * avec le fichier sélectionné.</li>
	 * <li>enregistre pContenu dans le fichier et alimente alimente 
	 * <code>this.contenuFichierSelectionne</code>.</li>
	 * <li>enregistre le répertoire de sélection 
	 * dans les préférences (si fichier sélectionné pas null).</li>
	 * <li>alimente <code>this.repertoirePrefere</code> 
	 * avec le répertoire de sélection 
	 * (si fichier sélectionné pas null).</li>
	 * </ul>
	 * - retourne null si aucun fichier n'est choisi.<br/>
	 * <br/>
	 *
	 * @param pStage : Stage : Fenêtre (théâtre) 
	 * englobant le FileChooser.<br/> Peut être null.<br/>
	 * @param pContenu : String : 
	 * Contenu à enregistrer dans 
	 * <code>this.fichierselectionne</code>.<br/>
	 * 
	 * @return : File : this.fichierSelectionne.<br/>
	 * 
	 * @throws Exception 
	 */
	File selectionnerEtEnregistrer(Stage pStage, String pContenu) throws Exception;
	


	/**
	 * <b>Enregistre en UTF8 un contenu textuel sous forme de String 
	 * pContenu dans un File pFile.</b>.<br/>
	 * Encode le contenu en UTF8 et substitue les sauts de ligne 
	 * dans le contenu par le saut de ligne de la plateforme NEWLINE.
	 * <ul>
	 * <li>remplace le contenu du fichier si pFile 
	 * est déjà existant et rempli sur le disque.</li>
	 * </ul>
	 * - retourne null si pFile == null.<br/>
	 * - retourne null si pFile n'existe pas.<br/>
	 * - retourne null si pFile est un répertoire.<br/>
	 * - retourne null si pContenu == null.<br/>
	 * <br/>
	 *
	 * @param pContenu : String : 
	 * contenu textuel à enregistrer en UTF8 dans pFile.<br/>
	 * @param pFile : File : 
	 * fichier dans lequel on enregistre le contenu.<br/> 
	 * 
	 * @return : File : 
	 * le fichier enregistré sur disque contenant pContenu.<br/>
	 * 
	 * @throws IOException
	 */
	File enregistrerContenuDansFichier(String pContenu, File pFile) throws IOException;
	


	/**
	 * <b>Enregistre un contenu textuel sous forme de String 
	 * pContenu dans un File pFile EXISTANT SUR DISQUE.</b>.<br/>
	 * Encode le contenu en pCharset et substitue les sauts de ligne 
	 * dans le contenu par pSautLigne.
	 * <ul>
	 * <li>choisit automatiquement UTF8 si pCharset est null.</li>
	 * <li>passe automatiquement le saut de ligne à NEWLINE 
	 * (saut de ligne de la plateforme) si pSautLigne est blank.</li>
	 * <li>remplace le contenu du fichier si pFile 
	 * est déjà existant et rempli sur le disque.</li>
	 * </ul>
	 * - retourne null si pFile == null.<br/>
	 * - retourne null si pFile n'existe pas.<br/>
	 * - retourne null si pFile est un répertoire.<br/>
	 * - retourne null si pContenu == null.<br/>
	 * <br/>
	 *
	 * @param pContenu : String : 
	 * contenu textuel à enregistrer dans pFile.<br/>
	 * @param pCharset : Charset : charset d'encodage du fichier.<br/>
	 * @param pSautLigne : String : Saut de ligne que l'on veut 
	 * dans pFile de sortie 
	 * (\r\n pour DOS/Windows, \r pour Mac, \n pour Unix).<br/>
	 * @param pFile : File : 
	 * fichier dans lequel on enregistre le contenu.<br/> 
	 * 
	 * @return : File : 
	 * le fichier enregistré sur disque contenant pContenu.<br/>
	 * 
	 * @throws IOException 
	 */
	File enregistrerContenuDansFichier(
			String pContenu
				, Charset pCharset
					, String pSautLigne
						, File pFile)
								throws IOException;



	/**
	 * method substituerSautLigne(
	 * String pString
	 * , String pSautLigne) :<br/>
	 * Substitue les sauts de ligne dans pString 
	 * (\r\n pour DOS/Windows, \r pour Mac, \n pour Unix) 
	 * par les sauts de ligne pSautLigne.<br/>
	 * <br/>
	 * - retourne null si pString est blank (null ou vide).<br/>
	 * - retourne null si pSautLigne est blank (null ou vide).
	 * <br/>
	 *
	 * @param pString : String : String à corriger.<br/>
	 * @param pSautLigne : String : saut de ligne à substituer.<br/>
	 * 
	 * @return : String : La String dans laquelle les sauts de ligne 
	 * (\r\n pour DOS/Windows, \r pour Mac, \n pour Unix) 
	 * ont été substitués par les sauts de ligne pSautLigne.<br/>
	 */
	String substituerSautLigne(String pString, String pSautLigne);



	/**
	 * <b>Crée sur disque dur l'arborescence</b> des répertoires 
	 * <i>parents de pFile</i> si elle n'existe pas déjà.<br/>
	 * <ul>
	 * <li><code>Files.createDirectories(pathParent);</code></li>
	 * </ul>
	 * - ne fait rien si l'arborescence parente de pFile existe déjà.<br/>
	 * - ne fait rien si pFile == null.<br/>
	 * - ne fait rien si pFile est une racine (pas de parent).<br/>
	 * </br/>
	 *
	 * @param pFile : File : 
	 * fichier dont on veut créer l'arborescence parente 
	 * sur disque dur.<br/>
	 * 
	 * @throws IOException
	 */
	void creerArborescenceParente(File pFile) throws IOException;



	/**
	 * <b>Crée sur disque un fichier vide pFile et le retourne</b>.
	 * <ul>
	 * <li>Ne crée sur disque pFile que <i>si il n'existe pas déjà</i>.</li>
	 * <li>crée sur disque l'arborescence parente de pFile 
	 * <i>si elle n'existe pas déjà</i>.</li>
	 * <li>retourne pFile si il est déjà existant.</li>
	 * <li><b>n'écrase jamais un fichier déjà existant</b>.</li>
	 * <li>utilise <code>Files.createFile(pFile.toPath());</code></li>.
	 * </ul>
	 * - retourne null si pFile == null.<br/>
	 * <br/>
	 *
	 * @param pFile : File : Fichier à créer sur disque dur.<br/>
	 * 
	 * @return File : le fichier vide existant sur disque 
	 * ou le fichier déjà existant.<br/>
	 * 
	 * @throws IOException
	 */
	File creerFichierSurDisque(File pFile) throws IOException;



	/**
	 * method retournerPathGenerique(
	 * String pPathString) :<br/>
	 * <ul>
	 * <li><b>Remplace les séparateurs de fichier antislash</b> 
	 * dans pPath par des <b>séparateurs génériques slash '/'</b>.</li>
	 * <li>Par exemple : <br/>
	 * <code>retournerPathGenerique("D:\Donnees
	 * \eclipse\eclipseworkspace_neon\generation_code")</code><br/> 
	 * retourne <br/>
	 * <code>
	 * "D:/Donnees/eclipse/eclipseworkspace_neon/generation_code"
	 * </code>
	 * </li>
	 * </ul>
	 *
	 * @param pPathString : String.<br/>
	 * 
	 * @return : String : String avec des slashes
	 *  à la place des antislash.<br/>
	 */
	String retournerPathGenerique(String pPathString);



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
	

	
} // FIN DE L'INTERFACE IEnregistreurFichier.--------------------------------
