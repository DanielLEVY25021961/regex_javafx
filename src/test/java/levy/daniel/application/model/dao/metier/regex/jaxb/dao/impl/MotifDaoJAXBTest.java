package levy.daniel.application.model.dao.metier.regex.jaxb.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.model.metier.regex.impl.Motif;
import levy.daniel.application.model.persistence.metier.regex.jaxb.dao.IMotifDaoJAXB;
import levy.daniel.application.model.persistence.metier.regex.jaxb.dao.impl.MotifDaoJAXB;


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
	 * new Motif("1 chiffre", "\\d", "1 chiffre", "[0-9]", "/ \\d /").<br/>
	 */
	public static final IMotif MOTIF1 
	= new Motif("1 chiffre", "\\d", "1 chiffre", "[0-9]", "/ \\d /");
	
	/**
	 * new Motif("commence par 1 à 3 chiffres", "^\\d{1,3}?", "commence par 1 à 3 chiffres reluctant", "^\\d[0-9]{1,3}?", "/ ^\\\\d{1,3}? /").<br/>
	 */
	public static final IMotif MOTIF2 
		= new Motif("commence par 1 à 3 chiffres", "^\\d{1,3}?", "commence par 1 à 3 chiffres reluctant", "^\\d[0-9]{1,3}?", "/ ^\\\\d{1,3}? /");
	
	/**
	 * new Motif("commence par 1 à 4 chiffres", "^\\d{1,4}?", "commence par 1 à 4 chiffres reluctant", "^\\d[0-9]{1,4}?", "/ ^\\d{1,4}? /").<br/>
	 */
	public static final IMotif MOTIF3 
		= new Motif("commence par 1 à 4 chiffres", "^\\d{1,4}?", "commence par 1 à 4 chiffres reluctant", "^\\d[0-9]{1,4}?", "/ ^\\d{1,4}? /");

	/**
	 * FILE : File :<br/>
	 * new File("data/base-regex_javafx-JAXB/motifs.xml").<br/>
	 */
	public static final File FILE 
		= new File("data/base-regex_javafx-JAXB/motifs.xml");

	/**
	 * "FILE ne doit pas exister : ".<br/>
	 */
	public static final String FILE_PAS_EXISTER 
		= "FILE ne doit pas exister : ";
	
	/**
	 * "FILE doit exister : ".<br/>
	 */
	public static final String FILE_EXISTER 
		= "FILE doit exister : ";
	
	/**
	 * "CONTENU DU FICHIER : '".<br/>
	 */
	public static final String CONTENU_FICHIER 
		= "CONTENU DU FICHIER : '";
		
	/**
	 * "'\n".<br/>
	 */
	public static final String SAUT_APO = "'\n";
	
	/**
	 * "NOMBRE D'ENREGISTREMENTS DANS LE FICHIER : ".<br/>
	 */
	public static final String NOMBRE_ENREGISTREMENTS 
		= "NOMBRE D'ENREGISTREMENTS DANS LE FICHIER : ";
	
	/**
	 * IMotifDaoJAXB.<br/>
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
	 * teste la méthode create(IMotif).<br/>
	 * <ul>
	 * <li>garantit que create() crée sur disque 
	 * le fichier XML si il n'existe pas.</li>
	 * <li>garantit que create() insère un enregistrement 
	 * dans le stockage.</li>
	 * <li>garantit que create() ne crée pas de doublon.</li>
	 * </ul>
	 * 
	 * @throws JAXBException 
	 * @throws IOException 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testCreate() throws JAXBException, IOException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJAXBTest - méthode testCreate() ********** ");
		}

		if (FILE.exists()) {
			Files.delete(FILE.toPath());
		}
		
		/* garantit que le fichier XML n'existe pas. */
		assertFalse(FILE_PAS_EXISTER, FILE.exists());
		
		// *************************************
		/* stockage d'un motif dans le XML. */
		daoJAXB.create(MOTIF1);
		
		/* garantit que create() crée sur disque le fichier XML si il n'existe pas. */
		assertTrue(FILE_EXISTER, FILE.exists());
		
		final Long nombreInitial = daoJAXB.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_FICHIER + FILE.getAbsolutePath() + SAUT_APO);
			daoJAXB.ecrireListeObjetsMetierXMLConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que create() insère un enregistrement dans le stockage. */
		assertEquals("Le fichier doit contenir 1 enregistrement : "
				, (Long) 1L
					, nombreInitial);
		
		// *************************************
		/* stockage d'un motif dans le XML. */
		daoJAXB.create(MOTIF1);
		
		final Long nombreApresDoublon = daoJAXB.count();
		
		/* garantit que create() ne crée pas de doublon. */
		assertEquals("Le fichier doit contenir 1 enregistrement : "
				, (Long) 1L
					, nombreApresDoublon);

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
