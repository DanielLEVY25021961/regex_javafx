package levy.daniel.application.model.dao.metier.regex.jaxb.entities.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.IConstantesApplicatives;
import levy.daniel.application.model.dao.metier.regex.jaxb.entities.ITableMotifsEntityJAXB;
import levy.daniel.application.model.metier.regex.IMotif;


/**
 * CLASSE TableMotifsEntityJAXB :<br/>
 * Modélisation JAXB équivalente à une Table JPA.<br/>
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
@XmlRootElement(namespace = IConstantesApplicatives.NAMESPACE)
public class TableMotifsEntityJAXB implements ITableMotifsEntityJAXB {

	// ************************ATTRIBUTS************************************/

	/**
	 * Liste de MotifEntityJAXB.<br/> 
	 * (équivalent d'une table motifs JPA).<br/>
	 */
	private List<MotifEntityJAXB> listeMotifs;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(TableMotifsEntityJAXB.class);

	// *************************METHODES************************************/
	
		
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public TableMotifsEntityJAXB() {
		this(null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pListeMotifs : List&lt;MotifEntityJAXB&gt;.<br/> 
	 */
	public TableMotifsEntityJAXB(
			final List<MotifEntityJAXB> pListeMotifs) {
		
		super();
		
		this.listeMotifs = pListeMotifs;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MotifEntityJAXB> convertirListModelEnEntities(
			final List<IMotif> pList) {
		
		if (pList == null) {
			return null;
		}
		
		final List<MotifEntityJAXB> resultat 
			= new ArrayList<MotifEntityJAXB>();
		
		for (final IMotif objetMetier : pList) {
			
			if (objetMetier != null) {
				
				final MotifEntityJAXB entiteJAXB 
					= new MotifEntityJAXB(objetMetier);
				
				resultat.add(entiteJAXB);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListModelEnEntities(...)._________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MotifEntityJAXB> getListeMotifs() {
		return this.listeMotifs;
	} // Fin de getListeMotifs().__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setListeMotifs(
			final List<MotifEntityJAXB> pListeMotifs) {
		this.listeMotifs = pListeMotifs;
	} // Fin de setListeMotifs(...)._______________________________________
	


} // FIN DE LA CLASSE TableMotifsEntityJAXB.---------------------------------
