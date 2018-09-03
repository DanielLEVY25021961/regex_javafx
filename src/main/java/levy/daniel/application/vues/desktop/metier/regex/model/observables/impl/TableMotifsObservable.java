package levy.daniel.application.vues.desktop.metier.regex.model.observables.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import levy.daniel.application.model.metier.regex.IMotif;
import levy.daniel.application.vues.desktop.metier.regex.model.observables.IMotifObservable;


/**
 * CLASSE TableMotifsObservable :<br/>
 * CONTROLLER pour gérer les actions sur la 
 * LISTE des OBSERVABLES (MotifObservable) 
 * dans une VUE javafx.<br/>
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
public class TableMotifsObservable {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * Observable liste de Motifs.<br/>
	 * (équivalent d'une table motifs JPA).<br/>
	 */
	private ObservableList<IMotifObservable> tableMotifs 
		= FXCollections.<IMotifObservable>observableArrayList();

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(TableMotifsObservable.class);


	// *************************METHODES************************************/
	
		
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public TableMotifsObservable() {
		this((ObservableList<IMotifObservable>) null);
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pTableMotifs : 
	 * ObservableList&lt;IMotifObservable&gt;.<br/>
	 */
	public TableMotifsObservable(
			final ObservableList<IMotifObservable> pTableMotifs) {
		
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
	public TableMotifsObservable(
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
	 * @return : ObservableList&lt;IMotifObservable&gt; : 
	 * liste observable.<br/>
	 */
	public final ObservableList<IMotifObservable> 
					convertirListModeleEnObservable(
								final List<IMotif> pList) {
		
		if (pList == null) {
			return null;
		}
		
		final ObservableList<IMotifObservable> resultat 
			= FXCollections.<IMotifObservable>observableArrayList();
		
		for (final IMotif objetMetier : pList) {
			
			if (objetMetier != null) {
				
				final IMotifObservable observable 
					= new MotifObservable(objetMetier);
				
				resultat.add(observable);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListModelenObservable(...)._______________________

	
	
	/**
	 * <b>ajoute un Observable CONTROLLER à la liste observable</b>.<br/>
	 * - retourne false si pMotif == null.<br/>
	 *
	 * @param pMotif : IMotifObservable : 
	 * élément à rajouter à la liste.<br/>
	 * 
	 * @return : boolean : 
	 * true si pMotif a été rajouté à la liste.<br/>
	 */
	public boolean ajouter(
			final IMotifObservable pMotif) {
		
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
	 * @param pMotifs : ObservableList<IMotifObservable> : 
	 * liste d'observables à ajouter.<br/>
	 * 
	 * @return : boolean : true si l'ajout a bien été effectué.<br/>
	 */
	public boolean ajouterListe(
			final ObservableList<IMotifObservable> pMotifs) {
		
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
		
		final IMotifObservable motif = new MotifObservable(pMotif);
		
		return this.tableMotifs.add(motif);

	}
	

	
	/**
	 * <b>retire un Observable CONTROLLER à la liste observable</b>.<br/>
	 * - retourne false si pMotif == null.<br/>
	 *
	 * @param pMotif : IMotifObservable : 
	 * élément à retirer à la liste.<br/>
	 * 
	 * @return : boolean : 
	 * true si pMotif a été retiré à la liste.<br/>
	 */
	public boolean retirer(
			final IMotifObservable pMotif) {
		
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
	 * @return tableMotifs : ObservableList<IMotifObservable>.<br/>
	 */
	public ObservableList<IMotifObservable> getTableMotifs() {
		return this.tableMotifs;
	}



	/**
	* method setTableMotifs(
	* ObservableList<IMotifObservable> pTableMotifs) :<br/>
	* .<br/>
	* <br/>
	*
	* @param pTableMotifs : ObservableList<IMotifObservable> : valeur à passer à tableMotifs.<br/>
	*/
	public void setTableMotifs(
			final ObservableList<IMotifObservable> pTableMotifs) {
		this.tableMotifs = pTableMotifs;
	}


	
	  

}
