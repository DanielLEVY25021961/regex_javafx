package levy.daniel.application.model.persistence.metier.regex.jpa.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.model.metier.regex.impl.Motif;
import levy.daniel.application.model.persistence.AbstractTestDaoGenericJPASpring;
import levy.daniel.application.model.persistence.daoexceptions.AbstractDaoException;


/**
 * CLASSE MotifDaoJPASpringGenericTest :<br/>
 * .<br/>
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
 * @since 8 sept. 2018
 *
 */
public class MotifDaoJPASpringGenericTest 
			extends AbstractTestDaoGenericJPASpring<IMotif, Long>{
	
	// ************************ATTRIBUTS************************************/
	
	/**
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(MotifDaoJPASpringGenericTest.class);
	

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MotifDaoJPASpringGenericTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	
	/**
	 * teste la méthode create(IMotif).<br/>
	 * <ul>
	 * <li>garantit que create(IMotif) insère un enregistrement 
	 * dans la table.</li>
	 * <li>garantit que create(IMotif) retourne l'instance 
	 * persistante.</li>
	 * <li>garantit que create(Doublon) ne crée pas de doublon.</li>
	 * <li>garantit que create(Doublon) retourne null.</li>
	 * <li>garantit que create(null) retourne null.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
//	@Test
	@Override
	public void testCreate() throws Exception { // NOPMD by dan on 08/09/18 09:28
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJPASpringGenericTest - méthode testCreate() ********** ");
		}
		
		super.testCreate(AFFICHAGE_GENERAL, affichage);
		
	} // Fin de testCreate().______________________________________________


	 
	/**
	 * {@inheritDoc}
	 */
	@Before
	@Override
	public void before() throws AbstractDaoException {
				
		this.objet1 
		= new Motif("1 chiffre", "\\d", "1 chiffre", "[0-9]", "/ \\d /");
		
		this.objet2 
		= new Motif("commence par 1 à 3 chiffres", "^\\d{1,3}?", "commence par 1 à 3 chiffres reluctant", "^\\d[0-9]{1,3}?", "/ ^\\\\d{1,3}? /");
		
		this.objet3 
		= new Motif("commence par 1 à 4 chiffres", "^\\d{1,4}?", "commence par 1 à 4 chiffres reluctant", "^\\d[0-9]{1,4}?", "/ ^\\d{1,4}? /");
		
		this.daoATester = new MotifDaoJPASpringGeneric();
		
	} // Fin de before().__________________________________________________	 
	 

	
	
} // FIN DE LA CLASSE MotifDaoJPASpringGenericTest.--------------------------
