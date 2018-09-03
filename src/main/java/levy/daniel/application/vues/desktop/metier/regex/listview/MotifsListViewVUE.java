package levy.daniel.application.vues.desktop.metier.regex.listview;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import levy.daniel.application.model.metier.regex.IMotif;


/**
 * CLASSE <b>MotifsListViewVUE</b> :<br/>
 * Classe chargée de fournir un GridPane 
 * contenant un ListView d'objets métier.<br/>
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
public class MotifsListViewVUE {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * "null".<br/>
	 */
	public static final String NULL = "null";
	
	/**
	 * label pour la sélection dans la liste.<br/>
	 */
	private Label motifLabel 
		= new Label("Sélectionnez un motif prédéfini (objet métier) : ");

	/**
	 * ListView (VUE) des motifs objets métier.<br/>
	 */
	private ListView<IMotif> motifsListView 
		= new ListView<IMotif>();

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(MotifsListViewVUE.class);

	// *************************METHODES************************************/
	

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MotifsListViewVUE() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * Getter du label pour la sélection dans la liste.<br/>
	 *
	 * @return this.motifLabel : Label.<br/>
	 */
	public Label getMotifLabel() {
		return this.motifLabel;
	} // Fin de getMotifLabel().___________________________________________


	
	/**
	* Setter du label pour la sélection dans la liste.<br/>
	*
	* @param pMotifLabel : Label : 
	* valeur à passer à this.motifLabel.<br/>
	*/
	public void setMotifLabel(
			final Label pMotifLabel) {
		this.motifLabel = pMotifLabel;
	} // Fin de setMotifLabel(...).________________________________________


	
	/**
	 * Getter du ListView (VUE) des motifs objets métier.<br/>
	 *
	 * @return this.motifsListView : ListView&lt;IMotif&gt;.<br/>
	 */
	public ListView<IMotif> getMotifsListView() {
		return this.motifsListView;
	} // Fin de getMotifsListView()._______________________________________
	
	

	/**
	* Setter du ListView (VUE) des motifs objets métier.<br/>
	*
	* @param pMotifsListView : ListView&lt;IMotif&gt; : 
	* valeur à passer à this.motifsListView.<br/>
	*/
	public void setMotifsListView(
			final ListView<IMotif> pMotifsListView) {
		this.motifsListView = pMotifsListView;
	} // Fin de setMotifsListView(...).____________________________________

	
	
} // FIN DE LA CLASSE MotifsListViewVUE.-------------------------------------
