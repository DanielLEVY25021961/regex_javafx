package levy.daniel.application.model.dao.metier.regex.jpa.entities;

import java.io.Serializable;

/**
 * INTERFACE IMotif :<br/>
 * Interface factorisant les comportements des motifs.<br/>
 * <br/>
 * Encapsulation et pure fabrication java.<br/>
 * Modélisation d'un <b>motif RegEx Java</b> avec tous les 
 * renseignements à afficher dans une liste.<br/>
 * <b>[id, nom; motifJava, signification, alias, motifJavaScript]</b>.<br/>
 * Par exemple : <br/>
 * [3, "commence par 1 chiffre", "^\\d"
 * , "ligne commence par un chiffre", "^[0-9]", "/ ^\d /"]<br/> 
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * encapsulation, pure fabrication, <br/> 
 * Expression régulière, expression reguliere, RegEx, Regex, regex, <br/>
 * motif regex, RegEx, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 27 août 2018
 *
 */
public interface IMotif extends 
		Comparable<IMotif>, Cloneable
					, IExportateurCsv, IExportateurJTable, Serializable {


	/**
	 * ';'.<br/>
	 */
	char POINT_VIRGULE = ';';
	
	/**
	 * NULL : String :<br/>
	 * "null".<br/>
	 */
	String NULL = "null";
	
	/**
	 * ", ".<br/>
	 */
	String VIRGULE = ", ";
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	int hashCode();


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	boolean equals(Object pObject);
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	int compareTo(IMotif pObject);
	

	
	/**
	 * Clone.<br/>
	 *
	 * @return : IMotif.<br/>
	 * 
	 * @throws CloneNotSupportedException 
	 */
	IMotif clone() throws CloneNotSupportedException;
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	String toString();
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête csv pour un Motif</b> :<br/>
	 * "id;nom;motifJava;signification;alias;motifJavaScript;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteCsv();
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne csv pour un Motif</b> :<br/>
	 * "id;nom;motifJava;signification;alias;motifJavaScript;".<br/>
	 * <br/>
	 */
	@Override
	String toStringCsv();
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête Jtable pour un Motif</b> :<br/>
	 * "id;nom;motifJava;signification;alias;motifJavaScript;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteColonne(int pI);
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne Jtable pour un Motif</b> :<br/>
	 * "id;nom;motifJava;signification;alias;motifJavaScript;".<br/>
	 * <br/>
	 */
	@Override
	Object getValeurColonne(int pI);
	

	
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

	
	
} // FIN DE L'INTERFACE IMotif.----------------------------------------------
