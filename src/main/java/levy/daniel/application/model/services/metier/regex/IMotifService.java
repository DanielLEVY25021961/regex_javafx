package levy.daniel.application.model.services.metier.regex;

import levy.daniel.application.model.metier.regex.IMotif;


/**
 * INTERFACE <b>IMotifService</b> :<br/>
 * .<br/>
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
 * @since 2 sept. 2018
 *
 */
public interface IMotifService {

	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pMotif
	 * @return :  :  .<br/>
	 */
	IMotif create(IMotif pMotif);



	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pMotif
	 * @return :  :  .<br/>
	 */
	IMotif update(IMotif pMotif);



	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pMotif
	 * @return :  :  .<br/>
	 */
	boolean delete(IMotif pMotif);
	
	
	
} // FIN DE L'INTERFACE IMotifService.-------------------------------------
