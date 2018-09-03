package levy.daniel.application.model.dao.metier.regex.jaxb.entities.impl;

import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


/**
 * CLASSE <b>MotifEntityJAXBTest</b> :<br/>
 * Test JUnit de la classe MotifEntityJAXB.<br/>
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
 * @since 2 sept. 2018
 *
 */
public class MotifEntityJAXBTest {
	
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
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(MotifEntityJAXBTest.class);


	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MotifEntityJAXBTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	

	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 * :  :  .<br/>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testCreate() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifEntityJAXBTest - méthode testCreate() ********** ");
		}

		
		assertTrue("BIDON : ", 1 == 1);
		
	} // Fin de testCreate().______________________________________________
	
	
	
} // FIN DE LA CLASSE MotifEntityJAXBTest.-----------------------------------
