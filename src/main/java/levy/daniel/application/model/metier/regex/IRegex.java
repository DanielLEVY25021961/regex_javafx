package levy.daniel.application.model.metier.regex;



/**
 * INTERFACE IRegex :<br/>
 * Interface factorisant les comportements des RegEx.<br/>
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
 * @since 6 août 2018
 *
 */
public interface IRegex {
	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pString
	 * @return :  :  .<br/>
	 */
	boolean motifFind(String pString);

	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pString
	 * @return :  :  .<br/>
	 */
	boolean motifMatche(String pString);


	/**
	 * Getter de la chaine de caractères dont on veut savoir 
	 * si elle contient ou matche le motif 
	 * de l'expression régulière.<br/>
	 *
	 * @return this.chaineATester : String.<br/>
	 */
	String getChaineATester();
	

	
	/**
	* Setter de la chaine de caractères dont on veut savoir 
	* si elle contient ou matche le motif 
	* de l'expression régulière.<br/>
	*
	* @param pChaineATester : String : 
	* valeur à passer à this.chaineATester.<br/>
	*/
	void setChaineATester(String pChaineATester);
	
	
	
	/**
	 * Getter du Motif de l'expression régulière 
	 * applicable en Java.<br/>
	 * Par exemple : "[0-9]" ou "\\d" en java pour un chiffre. 
	 *
	 * @return motifJava : String.<br/>
	 */
	String getMotifJava();



	/**
	* Setter du Motif de l'expression régulière 
	* applicable en Java.<br/>
	* Par exemple : "[0-9]" ou "\\d" en java pour un chiffre. 
	*
	* @param pMotifJava : String : 
	* valeur à passer à motifJava.<br/>
	*/
	void setMotifJava(String pMotifJava);



	/**
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return motifJavaScript : String.<br/>
	 */
	String getMotifJavaScript();



	/**
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return significationMotif : String.<br/>
	 */
	String getSignificationMotif();

	
	
} // FIN DE L'INTERFACE IRegex.----------------------------------------------
