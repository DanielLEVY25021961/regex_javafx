package levy.daniel.application.model.persistence.metier.regex;


import java.util.List;

import levy.daniel.application.model.metier.regex.IMotif;

/**
 * INTERFACE IDaoMotif :<br/>
 * Interface générique factorisant les comportements 
 * de tous les Data Access Object (DAO) quelle que soit 
 * la technologie (JPA, JAXB XML, JSON, ...).<br/>
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
 * @since 4 sept. 2018
 *
 */
public interface IDaoMotif {
	

	
	/**
	 * <b>crée un objet métier pObject dans le stockage 
	 * et retourne l'objet persisté</b>.<br/>
	 * <ul>
	 * <li>ne crée <b>pas de doublon</b>.</li>
	 * <li>retourne null si pObject existe déjà dans le stockage.</li>
	 * </ul>
	 *
	 * @param pObject : IMotif : 
	 * l'objet métier à persister dans le stockage.<br/>
	 * 
	 * @return IMotif : 
	 * l'objet métier persisté dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	IMotif create(IMotif pObject) 
			throws Exception;
	

	
	/**
	 * <b>crée un objet métier pObject dans le stockage 
	 * et retourne l'identifiant de l'objet persisté</b>.<br/>
	 * <ul>
	 * <li>ne crée <b>pas de doublon</b>.</li>
	 * <li>retourne null si pObject existe déjà dans le stockage.</li>
	 * </ul>
	 *
	 * @param pObject : IMotif : 
	 * l'objet métier à persister dans le stockage.<br/>
	 * 
	 * @return : Long : 
	 * identifiant de l'objet persisté dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	Long createReturnId(IMotif pObject) 
			throws Exception;
	
	
	
	/**
	 * <b>crée un iterable d'objets métier pObject 
	 * dans le stockage</b> et retourne l'itérable persisté.<br/>
	 * <ul>
	 * <li>ne crée <b>pas de doublon</b>.</li>
	 * <li>ne fait rien et continue la sauvegarde si un objet 
	 * dans l'itérable existe déjà dans le stockage.</li>
	 * </ul>
	 *
	 * @param pList : Iterable&lt;IMotif&gt; : 
	 * itérable d'objets métier à persister dans le stockage.<br/>
	 * 
	 * @return Iterable&lt;IMotif&gt; : 
	 * itérable d'objets métier persistés dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	Iterable<IMotif> save(
			Iterable<IMotif> pList) 
						throws Exception;


	
	/**
	 * <b>recherche un objet métier pObject 
	 * dans le stockage</b> et retourne l'objet métier persisté.<br/>
	 * recherche l'objet métier par son égalité métier 
	 * (equals()).<br/>
	 * <ul>
	 * <li>retourne null si l'objet métier 
	 * n'existe pas dans le stockage.</li>
	 * </ul>
	 *
	 * @param pObject : IMotif : objet métier à rechercher.<br/>
	 * 
	 * @return : IMotif : objet métier recherché.<br/>
	 * 
	 * @throws Exception
	 */
	IMotif retrieve(
			IMotif pObject) 
					throws Exception;
	

	
	/**
	 * <b>recherche un objet métier pObject via son identifiant (index) 
	 * dans le stockage</b> et retourne l'objet métier persisté.<br/>
	 * <ul>
	 * <li>retourne null si l'objet métier 
	 * n'existe pas dans le stockage.</li>
	 * </ul>
	 *
	 * @param pId : Long : 
	 * index (0-based) ou identifiant en base 
	 * de l'objet métier à rechercher.<br/>
	 * 
	 * @return : IMotif : objet métier recherché.<br/>
	 * 
	 * @throws Exception
	 */
	IMotif findById(Long pId) 
					throws Exception;
	

	
	/**
	 * <b>retourne la liste de tous les objets métier 
	 * persistés dans le stockage</b>.<br/>
	 *
	 * @return : List&lt;IMotif&gt; : 
	 * liste de tous les objets métier persistés dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	List<IMotif> findAll() 
				throws Exception;
	

	
	/**
	 * <b>retourne la liste des pMax objets métier 
	 * persistés dans le stockage</b> à partir de la 
	 * position pStartPosition.<br/>
	 * <ul>
	 * <li>retourne par exemple les 50 objets métier stockés 
	 * à partir du 100ème.</li>
	 * </ul>
	 *
	 * @param pStartPosition : int : index (0-based) de départ.<br/>
	 * @param pMaxResult : int : 
	 * nombre maximum d'objets métier à retourner.<br/>
	 * 
	 * @return : List&lt;IMotif&gt; : 
	 * liste des pMax objets métier persistés dans le stockage 
	 * à partir de pStartPosition.<br/>
	 * 
	 * @throws Exception
	 */
	List<IMotif> findAllMax(
			int pStartPosition, int pMaxResult) 
					throws Exception;
	
	
	
} // FIN DE L'INTERFACE IDaoMotif.-------------------------------------------
