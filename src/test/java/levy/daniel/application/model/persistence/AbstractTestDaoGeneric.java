package levy.daniel.application.model.persistence;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CLASSE AbstractTestDaoGeneric :<br/>
 * <b>classe abstraite factorisant les attributs 
 * et les méthodes de tous les tests JUnit de DAO</b>.<br/>
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
public abstract class AbstractTestDaoGeneric<T, ID extends Serializable> 
								implements ITestDaoGeneric<T, ID> {
	

	// ************************ATTRIBUTS************************************/

	
	/**
	 * objet1 valable et différent de objet2 et objet3.<br/>
	 */
	public T objet1; 
	
	
	/**
	 * objet2 valable et différent de objet1 et objet3.<br/>
	 */
	public T objet2;
	
	/**
	 * objet3 valable et différent de objet1 et objet2.
	 */
	public T objet3;

	
	/**
	 * DAO à tester.<br/>
	 */
	public transient IDaoGeneric<T, ID> daoATester;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
	= LogFactory.getLog(AbstractTestDaoGeneric.class);


	// *************************METHODES************************************/


	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public AbstractTestDaoGeneric() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

		
} // FIN DE LA CLASSE AbstractTestDaoGeneric.--------------------------------
