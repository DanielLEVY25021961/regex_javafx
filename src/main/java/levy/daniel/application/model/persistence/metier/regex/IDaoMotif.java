package levy.daniel.application.model.persistence.metier.regex;


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
	 * <b>crée un objet métier pObject dans le stockage</b>.<br/>
	 *
	 * @param pObject : IMotif : 
	 * l'objet métier à créer dans le stockage.<br/>
	 * 
	 * @return IMotif : 
	 * l'objet métier persisté dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	IMotif create(IMotif pObject) 
			throws Exception;
	

	
} // FIN DE L'INTERFACE IDaoMotif.-------------------------------------------
