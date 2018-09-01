package levy.daniel.application.model.dao.metier.regex.jaxb.entities;

import java.util.List;

import levy.daniel.application.model.dao.metier.regex.jaxb.entities.impl.MotifEntityJAXB;
import levy.daniel.application.model.metier.regex.IMotif;


/**
 * INTERFACE ITableMotifsEntityJAXB :<br/>
 * Interface factorisant les comportements 
 * des TableMotifsEntityJAXB.<br/>
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
 * @author adminLocal Lévy
 * @version 1.0
 * @since 29 août 2018
 *
 */
public interface ITableMotifsEntityJAXB {

	
	/**
	 * convertit une <b>liste d'objets métier</b> IMotif en 
	 * <b>liste d'entités</b>  MotifEntityJAXB.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IMotif&gt;
	 * 
	 * @return : List&lt;MotifEntityJAXB&gt;.<br/>
	 */
	List<MotifEntityJAXB> convertirListModelEnEntities(
			List<IMotif> pList);
	
	
	
	/**
	 * Getter de la Liste de MotifEntityJAXB.<br/> 
	 * (équivalent d'une table motifs JPA).<br/>
	 *
	 * @return this.listeMotifs : List&lt;MotifEntityJAXB&gt;.<br/>
	 */
	List<MotifEntityJAXB> getListeMotifs();


	
	/**
	* Setter de la Liste de MotifEntityJAXB.<br/> 
	* (équivalent d'une table motifs JPA).<br/>
	*
	* @param pListeMotifs : List&lt;MotifEntityJAXB&gt; : 
	* valeur à passer à this.listeMotifs.<br/>
	*/
	void setListeMotifs(List<MotifEntityJAXB> pListeMotifs);
	
	

} // FIN DE L'INTERFACE ITableMotifsEntityJAXB.--------------------------------
