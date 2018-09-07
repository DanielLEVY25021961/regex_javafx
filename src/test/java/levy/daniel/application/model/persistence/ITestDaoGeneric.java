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
	 * <li>garantit que create() ne crée pas de doublon.</li>
	 * <li>garantit que create(Doublon) retourne null.</li>
	 * <li>garantit que create(null) retourne null.</li>
	 * </ul>
	 */
	void testCreate() throws Exception;

} // FIN DE L'INTERFACE ITestDaoGeneric.--------------------------------------------
