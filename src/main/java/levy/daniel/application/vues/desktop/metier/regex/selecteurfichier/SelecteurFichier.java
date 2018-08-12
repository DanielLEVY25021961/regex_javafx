package levy.daniel.application.vues.desktop.metier.regex.selecteurfichier;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import levy.daniel.application.vues.desktop.utilitaires.gestionnairepreferencesselecteur.GestionnairePreferencesSelecteur;


/**
 * CLASSE SelecteurFichier :<br/>
 * <b>Configure et ouvre un FileChooser permettant à l'utilisateur 
 * de sélectionner un fichier simple.</b><br/>
 * <b>Lit le contenu du fichier sélectionné en UTF8 et le retourne sous forme de String.</b>
 * <ul>
 * <li>Instancie et configure un FileChooser pour choisir 
 * un fichier simple dans un système de fichiers.</li>
 * <li>Récupère le fichier sélectionné par l'utilisateur 
 * et mémorise son répertoire comme préférence 
 * (utilise un GestionnairePreferencesSelecteur).</li>
 * <li>Lit le contenu du fichier sélectionné en UTF8.</li>
 * <li>Retourne le contenu du fichier sélectionné sous forme de String.</li>
 * </ul>
 * <br/>
 * <img src="../../../../../../../../../../../javadoc/images/selecteur_fichier.png" 
 * alt="diagramme de classes SelecteurFichier" border="1" align="center" />
 * <br/><br/>
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
 * @author dan Lévy
 * @version 1.0
 * @since 8 août 2018
 *
 */
public class SelecteurFichier implements ISelecteurFichier {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * "Classe SelecteurFichier".<br/>
	 */
	public static final String CLASSE_SELECTEURFICHIER 
		= "Classe SelecteurFichier";
	
	/**
	 * FileChooser (Browser : VUE) pour 
	 * sélectionner un fichier sur un disque dur.<br/>
	 */
	private final FileChooser fileChooser = new FileChooser();
	
	/**
	 * titre du FileChooser.<br/>
	 */
	private String titre;
	
	
	/**
	 * répertoire sur lequel va pointer 
	 * le FileChooser à son ouverture.<br/>
	 */
	private File repertoirePrefere;
	
	/**
	 * fichier sélectionné par l'utilisateur 
	 * dans le FileChooser.<br/>
	 */
	private transient File fichierSelectionne;

	/**
	 * contenu sous forme de String du 
	 * fichier sélectionné par l'utilisateur 
	 * dans le FileChooser.<br/>
	 */
	private transient String contenuFichierSelectionne;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(SelecteurFichier.class);
	
	// *************************METHODES************************************/
	

	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public SelecteurFichier() {
		this(null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <ul>
	 * <li>configure le FileChooser.</li>
	 * </ul>
	 *
	 * @param pTitre : String : titre du FileChooser.
	 * @param pRepertoirePrefere : File : 
	 * répertoire sur lequel va pointer 
	 * le FileChooser à son ouverture.<br/>
	 */
	public SelecteurFichier(
			final String pTitre
				, final File pRepertoirePrefere) {
		
		super();
		
		this.titre = pTitre;
		this.repertoirePrefere = pRepertoirePrefere;
		
		/* configure le FileChooser. */
		this.configurerFileChooser();
				
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	/**
	 * configure le FileChooser.<br/>
	 * <ul>
	 * <li>paramètre le titre du FileChooser.</li>
	 * <li>paramètre le répertoire initial du FileChooser.</li>
	 * </ul>
	 */
	private void configurerFileChooser() {
		
		/* met this.titre au panneau du FileChooser. */
		if (this.titre != null) {
			this.fileChooser.setTitle(this.titre);
		}
				
		/* positionne this.fileChooser sur this.repertoirePrefere. */
		if (this.repertoirePrefere != null 
				&& this.repertoirePrefere.exists()) {
			this.fileChooser.setInitialDirectory(this.repertoirePrefere);
		}
				
	} // Fin de configurerFileChooser().___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String selectionnerEtLire(
			final Stage pStage) 
						throws Exception {
		
		/* Ouvre le FileChooser et récupère le fichier sélectionné. */
		/* Mémorise le répertoire de sélection dans les préférences. */
		this.ouvrirEtSelectionnerFichier(pStage);
		
		/* Lit le contenu du fichier sélectionné en UTF8. */
		return this.contenuFichierSelectionne;
		
	} // Fin de selectionnerEtLire(...).___________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final File ouvrirEtSelectionnerFichier(
			final Stage pStage) throws Exception {
		
		this.fichierSelectionne = null;
		
		/* affiche le FileChooser. */
		final File fichierChoisi = 
				this.fileChooser.showOpenDialog(pStage);
		
		if (fichierChoisi != null) {
			
			/* alimente this.fichierSelectionne. */
			this.fichierSelectionne = fichierChoisi;
			
			final File repertoireParent 
				= this.fichierSelectionne.getParentFile();
			
			if (repertoireParent != null) {
				
				/* enregistre le répertoire de sélection 
				 * dans les préférences. */
				GestionnairePreferencesSelecteur
					.setRepertoirePrefereFileChooser(repertoireParent);
				
				/* alimente this.repertoirePrefere avec 
				 * le répertoire de sélection. */
				this.setRepertoirePrefere(repertoireParent);
			}
			
			/* lit le contenu du fichier et alimente alimente 
			 * this.contenuFichierSelectionne. */
			this.lireContenuFichier(this.fichierSelectionne);
		}
		
		
		/* retourne null si aucun fichier n'est choisi. */
		return this.fichierSelectionne;
		
	} // Fin de ouvrirEtSelectionnerFichier(...).__________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String lireContenuFichier(
			final File pFile) throws Exception {
		
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* retourne null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* retourne null si pFile n'est pas un fichier simple 
		 * (répertoire). */
		if (!pFile.isFile()) {
			return null;
		}
				
		/* lit le contenu sous forme de 
		 * liste de lignes avec le Charset UTF8. */
		final List<String> listeLue 
			= this.lireStringsDansFile(pFile, CHARSET_UTF8);
		
		/* transforme la liste de lignes en String en mettant 
		 * un NEWLINE à chaque saut de ligne. */
		this.contenuFichierSelectionne 
			= this.creerStringAPartirDeListe(listeLue);
		
		return this.contenuFichierSelectionne;
		
	} // Fin de lireContenuFichier(...).___________________________________
	
	
	
	/**
	 * <b>Lit le contenu d'un fichier texte avec pCharset 
	 * et retourne une Liste de lignes</b>. 
	 * <ul>
	 * <li><b>Lit le contenu</b> d'un fichier texte 
	 * (fichier simple contenant du texte) pFile.</li>
	 * <li>Décode le contenu d'un fichier texte 
	 * (fichier simple contenant du texte) pFile 
	 * avec le Charset pCharset</li>
	 * <li><b>Retourne la liste des lignes</b> 
	 * du fichier simple texte pFile 
	 * lues avec le Charset pCharset.</li>
	 * <ul>
	 * <li>Utilise automatiquement le CHARSET_UTF8 
	 * si pCharset est null.</li>
	 * </ul>
	 * </ul>
	 * - Retourne null si pFile est null.<br/>
	 * - Retourne null si pFile n'existe pas.<br/>
	 * - Retourne null si pFile est un répertoire.<br/>
	 * - Retourne null en cas d'Exception loggée 
	 * (MalformedInputException, ...).<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier simple textuel à lire.<br/>
	 * @param pCharset : Charset : le Charset à utiliser pour 
	 * lire le fichier pFile.<br/>
	 * 
	 * @return : List&lt;String&gt; : Liste des lignes lues.<br/>
	 * 
	 * @throws Exception en cas d'Exception loggée 
	 * (IOException, MalformedInputException, ...).<br/>
	 */
	private List<String> lireStringsDansFile(
			final File pFile
				, final Charset pCharset) throws Exception {
		
		/* Retourne null si pFile est null. */
		if (pFile == null) {
			return null;
		}
		
		/* Retourne null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* Retourne null si pFile est un répertoire. */
		if (pFile.isDirectory()) {
			return null;
		}
		
		/* Utilise automatiquement le CHARSET_UTF8 
		 * si pCharset est null. */
		Charset charset = null;
		
		if (pCharset == null) {
			charset = CHARSET_UTF8;
		}
		else {
			charset = pCharset;
		}
		
		/* Récupère le Path de pFile. */
		final Path pathFichier = pFile.toPath();
		
		try {
			
			// *****************************************************
			/* Retourne la liste des lignes lues avec le charset. */
			return Files.readAllLines(pathFichier, charset);
			
		} 
		
		catch (MalformedInputException malformedInputException) {
			
			final String message 
			=  "Impossible de lire le contenu du fichier '" 
			+ pFile.getName() 
			+ "' avec le Charset " 
			+ charset.displayName(Locale.getDefault()) 
			+ " à cause d'un caractère qui ne peut être "
			+ "écrit dans ce Charset (MalformedInputException)";
			
			/* LOG de niveau Error. */
			loggerError(CLASSE_SELECTEURFICHIER
					, METHODE_LIRE_STRINGS_DANS_FILE 
					+ SEPARATEUR_MOINS_AERE 
					+ message
					, malformedInputException);
			
			/* retourne null en cas d'Exception loggée 
			 * (IOException, MalformedInputException, ...). */
			return null;
	
		}
		
		catch (IOException ioe) {
			
			/* LOG de niveau Error. */
			loggerError(CLASSE_SELECTEURFICHIER
					, METHODE_LIRE_STRINGS_DANS_FILE
					, ioe);
			
			final String message 
			= CLASSE_SELECTEURFICHIER 
			+ SEPARATEUR_MOINS_AERE 
			+ METHODE_LIRE_STRINGS_DANS_FILE 
			+ SEPARATEUR_MOINS_AERE 
			+ "Impossible de lire le contenu du fichier '" 
			+ pFile.getName() 
			+ "' avec le Charset " 
			+ charset.displayName(Locale.getDefault());
			
			/* jette une Exception en cas d'Exception loggée 
			 * (IOException, MalformedInputException, ...). */
			throw new Exception(message, ioe);
		
		}
		
	} // Fin de lireStringsDansFile(...).__________________________________
	

	
	/**
	 * <b>Crée une String à partir d'une liste de Strings</b>.
	 * <ul>
	 * <li>ajoute un saut de ligne de la plateforme 
	 * NEWLINE à chaque ligne.</li>
	 * </ul>
	 * - retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;String&gt;.<br/>
	 * 
	 * @return : String.<br/>
	 */
	private String creerStringAPartirDeListe(
			final List<String> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final String ligne : pList) {
			
			stb.append(ligne);
			
			/* ajoute un saut de ligne de la plateforme 
			 * NEWLINE à chaque ligne. */
			stb.append(NEWLINE);
		}
		
		return stb.toString();

	} // Fin de creerStringAPartirDeListe(...).____________________________
	

		
	/**
	 * method loggerInfo(
	 * String pClasse
	 * , String pMethode
	 * , String pMessage) :<br/>
	 * <ul>
	 * <li>Crée un message de niveau INFO dans le LOG.</li>
	 * </ul>
	 * - Ne fait rien si un des paramètres est null.<br/>
	 * <br/>
	 *
	 * @param pClasse : String : Classe appelante.<br/>
	 * @param pMethode : String : Méthode appelante.<br/>
	 * @param pMessage : String : Message particulier de la méthode.<br/>
	 */
	private static void loggerInfo(
			final String pClasse
				, final String pMethode
					, final String pMessage) {
		
		/* Ne fait rien si un des paramètres est null. */
		if (pClasse == null || pMethode == null || pMessage == null) {
			return;
		}
		
		/* LOG de niveau INFO. */			
		if (LOG.isInfoEnabled()) {
			
			final String message 
			= pClasse 
			+ SEPARATEUR_MOINS_AERE
			+ pMethode
			+ SEPARATEUR_MOINS_AERE
			+ pMessage;
			
			LOG.info(message);
		}
		
	} // Fin de la classe loggerInfo(...)._________________________________
	
	
	
	/**
	 * method loggerInfo(
	 * String pClasse
	 * , String pMethode
	 * , String pMessage
	 * , String pComplement) :<br/>
	 * <ul>
	 * <li>Créée un message de niveau INFO dans le LOG.</li>
	 * </ul>
	 * - Ne fait rien si un des paramètres est null.<br/>
	 * <br/>
	 *
	 * @param pClasse : String : Classe appelante.<br/>
	 * @param pMethode : String : Méthode appelante.<br/>
	 * @param pMessage : String : Message particulier de la méthode.<br/>
	 * @param pComplement : String : Complément au message de la méthode.<br/>
	 */
	private static void loggerInfo(
			final String pClasse
				, final String pMethode
					, final String pMessage
						, final String pComplement) {
		
		/* Ne fait rien si un des paramètres est null. */
		if (pClasse == null || pMethode == null 
				|| pMessage == null || pComplement == null) {
			return;
		}
		
		/* LOG de niveau INFO. */			
		if (LOG.isInfoEnabled()) {
			
			final String message 
			= pClasse 
			+ SEPARATEUR_MOINS_AERE
			+ pMethode
			+ SEPARATEUR_MOINS_AERE
			+ pMessage
			+ pComplement;
			
			LOG.info(message);
		}
		
	} // Fin de loggerInfo(...).___________________________________________
	
	
	
	/**
	 * method loggerError(
	 * String pClasse
	 * , String pMethode
	 * , Exception pException) :<br/>
	 * <ul>
	 * <li>Crée un message de niveau ERROR dans le LOG.</li>
	 * </ul>
	 * - Ne fait rien si un des paramètres est null.<br/>
	 * <br/>
	 *
	 * @param pClasse : String : Classe appelante.<br/>
	 * @param pMethode : String : Méthode appelante.<br/>
	 * @param pException : Exception : Exception transmise 
	 * par la méthode appelante.<br/>
	 */
	private static void loggerError(
			final String pClasse
				, final String pMethode
					, final Exception pException) {
		
		/* Ne fait rien si un des paramètres est null. */
		if (pClasse == null || pMethode == null || pException == null) {
			return;
		}
		
		/* LOG de niveau ERROR. */			
		if (LOG.isErrorEnabled()) {
			
			final String message 
			= pClasse 
			+ SEPARATEUR_MOINS_AERE
			+ pMethode
			+ SEPARATEUR_MOINS_AERE 
			+ pException.getMessage();
			
			LOG.error(message, pException);
			
		}
		
	} // Fin de loggerError(...).__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final FileChooser getFileChooser() {
		return this.fileChooser;
	} // Fin de getFileChooser().__________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getTitre() {
		return this.titre;
	} // Fin de getTitre().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setTitre(
			final String pTitre) {
		
		/* ne fait rien si pTitre est null ou egal à this.titre. */
		if (pTitre == null || pTitre.equals(this.titre)) {
			return;
		}
		
		this.titre = pTitre;
		
		/* configure le FileChooser. */
		this.configurerFileChooser();
		
	} // Fin de setTitre(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final File getRepertoirePrefere() {
		return this.repertoirePrefere;
	} // Fin de getRepertoirePrefere().____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRepertoirePrefere(
			final File pRepertoirePrefere) {
		
		/* ne fait rien si pRepertoirePrefere est null 
		 * ou egal à this.repertoirePrefere. */
		if (pRepertoirePrefere == null 
				|| pRepertoirePrefere.equals(this.repertoirePrefere)) {
			return;
		}
		
		this.repertoirePrefere = pRepertoirePrefere;
		
		/* configure le FileChooser. */
		this.configurerFileChooser();
		
	} // Fin de setRepertoirePrefere(...)._________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final File getFichierSelectionne() {
		return this.fichierSelectionne;
	} // Fin de getFichierSelectionne().___________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getContenuFichierSelectionne() {
		return this.contenuFichierSelectionne;
	} // Fin de getContenuFichierSelectionne().____________________________
	
		
	
} // FIN DE LA CLASSE SelecteurFichier.--------------------------------------
