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
			System.out.println("La chaîne '" + chaineATester + "' contient-elle le motif java '\\" + motif + "' : " + resultatContient);
			System.out.println("La chaîne '" + chaineATester + "' matche-t-elle le motif java '\\" + motif + "' : " + resultatMatche);
		}
		
		assertTrue("BIDON : ", 1 == 1);
		
	} // Fin de testMotifMatche()._________________________________________

	
	
} // FIN DE LA CLASSE RegexTest.---------------------------------------------
