package levy.daniel.application.model.services.metier.regex.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.model.services.metier.regex.IMotifService;


/**
 * CLASSE <b>MotifService</b> :<br/>
 * Classe SERVICE de LOGIQUE METIER pour les Motifs Regex Java.<br/>
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
public class MotifService implements IMotifService {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(MotifService.class);
	
	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MotifService() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IMotif create(
			final IMotif pMotif) {
		return null;
	}
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IMotif update(
			final IMotif pMotif) {
		return null;
	}
	
	
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(
			final IMotif pMotif) {
		return false;
	}
	
	
	
	
} // FIN DE LA CLASSE MotifService.------------------------------------------
