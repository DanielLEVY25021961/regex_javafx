package levy.daniel.application.model.persistence;

import java.io.Serializable;

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
	public abstract void testCreate() throws Exception;


} // FIN DE LA CLASSE AbstractTestDaoGenericJAXB.----------------------------
