package levy.daniel.application.vues.desktop.metier.regex.controllers.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.vues.desktop.metier.regex.controllers.IMotifController;


/**
 * CLASSE TableMotifsController :<br/>
 * CONTROLLER pour gérer les actions sur la 
 * liste des Motifs dans une VUE javafx.<br/>
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
 * @since 30 août 2018
 *
 */
public class TableMotifsController {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * Observable liste de Motifs.<br/>
	 * (équivalent d'une table motifs JPA).<br/>
	 */
	private ObservableList<IMotifController> tableMotifs 
		= FXCollections.observableArrayList();

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(TableMotifsController.class);


	// *************************METHODES************************************/
	
		
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public TableMotifsController() {
		this((ObservableList<IMotifController>) null);
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pTableMotifs : 
	 * ObservableList&lt;IMotifController&gt;.<br/>
	 */
	public TableMotifsController(
			final ObservableList<IMotifController> pTableMotifs) {
		
		super();
		
		this.tableMotifs = pTableMotifs;
		
	} // Fin de CONSTRUCTEUR COMPLET.--------------------------------------
	

	
	 /**
	 * CONSTRUCTEUR TRANSFORMATEUR.<br/>
	 * <ul>
	 * <li>permet de passer à l'attribut une liste d'objets métier.</li>
	 * <li>convertit la liste d'objets métier en liste d'observables.</li>
	 * </ul>
	 *
	 * @param pList : List&lt;IMotif&gt; : 
	 * liste d'objets métier.<br/>
	 */
	public TableMotifsController(
			final List<IMotif> pList) {
		
		super();
		
		this.tableMotifs 
			= this.convertirListModeleEnObservable(pList);
		
	}
	
	
	
	/**
	 * <b>convertit une liste d'objets métier 
	 * en liste observable</b>.<br/>
	 *
	 * @param pList : List&lt;IMotif&gt; : 
	 * liste d'objets métier.<br/>
	 * 
	 * @return : ObservableList&lt;IMotifController&gt; : 
	 * liste observable.<br/>
	 */
	public final ObservableList<IMotifController> 
					convertirListModeleEnObservable(
								final List<IMotif> pList) {
		
		if (pList == null) {
			return null;
		}
		
		final ObservableList<IMotifController> resultat 
			= FXCollections.observableArrayList();
		
		for (final IMotif objetMetier : pList) {
			
			if (objetMetier != null) {
				
				final IMotifController observable 
					= new MotifController(objetMetier);
				
				resultat.add(observable);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListModelenObservable(...)._______________________

	
	
	/**
	 * <b>ajoute un Observable CONTROLLER à la liste observable</b>.<br/>
	 * - retourne false si pMotif == null.<br/>
	 *
	 * @param pMotif : IMotifController : 
	 * élément à rajouter à la liste.<br/>
	 * 
	 * @return : boolean : 
	 * true si pMotif a été rajouté à la liste.<br/>
	 */
	public boolean ajouter(
			final IMotifController pMotif) {
		
		/* retourne false si pMotif == null. */
		if (pMotif == null) {
			return false;
		}
		
		return this.tableMotifs.add(pMotif);
		
	} // Fin de ajouter(...).______________________________________________
	

	
	/**
	 * <b>ajoute une liste  Observable de CONTROLLERs 
	 * à la liste observable</b>.<br/>
	 * - retourne false si pMotifs == null.<br/>
	 *
	 * @param pMotifs : ObservableList<IMotifController> : 
	 * liste d'observables à ajouter.<br/>
	 * 
	 * @return : boolean : true si l'ajout a bien été effectué.<br/>
	 */
	public boolean ajouterListe(
			final ObservableList<IMotifController> pMotifs) {
		
		/* retourne false si pMotifs == null. */
		if (pMotifs == null) {
			return false;
		}
		
		return this.tableMotifs.addAll(pMotifs);
		
	} // Fin de ajouterListe(...)._________________________________________
	
	
	
	/**
	 * <b>ajoute un OBJET METIER à la liste observable</b>.<br/>
	 * - retourne false si pMotif == null.<br/>
	 *
	 * @param pMotif : IMotif :
	 * élément à rajouter à la liste.<br/> 
	 * 
	 * @return : boolean : 
	 * true si pMotif a été rajouté à la liste.<br/>
	 */
	public boolean ajouterConvertir(
					final IMotif pMotif) {
		
		/* retourne false si pMotif == null. */
		if (pMotif == null) {
			return false;
		}
		
		final IMotifController motif = new MotifController(pMotif);
		
		return this.tableMotifs.add(motif);

	}
	

	
	/**
	 * <b>retire un Observable CONTROLLER à la liste observable</b>.<br/>
	 * - retourne false si pMotif == null.<br/>
	 *
	 * @param pMotif : IMotifController : 
	 * élément à retirer à la liste.<br/>
	 * 
	 * @return : boolean : 
	 * true si pMotif a été retiré à la liste.<br/>
	 */
	public boolean retirer(
			final IMotifController pMotif) {
		
		/* retourne false si pMotif == null. */
		if (pMotif == null) {
			return false;
		}
		
		return this.tableMotifs.remove(pMotif);	
		
	} // Fin de retirer(...).______________________________________________
	
	
	
	/**
	 * method getTableMotifs() :<br/>
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return tableMotifs : ObservableList<IMotifController>.<br/>
	 */
	public ObservableList<IMotifController> getTableMotifs() {
		return this.tableMotifs;
	}



	/**
	* method setTableMotifs(
	* ObservableList<IMotifController> pTableMotifs) :<br/>
	* .<br/>
	* <br/>
	*
	* @param pTableMotifs : ObservableList<IMotifController> : valeur à passer à tableMotifs.<br/>
	*/
	public void setTableMotifs(
			final ObservableList<IMotifController> pTableMotifs) {
		this.tableMotifs = pTableMotifs;
	}


	
	  

}
