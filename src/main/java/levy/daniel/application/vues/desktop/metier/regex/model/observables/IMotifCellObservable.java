package levy.daniel.application.vues.desktop.metier.regex.model.observables;

/**
 * INTERFACE IMotifCellObservable :<br/>
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
public interface IMotifCellObservable {

	/**
	 * "#ecf1f6".<br/>
	 */
	String COULEUR_BLEU_PALE_TABLEAU = "#ecf1f6";

	/**
	 * "#b3e6b3".<br/>
	 */
	String COULEUR_VERT_INTENSE_TABLEAU = "#b3e6b3";

	
	/**
	 * génère et passe à chaque cellule d'un ListView 
	 * le texte à afficher pour chaque item du modèle du ListView.<br/>
	 * <ul>
	 * <li>passe la valeur à afficher à la Property text de la cellule.</li>
	 * </ul>
	 *
	 * @param pItem : IMotifObservable : 
	 * objet (MODEL) affiché dans la cellule d'un ListView.<br/> 
	 * @param pEmpty : boolean : 
	 * boolean permettant de préciser quoi faire 
	 * si la cellule est vide.<br/>
	 */
	void updateItem(IMotifObservable pItem, boolean pEmpty);
	

	
} // FIN DE L'INTERFACE IMotifCellObservable.--------------------------------
