package levy.daniel.application.model.persistence;

import java.io.Serializable;

/**
 * INTERFACE <b>ITestDaoGeneric</b> :<br/>
 * Interface <b>factorisant les comportements 
 * de tous les tests JUnit de DAO</b>.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Test Dao, test DAO, Test persistence,<br/> 
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
 *
 */
public interface ITestDaoGeneric<T, ID extends Serializable> {
	

	/**
	 * "unused".<br/>
	 */
	String UNUSED = "unused";
	
	
	/**
	 * "CONTENU DU STOCKAGE : '".<br/>
	 */
	String CONTENU_STOCKAGE 
		= "CONTENU DU STOCKAGE : '";
		
	/**
	 * "'\n".<br/>
	 */
	String SAUT_APO = "'\n";
	
	/**
	 * "NOMBRE D'ENREGISTREMENTS DANS LE STOCKAGE : ".<br/>
	 */
	String NOMBRE_ENREGISTREMENTS 
		= "NOMBRE D'ENREGISTREMENTS DANS LE STOCKAGE : ";
	
	/**
	 * "Le stockage doit contenir 1 enregistrement : ".<br/>
	 */
	String STOCKAGE_CONTIENT_1_ENREGISTREMENT 
		= "Le stockage doit contenir 1 enregistrement : ";
	
	/**
	 * "Le stockage doit contenir 3 enregistrements : ".<br/>
	 */
	String STOCKAGE_CONTIENT_3_ENEGISTREMENTS 
		= "Le stockage doit contenir 3 enregistrements : ";

	

	
	
	/* CREATE ************/
	
	
	/**
	 * <ul>
	 * <b>Teste la méthode create(T pObject)</b> :<br/>
	 * <li>garantit que create(T pObject) insère un enregistrement 
	 * dans le stockage.</li>
	 * <li>garantit que create(T pObject) retourne l'instance 
	 * persistante.</li>
	 * <li>garantit que create(Doublon) ne crée pas de doublon.</li>
	 * <li>garantit que create(Doublon) retourne null.</li>
	 * <li>garantit que create(null) retourne null.</li>
	 * </ul>
	 * @param pAffichageGeneral : boolean
	 * @param pAffichage : boolean
	 * 
	 * @throws Exception 
	 */
	void testCreate(// NOPMD by dan on 08/09/18 09:32
			boolean pAffichageGeneral
				, boolean pAffichage) throws Exception;
	
	
	/**
	 * <b>teste la méthode create(T pObject)</b>.<br/>
	 * <b>A IMPLEMENTER DANS CHAQUE TEST CONCRET pour passer 
	 * les paramètres d'affichage</b>.<br/>
	 * <ul>
	 * <li>DOIT APPELER super.testCreate(
	 * boolean pAffichageGeneral, boolean pAffichage) 
	 * qui contient tout le code GENERIQUE.</li>
	 * <li>Exemple : <br/>
	 * <code>final boolean affichage = true;</code><br/>
	 * <code>System.out.println("********** CLASSE MotifDaoJAXBTest - méthode testCreate() ********** ");</code><br/>
	 * <code>super.testCreate(AFFICHAGE_GENERAL, affichage);</code>
	 * </li>
	 * </ul>
	 * @throws Exception 
	 */
	void testCreate() throws Exception; // NOPMD by dan on 08/09/18 18:45
	
	
	
	/**
	 * instructions exécutées avant <b>chaque</b> test 
	 * de la classe CONCRETE Junit.<br/>
	 * <ul>
	 * <li><b>A REMPLIR A LA MAIN dans CHAQUE TEST CONCRET</b></li>
	 * <li>A ANNOTER avec l'annotation JUnit <b>Before</b>.</li>
	 * <li>Instancie les objets métier déclarés en attribut 
	 * avant chaque test.</li>
	 * <li>instancie le DAO à tester <code>this.daoATester</code>.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	void before() throws Exception;
	
	

} // FIN DE L'INTERFACE ITestDaoGeneric.--------------------------------------------
