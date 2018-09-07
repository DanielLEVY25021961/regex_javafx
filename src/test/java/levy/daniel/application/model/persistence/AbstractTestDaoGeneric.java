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
	 * new Motif("1 chiffre", "\\d", "1 chiffre", "[0-9]", "/ \\d /").<br/>
	 */
	public T objet1; 
	
	
	/**
	 * new Motif("commence par 1 à 3 chiffres", "^\\d{1,3}?", "commence par 1 à 3 chiffres reluctant", "^\\d[0-9]{1,3}?", "/ ^\\\\d{1,3}? /").<br/>
	 */
	public T objet2;
	
	/**
	 * new Motif("commence par 1 à 4 chiffres", "^\\d{1,4}?", "commence par 1 à 4 chiffres reluctant", "^\\d[0-9]{1,4}?", "/ ^\\d{1,4}? /").<br/>
	 */
	public T objet3;


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
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract void testCreate() throws Exception;
	
	
} // FIN DE LA CLASSE AbstractTestDaoGeneric.--------------------------------
