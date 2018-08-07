package levy.daniel.application.model.metier.regex;

import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.metier.regex.impl.Regex;


/**
 * CLASSE RegexTest :<br/>
 * Test JUnit de la classe RegEx.<br/>
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
 * @since 6 août 2018
 *
 */
public class RegexTest {
	// ************************ATTRIBUTS************************************/
	
	/**
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	/**
	 * "La chaîne '".<br/>
	 */
	public static final String CHAINE = "La chaîne '";
	
	/**
	 * "' : "<br/>
	 */
	public static final String DEUX_POINTS = "' : ";
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(RegexTest.class);
	

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public RegexTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	/**
	 * teste la méthode expliquerMotif(String).<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 */
	@Test
	public void testExpliquerMotif() {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE RegexTest - méthode testExpliquerMotif() ********** ");
		}


		// **********************************
		final String motif = "^\\d+";
		final String chaineATester = "10";
		// **********************************
		
		
		final IRegex regex = new Regex();
		regex.setMotifJava(motif);
		
		final boolean resultatContient = regex.motifFind(chaineATester);
		final boolean resultatMatche = regex.motifMatche(chaineATester);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
			System.out.println("EXPLICATION DU MOTIF : ");
			System.out.println(regex.getSignificationMotif());
			System.out.println();
			System.out.println(CHAINE + chaineATester + "' contient-elle le motif java '\\" + motif + DEUX_POINTS + resultatContient);
			System.out.println(CHAINE + chaineATester + "' matche-t-elle le motif java '\\" + motif + DEUX_POINTS + resultatMatche);
		}
		
		assertTrue("BIDON : ", 1 == 1);
		
	} // Fin de testMotifMatche()._________________________________________

	
	
	/**
	 * teste la méthode motifMatche(String).<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 */
	@Test
	public void testMotifMatche() {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE RegexTest - méthode testMotifMatche() ********** ");
		}


		// **********************************
		final String motif = "[0-9]";
		final String chaineATester = "10";
		// **********************************
		
		
		final IRegex regex = new Regex();
		regex.setMotifJava(motif);
		
		final boolean resultatContient = regex.motifFind(chaineATester);
		final boolean resultatMatche = regex.motifMatche(chaineATester);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(CHAINE + chaineATester + "' contient-elle le motif java '\\" + motif + DEUX_POINTS + resultatContient);
			System.out.println(CHAINE + chaineATester + "' matche-t-elle le motif java '\\" + motif + DEUX_POINTS + resultatMatche);
		}
		
		assertTrue("BIDON : ", 1 == 1);
		
	} // Fin de testMotifMatche()._________________________________________

	
	
} // FIN DE LA CLASSE RegexTest.---------------------------------------------
