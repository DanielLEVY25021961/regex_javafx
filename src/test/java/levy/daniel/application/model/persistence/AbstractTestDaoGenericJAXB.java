package levy.daniel.application.model.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CLASSE <b>AbstractTestDaoGenericJAXB</b> :<br/>
 * <b>classe abstraite factorisant les attributs 
 * et les méthodes de tous les tests JUnit de DAO JAXB</b>.<br/>
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
 * @since 7 sept. 2018
 * 
 * @param <T> : Type paramétré : 
 * Type de l'objet métier sur lequel porte le Test du DAO.
 * @param <ID> : Type paramétré : type de l'ID dans le stockage 
 * de l'objet métier sur lequel porte le Test du DAO. 
 * (Long, Integer, String, ...).<br/>
 */
public abstract class AbstractTestDaoGenericJAXB<T, ID extends Serializable> 
								extends AbstractTestDaoGeneric<T, ID> {

	// ************************ATTRIBUTS************************************/


	/**
	 * "stockage ne doit pas exister : ".<br/>
	 */
	public static final String FILE_PAS_EXISTER 
		= "stockage ne doit pas exister : ";
	
	/**
	 * "stockage doit exister : ".<br/>
	 */
	public static final String FILE_EXISTER 
		= "stockage doit exister : ";
	
	/**
	 * <b>Stockage des données</b> (fichier XML).<br/>
	 * Equivalent d'une Table dans un SGBDR JPA.<br/>
	 */
	protected transient File stockage;


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AbstractTestDaoGenericJAXB.class);


	// *************************METHODES************************************/
	

	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public AbstractTestDaoGenericJAXB() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override 
	public void testCreate(
			final boolean pAffichageGeneral
				, final boolean pAffichage) throws Exception {

		/* DESTRUCTION DU STOCKAGE (FICHIER XML). */
		if (this.stockage.exists()) {
			Files.delete(this.stockage.toPath());
		}
		
		/* garantit que le stockage (fichier XML) n'existe pas. */
		assertFalse(FILE_PAS_EXISTER, this.stockage.exists());
		
		
		// *************************************************************
		/* enregistrement d'un objet dans le stockage (fichier XML). */
		final T objetPersiste = this.daoATester.create(this.objet1);
		// *************************************************************
		
		
		/* garantit que create() crée sur disque le fichier XML si il n'existe pas. */
		assertTrue(FILE_EXISTER, this.stockage.exists());
		
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
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que create() insère un enregistrement dans le stockage. */
		assertEquals(STOCKAGE_CONTIENT_1_ENREGISTREMENT
				, (Long) 1L
					, nombreInitial);

		
		// ******************************************************************
		/* enregistrement d'un DOUBLON dans le stockage (fichier XML). */
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

	} // Fin de testCreate().______________________________________________




} // FIN DE LA CLASSE AbstractTestDaoGenericJAXB.----------------------------
