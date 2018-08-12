package levy.daniel.application.vues.desktop.metier.regex.enregistreurfichier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import levy.daniel.application.vues.desktop.utilitaires.gestionnairepreferencesselecteur.GestionnairePreferencesSelecteur;


/**
 * <b>CLASSE EnregistreurFichier</b> :<br/>
 * <b>Configure et ouvre un {@link FileChooser} 
 * permettant à l'utilisateur 
 * d'enregistrer dans un fichier simple un contenu (String).</b><br/>
 * <b>Permet à l'utilisateur d'indiquer le nom 
 * et la destination du fichier.</b>
 * <ul>
 * <li>Instancie et configure un FileChooser pour créer 
 * un fichier simple dans un système de fichiers.</li>
 * <li>crée le fichier sur disque si nécessaire.<br/>
 * <li>Récupère le fichier sélectionné par l'utilisateur 
 * et mémorise son répertoire comme préférence 
 * (utilise un {@link GestionnairePreferencesSelecteur}).</li>
 * <li>Enregistre un contenu en UTF8 (String) dans le fichier sélectionné.</li>
 * <li>Retourne le fichier enregistré.</li>
 * </ul>
 * <br/>
 * <img src="../../../../../../../../../../../javadoc/images/diagramme_classe_enregistreurfichier.png" 
 * alt="diagramme de classes EnregistreurFichier" border="1" align="center" />
 * <br/><br/>
 *
 * - Exemple d'utilisation :<br/>
 * <code><i>// Instancie un EnregistreurFichier 
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
 *<br/><br/>
 *
 * - Mots-clé :<br/>
 * FileChooser, Properties, fichier properties, préférences, <br/>
 * preferences, écrire contenu dans fichier, ecrire fichier, <br/>
 * mémoriser répertoire, écrire repertoire dans préférences,<br/>
 * enregistrer contenu dans fichier,<br/> 
 * enregistrer contenu String dans fichier, <br/>
 * sélection de fichier, FileChooser, <br/>
 * enregistrer fichier, enregistrer String dans fichier,<br/>
 * enregistrer fichier texte en UTF8, <br/>
 * écrire contenu sur disque, ecrire sur disque, <br/>
 * filtrer fichiers FileChooser, <br/>
 * créer fichier sur disque dur, HDD, créer arborescence sur disque dur,<br/>
 * Files.createFile(pFile.toPath()),<br/>
 * chemin universel, chemin Linux, chemin linux, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 10 août 2018
 *
 */
public class EnregistreurFichier implements IEnregistreurFichier {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * "Classe EnregistreurFichier".<br/>
	 */
	public static final String CLASSE_ENREGISTREURFICHIER 
		= "Classe EnregistreurFichier";
	

	/**
	 * FileChooser (Browser : VUE) pour 
	 * enregistrer un fichier sur un disque dur.<br/>
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
	 * contenu sous forme de String à écrire dans le 
	 * fichier sélectionné par l'utilisateur 
	 * dans le FileChooser.<br/>
	 */
	private transient String contenuFichierSelectionne;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(EnregistreurFichier.class);
	
	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public EnregistreurFichier() {
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
	public EnregistreurFichier(
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
	 * <li>filtre les fichiers .txt</li>
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
		
		/* filtre les fichiers .txt */
		final FileChooser.ExtensionFilter extFilter 
			= new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
		
        this.fileChooser.getExtensionFilters().add(extFilter);
				
	} // Fin de configurerFileChooser().___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final File selectionnerEtEnregistrer(
			final Stage pStage
				, final String pContenu) throws Exception {
		
		this.fichierSelectionne = null;
		
		/* affiche le FileChooser. */
		final File fichierChoisi = 
				this.fileChooser.showSaveDialog(pStage);
		
		if (fichierChoisi != null) {
			
			/* crée le fichier choisi sur disque si il n'existe pas. */
			this.creerFichierSurDisque(fichierChoisi);
			
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
			
			/* enregistre le contenu dans fichier et alimente alimente 
			 * this.contenuFichierSelectionne. */
			this.enregistrerContenuDansFichier(
					pContenu, this.fichierSelectionne);
			
			this.contenuFichierSelectionne = pContenu;
		}
		
		
		/* retourne null si aucun fichier n'est choisi. */
		return this.fichierSelectionne;
		
	} // Fin de selectionnerEtEnregistrer(...).____________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final File enregistrerContenuDansFichier(
			final String pContenu
				, final File pFile) 
								throws IOException {
		
		return this.enregistrerContenuDansFichier(
				pContenu, CHARSET_UTF8, NEWLINE, pFile);
		
	} // Fin de enregistrerContenuDansFichier(...).________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final File enregistrerContenuDansFichier(
			final String pContenu
				, final Charset pCharset
					, final String pSautLigne
						, final File pFile) 
								throws IOException {
       
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* retourne null si pFile n'existe pas. */
		if (!pFile.exists()) {			
			return null;
		}
		
		/* retourne null si pFile est un répertoire. */
		if (!pFile.isFile()) {
			return null;
		}
		
		/* retourne null si pContenu == null. */
		if (pContenu == null) {
			return null;
		}
		
		Charset charset = null;
		
		/* choisit automatiquement UTF8 si pCharset est null. */
		if (pCharset == null) {
			charset = CHARSET_UTF8;
		} else {
			charset = pCharset;
		}
		
		String sautLigne = null;
		
		/* Passe automatiquement le saut de ligne à NEWLINE 
		 * (saut de ligne de la plateforme) si pSautLigne est blank. */
		if (StringUtils.isBlank(pSautLigne)) {
			sautLigne = NEWLINE;
		} else {
			sautLigne = pSautLigne;
		}
		
		/* Ouverture d'un FileOutputStream sur le fichier. */
		/* Remplace le contenu du fichier 
		 * si pFile est déjà existant et rempli sur le disque. */
		final OutputStream fileOutputStream 
			= new FileOutputStream(pFile, false);
		
		/* Ouverture d'un OutputStreamWriter 
		 * sur le FileOutputStream en lui passant le Charset. */
		final OutputStreamWriter outputStreamWriter 
			= new OutputStreamWriter(fileOutputStream, charset);
		
		/* Ouverture d'un tampon d'écriture 
		 * BufferedWriter sur le OutputStreamWriter. */
		final BufferedWriter bufferedWriter 
			= new BufferedWriter(outputStreamWriter);
		
		// ECRITURE SUR DISQUE.
		/* Substitue automatiquement sautLigne aux sauts de ligne 
		 * dans pString si nécessaire. */
		bufferedWriter.write(
				this.substituerSautLigne(pContenu, sautLigne));
		bufferedWriter.flush();
		
		/* fermeture des flux. */
		bufferedWriter.close();
		outputStreamWriter.close();		
		fileOutputStream.close();

		
		// Retour du fichier. 
		return pFile;
                
    } // Fin de enregistrerContenuDansFichier(...).________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String substituerSautLigne(
			final String pString
				, final String pSautLigne) {
		
		/* retourne null si pString est blank (null ou vide). */
		if (StringUtils.isBlank(pString)) {
			return null;
		}
		
		/* retourne null si pSautLigne est blank (null ou vide). */
		
		/* Recherche des sauts de ligne DOS/Windows. */
		if (StringUtils.contains(pString, SAUTDELIGNE_DOS_WINDOWS)) {
			
			final String resultat 
				= StringUtils.replace(
						pString, SAUTDELIGNE_DOS_WINDOWS, pSautLigne);
			
			return resultat;
		}
		
		/* Recherche des sauts de ligne Mac. */
		if (StringUtils.contains(pString, SAUTDELIGNE_MAC)) {
			
			final String resultat 
				= StringUtils.replace(
						pString, SAUTDELIGNE_MAC, pSautLigne);
			
			return resultat;
		}
		
		/* Recherche des sauts de ligne Unix. */
		if (StringUtils.contains(pString, SAUTDELIGNE_UNIX)) {
			
			final String resultat 
				= StringUtils.replace(
						pString, SAUTDELIGNE_UNIX, pSautLigne);
			
			return resultat;
		}
		
		/* Retourne la chaîne inchangée 
		 * si il n'y avait pas de saut de ligne. */
		return pString;
			
	} // Fin de substituerSautLigne(
	 // String pString
	 // , String pSautLigne).______________________________________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void creerArborescenceParente(
			final File pFile) throws IOException {
		
		/* ne fait rien si pFile == null. */
		if (pFile == null) {
			return;
		}
		
		final Path pathFile = pFile.toPath();
		final Path pathParent = pathFile.getParent();
		
		/* ne fait rien si pFile est une racine (pas de parent). */
		if (pathParent != null) {
			Files.createDirectories(pathParent);
		}
				
	} // Fin de creerArborescenceParente(...)._____________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final File creerFichierSurDisque(
			final File pFile) 
					throws IOException {
		
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* crée sur disque l'arborescence parente de pFile 
		 * si elle n'existe pas déjà. */
		this.creerArborescenceParente(pFile);
		
		Path pathFile = null;
		
		try {
			
			pathFile = Files.createFile(pFile.toPath());
			
		/* Ne crée sur disque pFile que si il n'existe pas déjà.*/	
		} catch (FileAlreadyExistsException e) {
			return pFile;
		}
		
		return pathFile.toFile();
		
	} // Fin de creerFichierSurDisque(...).________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String retournerPathGenerique(
			final String pPathString) {
		
		/* retourne null si pPathString est blank. */
		if (StringUtils.isBlank(pPathString)) {
			return null;
		}
		
		final String resultat 
			= StringUtils.replaceChars(pPathString, '\\', SLASH);
		
		return resultat;
		
	} // Fin de retournerPathGenerique(...)._______________________________
	
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
	
			
	
} // FIN DE LA CLASSE EnregistreurFichier.-----------------------------------
