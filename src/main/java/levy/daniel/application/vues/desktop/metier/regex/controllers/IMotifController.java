package levy.daniel.application.vues.desktop.metier.regex.controllers;

import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;

/**
 * INTERFACE IMotifController :<br/>
 * Interface factorisant es comportements des MotifController.<br/>
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
public interface IMotifController {
	

	
	/**
	 * Getter de l'identifiant en base.<br/>
	 *
	 * @return this.id : Long.<br/>
	 */
	Long getId();



	/**
	* Setter de l'identifiant en base.<br/>
	*
	* @param pId : Long : 
	* valeur à passer à this.id.<br/>
	*/
	void setId(Long pId);


	/**
	 * getter de <b>this.id</b>.<br/>
	 *
	 * @return : this.id : LongProperty.<br/>
	 */
	LongProperty idProperty();
	
	
	
	/**
	 * Getter du nom du motif Regex Java.<br/>
	 *
	 * @return this.nom : String.<br/>
	 */
	String getNom();



	/**
	* Getter du nom du motif Regex Java.<br/>
	*
	* @param pNom : String : 
	* valeur à passer à this.nom.<br/>
	*/
	void setNom(String pNom);


	
	/**
	 * getter de <b>this.nom</b>.<br/>
	 *
	 * @return : StringProperty : this.nom.<br/>
	 */
	StringProperty nomProperty();
	
	
	
	/**
	 * Getter du motif Regex Java.<br/>
	 *
	 * @return this.motifJava : String.<br/>
	 */
	String getMotifJava();



	/**
	* Setter du motif Regex Java.<br/>
	*
	* @param pMotifJava : String : 
	* valeur à passer à this.motifJava.<br/>
	*/
	void setMotifJava(String pMotifJava);


	
	/**
	 * getter de <b>this.motifJava</b>.<br/>
	 *
	 * @return : StringProperty : this.motifJava.<br/>
	 */
	StringProperty motifJavaProperty();
	
	
	
	/**
	 * Getter de la signification du motif Java.<br/>
	 *
	 * @return this.signification : String.<br/>
	 */
	String getSignification();



	/**
	* Setter de la signification du motif Java.<br/>
	* <br/>
	*
	* @param pSignification : String : 
	* valeur à passer à this.signification.<br/>
	*/
	void setSignification(String pSignification);


	
	/**
	 * getter de <b>this.signification</b>.<br/>
	 *
	 * @return : StringProperty : this.signification.<br/>
	 */
	StringProperty significationProperty();
	
	
	
	/**
	 * Getter d'une autre façon d'écrire le motif Regex Java.<br/>
	 *
	 * @return this.alias : String.<br/>
	 */
	String getAlias();



	/**
	* Setter d'une autre façon d'écrire le motif Regex Java.<br/>
	* <br/>
	*
	* @param pAlias : String : 
	* valeur à passer à this.alias.<br/>
	*/
	void setAlias(String pAlias);


	
	/**
	 * getter de <b>this.alias</b>.<br/>
	 *
	 * @return : StringProperty : this.alias.<br/>
	 */
	StringProperty aliasProperty();
	
	
	
	/**
	 * Getter du motif Regex JavaScript.<br/>
	 *
	 * @return this.motifJavaScript : String.<br/>
	 */
	String getMotifJavaScript();



	/**
	* Setter du motif Regex JavaScript.<br/>
	*
	* @param pMotifJavaScript : String : 
	* valeur à passer à this.motifJavaScript.<br/>
	*/
	void setMotifJavaScript(String pMotifJavaScript);


	
	/**
	 * getter de <b>this.motifJavaScript</b>.<br/>
	 *
	 * @return : StringProperty : this.motifJavaScript.<br/>
	 */
	StringProperty motifJavaScriptProperty();
	
	
	
} // FIN DE L'INTERFACE IMotifController.------------------------------------
