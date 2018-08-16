package levy.daniel.application.model.metier.regex;

/**
 * INTERFACE <b>IOccurence</b> :<br/>
 * Interface factorisant les comportements des Occurence concrets.<br/>
 * <br/>
 * Encapsulation et pure fabrication java.<br/>
 * Modélisation de l'occurence d'un motif RegEx Java dans un texte.<br/>
 * Par exemple : <br/>
 * pour le motif Regex Java <code>"avec"</code> 
 * dans le texte :<br/>
 * <b>avec</b> le temps, <b>avec</b> le temps va...<br/>
 * <b>Occurence</b> va servir à encapsuler toutes les occurences 
 * <b>(numéro, contenu, position de début, position de fin)</b> 
 * du motif "avec" dans le texte.<br/>
 * <br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * <code><i>// instanciation d'occurences dans la boucle de la méthode find() d'un Matcher.</i></code><br/>
 * <code>IOccurence occurence = new Occurence(i, trouve, positionDebut, positionFin);</code><br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 16 août 2018
 *
 */
public interface IOccurence extends 
	Comparable<IOccurence>, Cloneable
			, IExportateurCsv, IExportateurJTable {

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
	int hashCode();


	
	/**
	 * {@inheritDoc}
	 */
	boolean equals(Object pObject);
	

	
	/**
	 * {@inheritDoc}
	 */
	int compareTo(IOccurence pObject);
	
	

	/**
	 * {@inheritDoc}
	 */
	IOccurence clone() throws CloneNotSupportedException;
	
	

	/**
	 * {@inheritDoc}
	 */
	String toString();
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête csv pour un Occurence</b> :<br/>
	 * "numéro;contenu;indexDebut;indexFin;".<br/>
	 * <br/>
	 */
	String getEnTeteCsv();
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne csv pour un Occurence</b> :<br/>
	 * "numéro;contenu;indexDebut;indexFin;".<br/>
	 * <br/>
	 */
	String toStringCsv();
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête Jtable pour un Occurence</b> :<br/>
	 * "numéro;contenu;indexDebut;indexFin;".<br/>
	 * <br/>
	 */
	String getEnTeteColonne(int pI);
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne Jtable pour un Occurence</b> :<br/>
	 * "numéro;contenu;indexDebut;indexFin;".<br/>
	 * <br/>
	 */
	Object getValeurColonne(int pI);
	
	

	/**
	 * Getter du numero d'ordre (1-based) de l'occurence 
	 * du motif dans un texte.<br/>
	 * (1ère occurence, 2ème occurence, ...).<br/>
	 *
	 * @return this.numero : int.<br/>
	 */
	int getNumero();
	
	

	/**
	 * Getter du contenu de l'occurence du motif dans le texte.<br/>
	 *
	 * @return this.contenu : String.<br/>
	 */
	String getContenu();
	
	

	/**
	 * Getter de la position (0-based) du début 
	 * de l'occurence du motif.<br/>
	 *
	 * @return this.indexDebut : int.<br/>
	 */
	int getIndexDebut();
	
	

	/**
	 * Getter de la position (0-based) de la fin 
	 * de l'occurence du motif.<br/>
	 * <br/>
	 *
	 * @return this.indexFin : int.<br/>
	 */
	int getIndexFin();
	
	

} // FIn DE L'INTERFACE IOccurence.------------------------------------------