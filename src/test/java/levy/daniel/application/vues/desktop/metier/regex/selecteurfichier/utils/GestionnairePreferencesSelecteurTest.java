package levy.daniel.application.vues.desktop.metier.regex.selecteurfichier.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.ConfigurationApplicationManager;

/**
 * CLASSE GestionnairePreferencesSelecteurTest :<br/>
 * Test JUnit de la classe GestionnairePreferencesSelecteur.<br/>
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
 * @since 9 août 2018
 *
 */
public class GestionnairePreferencesSelecteurTest {

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
	 * fichier preferences_selecteur.properties.<br/>
	 */
	public transient File filePreferencesProperties;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(GestionnairePreferencesSelecteurTest.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public GestionnairePreferencesSelecteurTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	
	/**
	 * test bidon pour vérifier l'affichage des Charsets.<br/>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testCharsetName() {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE GestionnairePreferencesSelecteurTest - méthode testCharsetName() ********** ");
		}

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println("CHARSET_UTF8.name() : " + CHARSET_UTF8.name());
			System.out.println("CHARSET_UTF8.displayName(Locale.FRANCE) : " + CHARSET_UTF8.displayName(Locale.FRANCE));
			
			System.out.println("CHARSET_ANSI.name() : " + CHARSET_ANSI.name());
			System.out.println("CHARSET_ANSI.displayName(Locale.FRANCE) : " + CHARSET_ANSI.displayName(Locale.FRANCE));
		}
		
		assertNotNull("CHARSET_UTF8.name() n'est pas null : ", CHARSET_UTF8.name());
		
	} // Fin de testCharsetName()._________________________________________
	

	
	/**
	 * Vérifie la création automatique de 
	 * preferences_selecteur.properties 
	 * si il n'existe pas.<br/>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testInitialisation() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE GestionnairePreferencesSelecteurTest - méthode testInitialisation() ********** ");
		}
		
		this.filePreferencesProperties = this.fournirFilePreferencesProperties();
		
		if (this.filePreferencesProperties.exists()) {
			
			final boolean detruit 
				= this.filePreferencesProperties.delete();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("preferences_selecteur.properties détruit : " + detruit);
			}
			
			assertFalse(
					"le fichier preferences_selecteur.properties doit avoir été détruit : "
						, this.filePreferencesProperties.exists());
		}
		
		
		final Charset charsetSelecteur 
			= GestionnairePreferencesSelecteur.getCharsetApplication();
		
		final Locale localeSelecteur 
			= GestionnairePreferencesSelecteur
				.getLocaleDefautApplication();
		
		final File repertoireSelecteur 
			= GestionnairePreferencesSelecteur
				.getRepertoirePrefereFileChooser();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("user.dir : " + System.getProperty("user.dir"));
			System.out.println("Le charset du sélecteur est : " + charsetSelecteur.displayName());
			System.out.println("La locale du sélecteur est : " + localeSelecteur.getDisplayName());
			System.out.println("le répertoire du sélecteur est : " + repertoireSelecteur.getAbsolutePath());
		}
		
		/* vérifie la création du fichier properties. */
		assertTrue("this.filePreferencesProperties.exists() : "
				, this.filePreferencesProperties.exists());
		
		assertNotNull(
				"Le Charset de l'application ne doit pas être null : "
					, charsetSelecteur);
		
	} // Fin de testInitialisation().______________________________________
	

	/**
	 * Garantit que les setters permettent de modifier 
	 * preferences.properties.<br/>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testParametrage() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE GestionnairePreferencesSelecteurTest - méthode testParamétrage() ********** ");
		}
		
		/* UTILISATION DU SETTER (paramétrage). */
		GestionnairePreferencesSelecteur.setCharsetApplication(CHARSET_ANSI);
		GestionnairePreferencesSelecteur.setLocaleDefautApplication(Locale.US);
		
		final Charset charsetAppliqueANSI 
			= GestionnairePreferencesSelecteur.getCharsetApplication();
		final Locale localeAppliqueeUS 
			= GestionnairePreferencesSelecteur.getLocaleDefautApplication();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Charset courant : " + charsetAppliqueANSI.displayName());
			System.out.println("Locale courante : " + localeAppliqueeUS.getDisplayName(Locale.FRANCE));
		}
		
		assertEquals(
				"Le Charset paramétré doit être CHARSET_ANSI : "
					, CHARSET_ANSI, charsetAppliqueANSI);
		
		assertEquals(
				"Le Locale paramétré doit être Locale.US : "
					, Locale.US, localeAppliqueeUS);
		
		/* UTILISATION DU SETTER (paramétrage). */
		GestionnairePreferencesSelecteur.setCharsetApplication(CHARSET_UTF8);
		GestionnairePreferencesSelecteur.setLocaleDefautApplication(Locale.FRANCE);
		
		final Charset charsetAppliqueUTF8 
			= GestionnairePreferencesSelecteur.getCharsetApplication();
		final Locale localeAppliqueeFR 
			= GestionnairePreferencesSelecteur.getLocaleDefautApplication();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Charset courant : " + charsetAppliqueUTF8.displayName());
			System.out.println("Locale courante : " + localeAppliqueeFR.getDisplayName(Locale.FRANCE));
		}
		
		assertEquals(
				"Le Charset paramétré doit être CHARSET_UTF8 : "
					, CHARSET_UTF8, charsetAppliqueUTF8);
		
		assertEquals(
				"Le Locale paramétré doit être Locale.FRANCE : "
					, Locale.FRANCE, localeAppliqueeFR);
		
	} // Fin de testParametrage()._________________________________________
	

	
	/**
	 * Vérifie le motif Regex "(\\S+) \\((\\S+)\\)".<br/>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testRegex() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE GestionnairePreferencesSelecteurTest - méthode testParamétrage() ********** ");
		}
		
		final Locale locale = Locale.US;
		
		final String languePays = this.fournirLangueEtPaysEnFrancais(locale);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Langue et Pays de la Locale : " + languePays);
		}
		
		/* Décompose une String comme anglais (Etats-Unis) 
		 * en Language = "anglais" et coutry = "Etats-Unis". */
		final String motif = "(\\S+) \\((\\S+)\\)";
		final Pattern pattern = Pattern.compile(motif);
		
		final Matcher matcher = pattern.matcher(languePays);
		
		String langue = null;
		String pays = null;
		
		if (matcher.matches()) {
			langue = matcher.group(1);
			pays = matcher.group(2);
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Langue de la Locale : " + langue);
			System.out.println("Pays de la Locale : " + pays);
		}
				
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			final Locale localeInstanciee = new Locale(langue, pays);
			if (localeInstanciee != null) {
				System.out.println(localeInstanciee.getDisplayName(Locale.FRANCE));
			}			
		}
		
		assertTrue("BIDON : ", 1 == 1);
		
	} // Fin de testRegex()._______________________________________________

	
	
	/**
	 * retourne le File preferences_selecteur.properties.<br/>
	 *
	 * @return File : preferences_selecteur.properties
	 * 
	 * @throws Exception
	 */
	private File fournirFilePreferencesProperties() throws Exception {
		
		/* obtient le path du properties dans les 
		 * ressources externes auprès du 
		 * ConfigurationApplicationManager. */
		final Path pathRessourcesExternes 
		= Paths.get(ConfigurationApplicationManager
				.getPathRessourcesExternes());
	
		
		final Path pathAbsoluPreferencesProperties 
			= pathRessourcesExternes
				.resolve("preferences/preferences_selecteur.properties");
				
		final File filePreferencesPropertiesLocal 
			= pathAbsoluPreferencesProperties.toFile();
		
		return filePreferencesPropertiesLocal;
		
	} // Fin de fournirFilePreferencesProperties().________________________

	
	
	/**
	 * <b>Retourne le langage et le pays d'une Locale 
	 * exprimés en français</b> sous forme de String.<br/>
	 * <ul>
	 * Par exemple :
	 * <li><code>français (France)</code> pour une Locale.FRANCE.</li>
	 * <li><code>anglais (Etats-Unis)</code> pour une Locale.US.</li>
	 * </ul>
	 *
	 * @param pLocale : Locale.<br/>
	 * 
	 * @return : String  : langage et pays d'une Locale.<br/>
	 */
	private String fournirLangueEtPaysEnFrancais(
			final Locale pLocale) {
		
		return 
				pLocale.getDisplayLanguage(Locale.FRANCE) 
				+ " (" + pLocale.getDisplayCountry(Locale.FRANCE) + ")";
			
	} // Fin de fournirLangueEtPaysEnFrancais(...).________________________


		
} // FIN DE LA CLASSE GestionnairePreferencesSelecteurTest.------------------
