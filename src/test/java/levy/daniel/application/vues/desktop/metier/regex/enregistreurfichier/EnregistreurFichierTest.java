package levy.daniel.application.vues.desktop.metier.regex.enregistreurfichier;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * CLASSE EnregistreurFichierTest :<br/>
 * Test JUnit de la classe EnregistreurFichier.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * creer fichier, creer fichier sur disque, <br/>
 * créer fichier, créer fichier sur disque, <br/>
 * détruire fichier, détruire fichier sur disque, <br/>
 * detruire fichier, detruire fichier sur disque, <br/>
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
public class EnregistreurFichierTest {
	// ************************ATTRIBUTS************************************/
	
	/**
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	/**
	 * "unused".<br/>
	 */
	public static final String UNUSED = "unused";
	
	/**
	 * SLASH : char :<br/>
	 * Séparateur générique des fichiers slash.<br/>
	 * '/'.<br/>
	 */
	public static final char SLASH = '/';
		
	/**
	 * Charset.forName("UTF-8").<br/>
	 * Eight-bit Unicode (or UCS) Transformation Format.<br/> 
	 */
	public static final Charset CHARSET_UTF8 
		= Charset.forName("UTF-8");

	/**
	 * Charset.forName("Windows-1252").<br/>
	 * Charset ANSI.<br/>
	 */
	public static final Charset CHARSET_ANSI 
		= Charset.forName("Windows-1252");

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(EnregistreurFichierTest.class);

	// *************************METHODES************************************/
	
		
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public EnregistreurFichierTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * teste la méthode enregistrerContenuDansFichier(String, File).<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 * 
	 * @throws IOException 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testEnregistrerContenuDansFichier() throws IOException {
	
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE EnregistreurFichierTest - méthode testEnregistrerContenuDansFichier() ********** ");
		}
		
		final String contenu = "vous êtes gentil\nc'est bien";
		final File fichierTest = this.creerFichierTest();
		this.creerFichierSurDisque(fichierTest);
		
		final IEnregistreurFichier enregistreur 
			= new EnregistreurFichier();
		
		enregistreur.enregistrerContenuDansFichier(contenu, fichierTest);
		
		assertTrue(
				"Le fichier de test doit avoir du contenu : "
					, fichierTest.length() > 0);

		this.detruireFichierTest();
		
	} // Fin de testEnregistrerContenuDansFichier()._______________________
	

	
	/**
	 * Crée un fichier de test abstrait (vide).<br/>
	 *
	 * @return : File : fichier de test.<br/>
	 */
	private File creerFichierTest() {
		
		final String pathDataString
		= this.retournerPathGenerique(
				System.getProperty("user.dir")) + "/data";
	
		final Path pathData = Paths.get(pathDataString);
		
		final String nomFile = "fichier_test.txt";
		
		final Path pathFile = pathData.resolve(nomFile);
		
		final File fileTest = pathFile.toFile();
		
		return fileTest;
		
	} // Fin de creerFichierTest().________________________________________
	
	

	/**
	 * Détruit le fichier de test.<br/>
	 *
	 * @throws IOException
	 */
	private void detruireFichierTest() throws IOException {
		
		final File fichierTest = this.creerFichierTest();
		
		if (fichierTest.exists()) {
			Files.delete(fichierTest.toPath());
		}
		
	} // Fin de detruireFichierTest()._____________________________________
	
	
	
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
	private void creerArborescenceParente(
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
	private File creerFichierSurDisque(
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
	private String retournerPathGenerique(
			final String pPathString) {
		
		/* retourne null si pPathString est blank. */
		if (StringUtils.isBlank(pPathString)) {
			return null;
		}
		
		final String resultat 
			= StringUtils.replaceChars(pPathString, '\\', SLASH);
		
		return resultat;
		
	} // Fin de retournerPathGenerique(...)._______________________________
	

	
} // FIN DE LA CLASSE EnregistreurFichierTest.-------------------------------
