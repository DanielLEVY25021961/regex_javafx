package levy.daniel.application.model.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CLASSE AbstractTestDaoGenericJPA :<br/>
 * <b>classe abstraite factorisant les attributs 
 * et les méthodes de tous les tests JUnit de DAO JPA sans Spring</b>.<br/>
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
 * @since 11 sept. 2018
 * 
 * @param <T> : Type paramétré : 
 * Type de l'objet métier sur lequel porte le Test du DAO.
 * @param <ID> : Type paramétré : type de l'ID dans le stockage 
 * de l'objet métier sur lequel porte le Test du DAO. 
 * (Long, Integer, String, ...).<br/>
 */
public abstract class AbstractTestDaoGenericJPA<T, ID extends Serializable> 
									extends AbstractTestDaoGeneric<T, ID> {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AbstractTestDaoGenericJPA.class);

	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public AbstractTestDaoGenericJPA() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override // NOPMD by dan on 10/09/18 13:02
	public void testCreate(
			final boolean pAffichageGeneral
				, final boolean pAffichage) throws Exception {
		
		/* VIDAGE DU STOCKAGE (TABLE SGBDR JPA). */
		this.daoATester.deleteAll();
		
		/* garantit que le stockage (TABLE SGBDR JPA) est vide. */
		final List<T> listeEnregistrements = this.daoATester.findAll();
		
		assertTrue(
				"le stockage doit être vide : "
					, listeEnregistrements.isEmpty());
		
		
		// *************************************************************
		/* enregistrement d'un objet dans le stockage (TABLE SGBDR JPA). */
		final T objetPersiste = this.daoATester.create(this.objet1);
		// *************************************************************
		
				
		/* garantit que create() retourne une instance persistée. */
		assertNotNull(
				"create(...) doit retourner une instance persistée : "
					, objetPersiste);
		
		assertEquals(
				"create(...) doit retourner une instance persistée equals à this.objet1 : "
					, this.objet1 
						, objetPersiste);
		
		final Long nombreInitial = this.daoATester.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (pAffichageGeneral && pAffichage) {
			System.out.println();
			System.out.println("objet persisté retourne par create(T pObject) : " + objetPersiste.toString());
			System.out.println(CONTENU_STOCKAGE);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que create() insère un enregistrement dans le stockage. */
		assertEquals(STOCKAGE_CONTIENT_1_ENREGISTREMENT
				, (Long) 1L
					, nombreInitial);
		
		// ******************************************************************
		/* enregistrement d'un DOUBLON dans le stockage (TABLE SGBDR JPA). */
		final T motifDoublon = this.daoATester.create(this.objet1);
		// ******************************************************************
		
		final Long nombreApresDoublon = this.daoATester.count();
		
		/* garantit que create(Doublon) retourne null. */
		assertNull(
				"create(Doublon) doit retourner null : "
					, motifDoublon);
		
		/* garantit que create(Doublon) ne crée pas de doublon. */
		assertEquals(STOCKAGE_CONTIENT_1_ENREGISTREMENT
				, (Long) 1L
					, nombreApresDoublon);
		
		/* garantit que create(null) retourne null. */
		assertNull(
				"create(null) doit retourner null : "
					, this.daoATester.create(null));

	} // Fin de testCreate(...).___________________________________________



} // FIN DE LA CLASSE AbstractTestDaoGenericJPA.-----------------------------
