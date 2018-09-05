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
	 * identifiant (ou index 0-based) 
	 * de l'objet persisté dans le stockage.<br/>
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
	 * position pStartPosition (0-based).<br/>
	 * <ul>
	 * <li>retourne par exemple les 50 objets métier stockés 
	 * à partir du 100ème.</li>
	 * <li>retourne null si pStartPosition est hors indexes.</li>
	 * </ul>
	 *
	 * @param pStartPosition : int : index (0-based) de départ.<br/>
	 * @param pMaxResult : int : 
	 * nombre maximum d'objets métier à retourner.<br/>
	 * 
	 * @return : List&lt;IMotif&gt; : 
	 * liste des pMax objets métier persistés dans le stockage 
	 * à partir de pStartPosition (0-based).<br/>
	 * 
	 * @throws Exception
	 */
	List<IMotif> findAllMax(
			int pStartPosition, int pMaxResult) 
					throws Exception;

	
	
	/**
	 * <b>retourne l'identifiant ou l'index (0-based) 
	 * de l'objet métier pObject dans le stockage</b>.<br/>
	 *
	 * @param pObject : IMotif : 
	 * objet métier dont on recherche l'identifiant.<br/>
	 *  
	 * @return Long : 
	 * identifiant ou index (0-based) dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	Long retrieveId(IMotif pObject) 
					throws Exception;
	
	
	
	/**
	 * <b>modifie dans le stockage 
	 * l'objet d'index (0-based) ou d'identifiant pIndex 
	 * avec les valeurs 
	 * contenues dans pObjectModifie</b>.<br/>
	 * <ul>
	 * <li><b>pIndex doit correspondre à l'index (0-based) 
	 * de l'objet métier à modifier</b>.</li>
	 * <li>retourne null si pIndex est en dehors des indexes.</li>
	 * </ul>
	 *
	 * @param pIndex : Long : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * @param pObjectModifie : IMotif : 
	 * Objet métier modifié.<br/>
	 * 
	 * @return IMotif : objet métier modifié.<br/>
	 * 
	 * @throws Exception
	 */
	IMotif update(
			Long pIndex
				, IMotif pObjectModifie) 
							throws Exception;
	
	
	
	/**
	 * <b>retire l'objet métier pObject dans le stockage</b>.<br/>
	 * retourne true si le retrait a bien été effectué.<br/>
	 * <ul>
	 * <li>retourne false si pObject n'est pas persisté.</li>
	 * </ul>
	 *
	 * @param pObject : IMotif : objet métier à détruire.<br/>
	 * 
	 * @return : boolean : 
	 * true si l'objet métier a été détruit.<br/>
	 * 
	 * @throws Exception
	 */
	boolean delete(
			IMotif pObject) 
					throws Exception;
	
	
	/**
	 * <b>retire l'objet métier d'identifiant ou 
	 * d'index (0-based) pIndex dans le stockage</b>.<br/>
	 * <ul>
	 * <li>ne fait rien si pIndex est hors indexes.</li>
	 * </ul>
	 *
	 * @param pIndex : Long : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * 
	 * @throws Exception
	 */
	void deleteById(Long pIndex) 
						throws Exception;
	
	
	
	/**
	 * <b>retire l'objet métier d'identifiant ou 
	 * d'index (0-based) pIndex dans le stockage</b>.<br/>
	 * retourne true si le retrait à bien été effectué.<br/>
	 * <ul>
	 * <li>retourne false si pIndex est hors indexes.</li>
	 * </ul>
	 *
	 * @param pIndex : Long : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * 
	 * @return boolean : true si le retrait à bien été effectué.<br/>
	 * 
	 * @throws Exception 
	 */
	boolean deleteByIdBoolean(Long pIndex) 
								throws Exception;

	
	
	/**
	 * <b>retire tous les objets métier dans le stockage</b>.<br/>
	 *
	 * @throws Exception
	 */
	void deleteAll() throws Exception;
	

	
	/**
	 * <b>retire tous les objets métier dans le stockage</b>.<br/>
	 * retourne true si le retrait a bien été effectué.<br/>
	 *
	 * @return : boolean : 
	 * true si le retrait a bien été effectué.<br/>
	 * 
	 * @throws Exception
	 */
	boolean deleteAllBoolean() throws Exception;
	

	
	/**
	 * <b>retire tous les objets de l'itérable pList déjà persistés 
	 * dans le stockage</b>.<br/>
	 * <ul>
	 * <li>ne fait rien et continue le processus de retrait 
	 * si un objet de l'itérable n'est pas persisté.</li>
	 * </ul>
	 *
	 * @param pList : Iterable&lt;IMotif&gt; : 
	 * itérable d'objets àretirer du stockage?<br/>
	 *  
	 * @throws Exception
	 */
	void deleteIterable(Iterable<IMotif> pList) throws Exception;
	

	
	/**
	 * <b>retire tous les objets de l'itérable pList déjà persistés 
	 * dans le stockage</b>.<br/>
	 * retourne true si le retrait a bien été effectué.<br/>
	 * <ul>
	 * <li>ne fait rien et continue le processus de retrait 
	 * si un objet de l'itérable n'est pas persisté.</li>
	 * </ul>
	 *
	 * @param pList : Iterable&lt;IMotif&gt; : 
	 * itérable d'objets àretirer du stockage?<br/>
	 * 
	 * @return : boolean : true si le retrait a bien été effectué.<br/>
	 * 
	 * @throws Exception
	 */
	boolean deleteIterableBoolean(Iterable<IMotif> pList) 
				throws Exception;
	
	
	

	/* TOOLS *************/

	
	/**
	 * <b>retourne true si l'objet métier pObject 
	 * existe dans le stockage</b>.<br/>
	 *
	 * @param pObject : IMotif : objet métier à rechercher.<br/>
	 * 
	 * @return boolean : 
	 * true si l'objet métier existe dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	boolean exists(
			IMotif pObject) 
					throws Exception;
	
	
	
	/**
	 * <b>retourne true si l'objet métier pObject 
	 * d'identifiant ou d'index (0-based) pIndex 
	 * existe dans le stockage</b>.<br/>
	 *
	 * @param pIndex : Long : 
	 * identifiant ou index (0-based) de l'objet métier à 
	 * trouver dans le stockage.<br/>
	 * 
	 * @return boolean : 
	 * true si l'objet métier existe dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	boolean exists(
			Long pIndex) 
					throws Exception;
	
	
	
	/**
	 * <b>retourne le nombre total d'objets métier</b> 
	 * stockés dans le stockage.<br/>
	 *
	 * @return : Long : 
	 * nombre d'enregistrements dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	Long count() throws Exception;

	
	
	/* AFFICHAGE *************/

	
	
	/**
	 * <b>écrit le contenu du stockage dans la console</b>.<br/>
	 *
	 * @throws Exception
	 */
	void ecrireStockageDansConsole() throws Exception;
	
	
} // FIN DE L'INTERFACE IDaoMotif.-------------------------------------------
