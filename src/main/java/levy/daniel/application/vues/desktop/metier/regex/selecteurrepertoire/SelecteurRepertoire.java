package levy.daniel.application.vues.desktop.metier.regex.selecteurrepertoire;

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import levy.daniel.application.vues.desktop.utilitaires.gestionnairepreferencesselecteur.GestionnairePreferencesSelecteur;




/**
 * CLASSE SelecteurRepertoire :<br/>
 * <b>Configure et ouvre un {@link DirectoryChooser} permettant à l'utilisateur 
 * de sélectionner un répertoire.</b><br/>
 * <ul>
 * <li>Instancie et configure un {@link DirectoryChooser} pour choisir 
 * un répertoire dans un système de fichiers.</li>
 * <li>Récupère le répertoire sélectionné par l'utilisateur 
 * et le mémorise comme préférence 
 * (utilise un {@link GestionnairePreferencesSelecteur}).</li>
 * </ul>
 * <br/>
 * <img src="../../../../../../../../../../javadoc/images/selecteurfichier/selecteur_fichier.png" 
 * alt="diagramme de classes SelecteurRepertoire" border="1" align="center" />
 * <br/><br/>
 *
 * - Exemple d'utilisation :<br/>
 * <code><i>// Instancie un SelecteurRepertoire 
 * et configure son DirectoryChooser en le positionnant 
 * sur le répertoire préféré.</i></code><br/>
 * <code><b>ISelecteurRepertoire selecteur 
 * = new SelecteurRepertoire(titre, 
 * GestionnairePreferencesSelecteur.getRepertoirePrefereDirectoryChooserSource());</b></code><br/>
 * <code><i>// Ouvre le DirectoryChooser sur le répertoire mémorisé 
 * et permet la sélection d'un répertoire.<br/>
 * // Mémorise éventuellement le nouveau répertoire.</i></code><br/>
 * <code><b>selecteur.selectionnerEtLire(pPrimaryStage);</b></code><br/>
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
 * @author dan Lévy
 * @version 1.0
 * @since 8 août 2018
 *
 */
public class SelecteurRepertoire implements ISelecteurRepertoire {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * "Classe SelecteurRepertoire".<br/>
	 */
	public static final String CLASSE_SELECTEURREPERTOIRE 
		= "Classe SelecteurRepertoire";
	
	/**
	 * DirectoryChooser (Browser : VUE) pour 
	 * sélectionner un répertoire sur un disque dur.<br/>
	 */
	private final DirectoryChooser directoryChooser = new DirectoryChooser();
	
	/**
	 * titre du DirectoryChooser.<br/>
	 */
	private String titre;
	
	
	/**
	 * répertoire sur lequel va pointer 
	 * le DirectoryChooser à son ouverture.<br/>
	 */
	private File repertoirePrefere;
	
	/**
	 * répertoire sélectionné par l'utilisateur 
	 * dans le DirectoryChooser.<br/>
	 */
	private transient File repertoireSelectionne;

	/**
	 * chemin sous forme de String du 
	 * répertoire sélectionné par l'utilisateur 
	 * dans le DirectoryChooser.<br/>
	 */
	private transient String cheminRepertoireSelectionne;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(SelecteurRepertoire.class);
	
	// *************************METHODES************************************/
	

	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public SelecteurRepertoire() {
		this(null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <ul>
	 * <li>configure le DirectoryChooser.</li>
	 * </ul>
	 *
	 * @param pTitre : String : titre du DirectoryChooser.
	 * @param pRepertoirePrefere : File : 
	 * répertoire sur lequel va pointer 
	 * le DirectoryChooser à son ouverture.<br/>
	 */
	public SelecteurRepertoire(
			final String pTitre
				, final File pRepertoirePrefere) {
		
		super();
		
		this.titre = pTitre;
		this.repertoirePrefere = pRepertoirePrefere;
		
		/* configure le DirectoryChooser. */
		this.configurerDirectoryChooser();
				
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	/**
	 * configure le DirectoryChooser.<br/>
	 * <ul>
	 * <li>paramètre le titre du DirectoryChooser.</li>
	 * <li>paramètre le répertoire initial du DirectoryChooser.</li>
	 * </ul>
	 */
	private void configurerDirectoryChooser() {
		
		/* met this.titre au panneau du DirectoryChooser. */
		if (this.titre != null) {
			this.directoryChooser.setTitle(this.titre);
		}
				
		/* positionne this.fileChooser sur this.repertoirePrefere. */
		if (this.repertoirePrefere != null 
				&& this.repertoirePrefere.exists()) {
			this.directoryChooser.setInitialDirectory(this.repertoirePrefere);
		}
				
	} // Fin de configurerDirectoryChooser().___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String selectionnerRepertoire(
			final Stage pStage) 
						throws Exception {
		
		/* Ouvre le DirectoryChooser et récupère le répertoire sélectionné. */
		/* Mémorise le répertoire sélectionné dans les préférences. */
		this.ouvrirEtSelectionnerRepertoire(pStage);
		
		/* retourne le chemin absolu du répertoire sélectionné. */
		return this.cheminRepertoireSelectionne;
		
	} // Fin de selectionnerEtLire(...).___________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final File ouvrirEtSelectionnerRepertoire(
			final Stage pStage) throws Exception {
		
		this.repertoireSelectionne = null;
		
		/* affiche le DirectoryChooser. */
		final File repertoireChoisi = 
				this.directoryChooser.showDialog(pStage);
		
		if (repertoireChoisi != null) {
			
			/* alimente this.repertoireSelectionne. */
			this.repertoireSelectionne = repertoireChoisi;
			
			if (this.repertoireSelectionne != null) {
				
				/* enregistre le répertoire sélectionné 
				 * dans les préférences. */
				GestionnairePreferencesSelecteur
					.setRepertoirePrefereFileChooser(
							this.repertoireSelectionne);
				
				/* alimente this.repertoirePrefere avec 
				 * le répertoire sélectionné. */
				this.setRepertoirePrefere(this.repertoireSelectionne);
			}
			
			/* lit le chemin absolu du répertoire sélectionné 
			 * et alimente this.cheminRepertoireSelectionne. */
			this.lireCheminRepertoireSelectionne(
					this.repertoireSelectionne);
		}
		
		
		/* retourne null si aucun fichier n'est choisi. */
		return this.repertoireSelectionne;
		
	} // Fin de ouvrirEtSelectionnerFichier(...).__________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String lireCheminRepertoireSelectionne(
			final File pFile) throws Exception {
		
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* retourne null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* retourne null si pFile n'est pas un Directory 
		 * (répertoire). */
		if (!pFile.isDirectory()) {
			return null;
		}

		/* alimente this.cheminRepertoireSelectionne 
		 * avec le chemin absolu du répertoire. */
		this.cheminRepertoireSelectionne 
			= pFile.getAbsolutePath();
		
		return this.cheminRepertoireSelectionne;
		
	} // Fin de lireContenuFichier(...).___________________________________
	
	
	
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
	public final DirectoryChooser getDirectoryChooser() {
		return this.directoryChooser;
	} // Fin de getDirectoryChooser()._____________________________________



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
		
		/* configure le DirectoryChooser. */
		this.configurerDirectoryChooser();
		
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
		
		/* configure le DirectoryChooser. */
		this.configurerDirectoryChooser();
		
	} // Fin de setRepertoirePrefere(...)._________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final File getRepertoireSelectionne() {
		return this.repertoireSelectionne;
	} // Fin de getRepertoireSelectionne().________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getCheminRepertoireSelectionne() {
		return this.cheminRepertoireSelectionne;
	} // Fin de getContenuFichierSelectionne().____________________________
	
		
	
} // FIN DE LA CLASSE SelecteurRepertoire.--------------------------------------
