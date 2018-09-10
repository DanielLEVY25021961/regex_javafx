package levy.daniel.application.model.persistence;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * CLASSE <b>JPAUtilsTest</b> :<br/>
 * Test JUnit de la classe {@link JPAUtils}.<br/>
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
 * @since 9 sept. 2018
 *
 */
public class JPAUtilsTest {
	
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
	private static final Log LOG 
		= LogFactory.getLog(JPAUtilsTest.class);

	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public JPAUtilsTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________




	/**
	 * teste la méthode getEntityManagerFactory().<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetEntityManagerFactory() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE JPAUtilsTest - méthode testGetEntityManagerFactory() ********** ");
		}
		
		
		// *****************************************************************
		// récupération de EntityManagerFactory.
		final EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(JPAUtils.afficherProperties());
		}
		
		assertNotNull(
				"EntityManagerFactory ne doit pas être null : "
					, emf);

	} // Fin de testGetEntityManagerFactory()._____________________________


	
	/**
	 * <ul>
	 * <li>instructions exécutées <b>une seule fois 
	 * lors de l'instanciation de la présente classe 
	 * AVANT l'ensemble des tests</b> 
	 * contenus par la présente classe JUnit.</li>
	 * </ul>
	 *
	 * @throws IOException 
	 */
	@BeforeClass
	public static void avantLaClasse() throws IOException {
		
		// ***************************************************
		// REMPLACE LE persistence.xml par persistence-text.xml
		JPAUtils.activerPersistenceTestXml();

	} // Fin de avantLaClasse().___________________________________________
	

	
	/**
	 * <ul>
	 * <li>instructions exécutées <b>une seule fois 
	 * lors de la fermeture de la présente classe 
	 * APRES l'ensemble des tests</b> 
	 * contenus par la présente classe JUnit.</li>
	 * </ul>
	 *
	 * @throws IOException
	 */
	@AfterClass
	public static void apresLaClasse() throws IOException {
		
		// ***************************************************
		// RETABLIT LE persistence.xml original
		JPAUtils.activerPersistenceXml();

	} // Fin de apresLaClasse().___________________________________________
	
	
	
} // FIN DE LA CLASSE JPAUtilsTest.------------------------------------------
