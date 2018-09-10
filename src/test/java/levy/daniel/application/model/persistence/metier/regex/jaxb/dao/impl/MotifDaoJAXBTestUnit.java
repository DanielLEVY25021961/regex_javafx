package levy.daniel.application.model.persistence.metier.regex.jaxb.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.model.metier.regex.impl.Motif;
import levy.daniel.application.model.persistence.AbstractTestDaoGenericJAXB;
import levy.daniel.application.model.persistence.IDaoGenericJAXB;



/**
 * CLASSE MotifDaoJAXBTestUnit :<br/>
 * Test JUnit de la classe MotifDaoJAXB.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Test Dao, test DAO, Test persistence,<br/> 
 * Test DAO JAXB, <br/>
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
public class MotifDaoJAXBTestUnit 
				extends AbstractTestDaoGenericJAXB<IMotif, Long> {
	
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
		= LogFactory.getLog(MotifDaoJAXBTestUnit.class);


	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MotifDaoJAXBTestUnit() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * teste la méthode create(IMotif).<br/>
	 * <ul>
	 * <li>garantit que create(IMotif) crée sur disque 
	 * le stockage (fichier XML) si il n'existe pas.</li>
	 * <li>garantit que create(IMotif) insère un enregistrement 
	 * dans this.stockage.</li>
	 * <li>garantit que create(IMotif) retourne l'instance 
	 * persistante.</li>
	 * <li>garantit que create(Doublon) ne crée pas de doublon.</li>
	 * <li>garantit que create(Doublon) retourne null.</li>
	 * <li>garantit que create(null) retourne null.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	@Override
	public void testCreate() throws Exception { // NOPMD by dan on 08/09/18 09:28
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJAXBTestUnit - méthode testCreate() ********** ");
		}
		
		super.testCreate(AFFICHAGE_GENERAL, affichage);
		
	} // Fin de testCreate().______________________________________________


	
	/**
	 * teste la méthode createReturnId(IMotif).<br/>
	 * <ul>
	 * <li>garantit que createReturnId() crée sur disque 
	 * le fichier XML si il n'existe pas.</li>
	 * <li>grantit que createReturnId(existant) retourne un identifiant.</li>
	 * <li>garantit que createReturnId() insère un enregistrement 
	 * dans le this.stockage.</li>
	 * <li>garantit que createReturnId() ne crée pas de doublon.</li>
	 * <li>garantit que createReturnId(Doublon) retourne null.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testCreateReturnId() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJAXBTestUnit - méthode testCreateReturnId() ********** ");
		}

		if (this.stockage.exists()) {
			Files.delete(this.stockage.toPath());
		}
		
		/* garantit que le fichier XML n'existe pas. */
		assertFalse(FILE_PAS_EXISTER, this.stockage.exists());
		
		// *************************************
		/* this.stockage d'un motif dans le XML. */
		final Long idMotif = this.daoATester.createReturnId(this.objet1);
		
		/* grantit que createReturnId(existant) retourne un identifiant. */
		assertNotNull(
				"createReturnId(existant) doit retourner un identifiant : "
					, idMotif);
		
		/* garantit que create() crée sur disque le fichier XML si il n'existe pas. */
		assertTrue(FILE_EXISTER, this.stockage.exists());
		
		final Long nombreInitial = this.daoATester.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que create() insère un enregistrement dans le this.stockage. */
		assertEquals(STOCKAGE_CONTIENT_1_ENREGISTREMENT
				, (Long) 1L
					, nombreInitial);
		
		// *************************************
		/* this.stockage d'un motif dans le XML (Doublon). */
		final Long idMotifDoublon = this.daoATester.createReturnId(this.objet1);
		
		final Long nombreApresDoublon = this.daoATester.count();
		
		/* garantit que createReturnId(Doublon) retourne null. */
		assertNull(
				"createReturnId(Doublon) doit retourner null : "
					, idMotifDoublon);		
		/* garantit que createReturnId() ne crée pas de doublon. */
		assertEquals(STOCKAGE_CONTIENT_1_ENREGISTREMENT
				, (Long) 1L
					, nombreApresDoublon);

	} // Fin de testCreateReturnId().______________________________________

	
	
	/**
	 * teste la méthode save(Iterable).<br/>
	 * <ul>
	 * <li>garantit que save() crée sur disque le fichier XML 
	 * si il n'existe pas.</li>
	 * <li>garantit que save() stocke dans le fichier XML 
	 * la totalité de la liste.</li>
	 * <li>garantit que save() ne crée pas de doublons.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testSave() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJAXBTestUnit - méthode testSave() ********** ");
		}

		if (this.stockage.exists()) {
			Files.delete(this.stockage.toPath());
		}
		
		/* garantit que le fichier XML n'existe pas. */
		assertFalse(FILE_PAS_EXISTER, this.stockage.exists());
		
		final List<IMotif> liste1 = new ArrayList<IMotif>();
		liste1.add(this.objet1);
		liste1.add(this.objet2);
		
		final List<IMotif> liste2 = new ArrayList<IMotif>();
		liste2.add(this.objet2);
		liste2.add(this.objet3);
		
		// *************************************
		/* this.stockage d'un motif dans le XML. */
		this.daoATester.save(liste1);
		
		/* garantit que save() crée sur disque le fichier XML si il n'existe pas. */
		assertTrue(FILE_EXISTER, this.stockage.exists());
		
		final Long nombreInitial = this.daoATester.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que save() stocke dans le fichier XML 
		 * la totalité de la liste. */
		assertEquals("Le fichier doit contenir 2 enregistrements : "
				, (Long) 2L
					, nombreInitial);
		
		// *************************************
		/* this.stockage d'un motif dans le XML. */
		this.daoATester.save(liste2);
		
		final Long nombreFinal = this.daoATester.count(); 

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreFinal);
		}

		/* garantit que save() stocke dans le fichier XML 
		 * la totalité de la liste. */
		/* garantit que save() ne crée pas de doublons.*/
		assertEquals(STOCKAGE_CONTIENT_3_ENEGISTREMENTS
				, (Long) 3L
					, nombreFinal);
		
	} // Fin de testSave().________________________________________________
	

	
	/**
	 * teste la méthode retrieve(IMotif).<br/>
	 * <ul>
	 * <li>garantit que retrieve(existant) retourne 
	 * un unique objet métier.</li>
	 * <li>garantit que retrieve(existant) fonctionne bien.</li>
	 * <li>garantit que retrieve(null) retourne null.</li>
	 * <li>garantit que retrieve(inexistant) retourne null.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testRetrieve() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJAXBTestUnit - méthode testRetrieve() ********** ");
		}

		if (this.stockage.exists()) {
			Files.delete(this.stockage.toPath());
		}
		
		/* garantit que le fichier XML n'existe pas. */
		assertFalse(FILE_PAS_EXISTER, this.stockage.exists());
		
		final List<IMotif> liste1 = new ArrayList<IMotif>();
		liste1.add(this.objet1);
		liste1.add(this.objet2);
		liste1.add(this.objet3);
		
		/* this.stockage d'un motif dans le XML. */
		this.daoATester.save(liste1);
		
		/* garantit que save() crée sur disque le fichier XML si il n'existe pas. */
		assertTrue(FILE_EXISTER, this.stockage.exists());
		
		final Long nombreInitial = this.daoATester.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que save() stocke dans le fichier XML 
		 * la totalité de la liste. */
		assertEquals(STOCKAGE_CONTIENT_3_ENEGISTREMENTS
				, (Long) 3L
					, nombreInitial);

		// *************************************
		/* RECHERCHE d'un motif dans le XML. */
		final IMotif motif = this.daoATester.retrieve(this.objet2);
		final IMotif motifNull = this.daoATester.retrieve(null);
		final IMotif motifInexistantPur 
			= new Motif(7L, "inexistant1", "inexistant2", "inexistant3", "inexistant3", "inexistant5");
		final IMotif motifInexistant = this.daoATester.retrieve(motifInexistantPur);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("MOTIF RECHERCHE : " + motif.toString());
		}
		
		/* garantit que retrieve(existant) retourne un unique objet métier. */
		assertNotNull(
				"retrieve() doit retourner un unique objet métier : "
					, motif);
		
		/* garantit que retrieve(existant) fonctionne bien. */
		assertEquals("retrieve() doit retourner le bon objet métier : "
				, this.objet2
					, motif);
		
		/* garantit que retrieve(null) retourne null. */
		assertNull(
				"retrieve(null) doit retourner null : "
					, motifNull);
		
		/* garantit que retrieve(inexistant) retourne null.*/
		assertNull(
				"retrieve(inexistant) doit retourner null : "
					, motifInexistant);
		
	} // Fin de testRetrieve().____________________________________________


	
	/**
	 * teste la méthode findById(int pId).<br/>
	 * <ul>
	 * <li>garantit que findById(indexExistant) 
	 * retourne un objet métier.</li>
	 * <li>garantit le bon fonctionnement de 
	 * findById(indexExistant).</li>
	 * <li>garantit que findById(0) retourne null.</li>
	 * <li>garantit que findById(indexInexistant) retourne null.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFindById() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJAXBTestUnit - méthode testFindById() ********** ");
		}

		if (this.stockage.exists()) {
			Files.delete(this.stockage.toPath());
		}
		
		/* garantit que le fichier XML n'existe pas. */
		assertFalse(FILE_PAS_EXISTER, this.stockage.exists());
		
		final List<IMotif> liste1 = new ArrayList<IMotif>();
		liste1.add(this.objet1);
		liste1.add(this.objet2);
		liste1.add(this.objet3);
		
		/* this.stockage d'un motif dans le XML. */
		this.daoATester.save(liste1);
		
		/* garantit que save() crée sur disque le fichier XML si il n'existe pas. */
		assertTrue(FILE_EXISTER, this.stockage.exists());
		
		final Long nombreInitial = this.daoATester.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que save() stocke dans le fichier XML 
		 * la totalité de la liste. */
		assertEquals(STOCKAGE_CONTIENT_3_ENEGISTREMENTS
				, (Long) 3L
					, nombreInitial);
		
		// *******************************************
		/* RECHERCHE d'un objet métier dans le XML. */
		final Long index = 1L;
		final IMotif motif = this.daoATester.findById(index);
		final IMotif motifZero = this.daoATester.findById(0L);
		final IMotif motifInexistant = this.daoATester.findById(7L);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("MOTIF RECHERCHE PAR INDEX : " + motif.toString());
		}

		/* garantit que findById(indexExistant) retourne un objet métier. */
		assertNotNull("l'objet métier ne doit pas être null : ", motif);
		
		/* garantit le bon fonctionnement de findById(indexExistant). */
		assertEquals(
				"l'objet métier doit valoir une certaine valeur : "
					, this.objet2
						, motif);
		
		/* garantit que findById(0) retourne null. */
		assertNull(
				"findById(0) doit retourner null : "
					, motifZero);
		
		/* garantit que findById(indexInexistant) retourne null. */
		assertNull(
				"findById(indexInexistant) doit retourner null : "
					, motifInexistant);
		
	} // Fin de testFindById().____________________________________________
	
	
	
	/**
	 * teste la méthode retrieveId(IMotif).<br/>
	 * <ul>
	 * <li>garantit que retrieveId(existant) fonctionne bien.</li>
	 * <li>garantit que retrieveId(null) retourne 0.</li>
	 * <li>garantit que retrieveId(inexistant) retourne 0.</li>
	 * </ul>
	 *
	 * @throws JAXBException
	 * @throws IOException
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testRetrieveId() throws JAXBException, IOException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJAXBTestUnit - méthode testRetrieveId() ********** ");
		}

		if (this.stockage.exists()) {
			Files.delete(this.stockage.toPath());
		}
		
		/* garantit que le fichier XML n'existe pas. */
		assertFalse(FILE_PAS_EXISTER, this.stockage.exists());
		
		final List<IMotif> liste1 = new ArrayList<IMotif>();
		liste1.add(this.objet1);
		liste1.add(this.objet2);
		liste1.add(this.objet3);
		
		// CAST
		final IDaoGenericJAXB<IMotif, Long> daoJAXBCaste 
			= (IDaoGenericJAXB<IMotif, Long>) this.daoATester;
		
		/* this.stockage d'un motif dans le XML. */
		daoJAXBCaste.save(liste1);
		
		/* garantit que save() crée sur disque le fichier XML si il n'existe pas. */
		assertTrue(FILE_EXISTER, this.stockage.exists());
		
		final Long nombreInitial = daoJAXBCaste.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			daoJAXBCaste.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que save() stocke dans le fichier XML 
		 * la totalité de la liste. */
		assertEquals(STOCKAGE_CONTIENT_3_ENEGISTREMENTS
				, (Long) 3L
					, nombreInitial);

		// *******************************************
		/* RECHERCHE d'un objet métier dans le XML. */
		final Long indexMotif = daoJAXBCaste.retrieveId(this.objet2);
		final Long indexMotifNull = daoJAXBCaste.retrieveId(null);
		final IMotif motifInexistantPur 
			= new Motif(7L, "inexistant11", "inexistant21", "inexistant31", "inexistant31", "inexistant51");
		final Long indexMotifInexistant = daoJAXBCaste.retrieveId(motifInexistantPur);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("INDEX DU MOTIF RECHERCHE : " + indexMotif);
		}
		
		
		/* garantit que retrieveId(existant) fonctionne bien. */
		assertEquals("retrieveId() doit retourner le bon index d'objet métier : "
				, (Long) 1L
					, indexMotif);
		
		/* garantit que retrieveId(null) retourne 0. */
		assertEquals(
				"retrieveId(null) doit retourner 0 : "
					, (Long) 0L
						, indexMotifNull);
		
		/* garantit que retrieve(inexistant) retourne 0.*/
		assertEquals(
				"retrieveId(inexistant) doit retourner 0 : "
					, (Long) 0L
						, indexMotifInexistant);
		
	} // Fin de testRetrieveId().__________________________________________
	

	
	/**
	 * teste la méthode findByMetier(String).<br/>
	 * <ul>
	 * <li>garantit que findByMetier(recherche) fonctionne 
	 * correctement.</li>
	 * <li>garantit que findByMetier(rechercheInexistante) 
	 * retourne une liste vide.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFindByMetier() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJAXBTestUnit - méthode testFindByMetier() ********** ");
		}

		if (this.stockage.exists()) {
			Files.delete(this.stockage.toPath());
		}
		
		/* garantit que le fichier XML n'existe pas. */
		assertFalse(FILE_PAS_EXISTER, this.stockage.exists());
		
		final List<IMotif> liste1 = new ArrayList<IMotif>();
		liste1.add(this.objet1);
		liste1.add(this.objet2);
		liste1.add(this.objet3);
				
		/* this.stockage d'un motif dans le XML. */
		this.daoATester.save(liste1);
		
		/* garantit que save() crée sur disque le fichier XML si il n'existe pas. */
		assertTrue(FILE_EXISTER, this.stockage.exists());
		
		final Long nombreInitial = this.daoATester.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que save() stocke dans le fichier XML 
		 * la totalité de la liste. */
		assertEquals(STOCKAGE_CONTIENT_3_ENEGISTREMENTS
				, (Long) 3L
					, nombreInitial);
		
		// CAST
		final IDaoGenericJAXB<IMotif, Long> daoJAXBCaste 
			= (IDaoGenericJAXB<IMotif, Long>) this.daoATester;
		
		
		// *******************************************
		/* RECHERCHE d'objets métier dans le XML. */
		final String recherche = "chiffres";
		final String rechercheInexistant = "toto";
		final List<IMotif> liste = daoJAXBCaste.findByMetier(recherche);
		final List<IMotif> listeInexistant = daoJAXBCaste.findByMetier(rechercheInexistant);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("LISTE EXISTANTE : ");
			System.out.println(this.daoATester.afficherListeObjetsMetier(liste));
			System.out.println();
			System.out.println("LISTE INEXISTANTE : ");
			System.out.println(this.daoATester.afficherListeObjetsMetier(listeInexistant));
		}
		
		/* garantit que findByMetier(recherche) fonctionne 
		 * correctement. */
		assertEquals(
				"la liste doit retourner 2 éléments : "
					, 2
						, liste.size());
		
		/* garantit que findByMetier(rechercheInexistante) 
		 * retourne une liste vide. */
		assertTrue(
				"findByMetier(rechercheInexistante) doit retourner une liste vide : "
					, listeInexistant.isEmpty());
		
	} // Fin de testFindByMetier().________________________________________
	

	
	/**
	 * teste la méthode findAll().<br/>
	 * <ul>
	 * <li>garantit que findAll() fonctionne correctement.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFindAll() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJAXBTestUnit - méthode testFindAll() ********** ");
		}

		if (this.stockage.exists()) {
			Files.delete(this.stockage.toPath());
		}
		
		/* garantit que le fichier XML n'existe pas. */
		assertFalse(FILE_PAS_EXISTER, this.stockage.exists());
		
		final List<IMotif> liste1 = new ArrayList<IMotif>();
		liste1.add(this.objet1);
		liste1.add(this.objet2);
		liste1.add(this.objet3);
		
		/* this.stockage d'un motif dans le XML. */
		this.daoATester.save(liste1);
		
		/* garantit que save() crée sur disque le fichier XML si il n'existe pas. */
		assertTrue(FILE_EXISTER, this.stockage.exists());
		
		final Long nombreInitial = this.daoATester.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que save() stocke dans le fichier XML 
		 * la totalité de la liste. */
		assertEquals(STOCKAGE_CONTIENT_3_ENEGISTREMENTS
				, (Long) 3L
					, nombreInitial);
		
		// *******************************************
		/* RECHERCHE d'objets métier dans le XML. */
		final List<IMotif> liste = this.daoATester.findAll();
		
		/* garantit que findAll() fonctionne 
		 * correctement. */
		assertEquals(
				"la liste doit retourner 3 éléments : "
					, 3
						, liste.size());
		
	} // Fin de testFindAll()._____________________________________________
		

	
	/**
	 * .<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 *
	 * @throws Exception : void :  .<br/>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFindAllMax() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJAXBTestUnit - méthode testFindAllMax() ********** ");
		}

		if (this.stockage.exists()) {
			Files.delete(this.stockage.toPath());
		}
		
		/* garantit que le fichier XML n'existe pas. */
		assertFalse(FILE_PAS_EXISTER, this.stockage.exists());
		
		final List<IMotif> liste1 = new ArrayList<IMotif>();
		liste1.add(this.objet1);
		liste1.add(this.objet2);
		liste1.add(this.objet3);
		
		/* this.stockage d'un motif dans le XML. */
		this.daoATester.save(liste1);
		
		/* garantit que save() crée sur disque le fichier XML si il n'existe pas. */
		assertTrue(FILE_EXISTER, this.stockage.exists());
		
		final Long nombreInitial = this.daoATester.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que save() stocke dans le fichier XML 
		 * la totalité de la liste. */
		assertEquals(STOCKAGE_CONTIENT_3_ENEGISTREMENTS
				, (Long) 3L
					, nombreInitial);
		
	} // Fin de testFindAllMax().__________________________________________
	
	
	
	/**
	 * teste la méthode update(...).<br/>
	 * <ul>
	 * <li>garantit le bon fonctionnement de update(...).</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testUpdate() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJAXBTestUnit - méthode testUpdate() ********** ");
		}

		if (this.stockage.exists()) {
			Files.delete(this.stockage.toPath());
		}
		
		/* garantit que le fichier XML n'existe pas. */
		assertFalse(FILE_PAS_EXISTER, this.stockage.exists());
		
		final List<IMotif> liste1 = new ArrayList<IMotif>();
		liste1.add(this.objet1);
		liste1.add(this.objet2);
		liste1.add(this.objet3);
		
		/* this.stockage d'un motif dans le XML. */
		this.daoATester.save(liste1);
		
		/* garantit que save() crée sur disque le fichier XML si il n'existe pas. */
		assertTrue(FILE_EXISTER, this.stockage.exists());
		
		final Long nombreInitial = this.daoATester.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que save() stocke dans le fichier XML 
		 * la totalité de la liste. */
		assertEquals(STOCKAGE_CONTIENT_3_ENEGISTREMENTS
				, (Long) 3L
					, nombreInitial);
		
		// *******************************************
		/* RECHERCHE d'objets métier dans le XML. */
		final List<IMotif> liste = this.daoATester.findAll();
		
		/* garantit que findAll() fonctionne 
		 * correctement. */
		assertEquals(
				"la liste doit retourner 3 éléments : "
					, 3
						, liste.size());
		
		
		/* RECHERCHE d'un objet métier dans le XML. */
		final Long indexMotif = this.daoATester.retrieveId(this.objet2);

		final IMotif objetModifie 
			= new Motif(
					7L
					, "modifie1"
					, "modifie2", "modifie3", "modifie4", "modifie5");
		
		// *******************************************
		// MODIFICATION.
		this.daoATester.update(indexMotif, objetModifie);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que save() stocke dans le fichier XML 
		 * la totalité de la liste. */
		assertEquals(STOCKAGE_CONTIENT_3_ENEGISTREMENTS
				, (Long) 3L
					, nombreInitial);
		
		/* RECHERCHE d'objets métier dans le XML. */
		final List<IMotif> listeModifiee = this.daoATester.findAll();
		
		/* garantit le bon fonctionnement de update(...). */
		assertEquals(
				"objetModifie doit avoir remplacé this.objet2 : "
					, objetModifie
						, listeModifiee.get(indexMotif.intValue()));
		
	} // Fin de testUpdate().______________________________________________
	

	
	/**
	 * teste la méthode delete(...).<br/>
	 * <ul>
	 * <li>garantit que delete(existant) supprime dans le fichier XML 
	 * un enregistrement existant.</li>
	 * <li>garantit que delete(existant) retourne true.</li>
	 * <li>garantit que delete(null) retourne false.</li>
	 * <li>garantit que delete(inexistant) retourne false.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDelete() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJAXBTestUnit - méthode testDelete() ********** ");
		}

		if (this.stockage.exists()) {
			Files.delete(this.stockage.toPath());
		}
		
		/* garantit que le fichier XML n'existe pas. */
		assertFalse(FILE_PAS_EXISTER, this.stockage.exists());
		
		final List<IMotif> liste1 = new ArrayList<IMotif>();
		liste1.add(this.objet1);
		liste1.add(this.objet2);
		liste1.add(this.objet3);
		
		/* this.stockage d'un motif dans le XML. */
		this.daoATester.save(liste1);
		
		/* garantit que save() crée sur disque le fichier XML si il n'existe pas. */
		assertTrue(FILE_EXISTER, this.stockage.exists());
		
		final Long nombreInitial = this.daoATester.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que save() stocke dans le fichier XML 
		 * la totalité de la liste. */
		assertEquals(STOCKAGE_CONTIENT_3_ENEGISTREMENTS
				, (Long) 3L
					, nombreInitial);
		
		// *******************************************
		/* RECHERCHE d'objets métier dans le XML. */
		final List<IMotif> liste = this.daoATester.findAll();
		
		/* garantit que findAll() fonctionne 
		 * correctement. */
		assertEquals(
				"la liste doit retourner 3 éléments : "
					, 3
						, liste.size());
		
		// *******************************************
		// DESTRUCTION.
		final boolean deleteTrue = this.daoATester.delete(this.objet2);
		
		final Long nombreFinal = this.daoATester.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("************** APRES DESTRUCTION ************** ");
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreFinal);
		}
				
		/* garantit que delete(existant) supprime dans le fichier XML 
		 * un enregistrement existant. */
		assertEquals("Le fichier doit contenir 2 enregistrements : "
				, (Long) 2L
					, nombreFinal);
		
		/* garantit que delete(existant) retourne true. */
		assertTrue(
				"delete(existant) doit retourner true : "
					, deleteTrue);
		
		// DESTRUCTION d'un inexistant.
		final boolean deleteNull = this.daoATester.delete(null);
		
		final IMotif objetInexistant 
		= new Motif(
				7L
				, "inex11"
				, "inex12", "inex13", "inex14", "inex15");
		
		final boolean deleteInexistant = this.daoATester.delete(objetInexistant);
		
		/* garantit que delete(null) retourne false. */
		assertFalse(
				"delete(null) doit retourner false : "
					, deleteNull);
		
		/* garantit que delete(inexistant) retourne false. */
		assertFalse(
				"delete(inexistant) doit retourner false : "
					, deleteInexistant);

	} // Fin de testDelete().______________________________________________
	

	
	/**
	 * .<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDeleteById() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJAXBTestUnit - méthode testDeleteById() ********** ");
		}

		if (this.stockage.exists()) {
			Files.delete(this.stockage.toPath());
		}
		
		/* garantit que le fichier XML n'existe pas. */
		assertFalse(FILE_PAS_EXISTER, this.stockage.exists());
		
		final List<IMotif> liste1 = new ArrayList<IMotif>();
		liste1.add(this.objet1);
		liste1.add(this.objet2);
		liste1.add(this.objet3);
		
		/* this.stockage d'un motif dans le XML. */
		this.daoATester.save(liste1);
		
		/* garantit que save() crée sur disque le fichier XML si il n'existe pas. */
		assertTrue(FILE_EXISTER, this.stockage.exists());
		
		final Long nombreInitial = this.daoATester.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que save() stocke dans le fichier XML 
		 * la totalité de la liste. */
		assertEquals(STOCKAGE_CONTIENT_3_ENEGISTREMENTS
				, (Long) 3L
					, nombreInitial);
		
	} // Fin de testDeleteById().__________________________________________
	

	
	/**
	 * .<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDeleteByIdBoolean() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJAXBTestUnit - méthode testDeleteByIdBoolean() ********** ");
		}

		if (this.stockage.exists()) {
			Files.delete(this.stockage.toPath());
		}
		
		/* garantit que le fichier XML n'existe pas. */
		assertFalse(FILE_PAS_EXISTER, this.stockage.exists());
		
		final List<IMotif> liste1 = new ArrayList<IMotif>();
		liste1.add(this.objet1);
		liste1.add(this.objet2);
		liste1.add(this.objet3);
		
		/* this.stockage d'un motif dans le XML. */
		this.daoATester.save(liste1);
		
		/* garantit que save() crée sur disque le fichier XML si il n'existe pas. */
		assertTrue(FILE_EXISTER, this.stockage.exists());
		
		final Long nombreInitial = this.daoATester.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_STOCKAGE + this.stockage.getAbsolutePath() + SAUT_APO);
			this.daoATester.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
		
		/* garantit que save() stocke dans le fichier XML 
		 * la totalité de la liste. */
		assertEquals(STOCKAGE_CONTIENT_3_ENEGISTREMENTS
				, (Long) 3L
					, nombreInitial);
		
	} // Fin de testDeleteByIdBoolean().___________________________________
	
	
	 
	/**
	 * {@inheritDoc}
	 */
	@Before
	@Override
	public void before() throws JAXBException {
		
		this.stockage 
			= new File("data/base-regex_javafx-JAXB/motifs.xml");
		
		this.objet1 
		= new Motif("1 chiffre", "\\d", "1 chiffre", "[0-9]", "/ \\d /");
		
		this.objet2 
		= new Motif("commence par 1 à 3 chiffres", "^\\d{1,3}?", "commence par 1 à 3 chiffres reluctant", "^\\d[0-9]{1,3}?", "/ ^\\\\d{1,3}? /");
		
		this.objet3 
		= new Motif("commence par 1 à 4 chiffres", "^\\d{1,4}?", "commence par 1 à 4 chiffres reluctant", "^\\d[0-9]{1,4}?", "/ ^\\d{1,4}? /");
		
		this.daoATester = new MotifDaoJAXBGeneric(this.stockage);
		
	} // Fin de before().__________________________________________________	 
	 
	 
	
	/**
	 * <ul>
	 * <li>instructions exécutées <b>une seule fois 
	 * lors de l'instanciation de la présente classe 
	 * avant l'ensemble des tests</b> 
	 * contenus par la présente classe JUnit.</li>
	 * <li><b>A REMPLIR A LA MAIN</b></li>
	 * </ul>
	 * @throws JAXBException 
	 */
	@BeforeClass
   public static void avantTests() throws JAXBException {
		
		/**/
		
	} // Fin de avantTests().______________________________________________
	

	
} // FIN DE LA CLASSE MotifDaoJAXBTestUnit.--------------------------------------
