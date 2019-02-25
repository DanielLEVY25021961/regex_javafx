package levy.daniel.application;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.model.metier.regex.impl.Motif;
import levy.daniel.application.model.persistence.IDaoGeneric;
import levy.daniel.application.model.persistence.metier.regex.jpa.dao.impl.MotifDaoJPAGeneric;

/**
 * CLASSE Main :<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 11 sept. 2018
 * 
 */
public final class Main {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 * DOIT FIGURER DANS LA CLASSE CONCRETE DE TEST 
	 * POUR PARAMETRER L'AFFICHAGE EFFECTIF DES TESTS.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	/**
	 * "CONTENU DU STOCKAGE : ".<br/>
	 */
	public static final String CONTENU_DU_STOCKAGE 
		= "CONTENU DU STOCKAGE : ";
	
	/**
	 * "NOMBRE D'ENREGISTREMENTS DANS LE STOCKAGE : ".<br/>
	 */
	public static final String NOMBRE_ENREGISTREMENTS 
		= "NOMBRE D'ENREGISTREMENTS DANS LE STOCKAGE : ";
	
	/**
	 * "Le stockage doit contenir 1 enregistrement : ".<br/>
	 */
	public static final String STOCKAGE_CONTIENT_1_ENREGISTREMENT 
		= "Le stockage doit contenir 1 enregistrement : ";
	
	/**
	 * "Le stockage doit contenir 3 enregistrements : ".<br/>
	 */
	public static final String STOCKAGE_CONTIENT_3_ENEGISTREMENTS 
		= "Le stockage doit contenir 3 enregistrements : ";


	/**
	 * DAO à tester.<br/>
	 */
	public static final transient IDaoGeneric<IMotif, Long> DAOATESTER = new MotifDaoJPAGeneric();
	
	
	/**
	 * objet1 valable et différent de objet2 et objet3.<br/>
	 */
	public static final IMotif OBJET1 
		= new Motif("1 chiffre", "\\d", "1 chiffre", "[0-9]", "/ \\d /"); 
	
	
	/**
	 * objet2 valable et différent de objet1 et objet3.<br/>
	 */
	public static final IMotif OBJET2 
		= new Motif("commence par 1 à 3 chiffres", "^\\d{1,3}?", "commence par 1 à 3 chiffres reluctant", "^\\d[0-9]{1,3}?", "/ ^\\\\d{1,3}? /");
	
	/**
	 * objet3 valable et différent de objet1 et objet2.
	 */
	public static final IMotif OBJET3 
		= new Motif("commence par 1 à 4 chiffres", "^\\d{1,4}?", "commence par 1 à 4 chiffres reluctant", "^\\d[0-9]{1,4}?", "/ ^\\d{1,4}? /");


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(Main.class);

	// *************************METHODES************************************/

	 /**
	 * .<br/>
	 * <br/>
	 *
	 */
	private Main() {
		super();
	} // Fin de Main().____________________________________________________
	
	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 *
	 * @param pArgs : void :  .<br/>
	 * 
	 * @throws Exception 
	 */
	public static void main(
			final String[] pArgs) throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE MotifDaoJPAGenericTest - méthode testCreate() ********** ");
		}
		
		/* VIDAGE DU STOCKAGE (TABLE SGBDR JPA). */
//		DAOATESTER.deleteAll();
		
		/* garantit que le stockage (TABLE SGBDR JPA) est vide. */
//		final List<IMotif> listeEnregistrements = DAOATESTER.findAll();
		
//		assertTrue(
//				"le stockage doit être vide : "
//					, listeEnregistrements.isEmpty());
		
		
		// *************************************************************
		/* enregistrement d'un objet dans le stockage (TABLE SGBDR JPA). */
		final IMotif objetPersiste = DAOATESTER.create(OBJET1);
		// *************************************************************
				
		final Long nombreInitial = DAOATESTER.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("objet persisté retourne par create(T pObject) : " + objetPersiste.toString());
			System.out.println(CONTENU_DU_STOCKAGE);
			DAOATESTER.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
		}
				
		// ******************************************************************
		/* enregistrement d'un DOUBLON dans le stockage (TABLE SGBDR JPA). */
//		final IMotif motifDoublon = DAOATESTER.create(objet1);
		// ******************************************************************
		
//		final Long nombreApresDoublon = DAOATESTER.count();
		
	} // Fin de main(...)._________________________________________________



} // FIN DE LA CLASSE Main.--------------------------------------------------
