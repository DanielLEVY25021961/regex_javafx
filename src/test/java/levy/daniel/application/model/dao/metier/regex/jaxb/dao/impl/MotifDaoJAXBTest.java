package levy.daniel.application.model.dao.metier.regex.jaxb.dao.impl;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import levy.daniel.application.model.dao.metier.regex.jaxb.dao.IMotifDaoJAXB;
import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.model.metier.regex.impl.Motif;


/**
 * CLASSE MotifDaoJAXBTest :<br/>
 * Test JUnit de la classe MotifDaoJAXB.<br/>
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
public class MotifDaoJAXBTest {
	
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
	 * FILE : File :<br/>
	 * new File("data/base-regex_javafx-JAXB/motifs.xml").<br/>
	 */
	public static final File FILE 
		= new File("data/base-regex_javafx-JAXB/motifs.xml");

	/**
	 * .<br/>
	 */
	public static transient IMotifDaoJAXB daoJAXB;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(MotifDaoJAXBTest.class);


	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MotifDaoJAXBTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 * :  :  .<br/>
	 * 
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testCreate() throws FileNotFoundException, JAXBException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJAXBTest - méthode testCreate() ********** ");
		}

		final IMotif motif1 
		= new Motif("1 chiffre", "\\d", "1 chiffre", "[0-9]", "/ \\d /");
		final IMotif motif2 
			= new Motif("commence par 1 à 3 chiffres", "^\\d{1,3}?", "commence par 1 à 3 chiffres reluctant", "^\\d[0-9]{1,3}?", "/ ^\\\\d{1,3}? /");
		final IMotif motif3 
			= new Motif("commence par 1 à 4 chiffres", "^\\d{1,4}?", "commence par 1 à 4 chiffres reluctant", "^\\d[0-9]{1,4}?", "/ ^\\d{1,4}? /");

		/* stockage d'un motif dans le XML. */
		daoJAXB.create(motif1);
		
		
		assertTrue("BIDON : ", 1 == 1);
		

	} // Fin de testCreate().______________________________________________

	
	
	/**
	 * method avantTests() :<br/>
	 * <ul>
	 * <li>instructions exécutées <b>avant l'ensemble des tests</b> 
	 * de la classe JUnit.</li>
	 * <li><b>A REMPLIR A LA MAIN</b></li>
	 * </ul>
	 * @throws JAXBException 
	 */
	@BeforeClass
   public static void avantTests() throws JAXBException {
		
		daoJAXB = new MotifDaoJAXB(FILE);
		
	} // Fin de avantTests().______________________________________________
	

	
} // FIN DE LA CLASSE MotifDaoJAXBTest.--------------------------------------
