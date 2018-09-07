package levy.daniel.application.model.persistence;

import java.io.Serializable;

/**
 * INTERFACE <b>IDaoGenericJAXB</b> :<br/>
 * <ul>
 * <li>INTERFACE <b>GENERIQUE</b> pour les <b>DAO JPA</b> sous <b>SPRING</b>.</li>
 * <li>
 * Comporte les définitions des méthodes <b>CRUD</b> valables 
 * pour <b>tous les objets métier</b>.
 * </li>
 * </ul>
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
 * @param <T> : Type paramétré : Classe réelle d'un Objet métier.<br/>
 * @param <ID> : Type paramétré : type de l'ID en base d'un Objet métier 
 * (Long, Integer, String, ...).<br/>
 */
public interface IDaoGenericJAXB<T, ID extends Serializable> 
									extends IDaoGeneric<T, ID> {
	

	/**
	 * SAUT_LIGNE_JAVA : Character :<br/>
	 * saut de ligne "\n".<br/>
	 */
	String SAUT_LIGNE_JAVA = "\n";



} // FIN DE L'INTERFACE IDaoGenericJAXB.-------------------------------------
